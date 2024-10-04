package com.trysys.solution.trysolution.implementacao;

public class Medico {

    String nome;
    int crm;
    int cpf;
    String especialidade;
    boolean disponibilidade;
    int Patendidos;
    Medico prox; // Próximo nó
    Medico ant; // Nó anterior

    public Medico(String nome, int crm, String especialidade, boolean disponibilidade, int cpf) {
        this.nome = nome;
        this.crm = crm;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
        this.Patendidos = 0;
        this.prox = null;
        this.ant = null;
    }
    public void incrementaPacientesAtendidos() {
        this.Patendidos++;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCrm() {
        return crm;
    }
    public void setCrm(int crm) {
        this.crm = crm;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    public int getPatendidos() {
        return Patendidos;
    }
    public void setPatendidos(int patendidos) {
        Patendidos = patendidos;
    }
    public Medico getProx() {
        return prox;
    }
    public void setProx(Medico prox) {
        this.prox = prox;
    }
    public Medico getAnt() {
        return ant;
    }
    public void setAnt(Medico ant) {
        this.ant = ant;
    }

    

}
