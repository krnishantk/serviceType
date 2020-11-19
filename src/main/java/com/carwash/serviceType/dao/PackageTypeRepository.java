package com.carwash.serviceType.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.serviceType.model.PackageType;

@Repository
public interface PackageTypeRepository extends MongoRepository<PackageType, String> {
	
	List<PackageType> findByIsActive(Boolean isActive);
	 
	PackageType findByPackageName(String packageTypeName);

}
