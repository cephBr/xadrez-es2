/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author me
 */
public interface InterfaceTela { 
        
    /**
     * Responsável pela criação dos objetos a serem usados na tela.
     */
    void carregar();
    
    /**
     * Reponsável pelo descarregamento dos objetos.
     */
    void descarregar();
    
    /**
     * Responsável pela lógica que compõe a tela
     */
    void logica();    
    
    /**
     * Reponsável por realizar o desenho dos objetos na tela.
     */
    void desenhar();

    /**
     * Responsável por dizer ao motor qual a próxima tela a ser executada quando
     * ocorrer determinado evento.
     */    
    void proxTela();
}
