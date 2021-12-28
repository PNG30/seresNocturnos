package edu.it.entities;

import javax.persistence.*;

@Entity
@Table(name="peliculas")
public class Pelicula {
	@Id
	public String id;
	public String nombre;
	public String genero;
	
	@ManyToOne
	public Director director;
}
