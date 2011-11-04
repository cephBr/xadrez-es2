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
public class TelaOpcoes implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoNivel;
    Sprite botaoEstatistica;
    Sprite botaoVoltar;
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        botaoNivel = new Sprite(Constantes.BOTAO_NIVEL,2); 
        botaoNivel.setPosition(250,400);
        botaoNivel.setInitialFrame(0);
        botaoNivel.setFinalFrame(1);
        botaoEstatistica = new Sprite(Constantes.BOTAO_ESTATISTICAS,2);
        botaoEstatistica.setPosition(250,450);
        botaoEstatistica.setInitialFrame(0);
        botaoEstatistica.setFinalFrame(1);
        botaoVoltar = new Sprite(Constantes.BOTAO_VOLTAR,2);
        botaoVoltar.setPosition(250,500);
        botaoVoltar.setInitialFrame(0);
        botaoVoltar.setFinalFrame(1);
        
    }

    public void descarregar() {
        fundo = null ;
        botaoNivel = null;
        botaoEstatistica = null;
        botaoVoltar = null ;
    }

    public void logica() {
         if (mouse.isOverObject(botaoNivel)) {
            botaoNivel.setCurrFrame(1);
        }else
            botaoNivel.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoEstatistica)) {
            botaoEstatistica.setCurrFrame(1);
        }else
            botaoEstatistica.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        botaoNivel.draw();
        //botaoEstatistica.draw();
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if (mouse.isOverObject(botaoVoltar)) {
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGAR);
            }else
                if(mouse.isOverObject(botaoEstatistica))
                    Motor.getInstancia().setProxTela(Constantes.TELA_ESTATISTICA);
                else
                    if(mouse.isOverObject(botaoNivel))
                        Motor.getInstancia().setProxTela(Constantes.TELA_NIVEL);
        }
    }
    
}
