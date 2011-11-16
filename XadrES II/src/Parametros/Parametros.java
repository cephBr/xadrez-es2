/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametros;

import Interface.Tabuleiro;



/**
 *
 * @author Ceph
 */
public class Parametros {
    String nomeJogador1;
    String nomeJogador2;
    Tabuleiro tabuleiro;
    String turno;  
    Boolean temCpu = Boolean.FALSE;
     
    
     

    public String vezDeQuem(){
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public void passaVez(){
        if (turno.equals(Constantes.BRANCO)) 
            turno = Constantes.PRETO;
        else
            turno= Constantes.BRANCO;
    }
    
    public void defineTurno(String turno){
        this.turno=turno;
    }
    
    
    public Boolean temCpu() {
        return temCpu;
    }

    public void setTemCpu(Boolean temCpu) {
        this.temCpu = temCpu;
    }
    
    
    
    public String getNomeJogador1() {
        return nomeJogador1;
    }

    public void setNomeJogador1(String nomeJogador1) {
        this.nomeJogador1 = nomeJogador1;
    }

    public String getNomeJogador2() {
        return nomeJogador2;
    }

    public void setNomeJogador2(String nomeJogador2) {
        this.nomeJogador2 = nomeJogador2;
    }
    
    
            
         
    
}
