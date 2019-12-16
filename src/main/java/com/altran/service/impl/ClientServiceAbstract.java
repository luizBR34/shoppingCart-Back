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
	
	
	public Usuario parserUserDTOToEntity(UsuarioDTO usuario) {
		
		Usuario user = new Usuario();
		user.setNomeCompleto(usuario.getNomeCompleto());
		user.setEmail(usuario.getEmail());
		user.setSenha(usuario.getPassword());
		user.setRole(parserRoleDTOToEntity(usuario.getRole()));
		
		return user;
	}
	
	
	public RoleDTO parserRoleEntityToDTO(Role entity) {
		RoleDTO dto = new RoleDTO();
		dto.setNomeRole(entity.getNomeRole());
		
		return dto;
	}
	
	
	public Role parserRoleDTOToEntity(RoleDTO dto) {
		
		Role role = new Role();
		role.setNomeRole(dto.getNomeRole());
		
		return role;
	}
	
	
	
	public ItemDTO parserItemEntityToDTO(Item entity) {
		
		ItemDTO dto = new ItemDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setUsuario(parserUserEntityToDTO(entity.getUsuario()));
		dto.setValor(entity.getValor());
		
		return dto;
	}
	
	public Item parserItemDTOToEntity(ItemDTO dto) {
		
		Item item = new Item();
		item.setNome(dto.getNome());
		item.setUsuario(parserUserDTOToEntity(dto.getUsuario()));
		item.setValor(dto.getValor());
		
		return item;
	}

}
