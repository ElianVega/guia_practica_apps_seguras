package com.example.guia_practica_apps_seguras.controller;

import org.springframework.web.bind.annotation.*;
import com.example.guia_practica_apps_seguras.service.AesEncryptionService;
import com.example.guia_practica_apps_seguras.service.RsaEncryptionService;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

	private final AesEncryptionService aesService;
	private final RsaEncryptionService rsaService;

	public CryptoController() throws Exception {
		this.aesService = new AesEncryptionService();
		this.rsaService = new RsaEncryptionService();
	}

	@PostMapping("/aes/encrypt")
	public String encryptAes(@RequestBody String input) throws Exception {
		return aesService.encrypt(input);
	}

	@PostMapping("/aes/decrypt")
	public String decryptAes(@RequestBody String input) throws Exception {
		return aesService.decrypt(input);
	}

	@PostMapping("/rsa/encrypt")
	public String encryptRsa(@RequestBody String input) throws Exception {
		return rsaService.encrypt(input);
	}

	@PostMapping("/rsa/decrypt")
	public String decryptRsa(@RequestBody String input) throws Exception {
		return rsaService.decrypt(input);
	}
}
