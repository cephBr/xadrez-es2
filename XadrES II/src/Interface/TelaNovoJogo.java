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
public class TelaNovoJogo implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoP1vsP2;
    Sprite botaoP1vsCpu;
    Sprite botaoVoltar;
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        botaoP1vsCpu = new Sprite(Constantes.BOTAO_P1_VS_CPU, 2);
        botaoP1vsP2 = new Sprite(Constantes.BOTAO_P1_VS_P2,2);
        botaoVoltar = new Sprite(Constantes.BOTAO_VOLTAR,2);
        botaoP1vsP2.setPosition(250, 450);
        botaoP1vsCpu.setPosition(250,400);
        botaoVoltar.setPosition(250, 500);
        botaoP1vsP2.setInitialFrame(0);
        botaoP1vsCpu.setInitialFrame(0);
        botaoVoltar.setInitialFrame(0);
        botaoP1vsP2.setFinalFrame(1);
        botaoP1vsCpu.setFinalFrame(1);
        botaoVoltar.setFinalFrame(1);
                
    }

    public void descarregar() {
        fundo=null;
        botaoP1vsCpu=null;
        botaoP1vsP2=null;
        botaoVoltar=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoP1vsP2)) {
            botaoP1vsP2.setCurrFrame(1);
        }else
            botaoP1vsP2.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoP1vsCpu)) {
            botaoP1vsCpu.setCurrFrame(1);
        }else
            botaoP1vsCpu.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        botaoP1vsCpu.draw();
        botaoP1vsP2.draw();
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if (mouse.isOverObject(botaoP1vsCpu)) {
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGO);
            }else
                if(mouse.isOverObject(botaoP1vsP2)){
                    Motor.getInstancia().setProxTela(Constantes.TELA_JOGO);
                }else
                    if(mouse.isOverObject(botaoVoltar))
                        Motor.getInstancia().setProxTela(Constantes.TELA_JOGAR);
    
        }
    }    
        
}
