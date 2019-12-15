package com.altran.security;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.altran.dto.UsuarioDTO;
import com.altran.service.ClientService;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(ImplementsUserDetailsService.class);
	
	@Autowired
	private ClientService service;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		log.info("ImplementsUserDetailsService:loadUserByUsername() - LOGIN: " + login);
		UsuarioDTO usuario = service.buscaUsuario(login);
		
		if (usuario == null) {
			log.warn("ImplementsUserDetailsService:loadUserByUsername() - USUARIO NÃO ENCONTRADO!");
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		log.info("ImplementsUserDetailsService:loadUserByUsername() - USUARIO ENCONTRADO COM SUCESSO!");
		return new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
}
