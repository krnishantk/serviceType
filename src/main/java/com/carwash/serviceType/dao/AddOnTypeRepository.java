package com.carwash.serviceType.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.serviceType.model.AddOnType;

@Repository
public interface AddOnTypeRepository extends MongoRepository<AddOnType, String> {
	
	List<AddOnType> findByIsActive(Boolean isActive);
	 
	AddOnType findByAddOnName(String packageTypeName);
	

}
