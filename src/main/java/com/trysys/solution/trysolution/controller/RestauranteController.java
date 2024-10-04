package com.trysys.solution.trysolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trysys.solution.trysolution.dto.ConsultaDTO;
import com.trysys.solution.trysolution.dto.ItemPedidoDTO;
import com.trysys.solution.trysolution.dto.MedicoDTO;
import com.trysys.solution.trysolution.dto.MesaDTO;
import com.trysys.solution.trysolution.dto.PacienteDTO;
import com.trysys.solution.trysolution.dto.ParticipanteDTO;
import com.trysys.solution.trysolution.dto.PedidoDTO;
import com.trysys.solution.trysolution.dto.eventoDTO;
import com.trysys.solution.trysolution.implementacao.Evento;
import com.trysys.solution.trysolution.implementacao.ListaMedicos;
import com.trysys.solution.trysolution.implementacao.Medico;
import com.trysys.solution.trysolution.implementacao.Mesa;
import com.trysys.solution.trysolution.implementacao.MesaObject;
import com.trysys.solution.trysolution.implementacao.Paciente;
import com.trysys.solution.trysolution.implementacao.Participante;
import com.trysys.solution.trysolution.implementacao.Pedido;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestauranteController {
    
    public Mesa mesa;
    
    @GetMapping("/restaurante/listar")
    public String restaurante(Model model) { 
        model.addAttribute("mesas", new MesaDTO()); 
        return "lista_mesas";
    }

    @GetMapping("/restaurante/mesa")
    public String mesa(Model model) { 
        model.addAttribute("mesa", new MesaDTO()); 
        return "mesa";
    }

     @PostMapping("/restaurante/mesa/criar")
    public String adicionaMesa(@ModelAttribute MesaDTO mesaDTO, Model model) {

        if(mesa == null){
            mesa = new Mesa();
            mesa.adicionarMesa(mesaDTO.getNumero(), mesaDTO.getCliente());;
        }else{
            mesa.adicionarMesa(mesaDTO.getNumero(), mesaDTO.getCliente());
        }

        List<MesaObject> mesasRetorno = mesa.getMesas();
        List<MesaDTO> mesas = new ArrayList<>();
        if(mesasRetorno != null){
            for (MesaObject mesaList : mesasRetorno) {
                MesaDTO mesaDto = new MesaDTO();
                mesaDto.setNumero(mesaList.getNumero());
                mesaDto.setCliente(mesaList.getCliente());
                mesaDto.setStatus(mesaList.getStatus());
                mesas.add(mesaDto);
            }
        }
        model.addAttribute("mesas", mesas ); 
        model.addAttribute("messagepart", "Mesa adicionada com sucesso" );
        return "lista_mesas";
    }
    @GetMapping("/restaurante/mesa/add_pedido/{numero}")
    public String addPedido(@PathVariable("numero") int numeroMesa, Model model) { 
        if(mesa != null){
            List<String> cardapioRetorno = mesa.exibirCardapio();
            model.addAttribute("cardapio", cardapioRetorno ); 
        }
        model.addAttribute("numeroMesa", numeroMesa); 
        model.addAttribute("itemPedido", new ItemPedidoDTO()); 
        return "item";
    }
    @PostMapping("/restaurante/mesa/add_pedido/criar/{numero}")
    public String adicionaPedido(@PathVariable("numero") int numeroMesa, @ModelAttribute ItemPedidoDTO itemPedidoDTO, Model model) {
        mesa.adicionarPedido(numeroMesa, itemPedidoDTO.getDescricao(), itemPedidoDTO.getQuantidade(), itemPedidoDTO.getTotal());
        
        List<MesaObject> mesasRetorno = mesa.getMesas();
        List<MesaDTO> mesas = new ArrayList<>();
        if(mesasRetorno != null){
            for (MesaObject mesaList : mesasRetorno) {
                MesaDTO mesaDto = new MesaDTO();
                mesaDto.setNumero(mesaList.getNumero());
                mesaDto.setCliente(mesaList.getCliente());
                mesaDto.setStatus(mesaList.getStatus());
                mesas.add(mesaDto);
            }
        }
        model.addAttribute("mesas", mesas ); 
        model.addAttribute("messagepart", "Pedido adicionado com sucesso" );
        return "lista_mesas";
    }

    @GetMapping("/restaurante/visualizar/pedido/{numero}")
    public String visualizaEvento(@PathVariable("numero") int numeroMesa, Model model) { 
       MesaObject visuMesa = mesa.buscarMesa(numeroMesa);
       List<PedidoDTO> pedidos = new ArrayList<>();
       Pedido pedidoAtual = visuMesa.getPedidos();
            if (pedidoAtual != null) {
                do {      
                    
                    PedidoDTO pedidoDTO = new PedidoDTO();
                    pedidoDTO.setItem(pedidoAtual.getItem());
                    pedidoDTO.setProximo(pedidoAtual.getProximo());
                    pedidoAtual = pedidoAtual.getProximo();
                    pedidos.add(pedidoDTO);
                } while (pedidoAtual != null && pedidoAtual != visuMesa.getPedidos());

            }

        model.addAttribute("mesa", visuMesa); //classe para trafegar os dados do front para o back 
        model.addAttribute("pedidos", pedidos);
        return "visualizar_mesa";
    }
}
