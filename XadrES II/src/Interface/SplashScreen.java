/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SplashScreen.java
 *
 * Created on 09/10/2011, 17:46:15
 */
package Interface;

import Parametros.Constantes;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ceph
 */
public class SplashScreen extends javax.swing.JFrame implements Runnable {

    
    private boolean fechou = false;
    public SplashScreen() {
        initComponents();
    }
    
    private void iniciarMotor() throws Exception{
             Motor motor = new Motor();
             motor.criarJanela(Constantes.DIM_TABULEIRO_HORIZONTAL, Constantes.DIM_TABULEIRO_VERTICAL);
             motor.addTela(Constantes.TELA_INICIAL, new TelaMenuPrincipal());
             motor.setTelaInicial(Constantes.TELA_INICIAL);
             motor.addTela(Constantes.TELA_JOGO, new TelaJogo());
             motor.addTela(Constantes.TELA_AJUDA, new TelaAjuda());
             motor.addTela(Constantes.TELA_JOGAR, new TelaJogar());
             motor.addTela(Constantes.TELA_NOVO_JOGO, new TelaNovoJogo());
        try {
            motor.rodar();
        } catch (Exception ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xadrez.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

        public void run() {
         try{
           this.setLocationRelativeTo(null);
           this.setVisible(true);
           Thread.sleep(Constantes.TEMPO);
           if (!fechou){
               this.dispose();
                try {
                    iniciarMotor();
                } catch (Exception ex) {
                    Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
         } catch (InterruptedException ex) {
            System.out.println("ERRO");
         }

    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
