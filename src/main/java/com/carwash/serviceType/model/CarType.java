package com.carwash.serviceType.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarType {

	@Id
	private String id;

	@NotBlank(message = "userId cannot be empty")
	private String carTypeName;

	private String carTypeDetails;

	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getCarTypeDetails() {
		return carTypeDetails;
	}

	public void setCarTypeDetails(String carTypeDetails) {
		this.carTypeDetails = carTypeDetails;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CarType [id=" + id + ", carTypeName=" + carTypeName + ", carTypeDetails=" + carTypeDetails
				+ ", isActive=" + isActive + "]";
	}

}
