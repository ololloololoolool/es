package com.library.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibriPerOrdineDAO;
import com.library.form.mo.LibriPerOrdine;
import com.library.service.interfaces.LibriPerOrdineServiceInterface;

@Service
public class LibriPerOrdineService implements LibriPerOrdineServiceInterface{

	@Autowired
	LibriPerOrdineDAO libriPerOrdineDAO;
	
	@Override
	public void saveAllBooks(Set<LibriPerOrdine> libri) {
		
		libriPerOrdineDAO.saveAll(libri);
	}

	@Override
	public List<Object> searchBooksSelled() {

		return libriPerOrdineDAO.searchBooksSelled();
	}

}
