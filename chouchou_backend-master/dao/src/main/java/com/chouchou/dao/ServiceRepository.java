package com.chouchou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chouchou.model.Categorie;
import com.chouchou.model.Salon;
import com.chouchou.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

    @Query("select s FROM Service s WHERE s.salon =:x group by s.categorie ")
	List<Service> findServiceBySalon(@Param("x")Salon salon);

//	@Query("select s.categorie FROM Service s WHERE s.partner.login =:x group by s.categorie ")
//	List<Categorie> findAllServedCategorie(@Param("x") String login);

}
