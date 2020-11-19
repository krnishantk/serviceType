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

import com.carwash.serviceType.model.PackageTypePrice;
import com.carwash.serviceType.model.RestResponse;
import com.carwash.serviceType.service.PackageTypePriceService;

@RequestMapping("packagePrice")
@RestController
@CrossOrigin
public class PackageTypePriceResource {

	@Autowired
	private PackageTypePriceService packageTypePriceService;

	@PostMapping()
	public RestResponse addPackagePrice(@RequestBody PackageTypePrice packageTypePrice) {
		RestResponse response = new RestResponse();
		PackageTypePrice isPackagePrice = packageTypePriceService
				.isPackageTypeByNameAndCarType(packageTypePrice.getCarTypeName(), packageTypePrice.getPackageName());
		if (isPackagePrice == null) {
			PackageTypePrice newPackagePriceType = packageTypePriceService.savePackagePriceType(packageTypePrice);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("packagePriceTypeId", newPackagePriceType.getId());
			response.setData(responseMap);
			response.setMsg("package price added successfully");

		} else {
			response.setMsg("package price already exist");
		}
		return response;
	}

	@GetMapping("{carType}/{packageType}")
	public RestResponse getPackagePrice(@PathVariable String carType, @PathVariable String packageType) {
		RestResponse response = new RestResponse();
		PackageTypePrice packageTypePrice = packageTypePriceService.getPackagePrice(carType, packageType);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("packagePrice", packageTypePrice.getPrice());
		response.setData(responseMap);
		response.setMsg("package price information fetch Successfully");
		return response;
	}

}
