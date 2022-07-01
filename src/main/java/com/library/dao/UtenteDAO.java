package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.form.mo.Utente;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Integer> {

	@Query(value = "SELECT u FROM Utente u WHERE u.username = :nickname")
	Utente findByNickname(@Param("nickname") String nickname);
	
}
