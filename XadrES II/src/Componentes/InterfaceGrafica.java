/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sound;
import JPlay.Window;
import Parametros.Constantes;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceph
 */
public class InterfaceGrafica {
        Tabuleiro tabuleiro;
        //time branco
        Peça peça1,peça2,peça3,peça4,peça5,peça6,peça7,peça8,
             peça9, peça10,peça11,peça12,peça13,peça14,peça15,peça16;
        
        //time preto
        Peça peça17,peça18,peça19,peça20,peça21,peça22,peça23,peça24,
             peça25,peça26,peça27,peça28,peça29,peça30,peça31,peça32;   
        
        Window janela;
        Keyboard keyboard;
        Mouse mouse;
        boolean executando;
    

    public InterfaceGrafica(){
        carregaDados();
        loop();
        encerrarJogo();
    }
     private void carregaDados(){
         janela = new Window(Constantes.DIM_TABULEIRO_HORIZONTAL,Constantes.DIM_TABULEIRO_VERTICAL);
         keyboard = janela.getKeyboard();
         keyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard. DETECT_INITIAL_PRESS_ONLY);
         mouse = janela.getMouse();
         tabuleiro = new Tabuleiro(8,8,Constantes.TABULEIRO);
         peça1 = new Peça(1,"teste1",Constantes.RAINHA,2,119,113,0,0);
         tabuleiro.setPeça(0, 0, peça1);
         peça2 = new Peça(2,"teste2",Constantes.RAINHA,2,173,113,1,0);
         tabuleiro.setPeça(1, 0, peça2);
         peça3 = new Peça(3,"teste3",Constantes.RAINHA,2,229,113,2,0);
         tabuleiro.setPeça(2, 0, peça3);
         peça4 = new Peça(4,"teste4",Constantes.RAINHA,2,285,113,3,0);
         tabuleiro.setPeça(3, 0, peça4);
         peça5 = new Peça(5,"teste5",Constantes.RAINHA,2,339,113,4,0);
         tabuleiro.setPeça(4, 0, peça5);
         peça6 = new Peça(6,"teste6",Constantes.RAINHA,2,395,113,5,0);
         tabuleiro.setPeça(6, 0, peça6);
         peça7 = new Peça(7,"teste7",Constantes.RAINHA,2,450,113,6,0);
         tabuleiro.setPeça(6,0, peça7);
         peça8 = new Peça(8,"teste8",Constantes.RAINHA,2,506,113,7,0);
         tabuleiro.setPeça(7,0, peça8);
         peça9 = new Peça(9,"teste9",Constantes.RAINHA,2,115,158,0,1);
         tabuleiro.setPeça(0,1, peça9);
         peça10 = new Peça(10,"teste10",Constantes.RAINHA,2,171,158,1,1);
         tabuleiro.setPeça(1,1, peça10);
         peça11 = new Peça(11,"teste11",Constantes.RAINHA,2,228,158,2,1);
         tabuleiro.setPeça(2,1, peça11);
         peça12 = new Peça(12,"teste12",Constantes.RAINHA,2,284,158,3,1);
         tabuleiro.setPeça(3,1, peça12);
         peça13 = new Peça(13,"teste13",Constantes.RAINHA,2,341,158,4,1);
         tabuleiro.setPeça(4,1, peça13);
         peça14 = new Peça(14,"teste14",Constantes.RAINHA,2,396,158,5,1);
         tabuleiro.setPeça(6,1, peça14);
         peça15 = new Peça(15,"teste15",Constantes.RAINHA,2,451,158,6,1);
         tabuleiro.setPeça(6,1, peça15);
         peça16 = new Peça(16,"teste16",Constantes.RAINHA,2,508,158,7,1);
         tabuleiro.setPeça(7,1, peça16);
         peça17 = new Peça(17,"teste17",Constantes.RAINHA,2,99,412,0,6);
         tabuleiro.setPeça(0,6, peça17);
         peça18 = new Peça(18,"teste18",Constantes.RAINHA,2,159,412,1,6);
         tabuleiro.setPeça(1,6, peça18);
         peça19 = new Peça(19,"teste19",Constantes.RAINHA,2,220,412,2,6);
         tabuleiro.setPeça(2,6, peça19);
         peça20 = new Peça(20,"teste20",Constantes.RAINHA,2,281,412,3,6);
         tabuleiro.setPeça(3,6, peça20);
         peça21 = new Peça(21,"teste21",Constantes.RAINHA,2,341,412,4,6);
         tabuleiro.setPeça(4,6, peça21);
         peça22 = new Peça(22,"teste22",Constantes.RAINHA,2,404,412,5,6);
         tabuleiro.setPeça(6,6, peça22);
         peça23 = new Peça(23,"teste23",Constantes.RAINHA,2,464,412,6,6);
         tabuleiro.setPeça(6,6, peça23);
         peça24 = new Peça(24,"teste24",Constantes.RAINHA,2,526,412,7,6);
         tabuleiro.setPeça(7,6, peça24);
         peça25 = new Peça(25,"teste25",Constantes.RAINHA,2,94,471,0,7);
         tabuleiro.setPeça(0,7, peça25);
         peça26 = new Peça(26,"teste26",Constantes.RAINHA,2,157,471,1,7);
         tabuleiro.setPeça(1,7, peça26);
         peça27 = new Peça(27,"teste27",Constantes.RAINHA,2,220,471,2,7);
         tabuleiro.setPeça(2,7, peça27);
         peça28 = new Peça(28,"teste28",Constantes.RAINHA,2,281,471,3,7);
         tabuleiro.setPeça(3,7, peça28);
         peça29 = new Peça(29,"teste29",Constantes.RAINHA,2,343,471,4,7);
         tabuleiro.setPeça(4,7, peça29);
         peça30 = new Peça(30,"teste30",Constantes.RAINHA,2,405,471,5,7);
         tabuleiro.setPeça(6,7, peça30);
         peça31 = new Peça(31,"teste31",Constantes.RAINHA,2,467,471,6,7);
         tabuleiro.setPeça(6,7, peça31);
         peça32 = new Peça(32,"teste32",Constantes.RAINHA,2,529,471,7,7);
         tabuleiro.setPeça(7,7, peça32);
         executando = true;
   }
   

    private void monitorPeça(Peça p) throws Exception{
     

                if(p.estaSelecionada()){
                    if (!mouse.isOverObject(p.sprite)) {
                        tabuleiro.ocupar(tabuleiro.coordenadaX(mouse.getPosition().x, mouse.getPosition().y),tabuleiro.coordenadaY(mouse.getPosition().x, mouse.getPosition().y), p);
                        p.sprite.reset();
                    }
                }

               if(mouse.isOverObject(p.sprite)){
                    if(!p.estaSelecionada()) {
                            p.selecionar();
                    }else{
                            p.selecionada=false;
                            p.sprite.reset();
                        }
                    }
           }
       

    public void atualiazações(){
          try {
            if (mouse.isLeftButtonPressed()==true) {
                monitorPeça(peça1);
                monitorPeça(peça2);
                monitorPeça(peça3);
                monitorPeça(peça4);
                monitorPeça(peça5);
                monitorPeça(peça6);
                monitorPeça(peça7);
                monitorPeça(peça8);
                monitorPeça(peça9);
                monitorPeça(peça10);
                monitorPeça(peça11);
                monitorPeça(peça12);
                monitorPeça(peça13);
                monitorPeça(peça14);
                monitorPeça(peça15);
                monitorPeça(peça16);
                monitorPeça(peça17);
                monitorPeça(peça18);
                monitorPeça(peça19);
                monitorPeça(peça20);
                monitorPeça(peça21);
                monitorPeça(peça22);
                monitorPeça(peça23);
                monitorPeça(peça24);
                monitorPeça(peça25);
                monitorPeça(peça26);
                monitorPeça(peça27);
                monitorPeça(peça28);
                monitorPeça(peça29);
                monitorPeça(peça30);
                monitorPeça(peça31);
                monitorPeça(peça32);
            }
        }catch (Exception e){
            new Sound(Constantes.ERRO_SOM).play();
        }
          if ( keyboard.keyDown(Keyboard.ESCAPE_KEY) == true){
             int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
             if (op == JOptionPane.OK_OPTION)
                 executando = false;
          }
    }
    
    public void desenhar(int id){
           tabuleiro.fundo.draw();
           switch(id){
                case 1:{                    
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça1.sprite.draw();
                    break;
                }
                case 2:{
                    peça1.sprite.draw();                    
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça2.sprite.draw();
                    break;
                }
                case 3:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();                    
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça3.sprite.draw();
                    break;
                }
                case 4:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();                    
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça4.sprite.draw();
                    break;
                }
                case 5:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();                    
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça5.sprite.draw();
                    break;
                }
                case 6:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();                    
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça6.sprite.draw();
                    break;
                }
                case 7:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();                    
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça7.sprite.draw();
                    break;
                }
                case 8:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();                    
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça8.sprite.draw();                    
                    break;
                }
               case 9:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();                    
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça9.sprite.draw();
                   break;
               }
               case 10:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();                    
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça10.sprite.draw();                
                   break;
               }
               case 11:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();                    
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça11.sprite.draw();
                   break;
               }
               case 12:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();                    
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça12.sprite.draw();
                   break;
               }
               case 13:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();                    
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça13.sprite.draw();
                   break;
               }
               case 14:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();                    
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça14.sprite.draw();
                   break;   
               }
               case 15:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();                    
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça15.sprite.draw();
                   break;
               }
               case 16:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();                    
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça16.sprite.draw();
                   break;
               }
               case 17:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();                   
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça17.sprite.draw();
                   break;
               }
               case 18:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();                    
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça18.sprite.draw();
                   break;
               }
               case 19:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça19.sprite.draw();
                   break;
               }
               case 20:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();                    
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça20.sprite.draw();
                   break;
               }
               case 21:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();                    
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça21.sprite.draw();
                   break;
               }
               case 22:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();                    
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça22.sprite.draw();
                   break;
               }
               case 23:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();                    
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça23.sprite.draw();                    
                   break;
               }
               case 24:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();                    
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça24.sprite.draw();
                   break;
               }
               case 25:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();                    
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça25.sprite.draw();
                   break;
               }
               case 26:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();                    
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça26.sprite.draw();
                   break;
               }
               case 27:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();                    
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça27.sprite.draw();
                   break;
               }
               case 28:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();                    
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça28.sprite.draw();
                   break;
               }
               case 29:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();                    
                    peça30.sprite.draw();                   
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                    peça29.sprite.draw(); 
                    
                   break;
               }
               case 30:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();                    
                    peça29.sprite.draw();
                    peça31.sprite.draw();          
                    peça32.sprite.draw(); 
                    peça30.sprite.draw();
                    
                   break;
               }
               case 31:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();                    
                    peça32.sprite.draw();
                    peça31.sprite.draw();
                   break;
               }
               case 32:{
                    peça1.sprite.draw();
                    peça2.sprite.draw();
                    peça3.sprite.draw();
                    peça4.sprite.draw();
                    peça5.sprite.draw();
                    peça6.sprite.draw();
                    peça7.sprite.draw();
                    peça8.sprite.draw();
                    peça9.sprite.draw();
                    peça10.sprite.draw();
                    peça11.sprite.draw();
                    peça12.sprite.draw();
                    peça13.sprite.draw();
                    peça14.sprite.draw();
                    peça15.sprite.draw();
                    peça16.sprite.draw();
                    peça17.sprite.draw();
                    peça18.sprite.draw();
                    peça19.sprite.draw();
                    peça20.sprite.draw();
                    peça21.sprite.draw();
                    peça22.sprite.draw();
                    peça23.sprite.draw();
                    peça24.sprite.draw();
                    peça25.sprite.draw();
                    peça26.sprite.draw();
                    peça27.sprite.draw();
                    peça28.sprite.draw();
                    peça29.sprite.draw();
                    peça30.sprite.draw();
                    peça31.sprite.draw();
                    peça32.sprite.draw();
                   break;
               }
            }
            
   }
    
    private void loop(){
        while(executando)
        {
             desenhar(tabuleiro.retornaIdUltimaPeça());
             janela.display();
             atualiazações();
        }
    }

    private void encerrarJogo(){
      janela.exit();
    }
}
   
