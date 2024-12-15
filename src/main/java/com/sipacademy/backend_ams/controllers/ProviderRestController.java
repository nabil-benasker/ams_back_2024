package com.sipacademy.backend_ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipacademy.backend_ams.entities.Provider;
import com.sipacademy.backend_ams.services.ProviderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping({ "/providers" })
public class ProviderRestController {

	@Autowired
	private ProviderService providerService;

	@GetMapping("/list")
	public List<Provider> getAllProvider() {
		return providerService.getAllProvider();
	}

	@PostMapping("/add")
	public Provider createProvider(@Valid @RequestBody Provider provider) {
		return providerService.createProvider(provider);
	}

	@PutMapping("/{providerId}")
	public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider providerRequest) {
		return providerService.updateProvider(providerId, providerRequest);
	}

	@DeleteMapping("/{providerId}")
	public Provider deleteProvider(@PathVariable Long providerId) {
		return providerService.deleteProvider(providerId);
	}

	@GetMapping("/{providerId}")
	public Provider getProviderById(@PathVariable Long providerId) {
		return providerService.getProviderById(providerId);
	}

}
