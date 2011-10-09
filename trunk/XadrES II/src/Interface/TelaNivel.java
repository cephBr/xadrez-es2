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
public class TelaNivel implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoFacil;
    Sprite botaoMedio;
    Sprite botaoDificil;
    Sprite botaoVoltar;
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        botaoFacil = new Sprite(Constantes.BOTAO_FACIL, 2);
        botaoFacil.setPosition(250,350);
        botaoFacil.setInitialFrame(0);
        botaoFacil.setFinalFrame(1);
        botaoMedio = new Sprite(Constantes.BOTAO_MEDIO, 2);
        botaoMedio.setPosition(250,400);
        botaoMedio.setInitialFrame(0);
        botaoMedio.setFinalFrame(1);
        botaoDificil = new Sprite(Constantes.BOTAO_DIFICIL, 2);
        botaoDificil.setPosition(250,450);
        botaoDificil.setInitialFrame(0);
        botaoDificil.setFinalFrame(1);
        botaoVoltar = new Sprite(Constantes.BOTAO_VOLTAR, 2);
        botaoVoltar.setPosition(250,500);
        botaoVoltar.setInitialFrame(0);
        botaoVoltar.setFinalFrame(1);
    }

    public void descarregar() {
        fundo=null;
        botaoFacil=null;
        botaoMedio=null;
        botaoDificil=null;
        botaoVoltar=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoFacil)) 
            botaoFacil.setCurrFrame(1);
        else
            botaoFacil.setCurrFrame(0);
        if(mouse.isOverObject(botaoMedio))
            botaoMedio.setCurrFrame(1);
        else
            botaoMedio.setCurrFrame(0);
        if(mouse.isOverObject(botaoDificil))
            botaoDificil.setCurrFrame(1);
        else
            botaoDificil.setCurrFrame(0);
        if (mouse.isOverObject(botaoVoltar)) 
            botaoVoltar.setCurrFrame(1);
        else
            botaoVoltar.setCurrFrame(0);
        
    }

    public void desenhar() {
        fundo.draw();
        botaoFacil.draw();
        botaoMedio.draw();
        botaoDificil.draw();
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if (mouse.isOverObject(botaoVoltar)) {
                Motor.getInstancia().setProxTela(Constantes.TELA_OPCOES);
            }
        }
    }
    
}
