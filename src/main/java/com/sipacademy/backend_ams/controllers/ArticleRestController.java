package com.sipacademy.backend_ams.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipacademy.backend_ams.entities.Article;
import com.sipacademy.backend_ams.services.ArticleService;
import com.sipacademy.backend_ams.services.ProviderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping({ "/articles" })
public class ArticleRestController {

	private final ArticleService articleService;

	public ArticleRestController(ArticleService articleService, ProviderService providerService) {
		this.articleService = articleService;
	}
	/*
	 * @Autowired private ArticleRepository articleRepository;
	 * 
	 * @Autowired private ProviderRepository providerRepository;
	 */

	@GetMapping("/list")
	public List<Article> getAllArticles() {
		return articleService.getAllArticles();
	}

	@PostMapping("/add/{providerId}")
	Article createArticle(@PathVariable(value = "providerId") Long providerId, @Valid @RequestBody Article article) {
		return articleService.createArticle(providerId, article);
	}

	@PutMapping("/update/{providerId}/{articleId}")
	public Article updateArticle(@PathVariable(value = "providerId") Long providerId, @PathVariable(value = "articleId") Long articleId, @Valid @RequestBody Article articleRequest) {
		return articleService.updateArticle(providerId, articleId, articleRequest);
	}

	@DeleteMapping("/delete/{articleId}")
	public Article deleteArticle(@PathVariable(value = "articleId") Long articleId) {
		return articleService.deleteArticle(articleId);
	}

	@GetMapping("/{articleId}")
	public Article getArticleById(Long articleId) {
		return articleService.getArticleById(articleId);
	}
}
