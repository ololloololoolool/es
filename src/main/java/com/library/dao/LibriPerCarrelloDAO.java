package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.form.mo.LibriPerCarrello;

@Repository
public interface LibriPerCarrelloDAO extends JpaRepository<LibriPerCarrello, Integer>{

	@Query(value = "SELECT lpc FROM LibriPerCarrello lpc WHERE lpc.carrello.id = :id AND lpc.libro.isbn = :isbn")
	LibriPerCarrello searchByCartIdAndISBN(@Param("id") Integer id, @Param("isbn") String isbn);
	
	@Query(value = "SELECT lpc FROM LibriPerCarrello lpc WHERE lpc.carrello.id = :id")
	List<LibriPerCarrello> searchByCartId(@Param("id") Integer id);
	
	@Query(value = "SELECT lpc FROM LibriPerCarrello lpc WHERE lpc.carrello.utente.id = :userId")
	List<LibriPerCarrello> searchBooksInCartByUserId(@Param("userId") Integer userId);
}
