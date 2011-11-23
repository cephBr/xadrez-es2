/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sound;
import JPlay.Sprite;
import JPlay.Window;
import Parametros.Constantes;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import IA.MiniMax;
import IA.Movimento;
import MaquinaRegras.Movimentacao;
import javax.swing.JFileChooser;

/**
 *
 * @author Ceph
 */
public class TelaJogo implements InterfaceTela{
        Tabuleiro tabuleiro;
        List<Peca> pecas;
        Font fonte;    
        Window janela;
        Keyboard keyboard;
        Mouse mouse;
        Boolean executando;
        Boolean temPecaSelecionada;
        Sprite botaoNovoJogo;
        Sprite botaoCarregarJogo;
        Sprite botaoAjuda;
        Sprite botaoSalvarJogo;
        Sprite botaoEstatisticas;
        Sprite barraPreta;
        Boolean clicouAjuda;
        Boolean clicouEstatistica;
        Boolean clicouNovoJogo;
        Boolean clicouCarregar;
        Boolean clicouSalvar;
        int[] ids;
        MiniMax ia;
    
   

    private void monitorPeca(Peca p,int i) throws Exception{
                Movimentacao mov = new Movimentacao();
                
                if(p.estaSelecionada()){
                    if (!mouse.isOverObject(p.sprite)) {
                        tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y),tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), p);
                        temPecaSelecionada=false;
                        p.deselecionar();
                        throw new Exception("");
                    }
                    
                }     
               
                if((p.posX==0||p.posX==7) && mov.retornaTipoPeca(p.id)==0){
                      if(!Motor.getInstancia().isPromocaoAtiva()){
                                  
                                  Peca peca=p;
                                  p.id=1;
                                  Motor.getInstancia().setPromocaoAtiva(Boolean.TRUE);
                                  new Thread(new TelaPromocao()).start();
                                  Motor.getInstancia().pausar();
                                  String promocao = Motor.getInstancia().getPromovidoPara();
                                  int linha=p.posX;
                                  int coluna=p.posY;
                                  tabuleiro.desocupar(coluna,linha);
                                  p.deselecionar();
                                  peca = promoverPeao(peca, promocao);
                                  pecas.add(i, peca);
                                  tabuleiro.setPeça(linha, coluna, peca);
                                  tabuleiro.posicionarPeca(linha, coluna, peca);
                                  temPecaSelecionada=false;
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
        barraPreta.draw();
        botaoNovoJogo.draw();
        botaoSalvarJogo.draw();
        botaoCarregarJogo.draw();
        botaoEstatisticas.draw();
        botaoAjuda.draw();
      
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
            janela.drawText("CPU", 500, 50, Color.RED, fonte);
        else
            janela.drawText(Motor.getInstancia().parametros.getNomeJogador2(), 500, 50, Color.RED, fonte);
            
    }

    
    
   

    public void carregar() {
        
        ia = new MiniMax();
         ids = new int[4];
         temPecaSelecionada = false;
         janela = Motor.getInstancia().getJanela();
         fonte = new Font("ARIAL", Font.TRUETYPE_FONT, 30);
         keyboard = Motor.getInstancia().getJanela().getKeyboard();
         keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard. DETECT_INITIAL_PRESS_ONLY);
         mouse = Motor.getInstancia().getJanela().getMouse();
         tabuleiro = new Tabuleiro(8,8,Constantes.TABULEIRO);
         barraPreta = new Sprite(Constantes.BARRA_PRETA);
         barraPreta.setPosition(0, 0);
         botaoAjuda=new Sprite(Constantes.BOTAO_AJUDA_MINI, 2); 
         botaoNovoJogo = new Sprite(Constantes.BOTAO_NOVO_JOGO_MINI, 2);
         botaoCarregarJogo = new Sprite(Constantes.BOTAO_CARREGAR_JOGO_MINI, 2);
         botaoSalvarJogo = new Sprite(Constantes.BOTAO_SALVAR_JOGO_MINI,2);
         botaoEstatisticas = new Sprite(Constantes.BOTAO_ESTTISTICAS_MINI,2);
         
         
         botaoNovoJogo.setInitialFrame(0);
         botaoNovoJogo.setFinalFrame(1);
         botaoNovoJogo.setPosition(1, 0);
         
         botaoSalvarJogo.setInitialFrame(0);
         botaoSalvarJogo.setFinalFrame(1);
         botaoSalvarJogo.setPosition(90, 0);
         
         
         botaoCarregarJogo.setInitialFrame(0);
         botaoCarregarJogo.setFinalFrame(1);
         botaoCarregarJogo.setPosition(195, 0);
         
         
         botaoEstatisticas.setInitialFrame(0);
         botaoEstatisticas.setFinalFrame(1);
         botaoEstatisticas.setPosition(310, 0);
         
         
         botaoAjuda.setInitialFrame(0);
         botaoAjuda.setFinalFrame(1);
         botaoAjuda.setPosition(395, 0);
         
         
         
         
         clicouAjuda=false;
         clicouEstatistica=false;
         clicouNovoJogo =false;
         clicouCarregar=false;
         clicouSalvar=false;
         if(!Motor.getInstancia().getIsJogoCarregado()){
            pecas = new ArrayList<Peca>();
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
         }else{
            Motor.getInstancia().parametros.defineTurno(Motor.getInstancia().buffer.getVezDeQuem()); 
            this.pecas=Motor.getInstancia().buffer.getPecas();
            this.tabuleiro=Motor.getInstancia().buffer.getTabuleiro();
            this.tabuleiro.montarCasas();
            this.tabuleiro.reposicionarTabuleiro(); 
         }
         ids[0]=19; //torre
         ids[1]=21; //cavalo
         ids[2]=10; //dama
         ids[3]=20; //bispo
         executando = true;
    }

    public void descarregar() {
          this.tabuleiro.fundo=null;        
          this.pecas=null;
          this.barraPreta=null;
          this.botaoAjuda=null;
          this.botaoCarregarJogo=null;
          this.botaoEstatisticas=null;
          this.botaoNovoJogo=null;
          this.botaoSalvarJogo=null;
          
                 
    }

    public void logica() {
        if (mouse.isOverObject(botaoAjuda)) {
                    botaoAjuda.setCurrFrame(1);
                }else 
                    botaoAjuda.setCurrFrame(0);
                if (mouse.isOverObject(botaoNovoJogo)) {
                    botaoNovoJogo.setCurrFrame(1);
                }else
                    botaoNovoJogo.setCurrFrame(0);
                if (mouse.isOverObject(botaoCarregarJogo)) {
                    botaoCarregarJogo.setCurrFrame(1);
                }else
                    botaoCarregarJogo.setCurrFrame(0);
                if (mouse.isOverObject(botaoSalvarJogo)) {
                    botaoSalvarJogo.setCurrFrame(1);
                }else
                    botaoSalvarJogo.setCurrFrame(0);
                if (mouse.isOverObject(botaoEstatisticas)) {
                    botaoEstatisticas.setCurrFrame(1);
                }else
                    botaoEstatisticas.setCurrFrame(0);
                
        try {
            
            
            if (Motor.getInstancia().parametros.temCpu()) { 
                if (Motor.getInstancia().parametros.vezDeQuem().equals(Constantes.PRETO)) {
                    Movimento movimento = ia.RandomIA(tabuleiro);             
                    tabuleiro.ocupar2(movimento.getPosFin().getPosX(), movimento.getPosFin().getPosY(), movimento.getPeca());
                }
            }
            
            if (mouse.isLeftButtonPressed()==true) {
                
                if(mouse.isOverObject(botaoSalvarJogo)){
                   String[] nomeJogadores = {Motor.getInstancia().parametros.getNomeJogador1(),Motor.getInstancia().parametros.getNomeJogador2()};
                   Motor.getInstancia().contexto.salvarJogo(this.tabuleiro, nomeJogadores,this.pecas, Motor.getInstancia().parametros.temCpu());
                   clicouSalvar=true;
                }
                if(mouse.isOverObject(botaoCarregarJogo)){
                  clicouCarregar=true;
                }
                if(mouse.isOverObject(botaoAjuda)){
                    clicouAjuda=true;
                }
                if(mouse.isOverObject(botaoNovoJogo)){
                    clicouNovoJogo=true;
                }
                if(mouse.isOverObject(botaoEstatisticas)){
                    clicouEstatistica=true;
                }    
                for (int i=0; i<=pecas.size();i++) {
                    Peca peca = pecas.get(i);
                    monitorPeca(peca,i);
                }
    
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
          
    }
    
    
    
    private Peca promoverPeao(Peca peao,String promocao){
        Peca peaoPromovido=null;
        String cor = peao.retornaCor();
        int linha = peao.getPosX();
        int coluna = peao.getPosY();
        int posX = tabuleiro.tabuleiro[coluna][linha].posX-peao.comp_X;
        int posY = tabuleiro.tabuleiro[coluna][linha].posY-peao.comp_Y;
        if(promocao.equals("Dama")){
            if(cor.equals(Constantes.BRANCO)){
                  peaoPromovido = new Dama(linha, coluna, 0, 0, ids[2]+6, cor, Constantes.DAMA_BRANCO);
            }else
                  peaoPromovido = new Dama(linha, coluna, 0, 0, ids[2]+6, cor, Constantes.DAMA_PRETO);
            ids[2]+=6;
        }
        if(promocao.equals("Cavalo")){
            if(cor.equals(Constantes.BRANCO)){
                  peaoPromovido = new Cavalo(linha, coluna, 0, 0, ids[1]+6, cor, Constantes.CAVALO_BRANCO);
            }else
                  peaoPromovido = new Cavalo(linha, coluna, 0, 0, ids[1]+6, cor, Constantes.CAVALO_PRETO);
            ids[1]+=6;
        }
        if(promocao.equals("Bispo")){
            if(cor.equals(Constantes.BRANCO)){
                  peaoPromovido = new Bispo(linha, coluna, 0, 0, ids[3]+6, cor, Constantes.BISPO_BRANCO);
            }else
                  peaoPromovido = new Bispo(linha, coluna, 0, 0, ids[3]+6, cor, Constantes.BISPO_PRETO);
            ids[3]+=6;
        }
        if(promocao.equals("Torre")){
            if(cor.equals(Constantes.BRANCO)){
                  peaoPromovido = new Torre(linha, coluna, 0, 0, ids[0]+6, cor, Constantes.TORRE_BRANCO);
            }else
                  peaoPromovido = new Torre(linha, coluna, 0, 0, ids[0]+6, cor, Constantes.TORRE_PRETO);
            ids[0]+=6;
        }
        return peaoPromovido;
    }
    public void proxTela() {
      
        if (clicouNovoJogo) {
            clicouNovoJogo=false;
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja iniciar um novo jogo?","Aviso",JOptionPane.OK_CANCEL_OPTION);
            if(op == JOptionPane.OK_OPTION){
                Motor.getInstancia().setIsJogoCarregado(false);
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGAR);
            }
            
        }
        if(clicouSalvar){
            clicouSalvar=false;    
        }
        if(clicouCarregar){
          clicouCarregar=false;
          Motor.getInstancia().contexto.carregarJogo();
          if(Motor.getInstancia().contexto.getResposta()==JFileChooser.APPROVE_OPTION){
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGO);
          }
          
        }
        if(clicouEstatistica){
           clicouEstatistica=false; 
           Motor.getInstancia().setProxTela(Constantes.TELA_HISTORICO);
        }
        if(clicouAjuda){
              clicouAjuda=false;
              Motor.getInstancia().setProxTela(Constantes.TELA_AJUDA);
        }                
                            
      }   
     
}
   
