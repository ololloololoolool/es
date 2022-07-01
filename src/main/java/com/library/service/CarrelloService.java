package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.CarrelloDAO;
import com.library.form.mo.Carrello;
import com.library.service.interfaces.CarrelloServiceInterface;

@Service
public class CarrelloService implements CarrelloServiceInterface{

	@Autowired
	CarrelloDAO carrelloDAO;
	
	@Override
	public Carrello save(Carrello carrello) {

		return carrelloDAO.save(carrello);
	}

	@Override
	public Carrello findByUserId(Integer UserId) {
		
		return carrelloDAO.searchByUserId(UserId);
	}

}
