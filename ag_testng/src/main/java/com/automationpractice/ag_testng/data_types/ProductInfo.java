package com.automationpractice.ag_testng.data_types;

public class ProductInfo {
	private String name;
	private String size;
	private String color;

	public String getName() {
		return name;
	}

	public ProductInfo setName(String name) {
		this.name = name;
		return this;
	}

	public String getSize() {
		return size;
	}

	public ProductInfo setSize(String size) {
		this.size = size;
		return this;
	}

	public String getColor() {
		return color;
	}

	public ProductInfo setColor(String color) {
		this.color = color;
		return this;
	}
}
