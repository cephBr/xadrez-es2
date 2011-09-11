/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Pecas.Bispo;
import Componentes.Pecas.Cavalo;
import Componentes.Pecas.Peao;
import Componentes.Pecas.Rainha;
import Componentes.Pecas.Rei;
import Componentes.Pecas.Torre;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sound;
import JPlay.Window;
import Parametros.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceph
 */
public class InterfaceGrafica {

    Tabuleiro tabuleiro;
    //time branco
    List<Peca> pecasBrancas = new ArrayList<Peca>(16);
    //time preto
    List<Peca> pecasPretas = new ArrayList<Peca>(16);
    Window janela;
    Keyboard keyboard;
    Mouse mouse;
    boolean executando;

    public InterfaceGrafica() {
        carregaDados();
        loop();
        encerrarJogo();
    }

    private void carregaDados() {
        janela = new Window(Constantes.DIM_TABULEIRO_HORIZONTAL, Constantes.DIM_TABULEIRO_VERTICAL);
        keyboard = janela.getKeyboard();
        keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        mouse = janela.getMouse();

        tabuleiro = new Tabuleiro(8, 8, Constantes.TABULEIRO);

        // Peças Brancas
        Torre torre = new Torre(0, 0, tabuleiro.getPosLinha(0, 0), tabuleiro.getPosColuna(0, 0));
        torre.setImagemSprite();
        pecasBrancas.add(torre);
        tabuleiro.setPeça(torre);

        Cavalo cavalo = new Cavalo(1, 0, tabuleiro.getPosLinha(1, 0), tabuleiro.getPosColuna(1, 0));
        cavalo.setImagemSprite();
        pecasBrancas.add(cavalo);
        tabuleiro.setPeça(cavalo);

        Bispo bispo = new Bispo(2, 0, tabuleiro.getPosLinha(2, 0), tabuleiro.getPosColuna(2, 0));
        bispo.setImagemSprite();
        pecasBrancas.add(bispo);
        tabuleiro.setPeça(bispo);

        Rainha rainha = new Rainha(3, 0, tabuleiro.getPosLinha(3, 0), tabuleiro.getPosColuna(3, 0));
        rainha.setImagemSprite();
        pecasBrancas.add(rainha);
        tabuleiro.setPeça(rainha);

        Rei rei = new Rei(4, 0, tabuleiro.getPosLinha(4, 0), tabuleiro.getPosColuna(4, 0));
        rei.setImagemSprite();
        pecasBrancas.add(rei);
        tabuleiro.setPeça(rei);

        Bispo bispo2 = new Bispo(5, 0, tabuleiro.getPosLinha(5, 0), tabuleiro.getPosColuna(5, 0));
        bispo2.setImagemSprite();
        pecasBrancas.add(bispo2);
        tabuleiro.setPeça(bispo2);

        Cavalo cavalo2 = new Cavalo(6, 0, tabuleiro.getPosLinha(6, 0), tabuleiro.getPosColuna(6, 0));
        cavalo2.setImagemSprite();
        pecasBrancas.add(cavalo2);
        tabuleiro.setPeça(cavalo2);

        Torre torre2 = new Torre(7, 0, tabuleiro.getPosLinha(7, 0), tabuleiro.getPosColuna(7, 0));
        torre2.setImagemSprite();
        pecasBrancas.add(torre2);
        tabuleiro.setPeça(torre2);

        Peao peao1 = new Peao(0, 1, tabuleiro.getPosLinha(0, 1), tabuleiro.getPosColuna(0, 1));
        peao1.setImagemSprite();
        pecasBrancas.add(peao1);
        tabuleiro.setPeça(peao1);

        Peao peao2 = new Peao(1, 1, tabuleiro.getPosLinha(1, 1), tabuleiro.getPosColuna(1, 1));
        peao2.setImagemSprite();
        pecasBrancas.add(peao2);
        tabuleiro.setPeça(peao2);

        Peao peao3 = new Peao(2, 1, tabuleiro.getPosLinha(2, 1), tabuleiro.getPosColuna(2, 1));
        peao3.setImagemSprite();
        pecasBrancas.add(peao3);
        tabuleiro.setPeça(peao3);

        Peao peao4 = new Peao(3, 1, tabuleiro.getPosLinha(3, 1), tabuleiro.getPosColuna(3, 1));
        peao4.setImagemSprite();
        pecasBrancas.add(peao4);
        tabuleiro.setPeça(peao4);

        Peao peao5 = new Peao(4, 1, tabuleiro.getPosLinha(4, 1), tabuleiro.getPosColuna(4, 1));
        peao5.setImagemSprite();
        pecasBrancas.add(peao5);
        tabuleiro.setPeça(peao5);

        Peao peao6 = new Peao(5, 1, tabuleiro.getPosLinha(5, 1), tabuleiro.getPosColuna(5, 1));
        peao6.setImagemSprite();
        pecasBrancas.add(peao6);
        tabuleiro.setPeça(peao6);

        Peao peao7 = new Peao(6, 1, tabuleiro.getPosLinha(6, 1), tabuleiro.getPosColuna(6, 1));
        peao7.setImagemSprite();
        pecasBrancas.add(peao7);
        tabuleiro.setPeça(peao7);

        Peao peao8 = new Peao(7, 1, tabuleiro.getPosLinha(7, 1), tabuleiro.getPosColuna(7, 1));
        peao8.setImagemSprite();
        pecasBrancas.add(peao8);
        tabuleiro.setPeça(peao8);

        //----------------------------
        // Peças Pretas
        //----------------------------
        peao1 = new Peao(0, 6, tabuleiro.getPosLinha(0, 6), tabuleiro.getPosColuna(0, 6));
        peao1.setImagemSprite();
        pecasPretas.add(peao1);
        tabuleiro.setPeça(peao1);

        peao2 = new Peao(1, 6, tabuleiro.getPosLinha(1, 6), tabuleiro.getPosColuna(1, 6));
        peao2.setImagemSprite();
        pecasPretas.add(peao2);
        tabuleiro.setPeça(peao2);

        peao3 = new Peao(2, 6, tabuleiro.getPosLinha(2, 6), tabuleiro.getPosColuna(2, 6));
        peao3.setImagemSprite();
        pecasPretas.add(peao3);
        tabuleiro.setPeça(peao3);

        peao4 = new Peao(3, 6, tabuleiro.getPosLinha(3, 6), tabuleiro.getPosColuna(3, 6));
        peao4.setImagemSprite();
        pecasPretas.add(peao4);
        tabuleiro.setPeça(peao4);

        peao5 = new Peao(4, 6, tabuleiro.getPosLinha(4, 6), tabuleiro.getPosColuna(4, 6));
        peao5.setImagemSprite();
        pecasPretas.add(peao5);
        tabuleiro.setPeça(peao5);

        peao6 = new Peao(5, 6, tabuleiro.getPosLinha(5, 6), tabuleiro.getPosColuna(5, 6));
        peao6.setImagemSprite();
        pecasPretas.add(peao6);
        tabuleiro.setPeça(peao6);

        peao7 = new Peao(6, 6, tabuleiro.getPosLinha(6, 6), tabuleiro.getPosColuna(6, 6));
        peao7.setImagemSprite();
        pecasPretas.add(peao7);
        tabuleiro.setPeça(peao7);

        peao8 = new Peao(7, 6, tabuleiro.getPosLinha(7, 6), tabuleiro.getPosColuna(7, 6));
        peao8.setImagemSprite();
        pecasPretas.add(peao8);
        tabuleiro.setPeça(peao8);

        torre = new Torre(0, 7, tabuleiro.getPosLinha(0, 7), tabuleiro.getPosColuna(0, 7));
        torre.setImagemSprite();
        pecasPretas.add(torre);
        tabuleiro.setPeça(torre);

        cavalo = new Cavalo(1, 7, tabuleiro.getPosLinha(1, 7), tabuleiro.getPosColuna(1, 7));
        cavalo.setImagemSprite();
        pecasPretas.add(cavalo);
        tabuleiro.setPeça(cavalo);

        bispo = new Bispo(2, 7, tabuleiro.getPosLinha(2, 7), tabuleiro.getPosColuna(2, 7));
        bispo.setImagemSprite();
        pecasPretas.add(bispo);
        tabuleiro.setPeça(bispo);

        rainha = new Rainha(3, 7, tabuleiro.getPosLinha(3, 7), tabuleiro.getPosColuna(3, 7));
        rainha.setImagemSprite();
        pecasPretas.add(rainha);
        tabuleiro.setPeça(rainha);

        rei = new Rei(4, 7, tabuleiro.getPosLinha(4, 7), tabuleiro.getPosColuna(4, 7));
        rei.setImagemSprite();
        pecasPretas.add(rei);
        tabuleiro.setPeça(rei);

        bispo2 = new Bispo(5, 7, tabuleiro.getPosLinha(5, 7), tabuleiro.getPosColuna(5, 7));
        bispo2.setImagemSprite();
        pecasPretas.add(bispo2);
        tabuleiro.setPeça(bispo2);

        cavalo2 = new Cavalo(6, 7, tabuleiro.getPosLinha(6, 7), tabuleiro.getPosColuna(6, 7));
        cavalo2.setImagemSprite();
        pecasPretas.add(cavalo2);
        tabuleiro.setPeça(cavalo2);

        torre2 = new Torre(7, 7, tabuleiro.getPosLinha(7, 7), tabuleiro.getPosColuna(7, 7));
        torre2.setImagemSprite();
        pecasPretas.add(torre2);
        tabuleiro.setPeça(torre2);

        executando = true;
    }

