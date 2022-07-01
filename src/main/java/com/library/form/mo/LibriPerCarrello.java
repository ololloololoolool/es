package com.library.form.mo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carrello_libri")
public class LibriPerCarrello implements Serializable{

	private static final long serialVersionUID = 8749131017715784528L;

	@Id
	@SequenceGenerator(name = "booksInCartGenerator", sequenceName = "carrello_libri_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booksInCartGenerator")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "carrello_id")
//	@EqualsAndHashCode.Exclude
	@JsonBackReference
	private Carrello carrello;
	
	@ManyToOne
	@JoinColumn(name = "isbn")
//	@EqualsAndHashCode.Exclude
	private Libro libro;
	
	@Column(name = "quantita")
	private Integer quantita;
	
}
