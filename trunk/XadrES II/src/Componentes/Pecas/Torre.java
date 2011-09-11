/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes.Pecas;

import Componentes.InterfaceGrafica;
import Componentes.Peca;
import JPlay.Sprite;
import Parametros.Constantes;

/**
 *
 * @author Uenes
 */
public class Torre extends Peca {

    private static final String caminhoSprite = "imagens/rainha.png";

    public Torre(int linha, int coluna) {
        super(linha, coluna);
    }

    public void setImagemSprite() {
        sprite = new Sprite(caminhoSprite, Constantes.NUMERO_FRAMES_PECAS);
        sprite.setInitialFrame(0);
        sprite.setFinalFrame(1);
        sprite.setPosition(InterfaceGrafica.getPosicaoColunaPorCasa(getLinha(), getColuna()), InterfaceGrafica.getPosicaoLinhaPorCasa(getColuna()));

    }
}
