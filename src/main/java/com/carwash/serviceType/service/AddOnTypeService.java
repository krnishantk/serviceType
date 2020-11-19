package com.carwash.serviceType.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.serviceType.dao.AddOnTypeRepository;
import com.carwash.serviceType.model.AddOnType;

@Service
public class AddOnTypeService {

	@Autowired
	private AddOnTypeRepository addOnTypeRepository;

	public List<AddOnType> getAllAddOn() {
		return addOnTypeRepository.findAll();
	}

	public AddOnType isAddOnTypeByName(String addOnName) {
		return addOnTypeRepository.findByAddOnName(addOnName);
	}

	public AddOnType saveAddOnType(AddOnType addOnType) {
		return addOnTypeRepository.save(addOnType);
	}

	public List<AddOnType> getAllActiveAddOnType() {
		return addOnTypeRepository.findByIsActive(true);
	}

	public List<AddOnType> getAllAddOnType() {
		return addOnTypeRepository.findAll();
	}

}
