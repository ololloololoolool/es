package com.library.service.interfaces;

import com.library.form.mo.Utente;

public interface UtenteServiceInterface {

	public Utente loginControl(String nickname, String password);

	public Utente findById(Integer id);
	
	public Utente save(Utente utente);
}
