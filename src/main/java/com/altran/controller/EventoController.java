package com.altran.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altran.dto.ItemDTO;
import com.altran.service.ClientService;

@Controller
public class EventoController  {

	private Logger log = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private ClientService sr;
	

	@RequestMapping(value="/listarItems", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Iterable<ItemDTO> listarItems(HttpServletResponse resposta) {
		
		log.info("EventoController:listarItems()");
		
		resposta.addHeader("Access-Control-Allow-Credentials", "true");
		resposta.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");		
		resposta.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
		resposta.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");

		Iterable<ItemDTO> lista = sr.listaItems();

		return lista;
	}

}
