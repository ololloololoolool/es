package com.library.form.mo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carrelli")
@Getter
@Setter
@NoArgsConstructor
public class Carrello implements Serializable{

	private static final long serialVersionUID = -1255592201105043057L;

	@Id
	@SequenceGenerator(name = "cartGenerator", sequenceName = "carrelli_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartGenerator")
	@Column(name = "id_carrello")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_utente")
	@JsonBackReference
	private Utente utente;
	
	@OneToMany(mappedBy = "carrello")
	private Set<LibriPerCarrello> libri = new HashSet<>();
	
}
