/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xadresii;

import Componentes.InterfaceGrafica;
import Componentes.Peça;
import Componentes.Tabuleiro;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sound;
import Parametros.Constantes;
import JPlay.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceph
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        /**Window janela = new Window(Constantes.DIM_TABULEIRO_HORIZONTAL,Constantes.DIM_TABULEIRO_VERTICAL);
        Keyboard keyboard = janela.getKeyboard();
        keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard. DETECT_INITIAL_PRESS_ONLY);
        Mouse mouse = janela.getMouse();
        Tabuleiro tabuleiro = new Tabuleiro(8,8,Constantes.TABULEIRO);
        Peça peça = new Peça(0,"teste0",Constantes.RAINHA,2,119,113,0,0);
        tabuleiro.setPeça(0, 0, peça);
        Peça peça2 = new Peça(1,"teste1",Constantes.RAINHA,2,173,113,1,0);
        tabuleiro.setPeça(0, 1, peça2);
        Peça peça3 = new Peça(2,"teste2",Constantes.RAINHA,2,229,113,2,0);
        //tabuleiro.setPeça(0, 2, peça3);
        Peça peça4 = new Peça(3,"teste3",Constantes.RAINHA,2,285,113,3,0);
       // tabuleiro.setPeça(0, 3, peça3);
        Peça peça5 = new Peça(4,"teste4",Constantes.RAINHA,2,339,113,4,0);
      //  tabuleiro.setPeça(0, 4, peça4);
        Peça peça6 = new Peça(5,"teste5",Constantes.RAINHA,2,395,113,5,0);
     //   tabuleiro.setPeça(0, 5, peça5);
        Peça peça7 = new Peça(6,"teste6",Constantes.RAINHA,2,450,113,6,0);
      //  tabuleiro.setPeça(0, 6, peça6);
        Peça peça8 = new Peça(7,"teste7",Constantes.RAINHA,2,506,113,7,0);
     //   tabuleiro.setPeça(0, 7, peça7);
        Boolean executando = true;
        
       

        while(executando)
        {
            tabuleiro.fundo.draw();
            
            peça2.sprite.draw();
            peça.sprite.draw();
            janela.display();
            try {
               if (mouse.isLeftButtonPressed()==true) {

                if(peça.estaSelecionada()){
                    if (!mouse.isOverObject(peça.sprite)) {
                        tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y),tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), peça);
                        peça.sprite.reset();
                    }
                }

               if(mouse.isOverObject(peça.sprite)){
                    if(!peça.estaSelecionada()) {
                         peça.selecionar();
                    }else{
                        peça.selecionada=false;
                        peça.sprite.reset();
                        }
                    }
                 }
               }
             catch (Exception e) {
                new Sound(Constantes.ERRO_SOM).play();
            }
           
            if ( keyboard.keyDown(Keyboard.ESCAPE_KEY) == true){
               int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
                if (op == JOptionPane.OK_OPTION)  
                   executando = false;
            }
        }
        janela.exit();**/

     InterfaceGrafica i = new InterfaceGrafica();
    }

}
