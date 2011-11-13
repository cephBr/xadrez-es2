/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaRegras;

/**
 *
 * @author Thiago
 */
public class Posicao {
    int posX;
    int posY;
    
    public Posicao (int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
            
}
