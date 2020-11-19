package com.carwash.serviceType.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.serviceType.model.AddOnTypePrice;

@Repository
public interface AddOnTypePriceRepository extends MongoRepository<AddOnTypePrice, String> {

	AddOnTypePrice findByCarTypeNameAndAddOnName(String carType, String addOnName);

}
