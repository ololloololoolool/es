package com.library.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.form.mo.Ordine;
import com.library.service.interfaces.OrdineServiceInterface;

@Controller
public class HistoryController {

	@Autowired
	OrdineServiceInterface ordineService;
	
	@GetMapping("/history")
	public String userOrderHistory(Model model, HttpServletRequest request) {
		
		Set<Ordine> ordini =
				ordineService.searchByUserId( (Integer) request.getSession().getAttribute("userId") );
		
		model.addAttribute("ordini", ordini);
		
		return "orderHistory";
	}
	
}
