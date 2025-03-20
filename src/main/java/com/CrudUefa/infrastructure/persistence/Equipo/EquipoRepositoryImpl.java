package com.CrudUefa.infrastructure.persistence.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.CrudUefa.domain.entity.Equipo;
import com.CrudUefa.domain.repository.EquipoRespository;
import com.CrudUefa.infrastructure.database.ConnectionDb;

public class EquipoRepositoryImpl implements EquipoRespository {
    private final ConnectionDb connection;
    
    public EquipoRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Equipo equipo) {
        String sql = "INSERT INTO equipos ( name, year_foundation, coach) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
        
            stmt.setString(1, equipo.getName());
            stmt.setInt(2, equipo.getYearfoundation());
            stmt.setString(3, equipo.getCoach());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo buscarPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Equipo(rs.getInt("id"), rs.getString("name"),rs.getInt("year_foundation"),rs.getString("coach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipo> listarTodos() {
        List<Equipo> client = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                client.add(new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void actualizar(Equipo cliente) {
        String sql = "UPDATE equipos SET name = ?, coach = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getCoach());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
