package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.UtenteDAO;
import com.library.form.mo.Utente;
import com.library.service.interfaces.UtenteServiceInterface;

@Service
public class UtenteService implements UtenteServiceInterface{

	@Autowired
	UtenteDAO utenteDAO;
	
	@Override
	public Utente loginControl(String nickname, String password) {
		
		Utente utente = utenteDAO.findByNickname(nickname);
		
		if(utente != null && utente.getPassword().equals(password)) {
			return utente;
		}
		
		return null;
	}
	
	public Utente findById(Integer id) {
		
		return utenteDAO.findById(id).orElse(null);
	}

	@Override
	public Utente save(Utente utente) {

		return utenteDAO.save(utente);
	}

}
