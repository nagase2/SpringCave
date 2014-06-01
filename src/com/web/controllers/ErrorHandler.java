package com.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException dae){
		System.out.println("DatabaseErrorHandler");
		dae.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(AccessDeniedException ex){
		Logger.getRootLogger().info("Error handler");
		return "denied";
	}

}
