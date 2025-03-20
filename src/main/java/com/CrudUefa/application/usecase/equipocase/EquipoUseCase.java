package com.CrudUefa.application.usecase.equipocase;

import java.util.List;

import com.CrudUefa.domain.entity.Equipo;
import com.CrudUefa.domain.repository.EquipoRespository;

public class EquipoUseCase {
    private final EquipoRespository repository;

    public EquipoUseCase(EquipoRespository repository) {
        this.repository = repository;
    }

    public  void guardar(int name, String yearfoundation, String coach) {
        Equipo equipo = new Equipo(name, yearfoundation, coach);
        repository.guardar(equipo);
    }

    public Equipo obtenerEquipo(int id) {
        return repository.buscarPorId(id);
    }

    public List<Equipo> listarEquipos() {
        return repository.listarTodos();
    }

    public static void actualizarEquipos(int id, String nombre, String email) {
        Equipo cliente = new Equipo(id, nombre, email);
        repository.actualizar(cliente);
    }

    public void eliminarEquipos(int id) {
        repository.eliminar(id);
    }
}
