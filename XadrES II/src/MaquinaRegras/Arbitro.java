/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaRegras;

import Interface.Casa;
import Interface.Peca;
import Interface.Rei;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Thiago
 */
public class Arbitro {
    
    Movimentacao mov = new Movimentacao();
    
    public List<Peca> getPecas(String corJogador, Casa[][] Tab){
        
        List<Peca> pecas = new ArrayList<Peca>();
        
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <=7; j++) {
                if (Tab[i][j].ocupada) {
                    if (Tab[i][j].peca.cor.equalsIgnoreCase(corJogador)) {
                          boolean add = pecas.add(Tab[i][j].peca);
                    }
                }
            }
        }
        
        return pecas;        
    }
    
    public Posicao getPosicaoRei (String corJogador, Casa[][] Tab){
        Posicao posRei = new Posicao(-1,-1);
        
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <=7; j++) {
                if (Tab[i][j].ocupada) {
                    if (Tab[i][j].peca instanceof Rei) {
                        if (Tab[i][j].peca.cor.equalsIgnoreCase(corJogador)) {
                            posRei  = new Posicao(i,j);
                        }
                    }
                }
            }
        }
        
        return posRei;
    
    }
    
    public boolean estaEmXeque(String corJogador, Casa[][] Tab) {
        
            Posicao posicaoRei;
            String corAdversario;
            
            if (corJogador.equalsIgnoreCase("branco"))
                corAdversario = "preto";
            else
                corAdversario = "branco";
            
            posicaoRei  = getPosicaoRei(corJogador,Tab);
            
            List<Peca> pecasAdver = getPecas(corAdversario,Tab);
            for (int i=0; i < pecasAdver.size(); i++) {
                List<Posicao> posicoesValidas = mov.posicoesValidas(Tab, pecasAdver.get(i));
                if (mov.contemNaLista(posicaoRei, posicoesValidas)) {
                    return true;
                }
            }
            return false;
        
    }

    
}
