package com.altran.service;

import com.altran.dto.UsuarioDTO;

public interface ClientService {

	public UsuarioDTO buscaUsuario(String email);
}
