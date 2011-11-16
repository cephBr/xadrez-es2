/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sprite;
import JPlay.Window;
import Parametros.Constantes;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Ceph
 */
public class TelaRegras implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoVoltar;
    Font fonte;
    Window janela;
    public void carregar() {
        janela = Motor.getInstancia().getJanela();
        mouse = Motor.getInstancia().getJanela().getMouse();
        teclado = Motor.getInstancia().getJanela().getKeyboard();
        fundo =  new GameImage(Constantes.TELA_PRETA);
        fonte = new Font("AR BERKLEY Thin",Font.BOLD, 50);;
        botaoVoltar = new Sprite(Constantes.BOTAO_VOLTAR, 2);
        botaoVoltar.setPosition(250,500);
        botaoVoltar.setInitialFrame(0);
        botaoVoltar.setInitialFrame(1);
        
    }

    public void descarregar() {
        fundo = null;
    }

    public void logica() {
       if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
            
        }else
            botaoVoltar.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        botaoVoltar.draw();
        janela.drawText("Regras", 200, 100, Color.RED,fonte);
        
    }

    public void proxTela() {
         if (mouse.isLeftButtonPressed()) 
            if(mouse.isOverObject(botaoVoltar))
               Motor.getInstancia().setProxTela(Constantes.TELA_AJUDA);
            
    
    }
    
}
