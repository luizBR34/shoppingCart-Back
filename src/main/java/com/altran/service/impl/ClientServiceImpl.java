package com.altran.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.dto.ItemDTO;
import com.altran.dto.UsuarioDTO;
import com.altran.model.Item;
import com.altran.model.Usuario;
import com.altran.repository.ItemRepository;
import com.altran.repository.UsuarioRepository;
import com.altran.service.ClientService;

@Service
public class ClientServiceImpl extends ClientServiceAbstract implements ClientService {
	
	private Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private ItemRepository ir;

	@Override
	public UsuarioDTO buscaUsuario(String email) {
		
		log.info("ClientServiceImpl:buscaUsuario()");

		Usuario usuario = ur.findByEmail(email);
		UsuarioDTO dto = parserUserEntityToDTO(usuario);
		
		return dto;
	}


	@Override
	public Iterable<ItemDTO> listaItems() {
		
		log.info("ClientServiceImpl:listaItems()");
		
		List<Item> lista = (List<Item>) ir.findAll();
		List<ItemDTO> listaDTO = lista.stream()
									  .filter(a -> nonNull(a.getId()))
									  .map(a -> parserItemEntityToDTO(a))
									  .collect(Collectors.toList());

		return listaDTO;
	}
}
