package com.disney.peliculas_y_series_entity;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String nombre;
	private Long edad;
	private Double peso;
	private String historia;

	@ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
	private List<PersonajeEntity> peliculasYSeries = new ArrayList<>();

}
