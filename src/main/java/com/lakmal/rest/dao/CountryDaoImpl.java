package com.lakmal.rest.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lakmal.rest.model.Country;

public class CountryDaoImpl extends JdbcDaoSupport implements CountryDao {

	public List<Country> getCountries() {
		String sql = "SELECT * FROM Country";
		List<Country> countries = (List<Country>) getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Country.class));
		return countries;
	}

	public Country getCountry(String code) {
		String sql = "SELECT * FROM Country WHERE Code=?";
		Country country = (Country) getJdbcTemplate()
				.queryForObject(sql, new Object[] { code },
						new BeanPropertyRowMapper(Country.class));
		return country;
	}

}
