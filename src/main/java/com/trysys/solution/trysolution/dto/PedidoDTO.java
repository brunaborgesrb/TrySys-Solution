package com.trysys.solution.trysolution.dto;

import com.trysys.solution.trysolution.implementacao.ItemPedido;
import com.trysys.solution.trysolution.implementacao.Pedido;

public class PedidoDTO {

    private    ItemPedido item;
    private    Pedido proximo;
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
    @Override
    public String toString() {
        return "PedidoDTO [item=" + item + ", proximo=" + proximo + "]";
    }

    

}
