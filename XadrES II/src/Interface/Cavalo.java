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
public class Cavalo extends Peca {

    

    public Cavalo(int linha, int coluna, int posLinha, int posColuna,int id,String cor,String caminhoSprite) {
        super(id,cor,caminhoSprite,Constantes.NUMERO_FRAMES_PECAS,linha,coluna);
        super.comp_X=26;
        super.comp_Y=70;
        super.sprite.setPosition(posLinha-super.comp_X, posColuna-super.comp_Y);
    }
}
