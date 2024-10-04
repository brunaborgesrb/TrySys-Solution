package com.trysys.solution.trysolution.dto;
import com.trysys.solution.trysolution.implementacao.Participante;
import java.util.List;
import java.util.ArrayList;

public class eventoDTO {

        private String nome;
        private String data;
        private String local;
        private int capacidade;
        List<ParticipanteDTO> participantes;
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public String getLocal() {
            return local;
        }
        public void setLocal(String local) {
            this.local = local;
        }
        public int getCapacidade() {
            return capacidade;
        }
        public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }
        public List<ParticipanteDTO> getParticipantes() {
            return participantes;
        }
        public void setParticipantes(List<ParticipanteDTO> participantes) {
            this.participantes = participantes;
        }
        
        @Override
        public String toString() {
            return "eventoDTO [nome=" + nome + ", data=" + data + ", local=" + local + ", capacidade=" + capacidade
                    + ", participantes=" + participantes + "]";
        }


        

}
