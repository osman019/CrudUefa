package com.CrudUefa.infrastructure.persistence.jugadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.CrudUefa.domain.entity.Jugadores;
import com.CrudUefa.domain.repository.JugadoresRepository;
import com.CrudUefa.infrastructure.database.ConnectionDb;

public class JugadoresRepositoryImpl implements JugadoresRepository {
    private final ConnectionDb connection;

    public JugadoresRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }

    @Override
    public void guardar(Jugadores jugador) {
        String sql = "INSERT INTO players (equipo_id  dorsal, name, nationality) VALUES (?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(jugador.getEquipo_id()));
            stmt.setInt(2, jugador.getDorsal());
            stmt.setString(3, jugador.getName());
            stmt.setString(4, jugador.getNationality());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jugadores buscarPorId(int id) {
        String sql = "SELECT * FROM jugadores WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Jugadores(rs.getInt("id"), rs.getString("name"), rs.getString("position"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Jugadores> listarTodos() {
        List<Jugadores> Jugadores = new ArrayList<>();
        String sql = "SELECT * FROM players";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Jugadores.add(new Jugadores(rs.getInt("id"), rs.getString("name"), rs.getString("position")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Jugadores;

    }

    @Override
    public void actualizar(Jugadores jugador) {
        String sql = "UPDATE players SET name = ?, age = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
                
            stmt.setString(1, jugador.getName());
            stmt.setInt(2, jugador.getAge());
            stmt.setInt(3, jugador.getId());
          
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM players WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
