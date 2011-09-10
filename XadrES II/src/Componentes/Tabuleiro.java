/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import JPlay.GameImage;

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
    private Casa[][] tabuleiro;
    public GameImage fundo;
    public int ultimaPeça= 32;

    public int retornaIdUltimaPeça(){
        return ultimaPeça;
    }

   public class Casa{
        Peça peca;
        Boolean ocupada;
        int x0,x1,y0,y1;
        int posX,posY;
    };

    public int getPosX(int x, int y){
        return tabuleiro[x][y].posX;
    }
    public int getPosY(int x, int y){
        return tabuleiro[x][y].posX;
    }
    
     

    public Tabuleiro(int dim_X,int dim_Y,String caminhoFundo) {
        this.tabuleiro = new Casa[dim_X][dim_Y];
        this.fundo = new GameImage(caminhoFundo);
        this.inicializarTabuleiro();
        this.montarCasas();
    }

    public void setPeça(int x,int y,Peça p){
        this.tabuleiro[x][y].peca=p;
        this.tabuleiro[x][y].ocupada=true;
    }




    public Boolean estaOcupado(int dim_X,int dim_Y){
        return tabuleiro[dim_Y][dim_X].ocupada;
    }

    public void ocupar(int dim_X,int dim_Y,Peça peca) throws Exception{
        if(!estaOcupado(dim_X, dim_Y)){
            desocupar(peca.getPosX(), peca.getPosY());
            this.tabuleiro[dim_Y][dim_X].ocupada=true;
            this.tabuleiro[dim_Y][dim_X].peca=peca;
            this.tabuleiro[dim_Y][dim_X].peca.sprite.setPosition(tabuleiro[dim_Y][dim_X].posX-26, tabuleiro[dim_Y][dim_X].posY-72);
            this.tabuleiro[dim_Y][dim_X].peca.setPosX(dim_Y);
            this.tabuleiro[dim_Y][dim_X].peca.setPosY(dim_X);
            this.ultimaPeça=tabuleiro[dim_Y][dim_X].peca.getId();
        }else throw new Exception();
    }

    public void desocupar(int dim_X,int dim_Y){
        this.tabuleiro[dim_X][dim_Y].ocupada=false;
        this.tabuleiro[dim_X][dim_Y].peca=null;
    };

    private void montarCasas(){
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
              }
            }
         }
         entrada.close();
    } catch (IOException e) {
    }

    }

   
     
    
    private void inicializarTabuleiro(){
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                 Casa casa = new Casa();
                 casa.ocupada=false;
                 casa.peca=null;
                 this.tabuleiro[i][j]=casa;
            }
        }
    }


    public Boolean clicouNaCasa(int x, int y, int posMouseX, int posMouseY){
       if ((posMouseX<=this.tabuleiro[y][x].x1 && posMouseX>=this.tabuleiro[y][x].x0)
          && (posMouseY<=this.tabuleiro[y][x].y1 && posMouseY>=this.tabuleiro[y][x].y0)  ){
                return true;
       }else return false;

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
