package com.trysys.solution.trysolution.implementacao;

public class Consulta {

    String nome;
    String ultConsulta;
    Consulta prox; // Próximo nó
    Consulta ant; // Nó anterior

    public Consulta(String nome, String ultConsulta) {
        this.nome = nome;
        this.ultConsulta = ultConsulta;
        this.prox = null;
        this.ant = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltConsulta() {
        return ultConsulta;
    }

    public void setUltConsulta(String ultConsulta) {
        this.ultConsulta = ultConsulta;
    }

    public Consulta getProx() {
        return prox;
    }

    public void setProx(Consulta prox) {
        this.prox = prox;
    }

    public Consulta getAnt() {
        return ant;
    }

    public void setAnt(Consulta ant) {
        this.ant = ant;
    }
    

}
