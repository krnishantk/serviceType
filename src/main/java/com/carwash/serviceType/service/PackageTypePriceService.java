package com.carwash.serviceType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.serviceType.dao.PackageTypePriceRepository;
import com.carwash.serviceType.model.PackageTypePrice;

@Service
public class PackageTypePriceService {

	@Autowired
	private PackageTypePriceRepository packageTypePriceRepository;

	public PackageTypePrice isPackageTypeByNameAndCarType(String carTypeName, String packageName) {
		return packageTypePriceRepository.findByCarTypeNameAndPackageName(carTypeName, packageName);
	}

	public PackageTypePrice savePackagePriceType(PackageTypePrice packageTypePrice) {
		return packageTypePriceRepository.save(packageTypePrice);
	}

	public PackageTypePrice getPackagePrice(String carType, String packageType) {
		return packageTypePriceRepository.findByCarTypeNameAndPackageName(carType, packageType);
	}

}
