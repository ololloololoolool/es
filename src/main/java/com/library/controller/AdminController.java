package com.library.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.form.mo.Libro;
import com.library.form.mo.Ordine;
import com.library.service.interfaces.LibriPerOrdineServiceInterface;
import com.library.service.interfaces.LibroServiceInterface;
import com.library.service.interfaces.OrdineServiceInterface;

@Controller
public class AdminController {

	@Autowired
	LibroServiceInterface libroService;
	
	@Autowired
	OrdineServiceInterface ordineService;
	
	@Autowired
	LibriPerOrdineServiceInterface lpo;
	
	@GetMapping("/adminPage")
	public String adminPage() {
		
		return "adminView";
	}
	
	@GetMapping("/addBookView")
	public String addBookView(Model model) {
		
		model.addAttribute("book", new Libro());
		
		return "addBookView";
	}
	
	@GetMapping("/salesView")
	public String salesView(Model model) {
		
		List<Object> books = lpo.searchBooksSelled();
		
		model.addAttribute("books", books);
		
		return "salesView";
	}
	
	@GetMapping("/clientHistoryView")
	public String clientHistoryView() {
		
		return "clientHistoryView";
	}
	
	@PostMapping("/admin/book/add")
	public String addBook(@ModelAttribute(name = "book") Libro libro) {
		
		libroService.save(libro);
		
		return "redirect:/book/isbn/"+libro.getIsbn();
	}
	
	@PostMapping("/admin/history")
	public String userOrderHistoryForAdmin(Model model, HttpServletRequest request) {
		
		Set<Ordine> ordini =
				ordineService.searchByUsername( (String) request.getParameter("username") );
		
		model.addAttribute("ordini", ordini);
		
		return "orderHistory";
	}
	
}
