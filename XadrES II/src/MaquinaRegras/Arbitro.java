/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaRegras;

import Interface.Casa;
import Interface.Peca;
import Interface.Rei;
import Interface.Tabuleiro;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Thiago
 */
public class Arbitro {
    
    Movimentacao mov = new Movimentacao();
        
    void imprimePosicoes (List<Posicao> posicoes){
        
        System.out.println("POSICOES:\n");
        for (int i = 0; i < posicoes.size(); i++) {
            System.out.print("POSICAO X: ");
            System.out.println(posicoes.get(i).posX);
            System.out.print("POSICAO Y: ");
            System.out.println(posicoes.get(i).posY);
            
        }
    }
    
    public List<Peca> getPecas(String corJogador, Casa[][] Tab){
        
        List<Peca> pecas = new ArrayList<Peca>();
        
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <=7; j++) {
                if (Tab[i][j].ocupada) {
                    if (Tab[i][j].peca.cor.equalsIgnoreCase(corJogador)) {
                          boolean add = pecas.add(Tab[i][j].peca);
                    }
                }
            }
        }
        
        return pecas;        
    }
    
    public Posicao getPosicaoRei (String corJogador, Casa[][] Tab){
        Posicao posRei = new Posicao(-1,-1);
        
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <=7; j++) {
                if (Tab[i][j].ocupada) {
                    if (Tab[i][j].peca instanceof Rei) {
                        if (Tab[i][j].peca.cor.equalsIgnoreCase(corJogador)) {
                            posRei  = new Posicao(i,j);
                        }
                    }
                }
            }
        }
        
        return posRei;
    
    }
    
    public boolean estaEmXeque(String corJogador, Casa[][] Tab) {
        
            Posicao posicaoRei;
            String corAdversario;
            
            if (corJogador.equalsIgnoreCase("branco"))
                corAdversario = "preto";
            else
                corAdversario = "branco";
            
            posicaoRei  = getPosicaoRei(corJogador,Tab);
            
            List<Peca> pecasAdver = getPecas(corAdversario,Tab);
            for (int i=0; i < pecasAdver.size(); i++) {
                List<Posicao> posicoesValidas = mov.posicoesValidas(Tab, pecasAdver.get(i));
                if (mov.contemNaLista(posicaoRei, posicoesValidas)) {
                    return true;
                }
            }
            return false;
        
    }
    
    public Casa[][] montaTabVirtual (Posicao posicaoRei, Posicao possivelPosRei, Casa[][] Tab, Peca rei){
        
        //this.comerPeca(dim_Y, dim_X, peca);
            if(Tab[possivelPosRei.posX][possivelPosRei.posY].peca!=null &&
             !Tab[possivelPosRei.posX][possivelPosRei.posY].peca.retornaCor().equals(Tab[posicaoRei.posX][posicaoRei.posY].peca.retornaCor())){
                Tab[possivelPosRei.posX][possivelPosRei.posY].peca=null;
                Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada=false;
            }
            //this.desocupar(peca.getPosX(), peca.getPosY());
            Tab[posicaoRei.posX][posicaoRei.posY].peca=null;
            Tab[posicaoRei.posX][posicaoRei.posY].ocupada=false;
            
            Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada=true;
            Tab[possivelPosRei.posX][possivelPosRei.posY].peca = rei;
            //this.tabuleiro[dim_Y][dim_X].peca.sprite.setPosition(tabuleiro[dim_Y][dim_X].posX-tabuleiro[dim_Y][dim_X].peca.comp_X, tabuleiro[dim_Y][dim_X].posY-tabuleiro[dim_Y][dim_X].peca.comp_Y);
            Tab[possivelPosRei.posX][possivelPosRei.posY].peca.setPosX(possivelPosRei.posX);
            Tab[possivelPosRei.posX][possivelPosRei.posY].peca.setPosY(possivelPosRei.posY);
            //this.ultimaPeça=peca;
            //this.tabuleiro[dim_Y][dim_X].peca.foiMexida=true;

            // FIM MONTA TABULEIRO VIRTUAL //
        
        return Tab;
    }
    
    public Casa[][] retornaTabOriginal (Posicao posicaoRei, Posicao possivelPosRei, Casa[][] Tab, Peca rei, Peca pecaVelha){
        
            Tab[posicaoRei.posX][posicaoRei.posY].ocupada = true;
            Tab[posicaoRei.posX][posicaoRei.posY].peca = rei;
            //this.tabuleiro[dim_Y][dim_X].peca.sprite.setPosition(tabuleiro[dim_Y][dim_X].posX-tabuleiro[dim_Y][dim_X].peca.comp_X, tabuleiro[dim_Y][dim_X].posY-tabuleiro[dim_Y][dim_X].peca.comp_Y);
            Tab[posicaoRei.posX][posicaoRei.posY].peca.setPosX(posicaoRei.posX);
            Tab[posicaoRei.posX][posicaoRei.posY].peca.setPosY(posicaoRei.posY);
           
            
            if (pecaVelha != null) {
                Tab[pecaVelha.getPosX()][pecaVelha.getPosY()].ocupada = true;
                Tab[pecaVelha.getPosX()][pecaVelha.getPosY()].peca = pecaVelha;
                //tabVirtual.tabuleiro[pecaVelha.getPosX()][pecaVelha.getPosY()].peca.sprite.setPosition(tabuleiro[dim_Y][dim_X].posX-tabuleiro[dim_Y][dim_X].peca.comp_X, tabuleiro[dim_Y][dim_X].posY-tabuleiro[dim_Y][dim_X].peca.comp_Y);
                //tabVirtual.tabuleiro[dim_Y][dim_X].peca.setPosX(dim_Y);
                //tabVirtual.tabuleiro[dim_Y][dim_X].peca.setPosY(dim_X);
            } else {
                Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada = false;
                Tab[possivelPosRei.posX][possivelPosRei.posY].peca = null;
            }
  
        
        return Tab;
    }
    
    public boolean reiPodeFugir(String corJogador, Casa[][] Tab) throws Exception{
        
        String corAdversario;
            
        if (corJogador.equalsIgnoreCase("branco"))
            corAdversario = "preto";
        else
            corAdversario = "branco";
        
        //Armazena a posição do rei em xeque
        Posicao posicaoRei  = getPosicaoRei(corJogador,Tab);
        
        
        //iterador com as posições destino possíveis do rei
        List<Posicao> posicoesPossiveisRei = mov.posicoesValidasRei(Tab, Tab[posicaoRei.posX][posicaoRei.posY].peca);
        
        
        //Rei pode fugir?
        int i = 0;
        boolean reiEmPerigo = true;
        while ((i < posicoesPossiveisRei.size()) && reiEmPerigo) {
            Posicao possivelPosRei = posicoesPossiveisRei.get(i);
            //Armazena o rei e a peça que está na posição que ele vai testar para retornar depois
            Peca pecaVelha = Tab[possivelPosRei.posX][possivelPosRei.posY].peca;
            Peca rei = Tab[posicaoRei.posX][posicaoRei.posY].peca;

            
            // Monta um tabuleiro "virtual" para avaliacao de novas posicoes
            Casa[][] tabVirtual = montaTabVirtual (posicaoRei, possivelPosRei, Tab, rei);

            List<Peca> pecasAdver = getPecas(corAdversario,tabVirtual);
            
            int j = 0;
            boolean posicaoEmAtaque = false;
            while ((j < pecasAdver.size()) && !posicaoEmAtaque) {
                List<Posicao> posicoesValidas = mov.posicoesValidas(tabVirtual, pecasAdver.get(j));
                if (mov.contemNaLista(possivelPosRei, posicoesValidas)) {
                    posicaoEmAtaque = true;
                }
                    
                j++;
            }
            
            // Retornando o tabuleiro para a situacao original
            Tab = retornaTabOriginal (posicaoRei, possivelPosRei, Tab, rei, pecaVelha);
            
            if (!posicaoEmAtaque) {
                reiEmPerigo = false;
            }
            i++;
        }
        return !reiEmPerigo;
    }
    
    public boolean xequeMate(String corJogador, Casa[][] Tab) throws Exception {

        //Se o jogador não estiver em xeque, então não está em xeque-mate
        if (!estaEmXeque(corJogador,Tab)) {
            return false;
        }

        //Verifica se o rei pode fugir
        if (reiPodeFugir(corJogador, Tab)) {
            return false;
        }
        
        return true;
    }

    
}
