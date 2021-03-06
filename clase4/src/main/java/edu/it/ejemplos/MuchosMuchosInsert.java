package edu.it.ejemplos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.it.entities.Actor;
import edu.it.entities.Director;
import edu.it.entities.Pelicula;
import edu.it.repository.DirectorRepository;
import edu.it.repository.PeliculaRepository;

@Service
public class MuchosMuchosInsert {
	
	@Autowired
	DirectorRepository directorRepository;
	
	@Autowired 
	PeliculaRepository peliculaRepository;
	
	@Transactional
	public void run() {
		Actor javierBardem = new Actor("300000001", "Javier Bardem");
        Actor pabloEcharri = new Actor("300000002", "Pablo Echarri");
        Actor eduardoNoriega = new Actor("300000003", "Eduardo Noriega");
        Actor sbaraglia = new Actor("300000004", "Nombre Leonardo Sbaraglia");
        Actor pepaPig = new Actor("300000005", "Pepa pig");
        
        Director kubrick = new Director("200000001", "Stanley Kubrick");
        Director almodovar = new Director("200000002", "Pedor Almodovar");
        Director pineiro = new Director("200000003", "Marcelo Pyneiro");
        Director rodrigoGrande = new Director("200000004", "Rodrigo Grande");
        Director ethanCohen = new Director("200000005", "Hermanos Cohen");
        
        Pelicula volver = new Pelicula("100000001", "Volver", "drama", almodovar);
        Pelicula doloryGloria = new Pelicula("100000002", "Dolor y Gloria", "drama", almodovar);
        Pelicula elResplandor = new Pelicula("100000003", "El resplandor", "suspenso", kubrick);
        Pelicula barryLindon = new Pelicula("100000004", "Barry Lyndon", "drama", kubrick);
        Pelicula plataQuemada = new Pelicula("100000005", "Plata quemada","Drama", pineiro);
        Pelicula alFinalDelTunnel = new Pelicula("100000006", "Al final del tunnel","Suspenso", rodrigoGrande);
        Pelicula elMetodo = new Pelicula("100000007", "El metodo", "Suspenso", pineiro);
        Pelicula noCountryForOldMen = new Pelicula("100000008", "No Country for Old Men", "Suspenso", ethanCohen);
	
        /*
         * Que hacer para agregar un actor
         * Crear la interface DirectorRepository
         * recordar ponerle @Repository
         * inyectar DirectorRepository aca mismo con @Autowired
         * Anotar este mismo metodo con @Transactional
         * Por ultimo llamar a directorRepository.save(Elegir algun director)
         */
        this.directorRepository.save(pineiro);
        
        /* MISMO EJERCICIO DE AYER 
         * agregarActor en la entity Pelicula
         * agregarPelicula en la entity Actor
        plataQuemada.actores.add(pabloEcharri);
        plataQuemada.actores.add(eduardoNoriega);
        plataQuemada.actores.add(sbaraglia);
        pabloEcharri.peliculas.add(plataQuemada);
        eduardoNoriega.peliculas.add(plataQuemada);
        sbaraglia.peliculas.add(plataQuemada);
        */
        plataQuemada.agregaActor(pepaPig);
        
        
        peliculaRepository.save(plataQuemada);
        
        // Enlazar muchos a muchos, es muy similar a uno a muchos
        // Bidireccional
        // Vamos a ver el save
        // Lectura
        // Convenciones de Queryes sobre la JpaRepository
	}
}
