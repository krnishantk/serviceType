package com.carwash.serviceType.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.serviceType.model.CarType;
import java.lang.Boolean;
import java.util.List;

@Repository
public interface CarTypeRepository extends MongoRepository<CarType, String> {
	
	 List<CarType> findByIsActive(Boolean isactive);
	 
	 CarType findByCarTypeName(String carTypeName);
	
}
