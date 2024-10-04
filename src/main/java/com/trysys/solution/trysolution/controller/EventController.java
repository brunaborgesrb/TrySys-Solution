package com.trysys.solution.trysolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.trysys.solution.trysolution.implementacao.Evento;
import com.trysys.solution.trysolution.implementacao.ListaEncadeada;
import com.trysys.solution.trysolution.implementacao.Participante;
import com.trysys.solution.trysolution.dto.ParticipanteDTO;
import com.trysys.solution.trysolution.dto.eventoDTO;
import java.util.List;
import java.util.ArrayList;

@Controller
public class EventController {

    public ListaEncadeada listaEncadeada;

 @GetMapping("/evento")
    public String evento(Model model) { //atraves da model o thymeleaf entende os dados do back
        model.addAttribute("evento", new eventoDTO()); //classe para trafegar os dados do front para o back 
        return "evento";
    }

    @PostMapping("/evento/criar")
    public String criarEvento(@ModelAttribute eventoDTO evento, Model model) {
        Evento eventoNext = new Evento(evento.getNome(),evento.getData(), evento.getLocal(), evento.getCapacidade());

        if(listaEncadeada == null){
            listaEncadeada = new ListaEncadeada();
            listaEncadeada.adicionarEventoInicio(eventoNext);
        }else{
            listaEncadeada.adicionarEventoFim(eventoNext); 
        }
        model.addAttribute("evento", eventoNext);
        
        return "evento_adicionado";
    }

    @GetMapping("/evento/listar")
    public String getEventos(Model model) { 

        List<Evento> eventosRetorno = listaEncadeada.getEventosEParticipantes();
        List<eventoDTO> eventos = new ArrayList<>();
        if(eventosRetorno != null){
            for (Evento evento : eventosRetorno) {
                eventoDTO eventoDto = new eventoDTO();
                eventoDto.setNome(evento.getNome());
                eventoDto.setData(evento.getData());
                eventoDto.setLocal(evento.getLocal());
                eventoDto.setCapacidade(evento.getCapacidade());

                eventos.add(eventoDto);
            }
        }
        model.addAttribute("eventos", eventos ); 
        return "lista_eventos";
    }

    @GetMapping("/evento/participante/{nome_evento}")
    public String eventoParticipante(@PathVariable("nome_evento") String nomeEvento, Model model) { 
        Evento evento = listaEncadeada.buscarEvento(nomeEvento);

        model.addAttribute("participante", new ParticipanteDTO()); 
        model.addAttribute("evento", evento); 
        return "add_participante";
    }

    @PostMapping("/evento/participante/add/{nome_evento}")
    public String adicionaParticipante(@PathVariable("nome_evento") String nomeEvento, @ModelAttribute ParticipanteDTO participanteDTO, Model model) {
        Participante participante = new Participante(participanteDTO.getNome(), participanteDTO.getNumeroInscricao());
        listaEncadeada.adicionarParticipante(nomeEvento, participante);
        List<Evento> eventosRetorno = listaEncadeada.getEventosEParticipantes();
        List<eventoDTO> eventos = new ArrayList<>();
        if(eventosRetorno != null){
            for (Evento eventoList : eventosRetorno) {
                eventoDTO eventoDto = new eventoDTO();
                eventoDto.setNome(eventoList.getNome());
                eventoDto.setData(eventoList.getData());
                eventoDto.setLocal(eventoList.getLocal());
                eventoDto.setCapacidade(eventoList.getCapacidade());

                eventos.add(eventoDto);
            }
        }
        model.addAttribute("eventos", eventos ); 
        model.addAttribute("messagepart", "Participante Adicionado com sucesso" );
        return "lista_eventos";
    }

