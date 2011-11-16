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
   
    Sprite botaoEstatistica;
    Sprite botaoVoltar;
    
    public void carregar() {
        fundo = new GameImage(Constantes.MENU_PRINCIPAL);
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        
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
        
        botaoEstatistica = null;
        botaoVoltar = null ;
    }

    public void logica() {
         
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
                
        }
    }
    
}
