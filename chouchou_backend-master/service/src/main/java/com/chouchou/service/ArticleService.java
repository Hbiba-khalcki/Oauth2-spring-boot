package com.chouchou.service;

import java.util.List;
import java.util.Optional;

import com.chouchou.model.Article;

public interface ArticleService {

	public Article savOrUpdate(Article o);
	public void delete(Long id);
	public List<Article> findAll();
	public Optional<Article> findByID(long id);
}
