package com.lakmal.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lakmal.rest.exception.DataAccessException;
import com.lakmal.rest.model.Country;
import com.lakmal.rest.service.CountryService;

@Controller
@RequestMapping("/v1")
public class CountryController {

	@Autowired
	private CountryService countryService;

	Logger LOG = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/countries", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> getCountries() throws DataAccessException {
		LOG.info("Accessing get country list service");
		try {
			return countryService.getCountries();
		} catch (Exception e) {
			LOG.error("Data access exception");
			throw new DataAccessException();
		}
	}

	@RequestMapping(value = "/country/{code}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountry(@PathVariable String code)
			throws DataAccessException {
		LOG.info("Accessing get country service with country code " + code);
		try {
			return countryService.getCountry(code);
		} catch (Exception e) {
			LOG.error("Data access exception");
			throw new DataAccessException();
		}
	}

	@RequestMapping(value = "/countryQu", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountryWithQueryParam(
			@RequestParam(value = "code", required = true) String code)
			throws DataAccessException {
		try {
			return countryService.getCountry(code);
		} catch (Exception e) {
			LOG.error("Data access exception");
			throw new DataAccessException();
		}
	}
}
