package com.trysys.solution.trysolution.implementacao;

public class Evento {
        String nome;
        String data;
        String local;
        int capacidade;
        Participante participantes; // Lista encadeada de participantes
    
        public Evento(String nome, String data, String local, int capacidade) {
            this.nome = nome;
            this.data = data;
            this.local = local;
            this.capacidade = capacidade;
            this.participantes = null;
        }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Participante getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante participantes) {
        this.participantes = participantes;
    }

    }
    

