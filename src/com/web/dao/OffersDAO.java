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

@Component("offersDao123")
public class OffersDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDatasource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers(){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name","mike");
		params.addValue("id", "1");
		
		return jdbc.query("select * from offers ",new RowMapper<Offer>(){
			
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException{
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}
		});
	}
	public int update(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name, text=:text, email=:email where name like :name",params);
	}
	
	public boolean create(Offer offer){
		//Beanに登録された値を自動的にSQLに設定する
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name, text, email) values(:name, :text, :email)",params) == 1;
	}
	
	public int[] create(List<Offer> offers){
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offers (name, text, email) values(:name, :text, :email)", params);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);
		return jdbc.update("delete from offers where id=:id", params);
	}
	
	public Offer getOffers(int id){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>(){
			
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException{
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}
		});
	}
}
