package com.altran.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.altran.dto.ItemDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class ShoppControllerTest {
	
	WebTestClient client;

	@BeforeEach
	void setUp() throws Exception {
		client = WebTestClient.bindToServer().baseUrl("http://localhost:9090").build();
	}

	@Test
	void testListarItems() {
		client.get().uri("/listarItems")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(ItemDTO.class).hasSize(1).contains(new ItemDTO(12345, "smart watch", 300));
	}

	@Test
	void testCadastrarItem() {
		
		client.post().uri("/cadastrarItem")
		.bodyValue(new ItemDTO(12345, "smart watch", 300))
		.exchange()
		.expectStatus().isOk();
	}

}
