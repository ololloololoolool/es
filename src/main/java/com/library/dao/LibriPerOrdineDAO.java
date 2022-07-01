package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.form.mo.LibriPerOrdine;

@Repository
public interface LibriPerOrdineDAO extends JpaRepository<LibriPerOrdine, Integer>{

	@Query(value = "SELECT lpo.libro.isbn, COUNT(lpo) AS copieVendute "
			+ "FROM LibriPerOrdine lpo GROUP BY lpo.libro.isbn ORDER BY copieVendute DESC")
	List<Object> searchBooksSelled();
}
