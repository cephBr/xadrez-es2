/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sound;
import JPlay.Window;
import Parametros.Constantes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceph
 */
public class InterfaceGrafica {
        Tabuleiro tabuleiro;
        List<Peca> pecas = new ArrayList<Peca>();
        //time branco
        Peca peça1,peça2,peça3,peça4,peça5,peça6,peça7,peça8,
             peça9, peça10,peça11,peça12,peça13,peça14,peça15,peça16;
        
        //time preto
        Peca peça17,peça18,peça19,peça20,peça21,peça22,peça23,peça24,
             peça25,peça26,peça27,peça28,peça29,peça30,peça31,peça32;   
        
        Window janela;
        Keyboard keyboard;
        Mouse mouse;
        boolean executando;
        boolean temPecaSelecionada;

    public InterfaceGrafica(){
        carregaDados();
        loop();
        encerrarJogo();
    }
     private void carregaDados(){
         temPecaSelecionada = false;
         janela = new Window(Constantes.DIM_TABULEIRO_HORIZONTAL,Constantes.DIM_TABULEIRO_VERTICAL);
         keyboard = janela.getKeyboard();
         keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard. DETECT_INITIAL_PRESS_ONLY);
         mouse = janela.getMouse();
         tabuleiro = new Tabuleiro(8,8,Constantes.TABULEIRO);
         
         pecas.add(new Torre(0,0,119,113,1,"Torre_Preto_1"));
         tabuleiro.setPeça(0,0,pecas.get(0));
         pecas.add(new Cavalo(1,0,173,113,2,"Cavalo_Preto_1"));
         tabuleiro.setPeça(1,0,pecas.get(1));
         pecas.add(new Bispo(2,0,229,113,3,"Bispo_Preto_1"));
         tabuleiro.setPeça(2,0,pecas.get(2));
         pecas.add(new Rainha(3,0,285,113,4,"Rainha_Preto"));
         tabuleiro.setPeça(3,0,pecas.get(3));
         pecas.add(new Rei(4,0,339,113,5,"Rei_Preto"));
         tabuleiro.setPeça(4,0,pecas.get(4));
         pecas.add(new Bispo(5,0,395,113,6,"Bispo_Preto_2"));
         tabuleiro.setPeça(5,0,pecas.get(5));
         pecas.add(new Rei(6,0,450,113,7,"Cavalo_Preto_2"));
         tabuleiro.setPeça(6,0,pecas.get(6));
         pecas.add(new Rei(7,0,506,113,8,"Torre_Preto_2"));
         tabuleiro.setPeça(7,0,pecas.get(7));
         pecas.add(new Peao(0,1,115,158,9,"Peao_Preto_1"));
         tabuleiro.setPeça(0,1,pecas.get(8));
         pecas.add(new Peao(1,1,171,158,10,"Peao_Preto_2"));
         tabuleiro.setPeça(1,1,pecas.get(9));
         pecas.add(new Peao(2,1,228,158,11,"Peao_Preto_3"));
         tabuleiro.setPeça(2,1,pecas.get(10));
         pecas.add(new Peao(3,1,284,158,12,"Peao_Preto_4"));
         tabuleiro.setPeça(3,1,pecas.get(11));
         pecas.add(new Peao(4,1,341,158,13,"Peao_Preto_5"));
         tabuleiro.setPeça(4,1,pecas.get(12));
         pecas.add(new Peao(5,1,396,158,14,"Peao_Preto_6"));
         tabuleiro.setPeça(5,1,pecas.get(13));
         pecas.add(new Peao(6,1,451,158,15,"Peao_Preto_7"));
         tabuleiro.setPeça(6,1,pecas.get(14));
         pecas.add(new Peao(7,1,508,158,16,"Peao_Preto_8"));
         tabuleiro.setPeça(7,1,pecas.get(15));
         
         
         pecas.add(new Peao(0,6,99,412,17,"Peao_Branco_1"));
         tabuleiro.setPeça(0,6,pecas.get(16));
         pecas.add(new Peao(1,6,159,412,18,"Peao_Branco_2"));
         tabuleiro.setPeça(1,6,pecas.get(17));
         pecas.add(new Peao(2,6,220,412,19,"Peao_Branco_3"));
         tabuleiro.setPeça(2,6,pecas.get(18));
         pecas.add(new Peao(3,6,281,412,20,"Peao_Branco_4"));
         tabuleiro.setPeça(3,6,pecas.get(19));
         pecas.add(new Peao(4,6,341,412,21,"Peao_Branco_5"));
         tabuleiro.setPeça(4,6,pecas.get(20));
         pecas.add(new Peao(5,6,404,412,22,"Peao_Branco_6"));
         tabuleiro.setPeça(5,6,pecas.get(21));
         pecas.add(new Peao(6,6,464,412,23,"Peao_Branco_7"));
         tabuleiro.setPeça(6,6,pecas.get(22));
         pecas.add(new Peao(7,6,526,412,24,"Peao_Branco_8"));
         tabuleiro.setPeça(7,6,pecas.get(23));
         pecas.add(new Torre(0,7,94,471,25,"Torre_Branco_1"));
         tabuleiro.setPeça(0,7,pecas.get(24));
         pecas.add(new Cavalo(1,7,157,471,26,"Cavalo_Branco_1"));
         tabuleiro.setPeça(1,7,pecas.get(25));
         pecas.add(new Bispo(2,7,220,471,27,"Bispo_Branco_1"));
         tabuleiro.setPeça(2,7,pecas.get(26));
         pecas.add(new Rainha(3,7,281,471,28,"Rainha_Branco"));
         tabuleiro.setPeça(3,7,pecas.get(27));
         pecas.add(new Rei(4,7,343,471,29,"Rei_Branco"));
         tabuleiro.setPeça(4,7,pecas.get(28));
         pecas.add(new Bispo(5,7,405,471,30,"Bispo_Branco_2"));
         tabuleiro.setPeça(5,7,pecas.get(29));
         pecas.add(new Rei(6,7,467,471,31,"Cavalo_Branco_2"));
         tabuleiro.setPeça(6,7,pecas.get(30));
         pecas.add(new Rei(7,7,529,471,32,"Torre_Branco_2"));
         tabuleiro.setPeça(7,7,pecas.get(31));
         
