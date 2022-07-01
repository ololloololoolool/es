package com.library.service.interfaces;

import java.util.Set;

import com.library.form.mo.Ordine;

public interface OrdineServiceInterface {

	public Ordine save(Ordine ordine);
	
	public Set<Ordine> searchByUserId(Integer utenteId);
	
	public Set<Ordine> searchByUsername(String username);
}
