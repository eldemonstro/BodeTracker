package io.github.eldemonstro.bodetracker.db;

import io.github.eldemonstro.bodetracker.util.ConexaoDB;
import io.github.eldemonstro.bodetracker.bean.Bode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BodeDao {

    private final Connection c;

    public BodeDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Bode busca(Bode bode) throws SQLException {
        String sql = "select * from bodes WHERE idbodes = ?";

        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, bode.getId());
            try ( // executa
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto Bode
                    bode.setId(rs.getInt(1));
                    bode.setNome(rs.getString(2));
                    bode.setRegistro(rs.getString(3));
                    bode.setSexo(rs.getString(4));
                    bode.setRaca(rs.getString(5));
                }
            }
        }
        return bode;
    }

    public List<Bode> lista() throws SQLException {
        List<Bode> bodes = new ArrayList<>();

        String sql = "select * from bodes";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Bode
                Bode bode = new Bode();
                bode.setId(rs.getInt(1));
                bode.setNome(rs.getString(2));
                bode.setRegistro(rs.getString(3));
                bode.setSexo(rs.getString(4));
                bode.setRaca(rs.getString(5));
                bodes.add(bode);
            }

            rs.close();
        }
        return bodes;

    }

    public Bode inseri(Bode bode) throws SQLException {
        String sql = "insert into bodes (nome, registro, sexo, raca) values (?,?,?,?)";

        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, bode.getNome());
            stmt.setString(2, bode.getRegistro());
            stmt.setString(3, bode.getSexo());
            stmt.setString(4, bode.getRaca());
            // executa
            stmt.execute();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    bode.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return bode;
    }

    public Bode exclui(Bode bode) throws SQLException {
        String sql = "delete from bode WHERE idbodes = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setLong(1, bode.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return bode;
    }

    public Bode altera(Bode bode) throws SQLException {
        String sql = "UPDATE bodes SET nome = ?, registro = ?, sexo = ?, raca = ? WHERE idbodes = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os
            stmt.setString(1, bode.getNome());
            stmt.setString(2, bode.getRegistro());
            stmt.setString(3, bode.getSexo());
            stmt.setString(4, bode.getRaca());
            stmt.setLong(5, bode.getId());
            // executa
            stmt.execute();
        }
        return bode;
    }
}
