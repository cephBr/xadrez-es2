/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadresii;

import Interface.SplashScreen;

/**
 *
 * @author Ceph
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        new Thread(new SplashScreen()).start();
    }
}
