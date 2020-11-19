package com.carwash.serviceType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.serviceType.dao.AddOnTypePriceRepository;
import com.carwash.serviceType.model.AddOnTypePrice;

@Service
public class AddOnTypePriceService {

	@Autowired
	private AddOnTypePriceRepository addOnTypePriceRepository;

	public AddOnTypePrice isAddOnPriceTypeByNameAndCarType(String carTypeName, String addOnName) {
		return addOnTypePriceRepository.findByCarTypeNameAndAddOnName(carTypeName, addOnName);
	}

	public AddOnTypePrice saveAddOnPriceType(AddOnTypePrice addOnTypePrice) {
		return addOnTypePriceRepository.save(addOnTypePrice);
	}

	public AddOnTypePrice getAddOnPrice(String carType, String addOnType) {
		return addOnTypePriceRepository.findByCarTypeNameAndAddOnName(carType, addOnType);
	}

}
