package com.chouchou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	@Query(value="FROM Menu m join m.roles r WHERE r.id = :id")
    public Menu[] findFirstByIdRole(@Param("id") long id);

}
