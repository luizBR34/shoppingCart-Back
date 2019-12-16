package com.altran.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("valor")
	private long valor;
	
	private UsuarioDTO usuario;

	public ItemDTO(long id, String nome, long valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
