package com.library.service.interfaces;

import java.util.List;

import com.library.form.mo.LibriPerCarrello;

public interface LibriPerCarrelloServiceInterface {

	public LibriPerCarrello searchByCartIdAndISBN(Integer Id, String isbn);
	
	public List<LibriPerCarrello> searchByCartId(Integer Id);
	
	public LibriPerCarrello save(LibriPerCarrello lpc);
	
	public List<LibriPerCarrello> searchBooksInCartByUserId(Integer userId);
	
	public void deleteById(Integer id);
	
	public void deleteBooksInCart(List<LibriPerCarrello> libri);
}
