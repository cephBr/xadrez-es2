/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import JPlay.GameImage;

import MaquinaRegras.Movimentacao;
import MaquinaRegras.Posicao;
import Parametros.Constantes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Ceph
 */
public class Tabuleiro {
    public Casa[][] tabuleiro;
    public GameImage fundo;
    public Peca ultimaPeça;
    
    public Movimentacao mov = new Movimentacao();
    
    public Peca retornaUltimaPeça(){
        return ultimaPeça;
    }

       public Tabuleiro(int dim_X,int dim_Y,String caminhoFundo) {
        this.tabuleiro = new Casa[dim_X][dim_Y];
        this.fundo = new GameImage(caminhoFundo);
        this.inicializarTabuleiro();
        this.montarCasas();
    }

    public void setPeça(int x,int y,Peca p){
        this.tabuleiro[y][x].peca=p;
        this.tabuleiro[y][x].ocupada=true;
    }




    public Boolean estaOcupado(int dim_X,int dim_Y){
        return tabuleiro[dim_Y][dim_X].ocupada;
    }

    public void ocupar(int dim_X,int dim_Y,Peca peca) throws Exception{
        
        if(dim_X==-1 || dim_Y==-1){
            peca.deselecionar();
            peca.sprite.reset();
            throw new Exception("Tentativa de mover a peça para fora do tabuleiro");
        }
        
        List<Posicao> resposta;
        int posInicial_X = peca.getPosX();
        int posInicial_Y = peca.getPosY();
        
        resposta = mov.posicoesValidas(tabuleiro, peca);
        Posicao pos = new Posicao(dim_Y,dim_X);
        /*
        if (Motor.getInstancia().parametros.temCpu() && Motor.getInstancia().parametros.vezDeQuem().equals(Constantes.PRETO)) {
             pos = new Posicao(dim_X,dim_Y);    
        }else{
             pos = new Posicao(dim_Y,dim_X);
        }
             */
        if(mov.contemNaLista(pos, resposta)){
            this.comerPeca(dim_Y, dim_X, peca);
            this.desocupar(peca.getPosX(), peca.getPosY());
            this.tabuleiro[dim_Y][dim_X].ocupada=true;
            this.tabuleiro[dim_Y][dim_X].peca=peca;
            this.tabuleiro[dim_Y][dim_X].peca.sprite.setPosition(tabuleiro[dim_Y][dim_X].posX-tabuleiro[dim_Y][dim_X].peca.comp_X, tabuleiro[dim_Y][dim_X].posY-tabuleiro[dim_Y][dim_X].peca.comp_Y);
            this.tabuleiro[dim_Y][dim_X].peca.setPosX(dim_Y);
            this.tabuleiro[dim_Y][dim_X].peca.setPosY(dim_X);
            this.ultimaPeça=peca;
            this.tabuleiro[dim_Y][dim_X].peca.foiMexida=true;
            
            // MOVER A TORRE PARA REALIZAR O ROQUE //
            if ((peca.id%6) == 5) {
                // pequeno roque //
                if (dim_X == (posInicial_Y+2)) {
                    peca=this.tabuleiro[dim_Y][7].peca;
                    this.desocupar(peca.getPosX(), peca.getPosY());
                    this.tabuleiro[dim_Y][5].ocupada=true;
                    this.tabuleiro[dim_Y][5].peca=peca;
                    this.tabuleiro[dim_Y][5].peca.sprite.setPosition(tabuleiro[dim_Y][5].posX-tabuleiro[dim_Y][5].peca.comp_X, tabuleiro[dim_Y][5].posY-tabuleiro[dim_Y][5].peca.comp_Y);
                    this.tabuleiro[dim_Y][5].peca.setPosX(dim_Y);
                    this.tabuleiro[dim_Y][5].peca.setPosY(5);
                    this.ultimaPeça=peca;
                    this.tabuleiro[dim_Y][5].peca.foiMexida=true;
                }
                // grande roque //
                if (dim_X == (posInicial_Y-2)) {
                    peca=this.tabuleiro[dim_Y][0].peca;
                    this.desocupar(peca.getPosX(), peca.getPosY());
                    this.tabuleiro[dim_Y][3].ocupada=true;
                    this.tabuleiro[dim_Y][3].peca=peca;
                    this.tabuleiro[dim_Y][3].peca.sprite.setPosition(tabuleiro[dim_Y][3].posX-tabuleiro[dim_Y][3].peca.comp_X, tabuleiro[dim_Y][3].posY-tabuleiro[dim_Y][3].peca.comp_Y);
                    this.tabuleiro[dim_Y][3].peca.setPosX(dim_Y);
                    this.tabuleiro[dim_Y][3].peca.setPosY(3);
                    this.ultimaPeça=peca;
                    this.tabuleiro[dim_Y][3].peca.foiMexida=true;
                }
            }
            Motor.getInstancia().parametros.passaVez();
            
        }else
            throw new Exception("Posição inválida");
    }
    
