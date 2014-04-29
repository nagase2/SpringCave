package com.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.*;
import com.web.dao.Offer;
import com.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	/*
	@RequestMapping("/")
	public ModelAndView showHome(){
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "River");
		
		return mv;
	}
	*/
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	
	@RequestMapping("/old")
	public String showOld(Model model){
		model.addAttribute("name", "<b>Tiffany</b>");
		model.addAttribute("age","1000 years");
		Map map = new HashMap<String, String>();
		map.put("abc", "First");
		map.put("test", "OK");
		model.addAllAttributes(map);
		return "home";
	}
	@RequestMapping("/xxx")
	public String showX(HttpSession session){
		session.setAttribute("name", "I'm X");
		return "home";
	}
	@RequestMapping("/name")
	public String showHome(HttpSession session){
		session.setAttribute("name", "Boris");
		return "home";
	}
	
	
	@RequestMapping("/offers")
	public String showOffers(Model model){
		
		//offersService.throwTestException();
		
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers",offers);
		
		return "offers";
	}
	
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseException(DataAccessException dae){
//		return "error";
//	}

	//@RequestMapping(value="/test",method=RequestMethod.GET)
	@RequestMapping("/test")
	public String showTest(Model model,@RequestParam("id") String id){
		
		System.out.println("ID is"+ id);
		
		return "home";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model){
		//List<Offer> offers = offersService.getCurrent();
		//model.addAttribute("offers",offers);
		model.addAttribute("offer",new Offer());
		
		
		return "createOffer";
	}
	@RequestMapping("/docreate")
	public String doCreate(Model model,@Valid Offer offer,BindingResult result){
		
		System.out.println(offer);
		if(result.hasErrors()){
			System.out.println("form does not validate.");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createOffer";
			
		}else{
			System.out.println("Form validated.");
			offersService.create(offer);
		}
		
		return "offercreated";
	}
}
