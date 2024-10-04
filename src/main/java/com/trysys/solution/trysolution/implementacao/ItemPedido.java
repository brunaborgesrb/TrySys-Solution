package com.trysys.solution.trysolution.implementacao;

public class ItemPedido {

    String descricao;
        int quantidade;
        double total;

        ItemPedido(String descricao, int quantidade, double total) {
            this.descricao = descricao;
            this.quantidade = quantidade;
            this.total = total;
        }

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
        

}
