package com.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("usersDao")
public class UsersDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDatasource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public boolean create(User user){
		//Beanに登録された値を自動的にSQLに設定する
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username,  password, email, enabled) values (:username, :password, :email, :enabled)", params);
		return jdbc.update("insert into authorities (username, authority) values(:username, :authority)",params) == 1;
	}
	
	
}
