package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.form.mo.Carrello;
import com.library.form.mo.LibriPerCarrello;
import com.library.form.mo.Libro;
import com.library.form.mo.SearchBooksMO;
import com.library.service.interfaces.CarrelloServiceInterface;
import com.library.service.interfaces.LibriPerCarrelloServiceInterface;
import com.library.service.interfaces.LibroServiceInterface;

@Controller
public class CartController {

	@Autowired
	CarrelloServiceInterface carrelloService;
	
	@Autowired
	LibroServiceInterface libroService;
	
	@Autowired
	LibriPerCarrelloServiceInterface lpcService;
	
	@PostMapping("/cart/add")
	public String addToCart(Model model, HttpServletRequest request) {
		
		Carrello carrello = carrelloService.findByUserId((Integer)request.getSession().getAttribute("userId"));
		
		Libro libro = libroService.searchByISBN(request.getParameter("isbn"));
		
		LibriPerCarrello lpc =
				lpcService.searchByCartIdAndISBN(carrello.getId(), libro.getIsbn());

		if(lpc == null) {
			
			lpc = new LibriPerCarrello();
			lpc.setCarrello(carrello);
			lpc.setLibro(libro);
		}
		
		lpc.setQuantita(Integer.parseInt(request.getParameter("copie")));
		lpcService.save(lpc);
		
		model.addAttribute("searchBookData", new SearchBooksMO());
		
		return "home";
	}
	
	@GetMapping("/cart")
	public String viewCart(Model model, HttpServletRequest request) {
		
		List<LibriPerCarrello> books =
				lpcService.searchBooksInCartByUserId((Integer)request.getSession().getAttribute("userId"));
		
		model.addAttribute("books", books);
		
		for (LibriPerCarrello book : books) {
			
			if(book.getLibro().getCopie() < book.getQuantita()) {
				
				book.setQuantita(book.getLibro().getCopie());
				lpcService.save(book);
			}
		}
		
		return "cart";
	}
	
//	private LibriPerCarrello getLibriPerCarrello(HttpServletRequest request) {
//		
//		Carrello carrello = carrelloService.findByUserId((Integer)request.getSession().getAttribute("userId"));
//		
//		Libro libro = libroService.searchByISBN(request.getParameter("isbn"));
//		
//		return lpcService.searchByCartIdAndISBN(carrello.getId(), libro.getIsbn());
//	}
	
	@GetMapping("/cart/remove/{id}")
	public String removeFromCart(@PathVariable(name = "id") Integer id) {
		
		lpcService.deleteById(id);
		
		return "redirect:/cart";
	}
	
}
