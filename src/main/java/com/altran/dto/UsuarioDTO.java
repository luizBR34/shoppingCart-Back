package com.altran.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.altran.dto.RoleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("nomeCompleto")
	private String nomeCompleto;
	
	@JsonProperty("senha")
	private String senha;

	private RoleDTO role;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<RoleDTO> papeis = new ArrayList<RoleDTO>();
		papeis.add(this.role);

		return papeis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