         executando = true;
   }
   

    private void monitorPeça(Peca p) throws Exception{
     
                
                if(p.estaSelecionada()){
                    if (!mouse.isOverObject(p.sprite)) {
                        tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y),tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), p);
                        temPecaSelecionada=false;
                        p.sprite.reset();
                    }
                }

               if(mouse.isOverObject(p.sprite)){
                    if(!p.estaSelecionada()&&!temPecaSelecionada) {
                            p.selecionar();
                            temPecaSelecionada=true;
                    }else{
                            p.selecionada=false;
                            temPecaSelecionada=false;
                            p.sprite.reset();
                        }
               }
               
           }
       

    public void atualiazações(){
          try {
            if (mouse.isLeftButtonPressed()==true) {
                for (Iterator<Peca> it = pecas.iterator(); it.hasNext();) {
                    Peca peca = it.next();
                    monitorPeça(peca);
                }
                
            }
        }catch (Exception e){
            new Sound(Constantes.ERRO_SOM).play();
              System.out.println("JOGADA ILEGAL");
        }
          if ( keyboard.keyDown(Keyboard.ESCAPE_KEY) == true){
             int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
             if (op == JOptionPane.OK_OPTION)
                 executando = false;
          }
    }
    
    public void desenhar(){
        tabuleiro.fundo.draw();
        Peca peca;
        for (int j = 0; j <= 7; j++) {
            for(int i = 0; i<=7; i++){
                peca = tabuleiro.retornaPeca(j, i);
                if(peca!=null)
                   peca.sprite.draw();
            }
            
        }
    }

    
    
    private void loop(){
        while(executando)
        {
             desenhar();
             janela.display();
             atualiazações();
        }
    }

    private void encerrarJogo(){
      janela.exit();
    }
}
   
