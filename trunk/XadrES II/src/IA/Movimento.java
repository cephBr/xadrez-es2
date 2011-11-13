/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import Interface.Casa;
import Interface.Tabuleiro;
import Interface.Peca;
import MaquinaRegras.Posicao;

/**
 *
 * @author leandrogaluzzi
 */
public class Movimento {
    
        private Posicao posIni;
        private Posicao posFin;
        private Peca peca;
        
        public Movimento(Posicao ini, Posicao fin, Peca peca){
            this.posIni = ini;
            this.posFin = fin;
            this.peca = peca;
        }
    
        public Posicao getPosIni(){
               return this.posIni;
        }
        
        public Posicao getPosFin(){
                return this.posFin;
        }
        
        public Peca getPeca(){
                return this.peca;
        }
        
        public void setPosIni(){
               
        }
        
        public void setPosFin(){
                
        }
    
        
    
    
}
