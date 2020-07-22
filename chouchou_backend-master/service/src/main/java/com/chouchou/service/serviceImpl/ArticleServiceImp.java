package com.chouchou.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chouchou.dao.ArticleRepository;
import com.chouchou.model.Article;
import com.chouchou.service.ArticleService;

@Service
public class ArticleServiceImp implements ArticleService{
	
	
	@Autowired
	ArticleRepository rep;

	@Override
	public Article savOrUpdate(Article o) {
		return rep.save(o);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Article> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Article> findByID(long id) {
		return rep.findById(id);
	}

}
