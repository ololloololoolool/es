package com.library.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.form.mo.Carrello;
import com.library.form.mo.LibriPerCarrello;
import com.library.form.mo.LibriPerOrdine;
import com.library.form.mo.Libro;
import com.library.form.mo.Ordine;
import com.library.form.mo.SearchBooksMO;
import com.library.form.mo.Utente;
import com.library.service.interfaces.CarrelloServiceInterface;
import com.library.service.interfaces.LibriPerCarrelloServiceInterface;
import com.library.service.interfaces.LibriPerOrdineServiceInterface;
import com.library.service.interfaces.LibroServiceInterface;
import com.library.service.interfaces.OrdineServiceInterface;
import com.library.service.interfaces.UtenteServiceInterface;

@Controller
public class ShopController {

	@Autowired
	OrdineServiceInterface ordineService;
	
	@Autowired
	UtenteServiceInterface utenteService;
	
	@Autowired
	LibriPerCarrelloServiceInterface lpcService;
	
	@Autowired
	CarrelloServiceInterface carrelloService;
	
	@Autowired
	LibriPerOrdineServiceInterface lpoService;
	
	@Autowired
	LibroServiceInterface libroService;
	
	@GetMapping("/shop")
	public String shop(Model model, HttpServletRequest request) {
		
		Double totale = 0d;
		
		Utente utente = utenteService.findById((Integer)request.getSession().getAttribute("userId"));
		
		Carrello carrello = carrelloService.findByUserId((Integer)request.getSession().getAttribute("userId"));
		
		List<Libro> libri = new ArrayList<>();
		
		List<LibriPerCarrello> libriNelCarrello = lpcService.searchByCartId(carrello.getId());
		
		Set<LibriPerOrdine> libriOrdine = new HashSet<>();
		LibriPerOrdine nuovoLibro;
		
		for (LibriPerCarrello libroCarrello : libriNelCarrello) {
			
			nuovoLibro = new LibriPerOrdine();
			
			totale +=
					( libroCarrello.getLibro().getPrezzo() -
							(libroCarrello.getLibro().getPrezzo() * libroCarrello.getLibro().getSconto() /100) )
								* libroCarrello.getQuantita();
			
			libroCarrello.getLibro().setCopie(
					libroCarrello.getLibro().getCopie() - libroCarrello.getQuantita());
			libri.add(libroCarrello.getLibro());
			
			nuovoLibro.setLibro(libroCarrello.getLibro());
			nuovoLibro.setPrezzoInFaseDiAcquisto(libroCarrello.getLibro().getPrezzo());
			nuovoLibro.setScontoInFaseDiAcquisto(libroCarrello.getLibro().getSconto());
			nuovoLibro.setQuantita(libroCarrello.getQuantita());
			
			libriOrdine.add(nuovoLibro);
		}
		
		if(utente.getCredito() - totale > 0) {
			
			utente.setCredito(utente.getCredito() - totale);
			
			Ordine ordine = new Ordine();
			ordine.setUtente(utente);
			ordine.setDataOrdine(LocalDateTime.now());
			ordine.setTotale(totale);
			ordine.setLibri(libriOrdine);
			ordine = ordineService.save(ordine);
			
			for (LibriPerOrdine libroOrdine : libriOrdine) {
	
				libroOrdine.setOrdine(ordine);
			}
			
			lpoService.saveAllBooks(libriOrdine);
			utenteService.save(utente);
			libroService.addAll(libri);
			lpcService.deleteBooksInCart(libriNelCarrello);
			
			return "redirect:/history";
		}
		
		model.addAttribute("insufficientCredit", true);
		model.addAttribute("searchBookData", new SearchBooksMO());
		
		return "home";
	}
	
}
