package com.lakmal.rest.model;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * Person model class
	 */
	private static final long serialVersionUID = 757985997823327253L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
