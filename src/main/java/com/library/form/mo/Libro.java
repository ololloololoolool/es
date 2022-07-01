package com.library.form.mo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
public class Libro implements Serializable{

	private static final long serialVersionUID = -7740781462617124546L;

	@Id
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "autore")
	private String autore;
	
	@Column(name = "editore")
	private String editore;
	
	@Column(name = "prezzo")
	private Double prezzo;
	
	@Column(name = "genere")
	private String genere;
	
	@Column(name = "copie")
	private Integer copie;
	
	@Column(name = "sconto")
	private Integer sconto;
	
}
