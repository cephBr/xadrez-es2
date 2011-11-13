/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import Interface.Tabuleiro;
import Interface.Peca;
import Interface.Casa;
import MaquinaRegras.Movimentacao;
import MaquinaRegras.Posicao;
import Interface.TelaJogo;
import Parametros.Constantes;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author leandrogaluzzi
 */
public class FuncaoAvaliacaoIA {
    
    

    public int quantidadePecas(TabuleiroIA tab, String corLado){
        
        int quantPecas = 0;
             
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                
                if(null != tab && (tab.estaOcupado(i, j))){                    
                       Peca p = tab.retornaPeca(i, j);
                       if (p.cor.equals(corLado)){
                           quantPecas++;
                       }
                }                
            }           
        }
        return quantPecas;
    }
    
    
    
    
    public String retornaTipoDePeca(TabuleiroIA tab,int x,int y){
        
        int auxId;
        String tipoPeca = "";
        
        Peca p = tab.retornaPeca(x,y);
        
        auxId = p.getId()%6;
        
        switch (auxId) {
            case 0:
                tipoPeca = Constantes.PEAO; 
                break;
            case 1:
                tipoPeca = Constantes.TORRE;
                break;
            case 2:
                tipoPeca = Constantes.BISPO;
                break;
            case 3:
                tipoPeca = Constantes.CAVALO;
                break;
            case 4:
                tipoPeca = Constantes.DAMA; 
                break;
            case 5:
                tipoPeca = Constantes.REI; 
                break;
             default:
                 System.out.println("Este não é uma peça válida!");
         }             
        return tipoPeca;       
    }
    
    
    
    
    
    public int quantidadePecasEspecificas(TabuleiroIA tab, String cor ,String tipo){
        
        int quantPeca = 0;
        String tipoPeca;  
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                
                if(null != tab && (tab.estaOcupado(i, j))){
                    
                       Peca p = tab.retornaPeca(i, j);
                       if(p.retornaCor().equals(cor)){
                           tipoPeca = this.retornaTipoDePeca(tab, i, j);
                           if(tipoPeca.equals(tipo)){
                               quantPeca++;
                           }
                       } 
                }                
            }           
        }              
        return quantPeca;
    }
    
    
    
    public int estimativaPorForca(TabuleiroIA tab,String corLado){
        
        int forca = 0;
        int numPeao,numCavalo,numBispo,numTorre,numDama,numRei=0;
        
        numPeao = this.quantidadePecasEspecificas(tab, corLado, Constantes.PEAO);
        forca = forca + (numPeao * Constantes.FORCA_PEAO);
        
        numCavalo = this.quantidadePecasEspecificas(tab, corLado, Constantes.CAVALO);
        forca = forca + (numCavalo * Constantes.FORCA_CAVALO);
        
        numBispo = this.quantidadePecasEspecificas(tab, corLado, Constantes.BISPO);
        forca = forca + (numBispo * Constantes.FORCA_BISPO);
        
        numTorre = this.quantidadePecasEspecificas(tab, corLado, Constantes.TORRE);
        forca = forca + (numTorre * Constantes.FORCA_TORRE);
        
        numDama = this.quantidadePecasEspecificas(tab, corLado, Constantes.DAMA);
        forca = forca + (numDama * Constantes.FORCA_DAMA);
        
        numRei = this.quantidadePecasEspecificas(tab, corLado, Constantes.REI);
        forca = forca +(numDama * Constantes.FORCA_REI);
     
        return forca;
    }
    
    
    public int estimativaPorOpcoesDeMovimento(TabuleiroIA tab, String corLado){
         int forca = 0;
         List<Posicao> opcoesPosicao = new ArrayList<Posicao>();
         Peca p;
         Casa[][] casa;
         int auxID;
         
         for (int i = 0; i <=7; i++) {
             for (int j = 0; j <=7; j++) {
               if(tab.estaOcupado(i, j)){  
                 p = tab.retornaPeca(i,j);
                 auxID = p.getId()%6;
                 casa = tab.retornaCasa(i, j);
                 opcoesPosicao = tab.mov.posicoesValidas(casa, p);       
                 switch (auxID) {
                            case 0:
                                        forca = forca +opcoesPosicao.size()*10;
                                        break;
                            case 1:
                                        
                                        forca = forca + opcoesPosicao.size()*30; //Torre
                                        break;
                            case 2:
                                        forca = forca +opcoesPosicao.size()*20;                 //Bispo
                                        break;
                            case 3:
                                        forca = forca +opcoesPosicao.size()*50;           //Cavalo
                                        break;
                            case 4:
                                        forca = forca +opcoesPosicao.size()*30;       //Dama
                                        break;
                            case 5:
                                        forca = forca +opcoesPosicao.size()*-20;              //Rei
                                        break;
                default:
                            System.out.println("Este não é uma peça válida!");
                }
               }  
             }
            
        }
         
         
         
        
        
        return forca;
    }
    
    public int estimativaPorPosicao(TabuleiroIA tab,String corLado){
        int forca = 0;
         
         Peca p;
         Casa[][] casa;
         int auxID;
         
         for (int i =2; i <=5; i++) {
             for (int j =2; j <=5; j++) {
               if(tab.estaOcupado(i, j)){  
                 p = tab.retornaPeca(i,j);
                 auxID = p.getId()%6;
                 casa = tab.retornaCasa(i, j);
                        
                 switch (auxID) {
                            case 0:
                                        forca = forca + 10;
                                        break;
                            case 1:
                                        forca = forca + 50; //Torre
                                        break;
                            case 2:
                                        forca = forca + 40;                 //Bispo
                                        break;
                            case 3:
                                        forca = forca + 40;           //Cavalo
                                        break;
                            case 4:
                                        forca = forca + 60;       //Dama
                                        break;
                            case 5:
                                        forca = forca +50;              //Rei
                                        break;
                default:
                            System.out.println("Este não é uma peça válida!");
                }
               }  
             }   
        }
        return forca;
    }
    
    
    
    public int calcularAvaliacao(TabuleiroIA tab, String corLado){
    
        int estimativa = 0;
        
        estimativa = estimativa + this.estimativaPorForca(tab, corLado);
        
        estimativa = estimativa + this.estimativaPorOpcoesDeMovimento(tab, corLado);
       
        estimativa = estimativa + this.estimativaPorPosicao(tab, corLado);
      
        return estimativa;
    }
    
    
    public int calcularAvaliacaoComparativa(TabuleiroIA tab){
        int ladoPreto; 
        int ladoBranco;
        int resultado;
        
        ladoPreto = this.calcularAvaliacao(tab,Constantes.PRETO);
        ladoBranco = this.calcularAvaliacao(tab,Constantes.BRANCO);
        
        resultado = ladoPreto - ladoBranco;
        
        return resultado;
        
        
    }

 
    
    
    
    
    
    
    
    
    
    
    
}

