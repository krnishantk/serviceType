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

import com.carwash.serviceType.model.PackageType;
import com.carwash.serviceType.model.RestResponse;
import com.carwash.serviceType.service.PackageTypeService;

@RequestMapping("packageType")
@RestController
@CrossOrigin
public class PackageTypeResource {

	@Autowired
	private PackageTypeService packageTypeService;

	@PostMapping()
	public RestResponse addPackageType(@RequestBody PackageType packageType) {
		RestResponse response = new RestResponse();
		PackageType isPackageType = packageTypeService.isPackageTypeByName(packageType.getPackageName());
		if (isPackageType == null) {
			PackageType newPackageType = packageTypeService.savePackageType(packageType);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("packageTypeId", newPackageType.getId());
			response.setData(responseMap);
			response.setMsg("package type added successfully");

		} else {
			response.setMsg("package type already exist");
		}
		return response;
	}

	@GetMapping("getAllActivePackageType")
	public List<PackageType> getAllActivePackageType() {
		RestResponse response = new RestResponse();
		List<PackageType> packageType = packageTypeService.getAllActivePackageType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("packageType", packageType);
		response.setData(responseMap);
		response.setMsg("package type information fetch Successfully");
		return packageType;
	}

	@GetMapping("getAllPackageType")
	public List<PackageType> getAllPackageType() {
		RestResponse response = new RestResponse();
		List<PackageType> packageType = packageTypeService.getAllPackageType();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("packageType", packageType);
		response.setData(responseMap);
		response.setMsg("package type information fetch Successfully");
		return packageType;
	}

}
