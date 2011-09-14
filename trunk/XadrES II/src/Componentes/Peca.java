/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import JPlay.Sprite;
import Parametros.Constantes;

/**
 *
 * @author Ceph
 */

//loubake viado
public class Peca {

    private int id;
    private String apelido;
    public Sprite sprite;
    private Boolean ativa;
    public Boolean selecionada;
    private int coluna, linha, posLinha, posColuna;

    public Peca(int linha, int coluna, int posLinha, int posColuna) {
        this.ativa = true;
        this.selecionada=false;
        this.coluna= coluna;
        this.linha= linha;
        this.posLinha = posLinha;
        this.posColuna = posColuna;
    }

    public void desativarPeca() {
        this.setAtiva((Boolean) false);
    }

    public String getApelido() {
        return apelido;
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

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    /**
     * @return the coluna
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * @param coluna the coluna to set
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    /**
     * @return the linha
     */
    public int getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getPosColuna() {
        return posColuna;
    }

    public void setPosColuna(int posColuna) {
        this.posColuna = posColuna;
    }

    public int getPosLinha() {
        return posLinha;
    }

    public void setPosLinha(int posLinha) {
        this.posLinha = posLinha;
    }
}
