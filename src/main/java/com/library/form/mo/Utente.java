package com.library.form.mo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente implements Serializable{

	private static final long serialVersionUID = 3488450040934840507L;
	
	@Id
	@Column(name = "id_utenti")
	@SequenceGenerator(name = "userGenerator", sequenceName = "utenti_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenerator")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "admin")
	private Character admin;
	
	@Column(name = "credito")
	private Double credito;
	
	@OneToOne(mappedBy = "utente")
	@JsonManagedReference
	private Carrello carrello;
	
}
