/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Window;
import Parametros.Buffer;
import Parametros.Contexto;
import Parametros.Parametros;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * Classe responsável pela execução da Tela do jogo.
 * @author me
 */
public class Motor {
    Window janela;
    Hashtable telas;
    boolean promocaoAtiva = false;
    boolean executando;
    static Motor instancia;
    Parametros parametros = new Parametros();    
    Buffer buffer = new Buffer();
    Contexto contexto = new Contexto(buffer);
    Boolean isJogoCarregado = false;
    String promovidoPara;
    Boolean pausado=false;
    
    public void pausar() {
        int i=0;
        pausado=true;
        while(pausado){
           i++;
        }
    }
    
    public void despausar () {
		this.pausado = false;
                
    }
    public String getPromovidoPara() {
        return promovidoPara;
    }

    public void setPromovidoPara(String promovidoPara){
        this.promovidoPara = promovidoPara;
    }
    
    
    
    public boolean isPromocaoAtiva() {
        return promocaoAtiva;
    }

    public void setPromocaoAtiva(boolean promocaoAtiva) {
        this.promocaoAtiva = promocaoAtiva;
    }

    
    
    public Boolean getIsJogoCarregado() {
        return isJogoCarregado;
    }

    public void setIsJogoCarregado(Boolean isJogoCarregado) {
        this.isJogoCarregado = isJogoCarregado;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }
    
    
    
    /**
     * Tela que está sendo executada.
     */
    InterfaceTela telaCorrente;
    
    /**
     * Tela que será executada, essa variável existe para que quando houver uma
     * troca de telas o conteúdo da tela anterior seja descarregado da memória.
     */    
    InterfaceTela proxTela;
    
    
    /**     
     * Cria uma janela e a apresenta na tela.
     * @param largura largura da janela em pixels.
     * @param altura algura da janela em pixels.
     */    
    
    /**
     * Construtor da classe
     */
    public Motor(){
        telas = new Hashtable();
        executando = true;
        instancia = this;
    }
    
    
    /**
     * Retorna a instância corrente do objeto Motor.
     * @return Motor
     */
    public static Motor getInstancia(){
        if (instancia == null)
            instancia = new Motor();
        return instancia;
    }
    
    
    /**
     * Cria uma janela com as dimenões passadas como parâmetro.
     * @param largura
     * @param altura 
     */
    public void criarJanela(int largura, int altura){
        janela = new Window(largura, altura);
    }
    
    
    
    /**
     * Adiciona uma tela ao conjunto de telas que serão executadas.
     * 
     * @param id Identificar da tela, o qual é um número inteiro.
     * @param tela Instância do objeto tela.
     */
    public void addTela(int id, InterfaceTela tela){
        telas.put(id, tela);
    }
    
    
    /**
     * Remove a tela identificada pelo seu id do conjunto de telas.
     * @param id Identificador da tela, o qual é um número inteiro.
     */
    public void removerTela(int id){
        telas.get(id);
    }
    
    
    /**
     * Seta a próxima tela que deve ser executada.
     * @param id Identificador da tela, o qual é um número inteiro.
     */
    public void setProxTela(int id){
        proxTela = (InterfaceTela) telas.get(id);
    }
    
    
    /**
     * Set a tela que deve ser executada primeiro.
     * @param id Identificador da tela, o qual é um número inteiro.     
     */    
    public void setTelaInicial(int id){
        telaCorrente = (InterfaceTela) telas.get(id);
    }
    
    
    /**
     * Pára a execução do jogo.
     */    
    public void sair(){
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
                if (op == JOptionPane.OK_OPTION)
                     executando = false;
    }
    
    
    /**
     * Retorna a instância da janela que está sendo usada.
     * @return Window
     */
    public Window getJanela(){
        return janela;
    }
    
    
    /**
     * Inicia a execução do jogo em si.
     */    
    public void rodar() throws Exception
    {
        Keyboard teclado;
        Mouse mouse;
        TelaJogo telaJogo = new TelaJogo();
        if(telaCorrente == null)
            return;       
           
        executando = true;
        telaCorrente.carregar();        
        teclado = janela.getKeyboard();
        mouse = janela.getMouse();
        
        while(executando == true)
        {   
            
            telaCorrente.proxTela();
            telaCorrente.logica();            
            telaCorrente.desenhar();
            janela.display();   
            
            if(proxTela != null)
            {
                
                telaCorrente.descarregar();
                proxTela.carregar();

                telaCorrente = proxTela;
                proxTela = null;
            }
            //boolean xequeMate = telaJogo.avisaSobreXeque();
            
            if (teclado.keyDown(Keyboard.ESCAPE_KEY)){
                this.sair();
            }
            
            
        }
        janela.exit();
    }
}
