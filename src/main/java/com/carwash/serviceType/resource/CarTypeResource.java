package com.carwash.serviceType.resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.serviceType.model.CarType;
import com.carwash.serviceType.model.RestResponse;
import com.carwash.serviceType.service.CarTypeService;

@RequestMapping("carType")
@RestController
@CrossOrigin
public class CarTypeResource {
	
	@Autowired
	private CarTypeService carTypeService;
	
	@PostMapping()
	public RestResponse addCarType(@RequestBody CarType carType) {
		RestResponse response = new RestResponse();
		CarType isCarType = carTypeService.isCarTypeByName(carType.getCarTypeName());
		if (isCarType == null) {
			CarType newCarType = carTypeService.saveCarType(carType);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("carTypeId", newCarType.getId());
			response.setData(responseMap);
			response.setMsg("car type added successfully");

		} else {
			response.setMsg("car type already exist");
		}
		return response;
	}

	
	@GetMapping("getAllActiveCarType")
	public List<CarType> getAllActiveCarType() {
		RestResponse response = new RestResponse();
		List<CarType> carType = carTypeService.getAllActiveCarType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("userId", carType);
		response.setData(responseMap);
		response.setMsg("car type information fetch Successfully");
		return carType;
	}
	
	@GetMapping("getAllCarType")
	public List<CarType> getAllCarType() {
		RestResponse response = new RestResponse();
		List<CarType> carType = carTypeService.getAllCarType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("userId", carType);
		response.setData(responseMap);
		response.setMsg("car type information fetch Successfully");
		return carType;
	}


}

