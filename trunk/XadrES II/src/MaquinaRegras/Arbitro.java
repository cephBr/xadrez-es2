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
    
    public Arbitro (){
        
    }

    public Movimentacao mov = new Movimentacao();
        
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
    
    public Casa[][] montaTabVirtual (Posicao posicaoRei, Posicao possivelPosRei, Casa[][] Tab, Peca rei){
        
        
        if(Tab[possivelPosRei.posX][possivelPosRei.posY].peca!=null &&
         !Tab[possivelPosRei.posX][possivelPosRei.posY].peca.retornaCor().equals(Tab[posicaoRei.posX][posicaoRei.posY].peca.retornaCor())){
            Tab[possivelPosRei.posX][possivelPosRei.posY].peca=null;
            Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada=false;
        }
       /* this.comerPeca(dim_Y, dim_X, peca);
                this.desocupar(peca.getPosX(), peca.getPosY());
                this.tabuleiro[dim_Y][dim_X].ocupada=true;
                this.tabuleiro[dim_Y][dim_X].peca=peca;
                this.
                this.tabuleiro[dim_Y][dim_X].peca.setPosX(dim_Y);
                this.tabuleiro[dim_Y][dim_X].peca.setPosY(dim_X);
                this.ultimaPeça=peca;
                this.tabuleiro[dim_Y][dim_X].peca.foiMexida=true;
        */

        Tab[posicaoRei.posX][posicaoRei.posY].peca=null;
        Tab[posicaoRei.posX][posicaoRei.posY].ocupada=false;

        Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada=true;
        Tab[possivelPosRei.posX][possivelPosRei.posY].peca = rei;
        Tab[possivelPosRei.posX][possivelPosRei.posY].peca.setPosX(possivelPosRei.posX);
        Tab[possivelPosRei.posX][possivelPosRei.posY].peca.setPosY(possivelPosRei.posY);
        return Tab;
    }
    
    public Casa[][] retornaTabOriginal (Posicao posicaoRei, Posicao possivelPosRei, Casa[][] Tab, Peca rei, Peca pecaVelha){
        
        Tab[posicaoRei.posX][posicaoRei.posY].ocupada = true;
        Tab[posicaoRei.posX][posicaoRei.posY].peca = rei;
        Tab[posicaoRei.posX][posicaoRei.posY].peca.setPosX(posicaoRei.posX);
        Tab[posicaoRei.posX][posicaoRei.posY].peca.setPosY(posicaoRei.posY);


        if (pecaVelha != null) {
            Tab[pecaVelha.getPosX()][pecaVelha.getPosY()].ocupada = true;
            Tab[pecaVelha.getPosX()][pecaVelha.getPosY()].peca = pecaVelha;
        } else {
            Tab[possivelPosRei.posX][possivelPosRei.posY].ocupada = false;
            Tab[possivelPosRei.posX][possivelPosRei.posY].peca = null;
        }
        return Tab;
    }
    
    public boolean reiPodeFugir(String corJogador, Casa[][] Tab) throws Exception{
        
        String corAdversario;
            
        if (corJogador.equalsIgnoreCase("branco"))
            corAdversario = "preto";
        else
            corAdversario = "branco";
        
        //Armazena a posição do rei em xeque
        Posicao posicaoRei  = getPosicaoRei(corJogador,Tab);
        
        
        // Lista com as posições destino possíveis do rei
        List<Posicao> posicoesPossiveisRei = mov.posicoesValidasRei(Tab, Tab[posicaoRei.posX][posicaoRei.posY].peca);
        
        
        //Rei pode fugir?
        int i = 0;
        boolean reiEmPerigo = true;
        while ((i < posicoesPossiveisRei.size()) && reiEmPerigo) {
            Posicao possivelPosRei = posicoesPossiveisRei.get(i);
            //Armazena o rei e a peça que está na posição que ele vai testar para retornar depois
            Peca pecaVelha = Tab[possivelPosRei.posX][possivelPosRei.posY].peca;
            Peca rei = Tab[posicaoRei.posX][posicaoRei.posY].peca;

            
            // Monta um tabuleiro "virtual" para avaliacao de novas posicoes
            Casa[][] tabVirtual = montaTabVirtual (posicaoRei, possivelPosRei, Tab, rei);

            List<Peca> pecasAdver = getPecas(corAdversario,tabVirtual);
            
            int j = 0;
            boolean posicaoEmAtaque = false;
            while ((j < pecasAdver.size()) && !posicaoEmAtaque) {
                List<Posicao> posicoesValidas = mov.posicoesValidas(tabVirtual, pecasAdver.get(j));
                if (mov.contemNaLista(possivelPosRei, posicoesValidas)) {
                    posicaoEmAtaque = true;
                }
                    
                j++;
            }
            
            // Retornando o tabuleiro para a situacao original
            Tab = retornaTabOriginal (posicaoRei, possivelPosRei, Tab, rei, pecaVelha);
            
            if (!posicaoEmAtaque) {
                reiEmPerigo = false;
            }
            i++;
        }
        return !reiEmPerigo;
    }
    
    public List<Peca> getAmeacasRei(String corJogador, Casa[][] Tab) {
        
        List<Peca> ameacas = new ArrayList<Peca>();
        String corAdversario;
            
        if (corJogador.equalsIgnoreCase("branco"))
            corAdversario = "preto";
        else
            corAdversario = "branco";
        
        Posicao posicaoRei  = getPosicaoRei(corJogador,Tab);
        
         List<Peca> pecasAdver = getPecas(corAdversario, Tab);
        
        for (int i = 0; i < pecasAdver.size(); i++) {
            List<Posicao> posicoesValidas = mov.posicoesValidas(Tab, pecasAdver.get(i));
            if (mov.contemNaLista(posicaoRei, posicoesValidas)) {
                boolean add = ameacas.add(Tab[pecasAdver.get(i).getPosX()][pecasAdver.get(i).getPosY()].peca);
            }
        }
        return ameacas;
    }
    
    public List<Posicao> caminhoPara (Peca peca, Peca rei, Casa[][] Tab){
        List<Posicao> listaPosicoes = new ArrayList<Posicao>();
        int reiId = rei.getId();
        
        // se for dama
        if ((peca.id%6) == 4) {
            List<Posicao> posicoesPeca = mov.posicoesValidas(Tab, peca);
            rei.id = 1; // torre
            List<Posicao> posicoesRei = mov.posicoesValidas(Tab, rei);

            for (int i = 0; i < posicoesRei.size(); i++) {
                Posicao posRei = new Posicao(posicoesRei.get(i).getPosX(),posicoesRei.get(i).getPosY());
                for (int j = 0; j < posicoesPeca.size(); j++) {
                    Posicao posPeca = new Posicao(posicoesPeca.get(j).getPosX(),posicoesPeca.get(j).getPosY());
                    if (posPeca.getPosX() == posRei.getPosX() && posPeca.getPosY() == posRei.getPosY()) {
                        boolean add = listaPosicoes.add(new Posicao (posRei.getPosX(),posRei.getPosY()));
                    }
                }
            }
            
            if (listaPosicoes.isEmpty()) {
                rei.id = 2; // bispo
                posicoesRei = mov.posicoesValidas(Tab, rei);

                for (int i = 0; i < posicoesRei.size(); i++) {
                    Posicao posRei = new Posicao(posicoesRei.get(i).getPosX(),posicoesRei.get(i).getPosY());
                    for (int j = 0; j < posicoesPeca.size(); j++) {
                        Posicao posPeca = new Posicao(posicoesPeca.get(j).getPosX(),posicoesPeca.get(j).getPosY());
                        if (posPeca.getPosX() == posRei.getPosX() && posPeca.getPosY() == posRei.getPosY()) {
                            boolean add = listaPosicoes.add(new Posicao (posRei.getPosX(),posRei.getPosY()));
                        }
                    }
                }
            }
            
        } else { // qq outra peca
            List<Posicao> posicoesPeca = mov.posicoesValidas(Tab, peca);
            rei.id = peca.getId();
            List<Posicao> posicoesRei = mov.posicoesValidas(Tab, rei);

            for (int i = 0; i < posicoesRei.size(); i++) {
                Posicao posRei = new Posicao(posicoesRei.get(i).getPosX(),posicoesRei.get(i).getPosY());
                for (int j = 0; j < posicoesPeca.size(); j++) {
                    Posicao posPeca = new Posicao(posicoesPeca.get(j).getPosX(),posicoesPeca.get(j).getPosY());
                    if (posPeca.getPosX() == posRei.getPosX() && posPeca.getPosY() == posRei.getPosY()) {
                        boolean add = listaPosicoes.add(new Posicao (posRei.getPosX(),posRei.getPosY()));
                    }
                }
            }
        }
        rei.id = reiId;
        
        return listaPosicoes;
    }
    
    public boolean xequeMate(String corJogador, Casa[][] Tab) throws Exception {

        //Se o jogador não estiver em xeque, então não está em xeque-mate
        if (!estaEmXeque(corJogador,Tab)) {
            return false;
        }

        //Verifica se o rei pode fugir
        if (reiPodeFugir(corJogador, Tab)) {
            return false;
        }
        
        //Alguma peça pode salvar o rei
        Posicao posicaoRei  = getPosicaoRei(corJogador,Tab);
        Peca rei = Tab[posicaoRei.posX][posicaoRei.posY].peca;
        
        //Variável que verificará se precisa de apenas um movimento para salvar o rei
        //Se for necessário mais de um movimento, é xeque-mate
        int numMovimentos = 0; 
        
        //Nesta variável será armazenada a peça salvadora, ou seja, a que bloqueia o ataque
        Peca mosqueteiro = null; 
        
        //Aqui ficará a posição de bloqueio da peça que bloqueia
        Posicao posBloqueio = null; 
        
        //List para pegar as peças que ameaçam o rei
        List<Peca> ameacasRei = getAmeacasRei(corJogador,Tab);

        //Verifica se alguém pode bloquear ou comer as peças que ameaçam o rei
        //Varre a lista de ameaças e verifica para todas as peças do jogador vendo se pode haver bloqueio ou ataque
        int i = 0;
        boolean continuaWhile = true;
        while ((i < ameacasRei.size()) && continuaWhile) {
            //Peças do jogador em xeque
            List<Peca> pecasJogador = getPecas(corJogador, Tab);
            //Peça que ameaça o rei
            Peca pecaAdver = ameacasRei.get(i);
            //Pega as posições do caminho da peça que ameaça até o rei (conjunto)
            List<Posicao> caminhoParaRei = caminhoPara(pecaAdver, rei, Tab);
            //Adiciona a posição do adversario na lista
            caminhoParaRei.add(new Posicao(pecaAdver.getPosX(),pecaAdver.getPosY()));
            //booleano para controlar se a peça que ameaça tem caminho livre até o rei
            boolean caminhoLivre = true;
            //Varre as peças do jogador à procura de alguma para salvar o rei
            Peca pecaAtualJogador = null;
            Posicao pos = null;
            int j = 0;
            while ((j < pecasJogador.size()) && caminhoLivre) {
                pecaAtualJogador = pecasJogador.get(j);
                if (pecaAtualJogador != rei) {
                    //Lista com as posiçoes possíveis do jogador ameaçado
                    List<Posicao> posicoesPecasJogador = mov.posicoesValidas(Tab, pecaAtualJogador);
                    
                    //varre lista a procura de uma posição que esteja no caminho do rei
                    int k = 0;
                    while ((k < posicoesPecasJogador.size()) && caminhoLivre) {
                        pos = posicoesPecasJogador.get(k);
                        //Se a posição está na lista, a ameaça pode ser bloqueada
                        caminhoLivre = !mov.contemNaLista(pos, caminhoParaRei);
                        k++;
                    }
                }
                j++;
            }
            if (!caminhoLivre) {
                numMovimentos++;
                if (numMovimentos == 1) {
                    mosqueteiro = pecaAtualJogador;
                    posBloqueio = pos;
                    ameacasRei.remove(i);
                } else { //Ou seja, uma ameaça já foi bloqueada
                    if (mosqueteiro != pecaAtualJogador || posBloqueio != pos) {
                        return true;//Iria ser necessário mais de um movimento para salvar o rei
                    }
                }
            } else {
                return true;
            }
            i++;
        }
        return false;
    }
}
