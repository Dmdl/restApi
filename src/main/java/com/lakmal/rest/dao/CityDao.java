package com.lakmal.rest.dao;

import java.util.List;

import com.lakmal.rest.model.City;

public interface CityDao {

	public List<City> getCityiesForCountry(String code);
}
