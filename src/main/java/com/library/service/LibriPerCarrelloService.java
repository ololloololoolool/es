package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibriPerCarrelloDAO;
import com.library.form.mo.LibriPerCarrello;
import com.library.service.interfaces.LibriPerCarrelloServiceInterface;

@Service
public class LibriPerCarrelloService implements LibriPerCarrelloServiceInterface{

	@Autowired
	LibriPerCarrelloDAO lpcDAO;
	
	@Override
	public LibriPerCarrello searchByCartIdAndISBN(Integer Id, String isbn) {

		return lpcDAO.searchByCartIdAndISBN(Id, isbn);
	}
	
	@Override
	public List<LibriPerCarrello> searchByCartId(Integer Id) {
		return lpcDAO.searchByCartId(Id);
	}

	@Override
	public LibriPerCarrello save(LibriPerCarrello lpc) {
		
		return lpcDAO.save(lpc);
	}

	@Override
	public List<LibriPerCarrello> searchBooksInCartByUserId(Integer userId) {

		return lpcDAO.searchBooksInCartByUserId(userId);
	}

	@Override
	public void deleteById(Integer id) {

		lpcDAO.deleteById(id);
	}

	@Override
	public void deleteBooksInCart(List<LibriPerCarrello> libri) {

		lpcDAO.deleteAll(libri);
	}

}
