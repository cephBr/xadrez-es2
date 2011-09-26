/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Parametros.Constantes;

/**
 *
 * @author Uenes,Ceph
**/
public class Peao extends Peca {

  private static final String caminhoSprite = "imagens/rainha.png";

    public Peao(int linha, int coluna, int posLinha, int posColuna,int id,String apelido) {
        super(id,apelido,caminhoSprite,Constantes.NUMERO_FRAMES_PECAS,linha,coluna);
        super.sprite.setPosition(posLinha-26, posColuna-72);
    }
}
