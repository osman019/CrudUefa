package com.CrudUefa.application.usecase.jugadorcase;

import java.util.List;

import com.CrudUefa.domain.entity.Jugadores;

import com.CrudUefa.domain.repository.JugadoresRepository;


public class JugadoresUseCase {

    private final JugadoresRepository repository;

    public JugadoresUseCase(JugadoresRepository repository) {
        this.repository = repository;
    }

    public void registrarJugadores( String equipo_id,int dorsal, String name,String nationality,int age,  int height, int weight, String position) {
        Jugadores jugador = new Jugadores(equipo_id,dorsal,name,nationality,age,height,weight,position);
        repository.guardar(jugador);
    }

    public Jugadores obtenerJugadores(int id) {
        return repository.buscarPorId(id);
    }

    public List<Jugadores> listarJugadores() {
        return repository.listarTodos();
    }

    public void actualizarJugadores(String equipo_id, int dorsal,String name, String nationality, int age, int height, int weight,
    String position) {
        Jugadores jugador = new Jugadores(equipo_id, dorsal, name, nationality,age,height,weight,position);
        repository.actualizar(jugador);
    }

    public void eliminarproducto(int productoid) {
        repository.eliminar(productoid);
    }

    
}
