package com.trysys.solution.trysolution.implementacao;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ListaMedicos {
private Medico inicio;

    public ListaMedicos() {
        this.inicio = null;
    }

    public Medico criarMedico(Scanner scanner) {
        System.out.println("Digite o nome do médico:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CRM do médico:");
        int crm = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite a especialidade do médico:");
        String especialidade = scanner.nextLine();

        System.out.println("Digite o CPF do médico");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        System.out.println("O médico está disponível? (1 para sim, 0 para não):");
        int disponibilidade = scanner.nextInt();
        boolean disponivel = disponibilidade != 0;

        return new Medico(nome, crm, especialidade, disponivel, cpf);
    }

    public boolean inserirMedicoOrdenado(Medico novo) {
        if (inicio == null) {
            inicio = novo;
            return true;
        }

        Medico atual = inicio;
        Medico anterior = null;

        while (atual != null && atual.nome.compareToIgnoreCase(novo.nome) < 0) {
            anterior = atual;
            atual = atual.prox;
        }

        if (atual != null && atual.nome.equalsIgnoreCase(novo.nome)) {
            return false;
        }

        if (anterior == null) {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        } else {
            anterior.prox = novo;
            novo.ant = anterior;
            novo.prox = atual;
            if (atual != null) {
                atual.ant = novo;
            }
        }

        return true;
    }

    public void imprimirLista() {
        Medico atual = inicio;
        while (atual != null) {
            System.out.println("Nome: " + atual.nome);
            System.out.println("CRM: " + atual.crm);
            System.out.println("CPF: " + atual.cpf);
            System.out.println("Especialidade: " + atual.especialidade);
            System.out.println("Disponibilidade: " + (atual.disponibilidade ? "Sim" : "Não"));
            System.out.println("----------------------");
            atual = atual.prox;
        }
    }

    public List<Medico> getMedicos() {
        List<Medico> medicos = new ArrayList<>();
        Medico atual = inicio;
        while (atual != null) {
            Medico medicoAtual = atual;
            medicos.add(medicoAtual);
            atual = atual.prox;
        }
        return medicos;
    }

    public Medico buscarMedico(int crm) {
        Medico atual = inicio;

        while (atual != null) {
            if (atual.crm == crm) {
                return atual;
            }
            atual = atual.prox;
        }
        return null;
    }

    public boolean excluirMedico(int crm) {
        Medico atual = inicio;
        Medico anterior = null;

        while (atual != null && atual.crm != crm) {
            anterior = atual;
            atual = atual.prox;
        }
        if (atual == null) {
            return false;
        }
        if (anterior == null) {
            inicio = atual.prox;
            if (inicio != null) {
                inicio.ant = null;
            }
        } else {
            anterior.prox = atual.prox;
            if (atual.prox != null) {
                atual.prox.ant = anterior;
            }
        }
        return true;
    }

    public Medico medicoMaisAtendeu() {
        Medico atual = inicio;
        Medico medicoMaisAtendeu = null;
        int maxPacientes = -1;
        while (atual != null) {
            if (atual.Patendidos > maxPacientes) {
                maxPacientes = atual.Patendidos;
                medicoMaisAtendeu = atual;
            }
            atual = atual.prox;
        }
        return medicoMaisAtendeu;
    }
}
