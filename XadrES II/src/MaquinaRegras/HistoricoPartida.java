package MaquinaRegras;

import java.util.List;

public class HistoricoPartida {
    public static final String JOGO_EM_ANDAMENTO = "Jogo em Andamento";
    public static final String JOGO_FINALIZADO_VENCEDOR = "Jogo Finalizado com Vencedor";
    public static final String JOGO_FINALIZADO_EMPATE = "Jogo Finalizado com Empate";
    private List<String> jogadores;
    private String resultado;
    private String jogadorVencedor;
    
    public HistoricoPartida () {
        resultado = JOGO_EM_ANDAMENTO;
    }

    public String getJogadorVencedor() {
        return jogadorVencedor;
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }

    public String getResultado() {
        return resultado;
    }

    public void jogoEmpatado () {
        resultado = JOGO_FINALIZADO_EMPATE;
        jogadorVencedor = null;
    }
    
    public void vencedor (String jogadorVencedor) {
        resultado = JOGO_FINALIZADO_VENCEDOR;
        this.jogadorVencedor = jogadorVencedor;
    }
}
