package com.library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.form.mo.Carrello;
import com.library.form.mo.LoginMO;
import com.library.form.mo.SearchBooksMO;
import com.library.form.mo.Utente;
import com.library.service.interfaces.CarrelloServiceInterface;
import com.library.service.interfaces.UtenteServiceInterface;

@Controller
public class LoginController {
	
	@Autowired
	UtenteServiceInterface utenteService;
	
	@Autowired
	CarrelloServiceInterface carrelloService;

	@GetMapping({"/","/index", "/login"})
	public String mainPage(Model model) {
		
		model.addAttribute("loginData", new LoginMO());
		
		return "login";
	}
	
	@PostMapping("/login/control")
	public String controlLoginData(@Valid @ModelAttribute("loginData") LoginMO logData, BindingResult br, Model model, HttpServletRequest request) {
		
		Utente utente = null;
		
		if(br.hasErrors() || br.hasFieldErrors()) {
			
			model.addAttribute("blankField", true);
			
			return "login";
		}
		
		if( ( utente = utenteService.loginControl(logData.getNick(), logData.getPassword()) ) != null) {
			
			if(utente.getCarrello() == null) {
			
				utente.setCarrello(new Carrello());
				utente.getCarrello().setUtente(utente);
				
				carrelloService.save(utente.getCarrello());
			}
			
			request.getSession().setAttribute("userId", utente.getId());
			request.getSession().setAttribute("isAdmin", utente.getAdmin() == 'Y' ? true : false);
			
			model.addAttribute("books", null);
			model.addAttribute("searchBookData", new SearchBooksMO());
			
			return "home";
			
		}
		
		model.addAttribute("wrongPassword", true);
		
		return "login";
	}
	
}
