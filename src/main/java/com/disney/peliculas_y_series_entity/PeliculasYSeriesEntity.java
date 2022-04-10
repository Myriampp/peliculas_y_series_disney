package com.disney.peliculas_y_series_entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peliculasYSeries")
@Getter
@Setter

public class PeliculasYSeriesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String titulo;

	@Column(name = "fecha_estreno")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	
	private LocalDate fechaEstreno;

	private Byte calificacion;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "genero_id", insertable = false, updatable = false)
	private GeneroEntity genero;

	@Column(name = "genero_id", nullable = false)
	private Long generoId;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE

	})

	@JoinTable(name = "personajeAsociado",
	joinColumns = @JoinColumn(name = "peliculasYseries_id"),
	inverseJoinColumns = @JoinColumn(name = "personaje_id"))
	private Set<PersonajeEntity> personajes = new HashSet<>();

}
