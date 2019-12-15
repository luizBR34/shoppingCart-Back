package com.altran.service.impl;

import com.altran.dto.ItemDTO;
import com.altran.dto.RoleDTO;
import com.altran.dto.UsuarioDTO;
import com.altran.model.Item;
import com.altran.model.Role;
import com.altran.model.Usuario;

public abstract class ClientServiceAbstract {
	
	public UsuarioDTO parserUserEntityToDTO(Usuario entity) {
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNomeCompleto(entity.getNomeCompleto());
		dto.setEmail(entity.getEmail());
		dto.setSenha(entity.getSenha());
		dto.setRole(parserRoleEntityToDTO(entity.getRole()));
		
		return dto;
	}
	
	public RoleDTO parserRoleEntityToDTO(Role entity) {
		RoleDTO dto = new RoleDTO();
		dto.setNomeRole(entity.getNomeRole());
		
		return dto;
	}
	
	
	public ItemDTO parserItemEntityToDTO(Item entity) {
		
		ItemDTO dto = new ItemDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setUsuario(parserUserEntityToDTO(entity.getUsuario()));
		dto.setValor(entity.getValor());
		
		return dto;
	}
	
}
