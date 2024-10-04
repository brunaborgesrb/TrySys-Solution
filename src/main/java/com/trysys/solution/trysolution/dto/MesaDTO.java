package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.Mesa;
import com.trysys.solution.trysolution.implementacao.Pedido;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MesaDTO {
     private Mesa cabeca;
     private String[] cardapio = {"Hamburguer", "Pizza", "Salada", "Suco", "Refrigerante"}; // Cardápio pré-definido
     private Map<String, Integer> contagemItensPedidos = new HashMap<>(); // Contador de pedidos por item
     private int numero;
     private String cliente;
     private String status; // "livre" ou "ocupada"
     private Pedido pedidos;
     private Mesa proximo;
     
    public Mesa getCabeca() {
        return cabeca;
    }
    public void setCabeca(Mesa cabeca) {
        this.cabeca = cabeca;
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
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Pedido getPedidos() {
        return pedidos;
    }
    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }
    public Mesa getProximo() {
        return proximo;
    }
    public void setProximo(Mesa proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return "MesaDTO [cabeca=" + cabeca + ", cardapio=" + Arrays.toString(cardapio) + ", contagemItensPedidos="
                + contagemItensPedidos + ", numero=" + numero + ", cliente=" + cliente + ", status=" + status
                + ", pedidos=" + pedidos + ", proximo=" + proximo + "]";
    }

     

}
