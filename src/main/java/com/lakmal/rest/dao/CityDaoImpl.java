package com.lakmal.rest.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lakmal.rest.model.City;

@Repository
public class CityDaoImpl implements CityDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<City> getCityiesForCountry(String code) {
		String sql = "SELECT * FROM world.City where CountryCode = ?";
		List<City> countries = (List<City>) jdbcTemplate.query(sql,
				new Object[] { code }, new BeanPropertyRowMapper<City>(
						City.class));

		return countries;
	}

}
