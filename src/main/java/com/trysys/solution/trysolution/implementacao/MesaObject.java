package com.trysys.solution.trysolution.implementacao;

public class MesaObject {

    int numero;
    String cliente;
    String status; // "livre" ou "ocupada"
    Pedido pedidos;
    MesaObject proximo;

    MesaObject(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.status = "ocupada"; // ao adicionar, a mesa é ocupada
        this.pedidos = null;
        this.proximo = null; // inicializa o próximo como nulo
        
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

    public MesaObject getProximo() {
        return proximo;
    }

    public void setProximo(MesaObject proximo) {
        this.proximo = proximo;
    }

    
}
