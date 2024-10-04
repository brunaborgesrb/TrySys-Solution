package com.trysys.solution.trysolution.implementacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ListaConsultas {

    private Consulta inicio;

    public ListaConsultas() {
        this.inicio = null;
    }

    public Consulta criarConsulta(ListaMedicos listaMedicos, Scanner scanner) {
        System.out.println("Digite o nome do paciente para a consulta:");
        String nome = scanner.nextLine();

        System.out.println("Digite a data da última consulta (formato DD/MM/AAAA):");
        String ultConsulta = scanner.nextLine();

        System.out.println("Diga o CRM do médico que irá atender:");
        int crm = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        Medico medico = listaMedicos.buscarMedico(crm);
        if (medico != null) {
            medico.incrementaPacientesAtendidos();
        } else {
            System.out.println("Médico não encontrado.");
        }

        return new Consulta(nome, ultConsulta);
    }

    public boolean inserirConsultaOrdenada(Consulta nova) {
        if (inicio == null) {
            inicio = nova;
            return true;
        }

        Consulta atual = inicio;
        Consulta anterior = null;

        while (atual != null && atual.nome.compareToIgnoreCase(nova.nome) < 0) {
            anterior = atual;
            atual = atual.prox;
        }

        if (atual != null && atual.nome.equalsIgnoreCase(nova.nome)) {
            return false;
        }

        if (anterior == null) {
            nova.prox = inicio;
            inicio.ant = nova;
            inicio = nova;
        } else {
            anterior.prox = nova;
            nova.ant = anterior;
            nova.prox = atual;
            if (atual != null) {
                atual.ant = nova;
            }
        }

        return true;
    }

    public void imprimirLista() {
        Consulta atual = inicio;
        while (atual != null) {
            System.out.println("Nome do Paciente: " + atual.nome);
            System.out.println("Última Consulta: " + atual.ultConsulta);
            System.out.println("----------------------");
            atual = atual.prox;
        }
    }

    public List<Consulta> getConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        Consulta atual = inicio;
        while (atual != null) {
            Consulta consultaAtual = atual;
            consultas.add(consultaAtual);
            atual = atual.prox;
        }
        return consultas;
    }

}
