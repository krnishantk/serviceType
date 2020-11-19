package com.carwash.serviceType.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.serviceType.model.PackageTypePrice;

@Repository
public interface PackageTypePriceRepository extends MongoRepository<PackageTypePrice, String> {
	
	PackageTypePrice findByCarTypeNameAndPackageName(String carType, String packageType);
	

}
