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
public class TelaAjuda implements InterfaceTela {
    
    GameImage fundo; 
    Keyboard teclado;
    Mouse mouse;
    Sprite botaoRegras;
    Sprite botaoVoltar;
    
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        botaoRegras = new Sprite(Constantes.BOTAO_REGRAS,2);
        botaoRegras.setPosition(250,450);
        botaoRegras.setInitialFrame(0);
        botaoRegras.setFinalFrame(1);
        botaoVoltar= new Sprite(Constantes.BOTAO_VOLTAR,2);
        botaoVoltar.setPosition(250,500);
        botaoVoltar.setInitialFrame(0);
        botaoVoltar.setFinalFrame(1);
    }

    public void descarregar() {
        fundo=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoRegras)) {
            botaoRegras.setCurrFrame(1);
        }else
            botaoRegras.setCurrFrame(0);
        
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
        
       
    }

    public void desenhar() {
        fundo.draw();
        botaoRegras.draw(); 
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) 
            if(mouse.isOverObject(botaoVoltar))
               Motor.getInstancia().setProxTela(Constantes.TELA_INICIAL);
            else 
               if(mouse.isOverObject(botaoRegras)) 
                    Motor.getInstancia().setProxTela(Constantes.TELA_REGRAS);
    }
    
}
