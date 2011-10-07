/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadresii;

import Interface.Jogo;
import Interface.MenuPrincipal;
import Interface.Motor;
import Parametros.Constantes;

/**
 *
 * @author Ceph
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Motor motor = new Motor();
        motor.criarJanela(Constantes.DIM_TABULEIRO_HORIZONTAL, Constantes.DIM_TABULEIRO_VERTICAL);
        motor.addTela(Constantes.TELA_INICIAL, new MenuPrincipal());
        motor.setTelaInicial(Constantes.TELA_INICIAL);
        motor.addTela(Constantes.TELA_JOGO, new Jogo());
        motor.rodar();
    }
}
