package com.trysys.solution.trysolution.implementacao;

public class Pedido {

        ItemPedido item;
        Pedido proximo;

        Pedido(ItemPedido item) {
            this.item = item;
            this.proximo = null;
        }

        public ItemPedido getItem() {
            return item;
        }

        public void setItem(ItemPedido item) {
            this.item = item;
        }

        public Pedido getProximo() {
            return proximo;
        }

        public void setProximo(Pedido proximo) {
            this.proximo = proximo;
        }

        
}
