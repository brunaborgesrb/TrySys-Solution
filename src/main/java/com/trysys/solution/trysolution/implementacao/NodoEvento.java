package com.trysys.solution.trysolution.implementacao;

public class NodoEvento {
    Evento evento;
    NodoEvento proximo; // aponta para o próximo evento na lista

    public NodoEvento(Evento evento) {
        this.evento = evento;
        this.proximo = null;
    }
}
