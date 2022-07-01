package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.form.mo.Libro;

@Repository
public interface LibroDAO extends JpaRepository<Libro, String>{

	@Query(value = "SELECT l FROM Libro l WHERE"
			+ " l.titolo LIKE CONCAT('%',:titolo,'%') AND"
			+ " l.autore LIKE CONCAT('%',:autore,'%') AND"
			+ " l.editore LIKE CONCAT('%',:editore,'%')")
	List<Libro> search(
			@Param("titolo") String titolo,
			@Param("autore") String autore,
			@Param("editore") String editore);
}
