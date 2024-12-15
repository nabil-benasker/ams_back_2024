package com.sipacademy.backend_ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipacademy.backend_ams.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
