package com.carwash.serviceType.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PackageTypePrice {

	@Id
	private String id;

	@NotBlank(message = "carTypeName cannot be empty")
	private String carTypeName;

	@NotBlank(message = "packageName cannot be empty")
	private String packageName;

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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
		return "PackageType [id=" + id + ", carTypeName=" + carTypeName + ", packageName=" + packageName + ", price="
				+ price + ", discription=" + discription + "]";
	}

}
