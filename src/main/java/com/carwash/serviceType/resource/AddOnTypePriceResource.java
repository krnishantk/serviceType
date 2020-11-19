package com.carwash.serviceType.resource;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.serviceType.model.AddOnTypePrice;
import com.carwash.serviceType.model.RestResponse;
import com.carwash.serviceType.service.AddOnTypePriceService;

@RequestMapping("addOnPrice")
@RestController
@CrossOrigin
public class AddOnTypePriceResource {

	@Autowired
	private AddOnTypePriceService addOnTypePriceService;

	@PostMapping()
	public RestResponse addAddOnPrice(@RequestBody AddOnTypePrice addOnTypePrice) {
		RestResponse response = new RestResponse();
		AddOnTypePrice isAddOnType = addOnTypePriceService
				.isAddOnPriceTypeByNameAndCarType(addOnTypePrice.getCarTypeName(), addOnTypePrice.getAddOnName());
		if (isAddOnType == null) {
			AddOnTypePrice newAddOnPriceType = addOnTypePriceService.saveAddOnPriceType(addOnTypePrice);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("addOnPriceTypeId", newAddOnPriceType.getId());
			response.setData(responseMap);
			response.setMsg("addOn price added successfully");

		} else {
			response.setMsg("addOn price already exist");
		}
		return response;
	}

	@GetMapping("{carType}/{addOnType}")
	public RestResponse getAddOnPrice(@PathVariable String carType, @PathVariable String addOnType) {
		RestResponse response = new RestResponse();
		AddOnTypePrice addOnTypePrice = addOnTypePriceService.getAddOnPrice(carType, addOnType);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("addOnPrice", addOnTypePrice.getPrice());
		response.setData(responseMap);
		response.setMsg("addOn price information fetch Successfully");
		return response;
	}


}