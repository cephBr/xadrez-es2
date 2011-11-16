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
public class TelaHistorico implements InterfaceTela {
    GameImage fundo;
    Mouse mouse;
    Keyboard teclado;
    Sprite botaoVoltar;
    Font fonte;
    Window janela;
    public void carregar() {
       janela=Motor.getInstancia().getJanela(); 
       fundo = new GameImage(Constantes.TELA_PRETA);
       mouse = Motor.getInstancia().getJanela().getMouse();
       teclado = Motor.getInstancia().getJanela().getKeyboard();
       botaoVoltar=new Sprite(Constantes.BOTAO_VOLTAR, 2);
       botaoVoltar.setPosition(250,500);
       botaoVoltar.setInitialFrame(0);
       botaoVoltar.setFinalFrame(1);
       fonte = new Font("Arial", Font.ITALIC, 50);
       
    }

    public void descarregar() {
        fundo=null;
        botaoVoltar=null;
        fonte=null;
    }

    public void logica() {
        if (mouse.isOverObject(botaoVoltar)) {
            botaoVoltar.setCurrFrame(1);
        }else
            botaoVoltar.setCurrFrame(0);
    }

    public void desenhar() {
        fundo.draw();
        janela.drawText("Estatísticas", 250, 100, Color.RED, fonte);
        botaoVoltar.draw();
    }

    public void proxTela() {
        if (mouse.isLeftButtonPressed()) {
            if(mouse.isOverObject(botaoVoltar))
                Motor.getInstancia().setProxTela(Constantes.TELA_OPCOES);
        }
    }
    
}
