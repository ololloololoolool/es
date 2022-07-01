package com.library.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.OrdineDAO;
import com.library.form.mo.Ordine;
import com.library.service.interfaces.OrdineServiceInterface;

@Service
public class OrdineService implements OrdineServiceInterface{

	@Autowired
	OrdineDAO ordineDAO;
	
	@Override
	public Ordine save(Ordine ordine) {
		return ordineDAO.save(ordine);
	}
	
	@Override
	public Set<Ordine> searchByUserId(Integer utenteId) {

		return ordineDAO.searchByUserId(utenteId);
	}

	@Override
	public Set<Ordine> searchByUsername(String username) {
		
		return ordineDAO.searchByUsername(username);
	}
	
}
