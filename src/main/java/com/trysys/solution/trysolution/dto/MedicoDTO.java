package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.Medico;

public class MedicoDTO {

   private String nome;
   private int crm;
   private int cpf;
   private String especialidade;
   private boolean disponibilidade;
   private int Patendidos;
   private Medico prox; // Próximo nó
   private Medico ant; // Nó anterior
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
@Override
public String toString() {
    return "MedicoDTO [nome=" + nome + ", crm=" + crm + ", cpf=" + cpf + ", especialidade=" + especialidade
            + ", disponibilidade=" + disponibilidade + ", Patendidos=" + Patendidos + ", prox=" + prox + ", ant=" + ant
            + "]";
}



}
