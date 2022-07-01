package com.library.service.interfaces;

import java.util.List;
import java.util.Set;

import com.library.form.mo.LibriPerOrdine;

public interface LibriPerOrdineServiceInterface {

	public void saveAllBooks(Set<LibriPerOrdine> libri);
	
	public List<Object> searchBooksSelled();
}
