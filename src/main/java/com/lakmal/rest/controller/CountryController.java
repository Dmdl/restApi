package com.lakmal.rest.controller;

import java.util.List;

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
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/countries", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> getCountries() {
		return countryService.getCountries();
	}

	@RequestMapping(value = "/country/{code}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountry(@PathVariable String code) {
		return countryService.getCountry(code);
	}

	@RequestMapping(value = "/countryQu", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountryWithQueryParam(
			@RequestParam(value = "code", required = true) String code) {
		return countryService.getCountry(code);
	}
}
