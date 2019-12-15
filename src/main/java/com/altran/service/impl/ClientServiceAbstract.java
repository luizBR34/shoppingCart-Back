package com.altran.service.impl;

import com.altran.dto.RoleDTO;
import com.altran.dto.UsuarioDTO;
import com.altran.model.Role;
import com.altran.model.Usuario;

public abstract class ClientServiceAbstract {
	
	public UsuarioDTO parseEntityToDTO(Usuario entity) {
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNomeCompleto(entity.getNomeCompleto());
		dto.setEmail(entity.getEmail());
		dto.setSenha(entity.getSenha());
		dto.setRole(parseEntityToDTO(entity.getRole()));
		
		return dto;
	}
	
	public RoleDTO parseEntityToDTO(Role entity) {
		RoleDTO dto = new RoleDTO();
		dto.setNomeRole(entity.getNomeRole());
		
		return dto;
	}

}
