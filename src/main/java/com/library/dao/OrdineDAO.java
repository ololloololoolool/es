package com.library.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.form.mo.Ordine;

@Repository
public interface OrdineDAO extends JpaRepository<Ordine, Integer>{

	@Query( value = "SELECT o FROM Ordine o WHERE o.utente.id = :userId ORDER BY o.dataOrdine DESC")
	Set<Ordine> searchByUserId(@Param("userId") Integer userId);
	
	@Query( value = "SELECT o FROM Ordine o WHERE o.utente.username = :username ORDER BY o.dataOrdine DESC")
	Set<Ordine> searchByUsername(@Param("username") String username);
}
