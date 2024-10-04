package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.Consulta;

public class ConsultaDTO {

    private String nome;
    private String ultConsulta;
    private int crmMedico;
    private Consulta prox; // Próximo nó
    private Consulta ant; // Nó anterior
    
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
    @Override
    public String toString() {
        return "ConsultaDTO [nome=" + nome + ", ultConsulta=" + ultConsulta + ", prox=" + prox + ", ant=" + ant + "]";
    }
    public int getCrmMedico() {
        return crmMedico;
    }
    public void setCrmMedico(int crmMedico) {
        this.crmMedico = crmMedico;
    }

    

}
