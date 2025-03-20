package com.CrudUefa.domain.repository;

import java.util.List;

import com.CrudUefa.domain.entity.Jugadores;



public interface JugadoresRepository {
    void guardar(Jugadores jugador);
    Jugadores buscarPorId(int id);
    List<Jugadores> listarTodos();
    void actualizar(Jugadores jugador);
    void eliminar(int id);
}
