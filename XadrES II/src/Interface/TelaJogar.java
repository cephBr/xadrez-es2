/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sprite;
import Parametros.Constantes;

/**
 *
 * @author Ceph
 */
public class TelaJogar implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoNovoJogo;
    Sprite botaoCarregarJogo;
    Sprite botaoOpcoes;
    Sprite botaoVoltar;
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        botaoNovoJogo = new Sprite(Constantes.BOTAO_NOVO_JOGO,2);
        botaoCarregarJogo=new Sprite(Constantes.BOTAO_CARREGAR_JOGO,2);
        botaoOpcoes=new Sprite(Constantes.BOTAO_OPCOES, 2);
        botaoVoltar=new Sprite(Constantes.BOTAO_VOLTAR, 2);
        botaoNovoJogo.setPosition(250,350);
        botaoCarregarJogo.setPosition(250, 400);
        botaoOpcoes.setPosition(250,450);
        botaoVoltar.setPosition(250,500);
        botaoNovoJogo.setInitialFrame(0);
        botaoCarregarJogo.setInitialFrame(0);
        botaoOpcoes.setInitialFrame(0);
        botaoVoltar.setInitialFrame(0);
        botaoNovoJogo.setFinalFrame(1);
        botaoCarregarJogo.setFinalFrame(1);
        botaoOpcoes.setFinalFrame(1);
        botaoVoltar.setFinalFrame(1);
    }

    public void descarregar() {
        fundo=null;
        botaoNovoJogo=null;
        botaoCarregarJogo=null;
        botaoOpcoes=null;
        botaoVoltar=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoCarregarJogo)) {
            botaoCarregarJogo.setCurrFrame(1);
        }else
            botaoCarregarJogo.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoNovoJogo)) {
            botaoNovoJogo.setCurrFrame(1);
            
        }else
            botaoNovoJogo.setCurrFrame(0);
    
        if (mouse.isOverObject(botaoOpcoes)) {
            botaoOpcoes.setCurrFrame(1);
        }else
            botaoOpcoes.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        botaoNovoJogo.draw();
        botaoCarregarJogo.draw();
        botaoOpcoes.draw();
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if (mouse.isOverObject(botaoNovoJogo)) {
                Motor.getInstancia().setProxTela(Constantes.TELA_NOVO_JOGO);
            }else
                if(mouse.isOverObject(botaoVoltar)){
                    Motor.getInstancia().setProxTela(Constantes.TELA_INICIAL);
                }else
                    if(mouse.isOverObject(botaoOpcoes))
                        Motor.getInstancia().setProxTela(Constantes.TELA_OPCOES);
        }
    }
    
}
