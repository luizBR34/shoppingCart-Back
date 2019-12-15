package com.altran.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.dto.UsuarioDTO;
import com.altran.model.Usuario;
import com.altran.repository.UsuarioRepository;
import com.altran.service.ClientService;

@Service
public class ClientServiceImpl extends ClientServiceAbstract implements ClientService {
	
	private Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	private UsuarioRepository ur;


	public UsuarioDTO buscaUsuario(String email) {
		
		log.info("ClientServiceImpl:buscaUsuario()");

		Usuario usuario = ur.findByEmail(email);
		UsuarioDTO dto = parseEntityToDTO(usuario);
		
		return dto;
	}
}
