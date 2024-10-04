package com.trysys.solution.trysolution.implementacao;
// lista encadeada simples
import java.util.Scanner;

public class Participante {
    String nome;
    int numeroInscricao;
    Participante proximo; // aponta para o próximo participante

    public Participante(String nome, int numeroInscricao) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
        this.proximo = null;
    }

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

    @Override
    public String toString() {
        return "Participante [nome=" + nome + ", numeroInscricao=" + numeroInscricao + ", proximo=" + proximo + "]";
    }
    
}

