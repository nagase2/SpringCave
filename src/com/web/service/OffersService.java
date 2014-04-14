package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.Offer;
import com.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDAO;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDAO){
		System.out.println("setOffersDao");
		this.offersDAO = offersDAO;
	}
	
	public List<Offer> getCurrent(){
		return offersDAO.getOffers();
	}
}