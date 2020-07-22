package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
