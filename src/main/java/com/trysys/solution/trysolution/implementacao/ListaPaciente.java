package com.trysys.solution.trysolution.implementacao;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ListaPaciente {

     private Paciente inicio;

    public ListaPaciente() {
        this.inicio = null;
    }

    public Paciente criarPaciente(Scanner scanner) {
        System.out.println("Digite o nome do paciente:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do paciente:");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Histórico médico do paciente:");
        String hMedico = scanner.nextLine();

        System.out.println("Digite o CPF do paciente");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Última consulta do paciente (formato DD/MM/AAAA):");
        String ultConsulta = scanner.nextLine();

        return new Paciente(nome, idade, hMedico, ultConsulta, cpf);
    }

    public boolean inserirPacienteOrdenado(Paciente novo) {
        if (inicio == null) {
            inicio = novo;
            return true;
        }

        Paciente atual = inicio;
        Paciente anterior = null;

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
        Paciente atual = inicio;
        while (atual != null) {
            System.out.println("Nome: " + atual.nome);
            System.out.println("Idade: " + atual.idade);
            System.out.println("CPF: " + atual.cpf);
            System.out.println("Histórico Médico: " + atual.hMedico);
            System.out.println("Última Consulta: " + atual.ultConsulta);
            System.out.println("----------------------");
            atual = atual.prox;
        }
    }

    public List<Paciente> getPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        Paciente atual = inicio;
        while (atual != null) {
            Paciente pacienteAtual = atual;
            pacientes.add(pacienteAtual);
            atual = atual.prox;
        }
        return pacientes;
    }

    public Paciente buscarPaciente(String nome) {
        Paciente atual = inicio;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                return atual;
            }
            atual = atual.prox;
        }
        return null;
    }

    public boolean excluirPaciente(String nome) {
        Paciente atual = inicio;
        Paciente anterior = null;

        while (atual != null && !atual.nome.equalsIgnoreCase(nome)) {
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

}
