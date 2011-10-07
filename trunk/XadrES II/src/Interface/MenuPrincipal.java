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
import java.awt.Font;

/**
 *
 * @author Ceph
 */
public class MenuPrincipal implements InterfaceTela {
    GameImage fundo = new GameImage(Constantes.MENU_PRINCIPAL);
    Font fonte;
    Keyboard keyboard;
    Mouse mouse;
    Sprite botaoJogar;
    Sprite botaoSair;
    public void carregar() {
       keyboard = Motor.getInstancia().getJanela().getKeyboard();
       mouse = Motor.getInstancia().getJanela().getMouse();
       botaoJogar = new Sprite(Constantes.BOTAO_JOGAR,2);
       botaoJogar.setPosition(250, 400);
       botaoJogar.setInitialFrame(0);
       botaoJogar.setFinalFrame(1);
       botaoSair = new Sprite(Constantes.BOTAO_SAIR,2);
       botaoSair.setPosition(250, 500);
       botaoSair.setInitialFrame(0);
       botaoSair.setFinalFrame(1);
    }

    public void descarregar() {
        fundo=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoJogar)) {
            botaoJogar.setCurrFrame(1);
        }else
            botaoJogar.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoSair)) {
            botaoSair.setCurrFrame(1);
            
        }else
            botaoSair.setCurrFrame(0);
        
        
    }

    public void desenhar() {
        fundo.draw();
        botaoJogar.draw(); 
        botaoSair.draw();
        
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed() && mouse.isOverObject(botaoJogar)) {
            Motor.getInstancia().setProxTela(Constantes.TELA_JOGO);
        }
        
    }
    
}
