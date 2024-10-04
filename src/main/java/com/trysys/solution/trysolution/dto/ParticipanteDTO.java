package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.Evento;
import com.trysys.solution.trysolution.implementacao.Participante;

public class ParticipanteDTO {

    private String nome;
    private int numeroInscricao;
    private String evento;
    private Participante proximo;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumeroInscricao() {
        return numeroInscricao;
    }
    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }
    public Participante getProximo() {
        return proximo;
    }
    public void setProximo(Participante proximo) {
        this.proximo = proximo;
    }

    public String getEvento() {
        return evento;
    }
    public void setEvento(String evento) {
        this.evento = evento;
    }
    @Override
    public String toString() {
        return "ParticipanteDTO [nome=" + nome + ", numeroInscricao=" + numeroInscricao + ", evento=" + evento
                + ", proximo=" + proximo + "]";
    }

    

}
