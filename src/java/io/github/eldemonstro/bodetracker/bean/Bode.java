package io.github.eldemonstro.bodetracker.bean;

public class Bode {
    private long id;
    private String nome, registro, sexo, raca;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }



    public Bode(String nome, String registro, String sexo, String raca) {
        this.nome = nome;
        this.registro = registro;
        this.sexo = sexo;
        this.raca = raca;
    }

    public Bode(){

    }
}
