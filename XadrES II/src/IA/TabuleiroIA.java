/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;
import Interface.Casa;
import Interface.Peca;
import Interface.Tabuleiro;
import MaquinaRegras.Movimentacao;
import MaquinaRegras.Posicao;



/**
 *
 * @author leandrogaluzzi
 */
public class TabuleiroIA {
    private Casa[][] tabuleiro;
    public Peca ultimaPeca;
    
    public Movimentacao mov = new Movimentacao();
    
    
    public TabuleiroIA(int dim_X, int dim_Y){
        this.tabuleiro = new Casa[dim_X][dim_Y];
        this.inicializarTabuleiro();
    
       
    }
    
    public void setPeça(int x,int y,Peca p){
        //System.out.println("Set Peca x = "+x+", y ="+y);
        this.tabuleiro[x][y].peca=p;
        this.tabuleiro[x][y].ocupada=true;
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
    
    
     public void ocuparIA(Posicao posFin, Peca peca ){
        
            int dim_Y = posFin.getPosX();
            int dim_X = posFin.getPosY();
            
        
            this.comerPeca(dim_Y, dim_X, peca);
            this.desocupar(peca.getPosX(), peca.getPosY());
            this.tabuleiro[dim_Y][dim_X].ocupada=true;
            this.tabuleiro[dim_Y][dim_X].peca=peca;
            this.tabuleiro[dim_Y][dim_X].peca.setPosX(dim_Y);
            this.tabuleiro[dim_Y][dim_X].peca.setPosY(dim_X);
           // this.ultimaPeça=peca;
            this.tabuleiro[dim_Y][dim_X].peca.foiMexida=true;
            
        
        
        
    }
    
    
     public void comerPeca(int x, int y, Peca p){
        if(this.tabuleiro[y][x].peca!=null &&
             !this.tabuleiro[y][x].peca.retornaCor().equals(p.retornaCor())){
                 this.desocupar(x,y);                 
        }
    } 
     
    
     public void desocupar(int dim_X,int dim_Y){
        this.tabuleiro[dim_X][dim_Y].peca=null;
        this.tabuleiro[dim_X][dim_Y].ocupada=false;
    }
     
    
      public void copiarPecasIA(TabuleiroIA tab){
       
       
          for (int i = 0; i <=7; i++) {
              for (int j = 0; j <=7; j++) {
                  
                  if (tab.estaOcupado(i, j)) {  
                        Peca p = tab.retornaPeca(i,j);
                        this.setPeça(i, j, p);
                      
                  }
              
              }
          }
          
    } 
      
    public void copiarPecas(Tabuleiro tab){
       
       
          for (int i = 0; i <=7; i++) {
              for (int j = 0; j<=7; j++) {
                  
                  if (tab.estaOcupado(i, j)) {                
                        Peca p = tab.retornaPeca(i,j);
                        this.setPeça(j, i, p);
                       
                  }
              
              }
          }  
    }    
     
     public Boolean estaOcupado(int dim_X,int dim_Y){
        return tabuleiro[dim_Y][dim_X].ocupada;
    }
     
     public Peca retornaPeca(int posX, int posY){
        //System.out.println("Retorna Peca = x "+posX+", y ="+posY);
        return this.tabuleiro[posY][posX].peca;
        
    }
    
    public Casa[][] retornaCasa(int posX, int posY){
        Casa[][] aux;
        aux = tabuleiro;
        return this.tabuleiro;
    } 
     
     
}
