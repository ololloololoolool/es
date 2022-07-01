package com.library.service.interfaces;

import com.library.form.mo.Carrello;

public interface CarrelloServiceInterface {

	public Carrello save(Carrello carrello);
	
	public Carrello findByUserId(Integer UserId);
	
}
