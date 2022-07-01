package com.library.form.mo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordine_libri")
@Getter
@Setter
@NoArgsConstructor
public class LibriPerOrdine {

	@Id
	@SequenceGenerator(name = "booksInOrderGenerator", sequenceName = "ordine_libri_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booksInOrderGenerator")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;
	
	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro libro;
	
	@Column(name = "prezzo")
	private Double prezzoInFaseDiAcquisto;
	
	@Column(name = "sconto")
	private Integer scontoInFaseDiAcquisto;
	
	@Column(name = "quantita")
	private Integer quantita;
	
}
