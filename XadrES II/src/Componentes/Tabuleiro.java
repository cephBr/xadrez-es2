/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Peca;
import Componentes.Casa;
import JPlay.GameImage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Ceph
 */
public class Tabuleiro {

    private Casa[][] tabuleiro;
    public GameImage fundo;

    public int getPosX(int x, int y) {
        return tabuleiro[x][y].getPosY();
    }

    public int getPosY(int x, int y) {
        return tabuleiro[x][y].getPosX();
    }

    public Tabuleiro(int dim_X, int dim_Y, String caminhoFundo) {
        this.tabuleiro = new Casa[dim_X][dim_Y];
        this.fundo = new GameImage(caminhoFundo);
        this.inicializarTabuleiro();
        this.montarCasas();
    }

    public void setPeça(Peca p) {
        this.tabuleiro[p.getLinha()][p.getColuna()].setPeca(p);
        this.tabuleiro[p.getLinha()][p.getColuna()].setOcupada(Boolean.TRUE);
    }

    public Boolean estaOcupado(int dim_X, int dim_Y) {
        return tabuleiro[dim_Y][dim_X].getOcupada();
    }

    public void ocupar(int dim_X, int dim_Y, Peca peca) throws Exception {
        if (!estaOcupado(dim_X, dim_Y)) {
            desocupar(peca.getColuna(), peca.getLinha());
            this.tabuleiro[dim_Y][dim_X].setOcupada(Boolean.TRUE);
            this.tabuleiro[dim_Y][dim_X].setPeca(peca);
            this.tabuleiro[dim_Y][dim_X].getPeca().sprite.setPosition(tabuleiro[dim_Y][dim_X].getPosX() - 26, tabuleiro[dim_Y][dim_X].getPosY() - 72);
            this.tabuleiro[dim_Y][dim_X].getPeca().setColuna(dim_Y);
            this.tabuleiro[dim_Y][dim_X].getPeca().setLinha(dim_X);
//            this.setUltimaPeca(tabuleiro[dim_Y][dim_X].peca);
        } else {
            throw new Exception();
        }
    }

    public void desocupar(int dim_X, int dim_Y) {
        this.tabuleiro[dim_X][dim_Y].setOcupada(Boolean.FALSE);
        this.tabuleiro[dim_X][dim_Y].setPeca(null);
    }

    ;

    private void montarCasas() {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("src/configurações.txt"));
            StringTokenizer st;
            while (entrada.ready()) {
                for (int j = 0; j <= 7; j++) {
                    for (int i = 0; i <= 7; i++) {
                        st = new StringTokenizer(entrada.readLine(), ",");
                        this.tabuleiro[j][i].setX0(Integer.parseInt(st.nextToken()));
                        this.tabuleiro[j][i].setX1(Integer.parseInt(st.nextToken()));
                        this.tabuleiro[j][i].setY0(Integer.parseInt(st.nextToken()));
                        this.tabuleiro[j][i].setY1(Integer.parseInt(st.nextToken()));
                        this.tabuleiro[j][i].setPosX(Integer.parseInt(st.nextToken()));
                        this.tabuleiro[j][i].setPosY(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            entrada.close();
        } catch (IOException e) {
        }

    }

    private void inicializarTabuleiro() {
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                Casa casa = new Casa();
                casa.setOcupada(Boolean.FALSE);
                casa.setPeca(null);
                this.tabuleiro[i][j] = casa;
            }
        }
    }

    public Boolean clicouNaCasa(int x, int y, int posMouseX, int posMouseY) {
        if ((posMouseX <= this.tabuleiro[y][x].getX1() && posMouseX >= this.tabuleiro[y][x].getX0())
                && (posMouseY <= this.tabuleiro[y][x].getY1() && posMouseY >= this.tabuleiro[y][x].getY0())) {
            return true;
        } else {
            return false;
        }

    }

    private List encontrarCoordenada(int posX, int posY) {
        List<Integer> resp = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        Boolean encontrou = false;
        while (!encontrou && j <= 7) {
            while (!encontrou && i <= 7) {
                if ((posX >= this.tabuleiro[j][i].getX0()) && (posX <= this.tabuleiro[j][i].getX1())) {
                    if ((posY >= this.tabuleiro[j][i].getY0()) && (posY <= this.tabuleiro[j][i].getY1())) {
                        encontrou = true;
                        resp.add(i);
                        resp.add(j);
                    }
                }
                i++;
            }
            i = 0;
            j++;
        }

        return resp;
    }

    public int coordenadaY(int posX, int posY) {
        List<Integer> coordenadas = new ArrayList<Integer>();
        int resp = 0;
        coordenadas = encontrarCoordenada(posX, posY);
        if (!coordenadas.isEmpty()) {
            resp = coordenadas.get(1);
        } else {
            resp = -1;
        }
        return resp;

    }

    public int coordenadaX(int posX, int posY) {
        List<Integer> coordenadas = new ArrayList<Integer>();
        int resp = 0;
        coordenadas = encontrarCoordenada(posX, posY);
        if (!coordenadas.isEmpty()) {
            resp = coordenadas.get(0);
        } else {
            resp = -1;
        }
        return resp;

    }

    public Peca getPecaPorPosicao(int y, int x) {
        return tabuleiro[x][y].getPeca();
    }
}
