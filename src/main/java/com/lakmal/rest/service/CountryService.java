package com.lakmal.rest.service;

import java.util.List;

import com.lakmal.rest.model.Country;

public interface CountryService {
	public List<Country> getCountries();

	public Country getCountry(String code);
}
