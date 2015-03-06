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
	public List<Country> getCountries() {
		LOG.debug("Accessing get country list service");
		return countryService.getCountries();
	}

	@RequestMapping(value = "/country/{code}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountry(@PathVariable String code) {
		LOG.debug("Accessing get country service with country code " + code);
		return countryService.getCountry(code);
	}

	@RequestMapping(value = "/countryQu", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountryWithQueryParam(
			@RequestParam(value = "code", required = true) String code) {
		return countryService.getCountry(code);
	}
}
