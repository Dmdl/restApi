package com.lakmal.rest.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lakmal.rest.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Country> getCountries() {
		String sql = "SELECT * FROM Country";
		List<Country> countries = (List<Country>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<Country>(Country.class));
		return countries;
	}

	public Country getCountry(String code) {
		String sql = "SELECT * FROM Country WHERE Code=?";
		Country country = (Country) jdbcTemplate.queryForObject(sql,
				new Object[] { code }, new BeanPropertyRowMapper<Country>(
						Country.class));
		return country;
	}

}
