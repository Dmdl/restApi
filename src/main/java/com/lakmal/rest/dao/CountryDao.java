package com.lakmal.rest.dao;

import java.util.List;

import com.lakmal.rest.model.Country;

public interface CountryDao {

	public List<Country> getCountries();

	public Country getCountry(String code);
}
