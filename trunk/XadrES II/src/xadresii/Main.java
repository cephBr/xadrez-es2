/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadresii;

import Interface.SplashScreen;

/**
 *
 * @author Ceph
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Motor motor = new Motor();
        //motor.criarJanela(Constantes.DIM_TABULEIRO_HORIZONTAL, Constantes.DIM_TABULEIRO_VERTICAL);
        //motor.addTela(Constantes.TELA_INICIAL, new TelaMenuPrincipal());
        //motor.setTelaInicial(Constantes.TELA_INICIAL);
        //motor.addTela(Constantes.TELA_JOGO, new TelaJogo());
        //motor.addTela(Constantes.TELA_AJUDA, new TelaAjuda());
        //motor.addTela(Constantes.TELA_REGRAS, new TelaRegras());
        //motor.addTela(Constantes.TELA_JOGAR, new TelaJogar());
        //motor.addTela(Constantes.TELA_NOVO_JOGO, new TelaNovoJogo());
        //motor.addTela(Constantes.TELA_OPCOES, new TelaOpcoes());
        //motor.addTela(Constantes.TELA_ESTATISTICA, new TelaEstatisticas());
        //motor.addTela(Constantes.TELA_NIVEL, new TelaNivel());
        //motor.rodar();
        new Thread(new SplashScreen()).start();
    }
}
