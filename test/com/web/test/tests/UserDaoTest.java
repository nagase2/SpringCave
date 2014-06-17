package com.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.dao.User;
import com.web.dao.UsersDao;


@ActiveProfiles("dev")
@ContextConfiguration(locations={
		"classpath:com/web/config/dao-context.xml",
		"classpath:com/web/config/security-context.xml",
		"classpath:com/web/test/config/datasource.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
	}
	
	@Test
	public void testCreateUser(){
		User user = new User("jossss","ccccccc","aaa@ttt.com",true,"ROLE_USER");
		assertTrue("User creation should return true",usersDao.create(user));
		
		List<User> users=usersDao.getAllUsers();
		assertEquals("Number of users should be 1", 1,users.size());
		assertTrue("User should exist", usersDao.exists(user.getUsername()));
		assertEquals("Created user should be identidal to restricted user", user.getEmail(), users.get(0).getEmail());
	}
	
	@Test
	public void testCreateUser2(){
		User user = new User("jossss","ccccccc","aaa@ttt.com",true,"ROLE_USER");
		assertTrue("User creation should return true",usersDao.create(user));
		
		List<User> users=usersDao.getAllUsers();
		assertEquals("Number of users should be 1", 1,users.size());
		
		assertTrue("User should exist", usersDao.exists(user.getUsername()));
		
		assertEquals("Created user should be identidal to restricted user", user.getEmail(), users.get(0).getEmail());
		
	}
}
