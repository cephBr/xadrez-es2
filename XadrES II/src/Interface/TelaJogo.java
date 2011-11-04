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
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ceph
 */
public class TelaJogo implements InterfaceTela{
        Tabuleiro tabuleiro;
        List<Peca> pecas = new ArrayList<Peca>();
        Font fonte;    
        Window janela;
        Keyboard keyboard;
        Mouse mouse;
        boolean executando;
        boolean temPecaSelecionada;

    
    
   

    private void monitorPeca(Peca p) throws Exception{
     
                
                if(p.estaSelecionada()){
                    if (!mouse.isOverObject(p.sprite)) {
                        tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y),tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), p);
                        temPecaSelecionada=false;
                        p.deselecionar();
                        throw new Exception("");
                    }
                }

               if(mouse.isOverObject(p.sprite)){
                   if(!p.estaSelecionada()&&!temPecaSelecionada) {
                      if(p.retornaCor().equals(Motor.getInstancia().parametros.vezDeQuem())){    
                           if(Motor.instancia.parametros.temCpu()){
                                if (!p.retornaCor().equals(Constantes.PRETO)){
                                    p.selecionar();
                                    temPecaSelecionada=true;
                                    throw new Exception("");
                                }
                            }else{
                                    p.selecionar();
                                    temPecaSelecionada=true;
                                    throw new Exception("");
                                 }
                      }     
                    }else{
                           temPecaSelecionada=false;
                           p.deselecionar();
                         }
               }
    }
     
       

    
    
    public void desenhar(){
        tabuleiro.fundo.draw();
        Peca peca;
        for (int j = 0; j <= 7; j++) {
            for(int i = 0; i<=7; i++){
                peca = tabuleiro.retornaPeca(j,i);
                if(peca!=null)
                   if(peca.estaAtiva())
                     peca.sprite.draw();
                   else{
                     pecas.remove(peca);
                     tabuleiro.desocupar(j,i);
                   }  
            }
        }
        String nome = Motor.getInstancia().parametros.getNomeJogador1();
        janela.drawText(nome, 25, 540, Color.CYAN, fonte);
        if(Motor.getInstancia().parametros.temCpu())
            janela.drawText("CPU", 500, 50, Color.yellow, fonte);
        else
            janela.drawText(Motor.getInstancia().parametros.getNomeJogador2(), 500, 50, Color.yellow, fonte);
            
    }

    
    
   

    public void carregar() {
        
         temPecaSelecionada = false;
         janela = Motor.getInstancia().getJanela();
         fonte = new Font("ARIAL", Font.TRUETYPE_FONT, 30);
         keyboard = Motor.getInstancia().getJanela().getKeyboard();
         keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard. DETECT_INITIAL_PRESS_ONLY);
         mouse = Motor.getInstancia().getJanela().getMouse();
         tabuleiro = new Tabuleiro(8,8,Constantes.TABULEIRO);
         
         pecas.add(new Torre(0,0,119,113,1,Constantes.PRETO,Constantes.TORRE_PRETO));
         tabuleiro.setPeça(0,0,pecas.get(0));
         pecas.add(new Cavalo(1,0,173,113,3,Constantes.PRETO,Constantes.CAVALO_PRETO));
         tabuleiro.setPeça(1,0,pecas.get(1));
         pecas.add(new Bispo(2,0,229,113,2,Constantes.PRETO,Constantes.BISPO_PRETO));
         tabuleiro.setPeça(2,0,pecas.get(2));
         pecas.add(new Dama(3,0,285,113,4,Constantes.PRETO,Constantes.DAMA_PRETO));
         tabuleiro.setPeça(3,0,pecas.get(3));
         pecas.add(new Rei(4,0,339,113,5,Constantes.PRETO,Constantes.REI_PRETO));
         tabuleiro.setPeça(4,0,pecas.get(4));
         pecas.add(new Bispo(5,0,395,113,8,Constantes.PRETO,Constantes.BISPO_PRETO));
         tabuleiro.setPeça(5,0,pecas.get(5));
         pecas.add(new Cavalo(6,0,450,113,9,Constantes.PRETO,Constantes.CAVALO_PRETO));
         tabuleiro.setPeça(6,0,pecas.get(6));
         pecas.add(new Torre(7,0,506,113,7,Constantes.PRETO,Constantes.TORRE_PRETO));
         tabuleiro.setPeça(7,0,pecas.get(7));
         pecas.add(new Peao(0,1,115,158,0,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(0,1,pecas.get(8));
         pecas.add(new Peao(1,1,171,158,6,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(1,1,pecas.get(9));
         pecas.add(new Peao(2,1,228,158,12,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(2,1,pecas.get(10));
         pecas.add(new Peao(3,1,284,158,18,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(3,1,pecas.get(11));
         pecas.add(new Peao(4,1,341,158,24,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(4,1,pecas.get(12));
         pecas.add(new Peao(5,1,396,158,30,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(5,1,pecas.get(13));
         pecas.add(new Peao(6,1,451,158,36,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(6,1,pecas.get(14));
         pecas.add(new Peao(7,1,508,158,42,Constantes.PRETO,Constantes.PEAO_PRETO));
         tabuleiro.setPeça(7,1,pecas.get(15));
         
         pecas.add(new Peao(0,6,99,412,48,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(0,6,pecas.get(16));
         pecas.add(new Peao(1,6,159,412,54,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(1,6,pecas.get(17));
         pecas.add(new Peao(2,6,220,412,60,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(2,6,pecas.get(18));
         pecas.add(new Peao(3,6,281,412,66,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(3,6,pecas.get(19));
         pecas.add(new Peao(4,6,341,412,72,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(4,6,pecas.get(20));
         pecas.add(new Peao(5,6,404,412,78,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(5,6,pecas.get(21));
         pecas.add(new Peao(6,6,464,412,84,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(6,6,pecas.get(22));
         pecas.add(new Peao(7,6,526,412,90,Constantes.BRANCO,Constantes.PEAO_BRANCO));
         tabuleiro.setPeça(7,6,pecas.get(23));
         pecas.add(new Torre(0,7,94,471,13,Constantes.BRANCO,Constantes.TORRE_BRANCO));
         tabuleiro.setPeça(0,7,pecas.get(24));
         pecas.add(new Cavalo(1,7,157,471,15,Constantes.BRANCO,Constantes.CAVALO_BRANCO));
         tabuleiro.setPeça(1,7,pecas.get(25));
         pecas.add(new Bispo(2,7,220,471,14,Constantes.BRANCO,Constantes.BISPO_BRANCO));
         tabuleiro.setPeça(2,7,pecas.get(26));
         pecas.add(new Dama(3,7,281,471,10,Constantes.BRANCO,Constantes.DAMA_BRANCO));
         tabuleiro.setPeça(3,7,pecas.get(27));
         pecas.add(new Rei(4,7,343,471,11,Constantes.BRANCO,Constantes.REI_BRANCO));
         tabuleiro.setPeça(4,7,pecas.get(28));
         pecas.add(new Bispo(5,7,405,471,20,Constantes.BRANCO,Constantes.BISPO_BRANCO));
         tabuleiro.setPeça(5,7,pecas.get(29));
         pecas.add(new Cavalo(6,7,467,471,21,Constantes.BRANCO,Constantes.CAVALO_BRANCO));
         tabuleiro.setPeça(6,7,pecas.get(30));
         pecas.add(new Torre(7,7,529,471,19,Constantes.BRANCO,Constantes.TORRE_BRANCO));
         tabuleiro.setPeça(7,7,pecas.get(31));
         
         Motor.getInstancia().parametros.defineTurno(Constantes.BRANCO);
         executando = true;
    }

    public void descarregar() {
          this.tabuleiro.fundo=null;        
          this.pecas=null;
    }

    public void logica() {
        try {
            if (mouse.isLeftButtonPressed()==true) {
                System.out.println(tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y)+" , "+tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y));
                for (Iterator<Peca> it = pecas.iterator(); it.hasNext();) {
                    Peca peca = it.next();
                    monitorPeca(peca);
                }
                
            }
        }catch (Exception e){
            if(!e.getMessage().equals(""))
                new Sound(Constantes.ERRO_SOM).play();
            System.out.println(e.getMessage());
        }
          
    }

    public void proxTela() {
        if (mouse.isRightButtonPressed() && mouse.isOverArea(0, 0, 0, 0)) {
            Motor.getInstancia().setProxTela(Constantes.TELA_INICIAL);
        }
    }
}
   