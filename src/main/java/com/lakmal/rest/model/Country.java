package com.lakmal.rest.model;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {

	/**
	 * Country model class
	 */
	private static final long serialVersionUID = 5857966081528675040L;
	private String code;
	private String name;
	private String region;
	private double gnp;
	private List<City> cities;

	public double getGnp() {
		return gnp;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
