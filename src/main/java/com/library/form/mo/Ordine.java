package com.library.form.mo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ordini")
public class Ordine {

	@Id
	@SequenceGenerator(name = "orderGenerator", sequenceName = "ordini_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderGenerator")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "data_ordine")
	@CreationTimestamp
//	@DateTimeFormat(pattern = "dd/MM/yyyy'T'hh:mm:ss")
	private LocalDateTime dataOrdine;
	
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;
	
	@Column(name = "totale")
	private Double totale;
	
	@OneToMany(mappedBy = "ordine")
	private Set<LibriPerOrdine> libri = new HashSet<>();
	
}
