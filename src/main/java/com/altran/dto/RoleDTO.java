package com.altran.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO implements GrantedAuthority, Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("nomeRole")
	private String nomeRole;
	
	private List<UsuarioDTO> usuarios;
	

	public String getNomeRole() {
		return nomeRole;
	}


	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	@Override
	public String getAuthority() {
		return this.nomeRole;
	}
}
