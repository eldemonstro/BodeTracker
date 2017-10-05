package io.github.eldemonstro.bodetracker.db;

import io.github.eldemonstro.bodetracker.util.ConexaoDB;
import io.github.eldemonstro.bodetracker.bean.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBodeDao {
    private final Connection c;

    public UsuarioBodeDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }
    
    public void inseri(Usuario usu, Bode bode) throws SQLException {
        String sql = "insert into usuarios_has_bodes (usuarios_id, bodes_idbodes) values (?,?)";

        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, usu.getId());
            stmt.setLong(2, bode.getId());
            // executa
            stmt.execute();
        }
    }
    
    public void excluiBode(Bode bode) throws SQLException {
        String sql = "delete from usuarios_has_bodes WHERE bodes_idbodes = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, bode.getId());
            // executa
            stmt.execute();
        }
        c.close();
    }
    
    public void excluiUsuario(Usuario usu) throws SQLException {
        String sql = "delete from usuarios_has_bodes WHERE usuarios_id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setLong(1, usu.getId());
            // executa
            stmt.execute();
        }
        c.close();
    }
    
    public List<Bode> listaBodes(Usuario usu) throws SQLException {
        List<Bode> bodes = new ArrayList<>();

        String sql = "select b.* from bodes b join usuarios_has_bodes ub on b.idbodes = ub.bodes_idbodes join usuarios u on ub.usuarios_id = u.id where u.id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql); // seta os valores
                ) {
            stmt.setLong(1, usu.getId());
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

        }
        return bodes;

    }

}
