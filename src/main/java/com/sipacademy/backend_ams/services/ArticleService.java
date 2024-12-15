package com.sipacademy.backend_ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sipacademy.backend_ams.entities.Article;
import com.sipacademy.backend_ams.exceptions.ResourceNotFoundException;
import com.sipacademy.backend_ams.repositories.ArticleRepository;
import com.sipacademy.backend_ams.repositories.ProviderRepository;

@Service

public class ArticleService {
	private final ArticleRepository articleRepository;
	private final ProviderRepository providerRepository;

	public ArticleService(ArticleRepository articleRepository, ProviderRepository providerRepository) {
		this.articleRepository = articleRepository;
		this.providerRepository = providerRepository;
	}
	/*
	 * @Autowired private ArticleRepository articleRepository;
	 * 
	 * @Autowired private ProviderRepository providerRepository;
	 */

	public List<Article> getAllArticles() {
		return (List<Article>) articleRepository.findAll();
	}

	public Article createArticle(Long providerId, Article article) {
		return providerRepository.findById(providerId).map(provider -> {
			article.setProvider(provider);
			return articleRepository.save(article);
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}

	public Article updateArticle(Long providerId, Long articleId, Article articleRequest) {
		if (!providerRepository.existsById(providerId)) {
			throw new ResourceNotFoundException("ProviderId " + providerId + " not found");
		}
		return articleRepository.findById(articleId).map(article -> {
			article.setPrice(articleRequest.getPrice());
			article.setLabel(articleRequest.getLabel());
			article.setLabel(articleRequest.getPicture());
			return articleRepository.save(article);
		}).orElseThrow(() -> new ResourceNotFoundException("ArticleId " + articleId + "not found"));
	}

	public Article deleteArticle(Long articleId) {
		return articleRepository.findById(articleId).map(article -> {
			articleRepository.delete(article);
			return article;
		}).orElseThrow(() -> new ResourceNotFoundException("Article not found with id " + articleId));
	}

	public Article getArticleById(Long articleId) {
		return articleRepository.findById(articleId).map(article -> {
			return article;
		}).orElseThrow(() -> new ResourceNotFoundException("ArticleId " + articleId + " not found"));
	}
}
