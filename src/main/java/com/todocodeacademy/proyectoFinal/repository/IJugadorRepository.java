package com.todocodeacademy.proyectoFinal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.proyectoFinal.model.Jugador;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Long>{

}
