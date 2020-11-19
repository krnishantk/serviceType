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

import com.carwash.serviceType.model.AddOnType;
import com.carwash.serviceType.model.RestResponse;
import com.carwash.serviceType.service.AddOnTypeService;

@RequestMapping("addOn")
@RestController
@CrossOrigin
public class AddOnTypeResource {

	@Autowired
	private AddOnTypeService addOnService;

	@PostMapping()
	public RestResponse addPackageType(@RequestBody AddOnType addOnType) {
		RestResponse response = new RestResponse();
		AddOnType isAddOnType = addOnService.isAddOnTypeByName(addOnType.getAddOnName());
		if (isAddOnType == null) {
			AddOnType newAddOnType = addOnService.saveAddOnType(addOnType);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("addOnTypeId", newAddOnType.getId());
			response.setData(responseMap);
			response.setMsg("addOn type added successfully");

		} else {
			response.setMsg("addOn type already exist");
		}
		return response;
	}

	@GetMapping("getAllActiveAddOnType")
	public List<AddOnType> getAllActivePackageType() {
		RestResponse response = new RestResponse();
		List<AddOnType> addOnType = addOnService.getAllActiveAddOnType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("addOn", addOnType);
		response.setData(responseMap);
		response.setMsg("addOn type information fetch Successfully");
		return addOnType;
	}

	@GetMapping("getAllAddOnType")
	public List<AddOnType> getAllPackageType() {
		RestResponse response = new RestResponse();
		List<AddOnType> addOnType = addOnService.getAllAddOnType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("addOn", addOnType);
		response.setData(responseMap);
		response.setMsg("addOn type information fetch Successfully");
		return addOnType;
	}

}