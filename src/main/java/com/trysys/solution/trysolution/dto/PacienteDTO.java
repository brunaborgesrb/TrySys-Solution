package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.Paciente;

public class PacienteDTO {

   private String nome;
   private int idade;
   private String hMedico;
   private int cpf; 
   private String ultConsulta;
   private Paciente prox; // Próximo nó
   private Paciente ant; // Nó anterior
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
@Override
public String toString() {
    return "PacienteDTO [nome=" + nome + ", idade=" + idade + ", hMedico=" + hMedico + ", cpf=" + cpf + ", ultConsulta="
            + ultConsulta + ", prox=" + prox + ", ant=" + ant + "]";
}

   
}
