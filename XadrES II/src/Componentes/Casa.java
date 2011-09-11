/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Peca;

/**
 *
 * @author Uenes
 */
public class Casa {
    private Peca peca;
    private Boolean ocupada;
    private int x0, x1, y0, y1;
    private int posLinha, posColuna;

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public int getPosLinha() {
        return posLinha;
    }

    public void getPosLinha(int linha) {
        this.posLinha = linha;
    }

    public int getPosColuna() {
        return posColuna;
    }

    public void setPosColuna(int posColuna) {
        this.posColuna = posColuna;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
};
