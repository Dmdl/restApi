package com.lakmal.rest.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lakmal.rest.model.City;

public class CityDaoImpl extends JdbcDaoSupport implements CityDao {

	@Override
	public List<City> getCityiesForCountry(String code) {
		String sql = "SELECT * FROM world.City where CountryCode = ?";
		List<City> countries = (List<City>) getJdbcTemplate().query(sql,
				new Object[] { code }, new BeanPropertyRowMapper(City.class));

		return countries;
	}

}
