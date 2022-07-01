package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.form.mo.Libro;
import com.library.form.mo.SearchBooksMO;
import com.library.service.interfaces.LibroServiceInterface;

@Controller
public class SearchBooksController {

	@Autowired
	LibroServiceInterface libroService;
	
	@PostMapping("/book/search")
	public String searchBooks(Model model, @ModelAttribute("searchBookData") SearchBooksMO searchData) {
		
		List<Libro> libri = null;
		
		if(
				(searchData.getAutore() == null ||
				searchData.getAutore().trim().equals("")) &&
				(searchData.getEditore() == null ||
				searchData.getEditore().trim().equals("")) &&
				(searchData.getTitolo() == null ||
				searchData.getTitolo().trim().equals("")) ) {
			
			model.addAttribute("allBlank", true);
			
			return "home";
		}
		
		libri = libroService.search(
				searchData.getTitolo() != null ? searchData.getTitolo() : "",
				searchData.getAutore() != null ? searchData.getAutore() : "",
				searchData.getEditore() != null ? searchData.getEditore() : "");
		
		model.addAttribute("books", libri);
		
		return "home";
	}
	
	@GetMapping("/book/isbn/{isbn}")
	public String searchBook(@PathVariable(name = "isbn") String isbn, Model model) {
		
		Libro libro = null;
		
		if ( ( libro = libroService.searchByISBN(isbn) ) != null) {
			
			model.addAttribute("book", libro);
			
			return "bookInfo";
		}
		
		else {
			
			model.addAttribute("notExistingISBN", true);
			model.addAttribute("searchBookData", new SearchBooksMO());
			
			return "home";
		}
	}
	
}
