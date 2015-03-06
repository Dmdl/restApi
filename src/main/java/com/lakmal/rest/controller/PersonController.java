package com.lakmal.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lakmal.rest.model.Person;

@Controller
public class PersonController {

	@RequestMapping(value = "/person", produces = "application/json")
	@ResponseBody
	public Person getPerson() {
		Person person = new Person();
		person.setId(1);
		person.setName("Lakmal");
		return person;
	}
}
