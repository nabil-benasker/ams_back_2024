package com.sipacademy.backend_ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipacademy.backend_ams.entities.Provider;
import com.sipacademy.backend_ams.exceptions.ResourceNotFoundException;
import com.sipacademy.backend_ams.repositories.ProviderRepository;

@Service
public class ProviderService {
	@Autowired
	private ProviderRepository providerRepository;

	public Provider createProvider(Provider provider) {
		return providerRepository.save(provider);
	}

	public List<Provider> getAllProvider() {
		return (List<Provider>) providerRepository.findAll();
	}

	public Provider updateProvider(Long providerId, Provider providerRequest) {
		return providerRepository.findById(providerId).map(provider -> {
			provider.setName(providerRequest.getName());
			provider.setEmail(providerRequest.getEmail());
			provider.setAddress(providerRequest.getAddress());
			return providerRepository.save(provider);
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}

	public Provider deleteProvider(Long providerId) {
		return providerRepository.findById(providerId).map(provider -> {
			providerRepository.delete(provider);
			return provider;
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}

	public Provider getProviderById(Long providerId) {
		return providerRepository.findById(providerId).map(provider -> {
			return provider;
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}
}
