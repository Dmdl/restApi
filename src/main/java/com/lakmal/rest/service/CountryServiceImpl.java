package com.lakmal.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lakmal.rest.dao.CityDao;
import com.lakmal.rest.dao.CountryDao;
import com.lakmal.rest.model.City;
import com.lakmal.rest.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;

	@Transactional
	@Override
	public List<Country> getCountries() {
		List<Country> countries = countryDao.getCountries();
		List<Country> countryList = new ArrayList<>();
		for (Country country : countries) {
			List<City> cityies = cityDao
					.getCityiesForCountry(country.getCode());
			country.setCities(cityies);
			countryList.add(country);
		}
		return countryList;
	}

	@Transactional
	public Country getCountry(String code) {
		Country country = countryDao.getCountry(code);
		country.setCities(cityDao.getCityiesForCountry(country.getCode()));
		return country;
	}

}
