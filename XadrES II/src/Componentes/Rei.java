/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.InterfaceGrafica;
import Componentes.Peca;
import JPlay.Sprite;
import Parametros.Constantes;

/**
 *
 * @author Uenes
 */
public class Rei extends Peca {

    private static final String caminhoSprite = "imagens/rainha.png";

    public Rei(int linha, int coluna, int posLinha, int posColuna) {
        super(linha, coluna, posLinha, posColuna);
    }

    public void setImagemSprite() {
        sprite = new Sprite(caminhoSprite, Constantes.NUMERO_FRAMES_PECAS);
        sprite.setInitialFrame(0);
        sprite.setFinalFrame(1);
        sprite.setPosition(super.getPosColuna(), super.getPosLinha());
    }
}
