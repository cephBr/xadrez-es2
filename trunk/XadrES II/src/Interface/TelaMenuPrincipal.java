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
public class TelaMenuPrincipal implements InterfaceTela {
    GameImage fundo;
    Font fonte;
    Keyboard keyboard;
    Mouse mouse;
    Sprite botaoJogar;
    Sprite botaoSair;
    Sprite botaoAjuda;
    
    public void carregar() {
       fundo =  new GameImage(Constantes.MENU_PRINCIPAL); 
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
       botaoAjuda=new Sprite(Constantes.BOTAO_AJUDA,2);
       botaoAjuda.setPosition(250, 450);
       botaoAjuda.setInitialFrame(0);
       botaoAjuda.setFinalFrame(1);
       
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
        
        if (mouse.isOverObject(botaoAjuda)) {
            botaoAjuda.setCurrFrame(1);
            
        }else
            botaoAjuda.setCurrFrame(0);
        
        
    }

    public void desenhar() {
        fundo.draw();
        botaoJogar.draw(); 
        botaoSair.draw();
        botaoAjuda.draw();
        
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if(mouse.isOverObject(botaoJogar))
                Motor.getInstancia().setProxTela(Constantes.TELA_JOGAR);
            else 
                if(mouse.isOverObject(botaoAjuda))
                    Motor.getInstancia().setProxTela(Constantes.TELA_AJUDA);
                else
                    if(mouse.isOverObject(botaoSair))
                        Motor.getInstancia().sair();
         }
        
    }
    
}
