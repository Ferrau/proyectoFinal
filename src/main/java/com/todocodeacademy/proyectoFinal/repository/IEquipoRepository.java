package com.todocodeacademy.proyectoFinal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.proyectoFinal.model.Equipo;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Long>{

}
