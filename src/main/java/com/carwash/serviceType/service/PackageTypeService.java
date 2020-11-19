package com.carwash.serviceType.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.serviceType.dao.PackageTypeRepository;
import com.carwash.serviceType.model.PackageType;

@Service
public class PackageTypeService {

	@Autowired
	private PackageTypeRepository packageTypeRepository;

	public PackageType isPackageTypeByName(String packageName) {
		return packageTypeRepository.findByPackageName(packageName);
	}

	public List<PackageType> getAllActivePackageType() {
		return packageTypeRepository.findByIsActive(true);
	}

	public List<PackageType> getAllPackageType() {
		return packageTypeRepository.findAll();
	}

	public PackageType savePackageType(PackageType packageType) {
		return packageTypeRepository.save(packageType);
	}

}
