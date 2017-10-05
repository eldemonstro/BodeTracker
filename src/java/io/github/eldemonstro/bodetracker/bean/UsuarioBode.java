package io.github.eldemonstro.bodetracker.bean;

public class UsuarioBode {
    public Usuario usuario;
    public Bode bode;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bode getBode() {
        return bode;
    }

    public void setBode(Bode bode) {
        this.bode = bode;
    }
    
    public UsuarioBode(Usuario usuario, Bode bode){
        this.usuario = usuario;
        this.bode = bode;
    }
}
