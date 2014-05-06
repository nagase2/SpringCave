

package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.Offer;
import com.web.dao.OffersDao;

@Service("offersService")
public class OffersService {
	
	private OffersDao offersDAO;
	
	@Autowired
	public void setOffersDao(OffersDao offersDAO){
		System.out.println("setOffersDao");
		this.offersDAO = offersDAO;
	}
	
	public List<Offer> getCurrent(){
		return offersDAO.getOffers();
	}

	public void create(Offer offer) {
		offersDAO.create(offer);
			
	}

	public void throwTestException() {
		offersDAO.getOffers(9999);
	}
}
