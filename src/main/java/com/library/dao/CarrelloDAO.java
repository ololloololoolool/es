package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.form.mo.Carrello;

@Repository
public interface CarrelloDAO extends JpaRepository<Carrello, Integer>{

	@Query(value = "SELECT c FROM Carrello c WHERE c.utente.id = :userId")
	Carrello searchByUserId(@Param("userId") Integer userId);
}
