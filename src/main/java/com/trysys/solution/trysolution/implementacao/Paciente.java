package com.trysys.solution.trysolution.implementacao;

public class Paciente {
    String nome;
    int idade;
    String hMedico;
    int cpf; 
    String ultConsulta;
    Paciente prox; // Próximo nó
    Paciente ant; // Nó anterior

    public Paciente(String nome, int idade, String hMedico, String ultConsulta, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.hMedico = hMedico;
        this.cpf = cpf;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String gethMedico() {
        return hMedico;
    }

    public void sethMedico(String hMedico) {
        this.hMedico = hMedico;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getUltConsulta() {
        return ultConsulta;
    }

    public void setUltConsulta(String ultConsulta) {
        this.ultConsulta = ultConsulta;
    }

    public Paciente getProx() {
        return prox;
    }

    public void setProx(Paciente prox) {
        this.prox = prox;
    }

    public Paciente getAnt() {
        return ant;
    }

    public void setAnt(Paciente ant) {
        this.ant = ant;
    }

    

}
