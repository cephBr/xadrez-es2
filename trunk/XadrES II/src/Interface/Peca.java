/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import JPlay.Sprite;

/**
 *
 * @author Ceph
 */
public class Peca {

    private int id;
    public  String cor;
    public  Sprite sprite;
    private Boolean ativa;
    public Boolean selecionada;
    public Boolean foiMexida;
    private int posX,posY;
    public int comp_X;
    public int comp_Y;


    public Peca(int id, String cor, String caminhoSprite, int numeroFrames, int i,int j) {
        this.id = id;
        this.cor = cor;
        this.sprite = new Sprite(caminhoSprite,numeroFrames);
        this.sprite.setInitialFrame(0);
        this.sprite.setFinalFrame(1);
        this.foiMexida=false;
        this.ativa = true;
        this.selecionada=false;
        posX=j;
        posY=i;
    }

    public String retornaCor(){
        return this.cor;
    }
    
    public Boolean foiMexida(){
        return this.foiMexida;
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void desativarPeca() {
        this.ativa = false;
    }

    public String getApelido() {
        return cor;
    }

    public int getId() {
        return id;
    }

    public Boolean estaSelecionada() {
        return selecionada;
    }

    public void selecionar() {
        this.selecionada = true;
        this.sprite.setCurrFrame(sprite.getFinalFrame());
    }

    public void deselecionar(){
        this.selecionada = false;
    }







}
