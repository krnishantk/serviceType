package com.carwash.serviceType.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.serviceType.dao.CarTypeRepository;
import com.carwash.serviceType.model.CarType;

@Service
public class CarTypeService {

	@Autowired
	private CarTypeRepository carTypeRepository;

	public List<CarType> getAllActiveCarType() {
		return carTypeRepository.findByIsActive(true);
	}

	public List<CarType> getAllCarType() {
		return carTypeRepository.findAll();
	}

	public CarType isCarTypeByName(String carTypeName) {
		return carTypeRepository.findByCarTypeName(carTypeName);
	}

	public CarType saveCarType(CarType carType) {
		return carTypeRepository.save(carType);
	}

}