    public void reposicionarTabuleiro(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.tabuleiro[j][i].peca!=null) {
                   this.tabuleiro[j][i].peca.sprite.setPosition(tabuleiro[j][i].posX-tabuleiro[j][i].peca.comp_X, tabuleiro[j][i].posY-tabuleiro[j][i].peca.comp_Y);    
                }
                
            }
        }
    }
    
  
    
    public void desocupar(int dim_X,int dim_Y){
        this.tabuleiro[dim_X][dim_Y].peca=null;
        this.tabuleiro[dim_X][dim_Y].ocupada=false;
    }
    
    public void comerPeca(int x, int y, Peca p){
        if(this.tabuleiro[y][x].peca!=null &&
             !this.tabuleiro[y][x].peca.retornaCor().equals(p.retornaCor())){
                 this.desocupar(x,y);                 
        }
    }
    
    
    
    

    public void montarCasas(){
       try {
        BufferedReader entrada = new BufferedReader(new FileReader("src/configurações.txt"));
        StringTokenizer st;
        while (entrada.ready()) {
           for (int j = 0; j <= 7; j++) {
              for (int i = 0; i <= 7; i++) {
                  st = new StringTokenizer(entrada.readLine(),",");
                  this.tabuleiro[j][i].x0=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].x1=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].y0=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].y1=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].posX=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].posY=Integer.parseInt(st.nextToken());
                  this.tabuleiro[j][i].prioridadeDesenho=j;
              }
            }
            
         }
         entrada.close();
    } catch (IOException e) {
    }

    }

    
    public void inicializarTabuleiro(){
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                 Casa casa = new Casa();
                 casa.ocupada=false;
                 casa.peca=null;
                 this.tabuleiro[j][i]=casa;
            }
        }
    }


    public Boolean clicouNaCasa(int x, int y, int posMouseX, int posMouseY){
       if ((posMouseX<=this.tabuleiro[y][x].x1 && posMouseX>=this.tabuleiro[y][x].x0)
          && (posMouseY<=this.tabuleiro[y][x].y1 && posMouseY>=this.tabuleiro[y][x].y0)  ){
                return true;
       }else return false;

    }

    public Peca retornaPeca(int posX, int posY){
       
        return this.tabuleiro[posY][posX].peca;
    }
    
    public Casa[][] retornaCasa(int posX, int posY){
        Casa[][] aux;
        aux = tabuleiro;
        return this.tabuleiro;
    }

    private  List encontrarCoordenada(int posX, int posY){
        List<Integer> resp = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        Boolean encontrou = false;
        while(!encontrou && j<=7){
            while(!encontrou && i <= 7){
                if ( (posX>=this.tabuleiro[j][i].x0) && (posX<=this.tabuleiro[j][i].x1)){
                   if((posY>=this.tabuleiro[j][i].y0) && (posY<=this.tabuleiro[j][i].y1)) {
                        encontrou = true;
                        resp.add(i);
                        resp.add(j);
                   }
                }
                i++;
            }
            i=0;
            j++;
        }

        return resp;
    }

    public int coordenadaY(int posX, int posY){
       List<Integer> coordenadas = new ArrayList<Integer>();
       int resp = 0;
       coordenadas = encontrarCoordenada(posX, posY);
       if(!coordenadas.isEmpty())
           resp = coordenadas.get(1);
       else
           resp = -1;
       return resp;

    }

    public int coordenadaX(int posX, int posY){
       List<Integer> coordenadas = new ArrayList<Integer>();
       int resp = 0;
       coordenadas = encontrarCoordenada(posX, posY);
       if(!coordenadas.isEmpty())
           resp = coordenadas.get(0);
       else
           resp = -1;
       return resp;

    }



}
