package com.trysys.solution.trysolution.implementacao;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Mesa {

     

    MesaObject cabeca;
     String[] cardapio = {"Hamburguer", "Pizza", "Salada", "Suco", "Refrigerante"}; // Cardápio pré-definido
     Map<String, Integer> contagemItensPedidos = new HashMap<>(); // Contador de pedidos por item
 

        public void adicionarMesa(int numero, String cliente) {
            MesaObject novaMesa = new MesaObject(numero, cliente);
            if (cabeca == null) {
                cabeca = novaMesa;
                cabeca.proximo = cabeca;
            } else {
                MesaObject atual = cabeca;
                while (atual.proximo != cabeca) {
                    atual = atual.proximo;
                }
                atual.proximo = novaMesa;
                novaMesa.proximo = cabeca;
            }
            System.out.println("Mesa " + numero + " adicionada para o cliente " + cliente + ".");
        }
    
        // Função para exibir o cardápio
        public List<String> exibirCardapio() {
            List<String> cardapioList = new ArrayList<>();
            System.out.println("Cardápio:");
            for (String item : cardapio) {
                cardapioList.add(item);
                System.out.println("- " + item);
            }
            return cardapioList;
        }
    
        // Verifica se o item está no cardápio
        public boolean itemValido(String descricao) {
            for (String item : cardapio) {
                if (item.equalsIgnoreCase(descricao)) {
                    return true;
                }
            }
            return false;
        }
    
        public void adicionarPedido(int numeroMesa, String descricao, int quantidade, double total) {
            if (!itemValido(descricao)) {
                System.out.println("Item fora do cardápio: " + descricao);
                return;
            }
    
            MesaObject mesa = buscarMesa(numeroMesa);
            if (mesa != null && mesa.status.equals("ocupada")) {
                ItemPedido novoItem = new ItemPedido(descricao, quantidade, total);
                Pedido novoPedido = new Pedido(novoItem);
                novoPedido.proximo = mesa.pedidos;
                mesa.pedidos = novoPedido;
    
                // Atualiza a contagem do item no cardápio
                if(contagemItensPedidos == null){
                    for (String item : cardapio) {
                        contagemItensPedidos.put(item, 0);
                    }
                    contagemItensPedidos.put(descricao, contagemItensPedidos.get(descricao) + quantidade);
                }else{
                    for (String item : cardapio) {
                        contagemItensPedidos.put(item, 0);
                    }
                    contagemItensPedidos.put(descricao, contagemItensPedidos.get(descricao) + quantidade);   
                }
                
                System.out.println("Pedido adicionado na mesa " + numeroMesa + ".");
            } else {
                System.out.println("Mesa não encontrada ou está livre.");
            }
        }
    
        // Função para exibir os itens mais pedidos
        public void exibirItensMaisPedidos() {
            System.out.println("Itens mais pedidos:");
            contagemItensPedidos.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordena em ordem decrescente de pedidos
                    .forEach(entry -> {
                        if (entry.getValue() > 0) { // Mostra apenas itens com pedidos
                            System.out.println(entry.getKey() + ": " + entry.getValue() + " pedidos");
                        }
                    });
        }
    
        public void fecharConta(int numeroMesa) {
            MesaObject mesa = buscarMesa(numeroMesa);
            if (mesa != null && mesa.status.equals("ocupada")) {
                double totalConta = 0;
                Pedido atual = mesa.pedidos;
                while (atual != null) {
                    totalConta += atual.item.total;
                    atual = atual.proximo;
                    if (atual == mesa.pedidos) break; // Para evitar loop infinito
                }
                System.out.println("Total a pagar na mesa " + numeroMesa + ": R$ " + totalConta);
                mesa.status = "livre";
                mesa.pedidos = null;
            } else {
                System.out.println("Mesa não encontrada ou já está livre.");
            }
        }
    
        public MesaObject buscarMesa(int numero) {
            if (cabeca == null) return null;
            MesaObject atual = cabeca;
            do {
                if (atual.numero == numero) {
                    return atual;
                }
                atual = atual.proximo;
            } while (atual != cabeca);
            return null;
        }
    
        public void imprimirMesas() {
            if (cabeca == null) {
                System.out.println("Nenhuma mesa cadastrada.");
                return;
            }
            MesaObject atual = cabeca;
            do {
                System.out.println("Mesa: " + atual.numero + ", Cliente: " + atual.cliente + ", Status: " + atual.status);
                if (atual.pedidos != null) {
                    System.out.println("Pedidos:");
                    Pedido pedidoAtual = atual.pedidos;
                    do {
                        System.out.println(" - " + pedidoAtual.item.descricao + ": " + pedidoAtual.item.quantidade + " (R$ " + pedidoAtual.item.total + ")");
                        pedidoAtual = pedidoAtual.proximo;
                    } while (pedidoAtual != null && pedidoAtual != atual.pedidos);
                }
                atual = atual.proximo;
            } while (atual != cabeca);
        }

        public List<MesaObject> getMesas(){
            List<MesaObject> mesas = new ArrayList<>();
            MesaObject atual = cabeca;
            do {
                MesaObject mesaAtual = atual;
                mesas.add(mesaAtual);
                atual = atual.proximo;
            }while (atual != cabeca);

            return mesas;
        }
 
        public String[] getCardapio() {
            return cardapio;
        }
    
        public void setCardapio(String[] cardapio) {
            this.cardapio = cardapio;
        }
    
        public Map<String, Integer> getContagemItensPedidos() {
            return contagemItensPedidos;
        }
    
        public void setContagemItensPedidos(Map<String, Integer> contagemItensPedidos) {
            this.contagemItensPedidos = contagemItensPedidos;
        }

}
