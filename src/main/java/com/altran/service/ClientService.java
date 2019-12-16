package com.altran.service;

import com.altran.dto.ItemDTO;
import com.altran.dto.UsuarioDTO;

public interface ClientService {

	public UsuarioDTO buscaUsuario(String email);
	public Iterable<ItemDTO> listaItems();
	public void cadastraItem(ItemDTO item);
}
