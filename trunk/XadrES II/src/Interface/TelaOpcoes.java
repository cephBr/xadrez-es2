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
   
    Sprite botaoHistorico;
    Sprite botaoVoltar;
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        
        botaoHistorico = new Sprite(Constantes.BOTAO_ESTATISTICAS,2);
        botaoHistorico.setPosition(250,450);
        botaoHistorico.setInitialFrame(0);
        botaoHistorico.setFinalFrame(1);
        botaoVoltar = new Sprite(Constantes.BOTAO_VOLTAR,2);
        botaoVoltar.setPosition(250,500);
        botaoVoltar.setInitialFrame(0);
        botaoVoltar.setFinalFrame(1);
        
    }

    public void descarregar() {
        fundo = null ;
        
        botaoHistorico = null;
        botaoVoltar = null ;
    }

    public void logica() {
         
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoHistorico)) {
            botaoHistorico.setCurrFrame(1);
        }else
            botaoHistorico.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        //botaoEstatistica.draw();
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if (mouse.isOverObject(botaoVoltar)) {
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGAR);
            }else
                if(mouse.isOverObject(botaoHistorico))
                    Motor.getInstancia().setProxTela(Constantes.TELA_HISTORICO);
                
        }
    }
    
}
