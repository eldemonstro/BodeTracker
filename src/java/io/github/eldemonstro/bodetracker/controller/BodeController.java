package io.github.eldemonstro.bodetracker.controller;

import io.github.eldemonstro.bodetracker.bean.Bode;
import io.github.eldemonstro.bodetracker.bean.Usuario;
import io.github.eldemonstro.bodetracker.db.BodeDao;
import io.github.eldemonstro.bodetracker.db.UsuarioBodeDao;
import java.sql.SQLException;
import java.util.List;

public class BodeController {
    public Bode consultar(Bode bode) throws SQLException, ClassNotFoundException{
        BodeDao bodeDAO = new BodeDao();
        Bode usu = bodeDAO.busca(bode);
        return usu;
    }
    
    public Bode incluir(Bode bode, Usuario usu) throws SQLException, ClassNotFoundException {
        BodeDao bodeDAO = new BodeDao();
        UsuarioBodeDao usuBodeDao = new UsuarioBodeDao();
        Bode bodein = bodeDAO.inseri(bode);
        usuBodeDao.inseri(usu, bode);
        return bodein;
    }
    
    public Bode alterar(Bode bode) throws SQLException, ClassNotFoundException {
        BodeDao bodeDAO = new BodeDao();
        Bode bodealt = bodeDAO.altera(bode);
        return bodealt;
    }
    
    public void exclui(Bode bode) throws SQLException, ClassNotFoundException{
        BodeDao bodeDAO = new BodeDao();
        bodeDAO.exclui(bode);
    }
    
    public List<Bode> lista() throws SQLException, ClassNotFoundException{
        BodeDao bodeDAO = new BodeDao();
        List<Bode> bodes = bodeDAO.lista();
        return bodes;
    }
}
