package com.carwash.serviceType.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddOnTypePrice {

	@Id
	private String id;

	@NotBlank(message = "carTypeName cannot be empty")
	private String carTypeName;

	@NotBlank(message = "userId cannot be empty")
	private String addOnName;

	@NotBlank(message = "price cannot be empty")
	private Double price;

	private String discription;

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

	public String getAddOnName() {
		return addOnName;
	}

	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "AddOnType [id=" + id
				+ ", carTypeName=" + carTypeName + ", addOnName=" + addOnName + ", price=" + price
				+ ", discription=" + discription + "]";
	}

}
