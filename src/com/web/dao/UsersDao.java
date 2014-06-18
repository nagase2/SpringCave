package com.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("usersDao")
public class UsersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setDatasource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public boolean create(User user){
		//Beanに登録された値を自動的にSQLに設定する
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username,  password, email, enabled) values (:username, :password, :email, :enabled)", params);
		return jdbc.update("insert into authorities (username, authority) values(:username, :authority)",params) == 1;
	}


	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username",
				new MapSqlParameterSource("username",username), Integer.class) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Logger.getRootLogger().info("Allusers method");
		Logger.getRootLogger().info(session().createQuery("from User").getQueryString());
		
		return session().createQuery("from User").list();
	}
	
//	public List<User> getAllUsers2() {
//		Logger.getRootLogger().info("Allusers method");
//		return jdbc.query("select * from users,  authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
//	}
	
}
