package com.CrudUefa.domain.repository;

import java.util.List;

import com.CrudUefa.domain.entity.Equipo;

public interface EquipoRespository {
    void guardar(Equipo equipo);
    Equipo buscarPorId(int id);
    List<Equipo> listarTodos();
    void actualizar(Equipo equipo);
    void eliminar(int id);
}
