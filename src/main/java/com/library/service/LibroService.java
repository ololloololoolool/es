package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibroDAO;
import com.library.form.mo.Libro;
import com.library.service.interfaces.LibroServiceInterface;

@Service
public class LibroService implements LibroServiceInterface{

	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> search(String titolo, String autore, String editore) {

		return libroDAO.search(titolo, autore, editore);
	}

	@Override
	public Libro searchByISBN(String isbn) {

		return libroDAO.findById(isbn).orElse(null);
	}

	@Override
	public void addAll(List<Libro> libri) {

		libroDAO.saveAll(libri);
	}

	@Override
	public void save(Libro libro) {

		libroDAO.save(libro);
	}

}
