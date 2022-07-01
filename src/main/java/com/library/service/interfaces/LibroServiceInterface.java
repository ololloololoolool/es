package com.library.service.interfaces;

import java.util.List;

import com.library.form.mo.Libro;

public interface LibroServiceInterface {

	public List<Libro> search(String titolo, String autore, String editore);
	
	public Libro searchByISBN(String isbn);
	
	public void addAll(List<Libro> libri);
	
	public void save(Libro libro);
	
}