    private void monitorPeça(Peca p) throws Exception {


        if (p.estaSelecionada()) {
            if (!mouse.isOverObject(p.sprite)) {
                tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y), tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), p);
                p.sprite.reset();
            }
        }

        if (mouse.isOverObject(p.sprite)) {
            if (!p.estaSelecionada()) {
                p.selecionar();
            } else {
                p.selecionada = false;
                p.sprite.reset();
            }
        }
    }

    public void atualizações() {
        try {
            if (mouse.isLeftButtonPressed() == true) {
                for (Peca p : pecasBrancas) {
                    monitorPeça(p);
                }
                for (Peca p : pecasPretas) {
                    monitorPeça(p);
                }
            }
        } catch (Exception e) {
            new Sound(Constantes.ERRO_SOM).play();
        }
        if (keyboard.keyDown(Keyboard.ESCAPE_KEY) == true) {
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                executando = false;
            }
        }
    }

    public void desenhar() {
        tabuleiro.fundo.draw();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Peca pecaDesenhar = tabuleiro.getPecaPorPosicao(x, y);
                if (pecaDesenhar != null) {
                    pecaDesenhar.sprite.draw();
                }
            }
        }
    }

    private void loop() {
        while (executando) {// ultima peça é null
            desenhar();
            janela.display();
            atualizações();
        }
    }

    private void encerrarJogo() {
        janela.exit();
    }


}
