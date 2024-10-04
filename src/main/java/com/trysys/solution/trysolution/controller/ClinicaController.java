package com.trysys.solution.trysolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trysys.solution.trysolution.dto.ConsultaDTO;
import com.trysys.solution.trysolution.dto.MedicoDTO;
import com.trysys.solution.trysolution.dto.PacienteDTO;
import com.trysys.solution.trysolution.dto.eventoDTO;
import com.trysys.solution.trysolution.implementacao.Consulta;
import com.trysys.solution.trysolution.implementacao.Evento;
import com.trysys.solution.trysolution.implementacao.ListaConsultas;
import com.trysys.solution.trysolution.implementacao.ListaEncadeada;
import com.trysys.solution.trysolution.implementacao.ListaMedicos;
import com.trysys.solution.trysolution.implementacao.ListaPaciente;
import com.trysys.solution.trysolution.implementacao.Medico;
import com.trysys.solution.trysolution.implementacao.Paciente;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClinicaController {

    public ListaMedicos listaMedicos;

    public ListaPaciente listaPaciente;

    public ListaConsultas listaConsultas;

    @GetMapping("/clinica")
    public String clinica(Model model) { 
        
        return "clinica";
    }

    @GetMapping("/clinica/medico")
    public String medico(Model model) { 
        model.addAttribute("medico", new MedicoDTO()); 
        return "medico";
    }

    @PostMapping("/clinica/medico/criar")
    public String criarMedico(@ModelAttribute MedicoDTO medico, Model model) {
        Medico medicoNext = new Medico(medico.getNome(),medico.getCrm(), medico.getEspecialidade(), medico.isDisponibilidade(), medico.getCpf());

        if(listaMedicos == null){
            listaMedicos = new ListaMedicos();
            listaMedicos.inserirMedicoOrdenado(medicoNext);
        }else{
            listaMedicos.inserirMedicoOrdenado(medicoNext);
        }
        model.addAttribute("medico", medicoNext);
        
        if(listaMedicos != null){
            List<Medico> medicosRetorno = listaMedicos.getMedicos();
            List<MedicoDTO> medicos = new ArrayList<>();
            if(medicosRetorno != null){
                for (Medico medicor : medicosRetorno) {
                    MedicoDTO medicoDTO = new MedicoDTO();
                    medicoDTO.setNome(medicor.getNome());
                    medicoDTO.setCpf(medicor.getCpf());
                    medicoDTO.setCrm(medicor.getCrm());
                    medicoDTO.setDisponibilidade(medicor.isDisponibilidade());
                    medicoDTO.setEspecialidade(medicor.getEspecialidade());
                    medicoDTO.setPatendidos(medicor.getPatendidos());
    
                    medicos.add(medicoDTO);
                }
            }
            model.addAttribute("medicos", medicos ); 
            model.addAttribute("messagepart", "Medico Inserido com Sucesso" );
        }
            
        
            return "lista_medicos";
        
    }

    @GetMapping("/clinica/medico/listar")
    public String listarMedicos(Model model) { 
        if(listaMedicos != null){
        List<Medico> medicosRetorno = listaMedicos.getMedicos();
        List<MedicoDTO> medicos = new ArrayList<>();
        if(medicosRetorno != null){
            for (Medico medico : medicosRetorno) {
                MedicoDTO medicoDTO = new MedicoDTO();
                medicoDTO.setNome(medico.getNome());
                medicoDTO.setCpf(medico.getCpf());
                medicoDTO.setCrm(medico.getCrm());
                medicoDTO.setDisponibilidade(medico.isDisponibilidade());
                medicoDTO.setEspecialidade(medico.getEspecialidade());
                medicoDTO.setPatendidos(medico.getPatendidos());

                medicos.add(medicoDTO);
            }
        }
        model.addAttribute("medicos", medicos ); 
    }
        
    
        return "lista_medicos";
    }

    @GetMapping("/clinica/medico/remover/{crm}")
    public String removerMedico(@PathVariable("crm") int crm, Model model) {
        listaMedicos.excluirMedico(crm);
        List<Medico> medicosRetorno = listaMedicos.getMedicos();
        List<MedicoDTO> medicos = new ArrayList<>();
        if(medicosRetorno != null){
            for (Medico medico : medicosRetorno) {
                MedicoDTO medicoDTO = new MedicoDTO();
                medicoDTO.setNome(medico.getNome());
                medicoDTO.setCpf(medico.getCpf());
                medicoDTO.setCrm(medico.getCrm());
                medicoDTO.setDisponibilidade(medico.isDisponibilidade());
                medicoDTO.setEspecialidade(medico.getEspecialidade());
                medicoDTO.setPatendidos(medico.getPatendidos());

                medicos.add(medicoDTO);
            }
        }
        model.addAttribute("medicos", medicos ); 
        model.addAttribute("messagepart", "Medico removido com Sucesso" );
        return "lista_medicos";
    }
    @GetMapping("/clinica/paciente/listar")
    public String listarPacientes(Model model) { 
        if(listaPaciente != null){
        List<Paciente> pacientesRetorno = listaPaciente.getPacientes();
        List<PacienteDTO> pacientes = new ArrayList<>();
        if(pacientesRetorno != null){
            for (Paciente paciente : pacientesRetorno) {
                PacienteDTO pacienteDTO = new PacienteDTO();
                pacienteDTO.setNome(paciente.getNome());
                pacienteDTO.setCpf(paciente.getCpf());
                pacienteDTO.setIdade(paciente.getIdade());
                pacienteDTO.sethMedico(paciente.gethMedico());
                pacienteDTO.setUltConsulta(paciente.getUltConsulta());

                pacientes.add(pacienteDTO);
            }
        }
        model.addAttribute("pacientes", pacientes ); 
    }
        
    
        return "lista_pacientes";
    }
    @GetMapping("/clinica/paciente")
    public String paciente(Model model) { 
        if(listaMedicos != null){
            List<Medico> medicosRetorno = listaMedicos.getMedicos();
            List<MedicoDTO> medicos = new ArrayList<>();
            if(medicosRetorno != null){
                for (Medico medico : medicosRetorno) {
                    MedicoDTO medicoDTO = new MedicoDTO();
                    medicoDTO.setNome(medico.getNome());
                    medicoDTO.setCpf(medico.getCpf());
                    medicoDTO.setCrm(medico.getCrm());
                    medicoDTO.setDisponibilidade(medico.isDisponibilidade());
                    medicoDTO.setEspecialidade(medico.getEspecialidade());
                    medicoDTO.setPatendidos(medico.getPatendidos());
    
                    medicos.add(medicoDTO);
                }
            }
            model.addAttribute("medicos", medicos ); 
        }
        model.addAttribute("paciente", new PacienteDTO()); 
        return "paciente";
    }


    @PostMapping("/clinica/paciente/criar")
    public String criarPaciente(@ModelAttribute PacienteDTO paciente, Model model) {
        Paciente pacienteNext = new Paciente(paciente.getNome(),paciente.getIdade(), paciente.gethMedico(), paciente.getUltConsulta(), paciente.getCpf());

        if(listaPaciente == null){
            listaPaciente = new ListaPaciente();
            listaPaciente.inserirPacienteOrdenado(pacienteNext);
        }else{
            listaPaciente.inserirPacienteOrdenado(pacienteNext);
        }
        model.addAttribute("paciente", pacienteNext);
        
        if(listaPaciente != null){
            List<Paciente> pacientesRetorno = listaPaciente.getPacientes();
            List<PacienteDTO> pacientes = new ArrayList<>();
            if(pacientesRetorno != null){
                for (Paciente pacienter : pacientesRetorno) {
                    PacienteDTO pacienteDTO = new PacienteDTO();
                    pacienteDTO.setNome(pacienter.getNome());
                    pacienteDTO.setCpf(pacienter.getCpf());
                    pacienteDTO.setIdade(pacienter.getIdade());
                    pacienteDTO.sethMedico(pacienter.gethMedico());
                    pacienteDTO.setUltConsulta(pacienter.getUltConsulta());
    
                    pacientes.add(pacienteDTO);
                }
            }
           
            model.addAttribute("pacientes", pacientes ); 
            model.addAttribute("messagepart", "Paciente Inserido com Sucesso" );
        }
            
        
        return "lista_pacientes";
        
    }

    @GetMapping("/clinica/paciente/remover/{nome_paciente}")
    public String removerPaciente(@PathVariable("nome_paciente") String nomePaciente, Model model) {
        listaPaciente.excluirPaciente(nomePaciente);
        List<Paciente> pacientesRetorno = listaPaciente.getPacientes();
            List<PacienteDTO> pacientes = new ArrayList<>();
            if(pacientesRetorno != null){
                for (Paciente pacienter : pacientesRetorno) {
                    PacienteDTO pacienteDTO = new PacienteDTO();
                    pacienteDTO.setNome(pacienter.getNome());
                    pacienteDTO.setCpf(pacienter.getCpf());
                    pacienteDTO.setIdade(pacienter.getIdade());
                    pacienteDTO.sethMedico(pacienter.gethMedico());
                    pacienteDTO.setUltConsulta(pacienter.getUltConsulta());
    
                    pacientes.add(pacienteDTO);
                }
            }
            model.addAttribute("messagepart", "Paciente removido com Sucesso" );
            model.addAttribute("pacientes", pacientes ); 

            return "lista_pacientes";
    }

    @GetMapping("/clinica/consulta/listar")
    public String listarConsultas(Model model) { 
        if(listaConsultas != null){
        List<Consulta> consultasRetorno = listaConsultas.getConsultas();
        List<ConsultaDTO> consultas = new ArrayList<>();
        if(consultasRetorno != null){
            for (Consulta consulta : consultasRetorno) {
                ConsultaDTO consultaDTO = new ConsultaDTO();
                consultaDTO.setNome(consulta.getNome());
                consultaDTO.setUltConsulta(consulta.getUltConsulta());

                consultas.add(consultaDTO);
            }
        }
        model.addAttribute("consultas", consultas ); 
    }
        
    
        return "lista_consulta";
    }

    @GetMapping("/clinica/consulta")
    public String consulta(Model model) { 
        if(listaMedicos != null){
            List<Medico> medicosRetorno = listaMedicos.getMedicos();
            List<MedicoDTO> medicos = new ArrayList<>();
            if(medicosRetorno != null){
                for (Medico medico : medicosRetorno) {
                    MedicoDTO medicoDTO = new MedicoDTO();
                    medicoDTO.setNome(medico.getNome());
                    medicoDTO.setCpf(medico.getCpf());
                    medicoDTO.setCrm(medico.getCrm());
                    medicoDTO.setDisponibilidade(medico.isDisponibilidade());
                    medicoDTO.setEspecialidade(medico.getEspecialidade());
                    medicoDTO.setPatendidos(medico.getPatendidos());
    
                    medicos.add(medicoDTO);
                }
            }
            model.addAttribute("medicos", medicos ); 
        }

        if(listaPaciente != null){
            List<Paciente> pacientesRetorno = listaPaciente.getPacientes();
            List<PacienteDTO> pacientes = new ArrayList<>();
            if(pacientesRetorno != null){
                for (Paciente pacienter : pacientesRetorno) {
                    PacienteDTO pacienteDTO = new PacienteDTO();
                    pacienteDTO.setNome(pacienter.getNome());
                    pacienteDTO.setCpf(pacienter.getCpf());
                    pacienteDTO.setIdade(pacienter.getIdade());
                    pacienteDTO.sethMedico(pacienter.gethMedico());
                    pacienteDTO.setUltConsulta(pacienter.getUltConsulta());
    
                    pacientes.add(pacienteDTO);
                }
            }
            model.addAttribute("pacientes", pacientes ); 
        }
            
        model.addAttribute("consulta", new ConsultaDTO()); 
        return "consulta";
    }

    @PostMapping("/clinica/consulta/criar")
    public String criarConsulta(@ModelAttribute ConsultaDTO consulta, Model model) {
        Consulta consultaNext = new Consulta(consulta.getNome(),consulta.getUltConsulta());
        Medico medico = listaMedicos.buscarMedico(consulta.getCrmMedico());
        if (medico != null) {
            medico.incrementaPacientesAtendidos();
        } else {
            System.out.println("Médico não encontrado.");
        }
        if(listaConsultas == null){
            listaConsultas = new ListaConsultas();
            listaConsultas.inserirConsultaOrdenada(consultaNext);
        }else{
            listaConsultas.inserirConsultaOrdenada(consultaNext);
        }
        model.addAttribute("consulta", consultaNext);
        
        if(listaConsultas != null){
        List<Consulta> consultasRetorno = listaConsultas.getConsultas();
        List<ConsultaDTO> consultas = new ArrayList<>();
        if(consultasRetorno != null){
            for (Consulta consultar : consultasRetorno) {
                ConsultaDTO consultaDTO = new ConsultaDTO();
                consultaDTO.setNome(consultar.getNome());
                consultaDTO.setUltConsulta(consultar.getUltConsulta());

                consultas.add(consultaDTO);
            }
        }
        model.addAttribute("consultas", consultas ); 
        model.addAttribute("messagepart", "Consulta Inserido com Sucesso" );
    }
           
          
            
        
        return "lista_consulta";
        
    }
    
}
