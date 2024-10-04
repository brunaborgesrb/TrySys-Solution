package com.trysys.solution.trysolution.dto;

public class ItemPedidoDTO {

    private String descricao;
    private int quantidade;
    private double total;
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "ItemPedidoDTO [descricao=" + descricao + ", quantidade=" + quantidade + ", total=" + total + "]";
    }

    

}
