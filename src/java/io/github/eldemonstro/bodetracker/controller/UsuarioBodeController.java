package io.github.eldemonstro.bodetracker.controller;

import io.github.eldemonstro.bodetracker.bean.Bode;
import io.github.eldemonstro.bodetracker.bean.Usuario;
import io.github.eldemonstro.bodetracker.db.UsuarioBodeDao;
import java.sql.SQLException;
import java.util.List;

public class UsuarioBodeController {
    public List<Bode> lista(Usuario usu) throws SQLException, ClassNotFoundException{
        UsuarioBodeDao usuBodeDAO = new UsuarioBodeDao();
        List<Bode> bodes = usuBodeDAO.listaBodes(usu);
        return bodes;
    }
    
    public void inserir(Usuario usu, Bode bode) throws SQLException, ClassNotFoundException {
        UsuarioBodeDao usuBodeDAO = new UsuarioBodeDao();
        usuBodeDAO.inseri(usu, bode);
    }
}
