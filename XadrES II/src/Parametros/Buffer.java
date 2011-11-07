/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametros;

import Interface.Peca;
import Interface.Tabuleiro;
import java.util.List;

/**
 *
 * @author Ceph
 */
public class Buffer {
    String data;
    String hora; 
    String nomeJogador1;
    String nomeJogador2;
    String vezDeQuem;
    Boolean temCpu;
    List<Peca> pecas;
    Tabuleiro tabuleiro;

    public String getVezDeQuem() {
        return vezDeQuem;
    }

    public void setVezDeQuem(String vezDeQuem) {
        this.vezDeQuem = vezDeQuem;
    }
    
    
    
    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNomeJogador1(String nomeJogador1) {
        this.nomeJogador1 = nomeJogador1;
    }

    public void setNomeJogador2(String nomeJogador2) {
        this.nomeJogador2 = nomeJogador2;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void setTemCpu(Boolean temCpu) {
        this.temCpu = temCpu;
    }
    
    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getNomeJogador1() {
        return nomeJogador1;
    }

    public String getNomeJogador2() {
        return nomeJogador2;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public Boolean getTemCpu() {
        return temCpu;
    }
    
    
}
