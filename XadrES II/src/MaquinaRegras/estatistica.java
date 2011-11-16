package MaquinaRegras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class estatistica {
    public static final String JOGADOR_CPU = "Jogador CPU";
    public static final String JOGADOR_UM = "Jogador Um";
    public static final String JOGADOR_DOIS = "Jogador Dois";
    private Integer quantidadeJogos;
    private List<HistoricoPartida> historicosPartidas;
    private HashMap<String, String> jogadores;
    
    public estatistica() {
    }

    public HashMap getJogadores() {
        if (jogadores == null) {
            jogadores = new HashMap();
        }
        return jogadores;
    }

    public void setJogadores(HashMap jogadores) {
        this.jogadores = jogadores;
    }

    public Integer getQuantidadeJogos() {
        if (quantidadeJogos == null) {
            quantidadeJogos = 0;
        }
        return quantidadeJogos;
    }

    public void setQuantidadeJogos(Integer quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }

    public List<HistoricoPartida> getHistoricosPartidas() {
        if (historicosPartidas == null) {
            historicosPartidas = new ArrayList<HistoricoPartida>();
        }
        return historicosPartidas;
    }

    public void setHistoricosPartidas(List<HistoricoPartida> historicosPartidas) {
        this.historicosPartidas = historicosPartidas;
    }
    
    public void novaPartida (String nomeJogador1, String nomeJogador2) {
        HistoricoPartida historicoPartida = new HistoricoPartida();
        List<String> jogadores = new ArrayList();
        jogadores.add(nomeJogador1);
        jogadores.add(nomeJogador2);
        historicoPartida.setJogadores(jogadores);
        
        getHistoricosPartidas().add(historicoPartida);
        
        quantidadeJogos =+ 1;
    }
    
    public void novaPartida (String nomeJogador1) {
        HistoricoPartida historicoPartida = new HistoricoPartida();
        List<String> jogadores = new ArrayList();
        jogadores.add(nomeJogador1);
        jogadores.add(JOGADOR_CPU);
        historicoPartida.setJogadores(jogadores);
        
        getHistoricosPartidas().add(historicoPartida);
        
        quantidadeJogos =+ 1;
    }
    
    public Integer quantidadeVitoriasJogador (String nomeJogador) {
        Integer quantidadeVitorias = 0;
        
        for (HistoricoPartida hp : historicosPartidas) {
            if (hp.getResultado().equals(HistoricoPartida.JOGO_FINALIZADO_VENCEDOR)
                    && hp.getJogadorVencedor() != null
                    && hp.getJogadorVencedor().equals(nomeJogador)) {
                quantidadeVitorias ++;
            }
        }
        
        return quantidadeVitorias;
    }
    
    public Integer quantidadeDerrotasJogador (String nomeJogador) {
        Integer quantidadeDerrotas = 0;
        
        for (HistoricoPartida hp : historicosPartidas) {
            if (hp.getResultado().equals(HistoricoPartida.JOGO_FINALIZADO_VENCEDOR)
                    && hp.getJogadorVencedor() != null
                    && !hp.getJogadorVencedor().equals(nomeJogador)
                    && (hp.getJogadores().get(0).equals(nomeJogador) 
                    || hp.getJogadores().get(1).equals(nomeJogador))) {
                quantidadeDerrotas ++;
            }
        }
        
        return quantidadeDerrotas;
    }
    
    public Integer quantidadeEmpatesJogador (String nomeJogador) {
        Integer quantidadeEmpates = 0;
        
        for (HistoricoPartida hp : historicosPartidas) {
            if (hp.getResultado().equals(HistoricoPartida.JOGO_FINALIZADO_EMPATE)
                    && (hp.getJogadores().get(0).equals(nomeJogador) 
                    || hp.getJogadores().get(1).equals(nomeJogador))) {
                quantidadeEmpates ++;
            }
        }
        
        return quantidadeEmpates;
    }
    
    public List<HashMap<String, String>> ultimasDezDuplas () {
        List<HashMap<String, String>> ultimasDuplas = new ArrayList<HashMap<String, String>>();
        
        for (HistoricoPartida hp : historicosPartidas) {
            HashMap<String, String> dupla = new HashMap<String, String>();
            
            dupla.put(JOGADOR_UM, hp.getJogadores().get(0));
            dupla.put(JOGADOR_DOIS, hp.getJogadores().get(1));
            
            ultimasDuplas.add(dupla);
        }
        
        return ultimasDuplas;
    }
    
}