    @GetMapping("/evento/visualizar/{nome_evento}")
    public String visualizaEvento(@PathVariable("nome_evento") String nomeEvento, Model model) { 
       Evento visuEvento = listaEncadeada.buscarEvento(nomeEvento);
       List<ParticipanteDTO> participantes = new ArrayList<>();
       Participante participanteAtual = visuEvento.getParticipantes();
            if (participanteAtual != null) {
                while (participanteAtual != null) {
                    ParticipanteDTO participanteDTO = new ParticipanteDTO();
                    participanteDTO.setNome(participanteAtual.getNome());
                    participanteDTO.setNumeroInscricao(participanteAtual.getNumeroInscricao());

                    participantes.add(participanteDTO);

                    participanteAtual = participanteAtual.getProximo();
                }
            }
        model.addAttribute("evento", visuEvento); //classe para trafegar os dados do front para o back 
        model.addAttribute("participantes", participantes);
        return "visualizar_evento";
    }

    @PostMapping("/evento/editar/{nome_evento}")
    public String editarEvento(@PathVariable("nome_evento") String nomeEvento, @ModelAttribute eventoDTO evento, Model model) {

        Evento eventoEdit = listaEncadeada.buscarEvento(nomeEvento);
        if(eventoEdit.getNome() != evento.getNome()){
            listaEncadeada.atualizarNomeEvento(nomeEvento, evento.getNome());
        }
        if(eventoEdit.getLocal() != evento.getLocal()){
            listaEncadeada.atualizarLocalEvento(nomeEvento, evento.getLocal());
        }
        if(eventoEdit.getCapacidade() != evento.getCapacidade()){
            listaEncadeada.atualizarCapacidadeEvento(nomeEvento, evento.getCapacidade());
        }
        if(eventoEdit.getData() != evento.getData()){
            listaEncadeada.atualizarDataEvento(nomeEvento, evento.getData());
        }

        List<Evento> eventosRetorno = listaEncadeada.getEventosEParticipantes();
        List<eventoDTO> eventos = new ArrayList<>();
        if(eventosRetorno != null){
            for (Evento eventoList : eventosRetorno) {
                eventoDTO eventoDto = new eventoDTO();
                eventoDto.setNome(eventoList.getNome());
                eventoDto.setData(eventoList.getData());
                eventoDto.setLocal(eventoList.getLocal());
                eventoDto.setCapacidade(eventoList.getCapacidade());

                eventos.add(eventoDto);
            }
        }

        model.addAttribute("eventos", eventos ); 
        model.addAttribute("messagepart", "Evento Editado com Sucesso" );
        return "lista_eventos";
    }

    @GetMapping("/evento/removerpart/{nome_evento}/{num_inscricao}")
    public String removerParticipante(@PathVariable("nome_evento") String nomeEvento, @PathVariable("num_inscricao") int numInscricao,Model model) {
        listaEncadeada.removerParticipante(nomeEvento, numInscricao);
        List<Evento> eventosRetorno = listaEncadeada.getEventosEParticipantes();
        List<eventoDTO> eventos = new ArrayList<>();
        if(eventosRetorno != null){
            for (Evento eventoList : eventosRetorno) {
                eventoDTO eventoDto = new eventoDTO();
                eventoDto.setNome(eventoList.getNome());
                eventoDto.setData(eventoList.getData());
                eventoDto.setLocal(eventoList.getLocal());
                eventoDto.setCapacidade(eventoList.getCapacidade());

                eventos.add(eventoDto);
            }
        }

        model.addAttribute("eventos", eventos ); 
        model.addAttribute("messagepart", "Participante removido com Sucesso" );
        return "lista_eventos";
    }

    @GetMapping("/evento/remover/{nome_evento}")
    public String removerEvento(@PathVariable("nome_evento") String nomeEvento, Model model) {
        listaEncadeada.removerEvento(nomeEvento);
        List<Evento> eventosRetorno = listaEncadeada.getEventosEParticipantes();
        List<eventoDTO> eventos = new ArrayList<>();
        if(eventosRetorno != null){
            for (Evento eventoList : eventosRetorno) {
                eventoDTO eventoDto = new eventoDTO();
                eventoDto.setNome(eventoList.getNome());
                eventoDto.setData(eventoList.getData());
                eventoDto.setLocal(eventoList.getLocal());
                eventoDto.setCapacidade(eventoList.getCapacidade());

                eventos.add(eventoDto);
            }
        }

        model.addAttribute("eventos", eventos ); 
        model.addAttribute("messagepart", "Evento removido com Sucesso" );
        return "lista_eventos";
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindos a TriSys!");
        return "home";
    }
}
