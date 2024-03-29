/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaRegras;

import Interface.Bispo;
import Interface.Casa;
import Interface.Cavalo;
import Interface.Dama;
import Interface.Peao;
import Interface.Peca;
import Interface.Rei;
import Interface.Tabuleiro;
import Interface.Torre;
import Parametros.Constantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Movimentacao {
    
    public Movimentacao () {
        
    }
    
    public Peca ultimaPeça;
    // armazena a posicao que a ultima peca estava antes a movimentacao
    public Posicao posUltimaPeca;
    
    //Tabuleiro tabuleiro = new Tabuleiro();
    public void setUltimaPeca(Peca p) {
        ultimaPeça = p;
    }
    
    public void setPosUltimaPeca (Posicao pos) {
        posUltimaPeca = pos;
    }
    
    public int retornaTipoPeca(int id){
        return id%6;
    }
    
    public Boolean contemNaLista (Posicao pos, List<Posicao> lista){
        Boolean contem = false;
        
        for (Posicao p:lista) {
            if (p.posX == pos.posX && p.posY == pos.posY) {
                contem = true;
                return contem;
            }
        }
        
        return contem;
    }
    
    public List posicoesValidasPeao(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
        //Tabuleiro tabuleiro = null;// = new Tabuleiro();
        //Peca ultimaPeca = tabuleiro.ultimaPeça;
        
        // MOVIMENTACAO NORMAL DO PEAO //
        if (p.foiMexida.equals(false)) {
            if (p.cor.equalsIgnoreCase("preto")) {
                if (!tab[p.getPosX()+1][p.getPosY()].ocupada) {
                    resposta.add(new Posicao(p.getPosX()+1,p.getPosY()));
                    if (!tab[p.getPosX()+2][p.getPosY()].ocupada) {
                        resposta.add(new Posicao(p.getPosX()+2,p.getPosY()));
                    }
                }
            }
            else {
                if (!tab[p.getPosX()-1][p.getPosY()].ocupada) {
                    resposta.add(new Posicao(p.getPosX()-1,p.getPosY()));
                    if (!tab[p.getPosX()-2][p.getPosY()].ocupada) {
                        resposta.add(new Posicao(p.getPosX()-2,p.getPosY()));
                    }
                }
            }
        }
        else{
            if (p.cor.equalsIgnoreCase("preto")) {
                if (!tab[p.getPosX()+1][p.getPosY()].ocupada) {
                    resposta.add(new Posicao(p.getPosX()+1,p.getPosY()));
                }
            }
            else {
                if (!tab[p.getPosX()-1][p.getPosY()].ocupada) {
                    resposta.add(new Posicao(p.getPosX()-1,p.getPosY()));
                }
            }
        }
        
        // MOVIMENTACAO ONDE PEAO COME OUTRA PECA //
        if (p.cor.equalsIgnoreCase("preto")) {
            if (p.getPosX()+1 <= 7 && p.getPosY()+1 <= 7) {
                if (tab[p.getPosX()+1][p.getPosY()+1].ocupada) {
                    if (tab[p.getPosX()+1][p.getPosY()+1].peca.cor.equalsIgnoreCase("branco")) {
                        resposta.add(new Posicao(p.getPosX()+1,p.getPosY()+1));
                    }
                }
            }
            if (p.getPosX()+1 <= 7 && p.getPosY()-1 >= 0) {
                if (tab[p.getPosX()+1][p.getPosY()-1].ocupada) {
                    if (tab[p.getPosX()+1][p.getPosY()-1].peca.cor.equalsIgnoreCase("branco")) {
                        resposta.add(new Posicao(p.getPosX()+1,p.getPosY()-1));
                    }
                }
            }
        }
        else {
            if (p.getPosX()-1 >= 0 && p.getPosY()+1 <= 7) {
                if (tab[p.getPosX()-1][p.getPosY()+1].ocupada) {
                   if (tab[p.getPosX()-1][p.getPosY()+1].peca.cor.equalsIgnoreCase("preto")) {
                        resposta.add(new Posicao(p.getPosX()-1,p.getPosY()+1));
                    }
                }
            }
            if (p.getPosX()-1 >= 0 && p.getPosY()-1 >= 0) {
                if (tab[p.getPosX()-1][p.getPosY()-1].ocupada) {
                    if (tab[p.getPosX()-1][p.getPosY()-1].peca.cor.equalsIgnoreCase("preto")) {
                        resposta.add(new Posicao(p.getPosX()-1,p.getPosY()-1));
                    }
                }    
            }
        }
        
        // MOVIMENTACAO ESPECIAL DO PEAO //
        
        String corJogador = p.retornaCor();

        if (corJogador.equalsIgnoreCase(Constantes.BRANCO) && (p.getPosX() == 3)) {
            if (ultimaPeça instanceof Peao) {
                if ((posUltimaPeca.getPosX() == 1) && (ultimaPeça.getPosX() == 3)) {
                    if (p.getPosY() < 7) {
                        if (ultimaPeça.getPosY() == (p.getPosY()+1)) {
                            resposta.add(new Posicao(p.getPosX()-1,p.getPosY()+1));
                        }
                    }
                    if (p.getPosY() > 0) {
                        if (ultimaPeça.getPosY() == (p.getPosY()-1)) {
                            resposta.add(new Posicao(p.getPosX()-1,p.getPosY()-1));
                        }
                    }
                }
            }
        } else {
            if (corJogador.equalsIgnoreCase(Constantes.PRETO) && (p.getPosX() == 4)) {
                if (ultimaPeça instanceof Peao) {
                    if ((posUltimaPeca.getPosX() == 6) && (ultimaPeça.getPosX() == 4)) {
                        if (p.getPosY() < 7) {
                            if (ultimaPeça.getPosY() == (p.getPosY()+1)) {
                                resposta.add(new Posicao(p.getPosX()+1,p.getPosY()+1));
                            }
                        }
                        if (p.getPosY() > 0) {
                            if (ultimaPeça.getPosY() == (p.getPosY()-1)) {
                                resposta.add(new Posicao(p.getPosX()+1,p.getPosY()-1));
                            }
                        }

                    }
                }
            }
        }

     
        return resposta;
    }
    
    public List posicoesValidasTorre(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
        
        for (int i = p.getPosX()+1; i <= 7; i++) {
            if (tab[i][p.getPosY()].ocupada) {
                if (!tab[i][p.getPosY()].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,p.getPosY()));
                    break;
                }
                else {
                    break;
                }
            }
            else { 
                if (i != p.getPosX()) {
                    resposta.add(new Posicao(i,p.getPosY()));
                }
            }
        }
        
        for (int i = p.getPosX()-1; i >= 0; i--) {
            if (tab[i][p.getPosY()].ocupada) {
                if (!tab[i][p.getPosY()].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,p.getPosY()));
                    break;
                }
                else {
                    break;
                }
            }
            else { 
                if (i != p.getPosX()) {
                    resposta.add(new Posicao(i,p.getPosY()));
                }
            }
        }
        
        for (int i = p.getPosY()+1; i <= 7; i++) {
            if (tab[p.getPosX()][i].ocupada) {
                if (!tab[p.getPosX()][i].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(p.getPosX(),i));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                if (i != p.getPosY()) {
                    resposta.add(new Posicao(p.getPosX(),i));
                }
            }
        }
        
        for (int i = p.getPosY()-1; i >= 0; i--) {
            if (tab[p.getPosX()][i].ocupada) {
                if (!tab[p.getPosX()][i].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(p.getPosX(),i));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                if (i != p.getPosY()) {
                    resposta.add(new Posicao(p.getPosX(),i));
                }
            }
        }
        
        return resposta;
    }
    
    public List posicoesValidasBispo(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
        int i,j;
        
        i = p.getPosX()+1;
        j = p.getPosY()+1;
        while (i <= 7 && j <= 7) {
            if (tab[i][j].ocupada) {
                if (!tab[i][j].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,j));
                    break;
                }
                else {
                    break;
                }
            }
            else { 
                resposta.add(new Posicao(i,j));
            }
            
            i++;
            j++;
        }
        
        i = p.getPosX()-1;
        j = p.getPosY()-1;
        while (i >= 0 && j >= 0) {
            if (tab[i][j].ocupada) {
                if (!tab[i][j].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,j));
                    break;
                }
                else {
                    break;
                }
            }
            else { 
                resposta.add(new Posicao(i,j));
            }
            
            i--;
            j--;
        }
        
        i = p.getPosX()+1;
        j = p.getPosY()-1;
        while (i <= 7 && j >= 0) {
            if (tab[i][j].ocupada) {
                if (!tab[i][j].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,j));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                resposta.add(new Posicao(i,j));
            }
            
            i++;
            j--;
        }
        
        i = p.getPosX()-1;
        j = p.getPosY()+1;
        while (i >= 0 && j <= 7) {
            if (tab[i][j].ocupada) {
                if (!tab[i][j].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(i,j));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                resposta.add(new Posicao(i,j));
            }
            
            i--;
            j++;
        }        
        
        return resposta;
    }
    
    public List posicoesValidasCavalo(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
     
        int posX, posY;
        
        posX = p.getPosX();
        posY = p.getPosY();
        
        if (posX+2 <= 7 && posY+1 <= 7) {
            if (tab[posX+2][posY+1].ocupada) {
                if (!tab[posX+2][posY+1].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX+2,posY+1));
                }
            }
            else {
                resposta.add(new Posicao(posX+2,posY+1));
            }
        }
        
        if (posX+1 <= 7 && posY+2 <= 7) {
            if (tab[posX+1][posY+2].ocupada) {
                if (!tab[posX+1][posY+2].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX+1,posY+2));
                }
            }
            else {
                resposta.add(new Posicao(posX+1,posY+2));
            }
        }
        
        if (posX-1 >= 0 && posY+2 <= 7) {
            if (tab[posX-1][posY+2].ocupada) {
                if (!tab[posX-1][posY+2].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX-1,posY+2));
                }
            }
            else {
                resposta.add(new Posicao(posX-1,posY+2));
            }
        }
        
        if (posX-2 >= 0 && posY+1 <= 7) {
            if (tab[posX-2][posY+1].ocupada) {
                if (!tab[posX-2][posY+1].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX-2,posY+1));
                }
            }
            else {
                resposta.add(new Posicao(posX-2,posY+1));
            }
        }
        
        if (posX-2 >= 0 && posY-1 >= 0) {
            if (tab[posX-2][posY-1].ocupada) {
                if (!tab[posX-2][posY-1].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX-2,posY-1));
                }
            }
            else {
                resposta.add(new Posicao(posX-2,posY-1));
            }
        }
        
        if (posX-1 >= 0 && posY-2 >= 0) {
            if (tab[posX-1][posY-2].ocupada) {
                if (!tab[posX-1][posY-2].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX-1,posY-2));
                }
            }
            else {
                resposta.add(new Posicao(posX-1,posY-2));
            }
        }
        
        if (posX+1 <= 7 && posY-2 >= 0) {
            if (tab[posX+1][posY-2].ocupada) {
                if (!tab[posX+1][posY-2].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX+1,posY-2));
                }
            }
            else {
                resposta.add(new Posicao(posX+1,posY-2));
            }
        }
        
        if (posX+2 <= 7 && posY-1 >= 0) {
            if (tab[posX+2][posY-1].ocupada) {
                if (!tab[posX+2][posY-1].peca.cor.equalsIgnoreCase(p.cor)) {
                    resposta.add(new Posicao(posX+2,posY-1));
                }
            }
            else {
                resposta.add(new Posicao(posX+2,posY-1));
            }
        }
            
        return resposta;
    }
    
    public List posicoesValidasDama(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
        List<Posicao> resposta1, resposta2;
        
        resposta1 = posicoesValidasTorre(tab, p);
        resposta2 = posicoesValidasBispo(tab, p);
        
        for (Posicao pos:resposta1) {
            resposta.add(pos);
        }
        
        for (Posicao pos:resposta2) {
            resposta.add(pos);
        }
        
        return resposta;
    }
    
    // remove a possibilidade de realizar o roque
    public List<Posicao> removePosicaoRoque(Peca peca, List<Posicao> resposta) {
        
        int posY;
        int posPecaY1 = peca.getPosY()+2;
        int posPecaY2 = peca.getPosY()-2;
        int tamLista = resposta.size();
                
        tamLista--;
        posY = resposta.get(tamLista).getPosY();
        if ((posY == posPecaY1) || (posY == posPecaY2)) {
            resposta.remove(tamLista);
        }
        
        tamLista = resposta.size();
        tamLista--;
        posY = resposta.get(tamLista).getPosY();
        if ((posY == posPecaY1) || (posY == posPecaY2)) {
            resposta.remove(tamLista);
        }
        
        return resposta;
    }
    
    public List posicoesValidasRei(Casa[][] tab, Peca p){
        List<Posicao> resposta = new ArrayList<Posicao>();
        
        int posX, posY;
        
        posX = p.getPosX();
        posY = p.getPosY();
        
        for (int i = posX-1; i <= posX+1; i++) {
            for (int j = posY-1; j <= posY+1; j++) {
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
                    if (tab[i][j].ocupada) {
                        if (!tab[i][j].peca.cor.equalsIgnoreCase(p.cor)) {
                            resposta.add(new Posicao(i,j));
                        }
                    }
                    else {
                        resposta.add(new Posicao(i,j));
                    }
                }
            }
        }
        
        // MOVIMENTO ESPECIAL DO REI //
        
        // pequeno roque //
        if (!p.foiMexida()) {
            if (tab[posX][7].ocupada) {
                if (!tab[posX][7].peca.foiMexida()) {
                    if (!tab[posX][posY+1].ocupada && !tab[posX][posY+2].ocupada) {
                        int j;
                        j = posY+2;
                        resposta.add(new Posicao(posX,j));
                    }                                                
                }                    
            }            
        }

        // grande roque //
        if (!p.foiMexida()) {
            if (tab[posX][0].ocupada) {
                if (!tab[posX][0].peca.foiMexida()) {
                    if (!tab[posX][posY-1].ocupada && !tab[posX][posY-2].ocupada && !tab[posX][posY-3].ocupada) {
                        int j;
                        j = posY-2;
                        resposta.add(new Posicao(posX,j));
                    }                                                
                }                    
            }            
        }
        
        return resposta;
    }
    
    public List posicoesValidas(Casa[][] tab, Peca p){
        
        List<Posicao> resposta = new ArrayList<Posicao>();
        
        int tipoPeca;
        
        tipoPeca = retornaTipoPeca(p.getId());
        
        switch (tipoPeca) {
            case Constantes.tipoPEAO:
                resposta = posicoesValidasPeao(tab, p);
                break;
            case Constantes.tipoTORRE:
                resposta = posicoesValidasTorre(tab, p);
                break;
            case Constantes.tipoBISPO:
                resposta = posicoesValidasBispo(tab, p);
                break;
            case Constantes.tipoCAVALO:
                resposta = posicoesValidasCavalo(tab, p);
                break;
            case Constantes.tipoDAMA:
                resposta = posicoesValidasDama(tab, p);
                break;
            case Constantes.tipoREI:
                resposta = posicoesValidasRei(tab, p);
                break;
             default:
                 System.out.println("Este não é uma peça válida!");
        }
        
        return resposta;
    }
}
