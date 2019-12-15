package com.altran.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EventoController  {

	private Logger log = LoggerFactory.getLogger(EventoController.class);
	

/*	@RequestMapping(value="/listarItems", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody void Iterable<UsuarioDTO> listarItems(HttpServletResponse resposta) {
		
		log.info("EventoController:listarItems()");
		
		resposta.addHeader("Access-Control-Allow-Credentials", "true");
		resposta.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");		
		resposta.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
		resposta.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
	}*/
	
	
	@RequestMapping(value="/listarItems", method=RequestMethod.GET)
	public RedirectView formCadastrarEvento() {
		
		log.info("EventoController:formCadastrarEvento()");
	    RedirectView redirect = new RedirectView();
	    redirect.setUrl("http://localhost:4200/itemslist");
	    return redirect;
	}
	
	
	
}
