/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametros;

import Interface.Casa;
import Interface.Motor;
import Interface.Peca;
import Interface.Tabuleiro;
import JPlay.Sprite;
import MaquinaRegras.Movimentacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Ceph
 */
public class Contexto {
    File diretorio = new File("../XadrES II/Jogos_Salvos/");
    Parametros p;
    Buffer buffer;
    int resposta;
    public Contexto(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void salvarJogo(Tabuleiro tabuleiro,String[] nomeJogadores,List pecas,Boolean temCpu){
        BufferedWriter arq;
        Calendar calendario = Calendar.getInstance();
        Movimentacao mov = new Movimentacao();
        File arquivo;
        traduzirFileChooser();  
        JFileChooser fc = new JFileChooser();  
        fc.setDialogTitle("Salvar Jogo");
        fc.setCurrentDirectory(diretorio);
        fc.setFileFilter(new FileFilter() {
         
            
            public boolean accept(File f) {
               return f.getName().toLowerCase().endsWith(".xad") || f.isDirectory();
            }

            
            public String getDescription() {
                return "Jogos Salvos (.xad)";
            }
        });
        resposta = fc.showSaveDialog(null);
        if(resposta == JFileChooser.APPROVE_OPTION){
            
            arquivo = fc.getSelectedFile();
            if(!arquivo.exists()){
              try {
                 arquivo = new File(arquivo.getAbsolutePath()+".xad"); 
                 arquivo.createNewFile();
            
               } catch (IOException ex) {
                  Logger.getLogger(Contexto.class.getName()).log(Level.SEVERE, null, ex);
               }
            }else{
                   JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sobrescrever o arquivo?", "O arquivo já existe!", JOptionPane.OK_CANCEL_OPTION); 
                 }
            try {
                arq =  new BufferedWriter(new FileWriter(arquivo));
                arq.write(calendario.get(Calendar.DAY_OF_MONTH)+";");
                arq.write(calendario.get(Calendar.MONTH)+";");
                arq.write(calendario.get(Calendar.YEAR)+";");
                arq.write(calendario.get(Calendar.HOUR)+";");
                arq.write(calendario.get(Calendar.MINUTE)+";");
                arq.write(Motor.getInstancia().getParametros().vezDeQuem()+";");
                arq.write(temCpu.toString()+";");
                arq.write(nomeJogadores[0]+";");
                if(!temCpu){
                    arq.write(nomeJogadores[1]+";");
                }
                //SEÇÂO RELATIVA AS PEÇAS
                Integer qtdPecas =pecas.size();
                arq.write(qtdPecas.toString()+";"); //quantidades de peças restantes
                for (Iterator it = pecas.iterator(); it.hasNext();) {
                    Peca p = (Peca) it.next();
                    arq.write(p.id+";");
                    arq.write(p.cor+";");
                    arq.write(p.ativa.toString()+";");
                    arq.write(p.foiMexida.toString()+";");
                    arq.write(p.selecionada.toString()+";");
                    arq.write(p.comp_X+";");
                    arq.write(p.comp_Y+";");
                    arq.write(p.posX+";");
                    arq.write(p.posY+";");
                    switch (mov.retornaTipoPeca(p.id)){
                        case 0 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.PEAO_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.PEAO_PRETO+";");
                                  }
                                  break;
                                }
                        case 1 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.TORRE_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.TORRE_PRETO+";");
                                  }
                                  break;
                                }
                        case 2 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.BISPO_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.BISPO_PRETO+";");
                                  }
                                  break;
                                 
                                }
                        case 3 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.CAVALO_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.CAVALO_PRETO+";");
                                  }
                                  break;
                            
                                }
                        case 4 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.DAMA_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.DAMA_PRETO+";");
                                  }
                                  break;
                                }
                        case 5 :{
                                  if (p.cor.equals(Constantes.BRANCO)){
                                      arq.write(Constantes.REI_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.REI_PRETO+";");
                                  }
                                  break;
                                }    
                    }
                } //end for
                
                //SEÇÂO RETATIVA AO TABULEIRO
                
                arq.write(tabuleiro.ultimaPeça.id+";");
                arq.write(tabuleiro.ultimaPeça.cor+";");
                arq.write(tabuleiro.ultimaPeça.ativa.toString()+";");
                arq.write(tabuleiro.ultimaPeça.foiMexida.toString()+";");
                arq.write(tabuleiro.ultimaPeça.selecionada.toString()+";");
                arq.write(tabuleiro.ultimaPeça.comp_X+";");
                arq.write(tabuleiro.ultimaPeça.comp_Y+";");
                arq.write(tabuleiro.ultimaPeça.posX+";");
                arq.write(tabuleiro.ultimaPeça.posY+";");
                switch (mov.retornaTipoPeca(tabuleiro.ultimaPeça.id)){
                        case 0 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)){ 
                                      arq.write(Constantes.PEAO_BRANCO+";");
                                  }
                                  else{
                                      arq.write(Constantes.PEAO_PRETO+";");
                                  }
                                  break;
                                }
                        case 1 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)) {
                                      arq.write(Constantes.TORRE_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.TORRE_PRETO+";");
                                  }
                                  break;
                                }
                        case 2 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)) {
                                      arq.write(Constantes.BISPO_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.BISPO_PRETO+";");
                                  }
                                  break;
                                }
                        case 3 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)) {
                                      arq.write(Constantes.CAVALO_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.CAVALO_PRETO+";");
                                  }
                                  break;
                                }
                        case 4 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)) {
                                      arq.write(Constantes.DAMA_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.DAMA_PRETO+";");
                                  }    
                                  break;
                                }
                        case 5 :{
                                  if (tabuleiro.ultimaPeça.cor.equals(Constantes.BRANCO)) {
                                      arq.write(Constantes.REI_BRANCO+";");
                                  }else{
                                      arq.write(Constantes.REI_PRETO+";");
                                  }
                                  break;
                                }    
                    }
                    for (int j = 0; j <= 7; j++) {
                        for (int i = 0; i <= 7; i++) {
                              arq.write(tabuleiro.tabuleiro[j][i].ocupada.toString()+";");
                              if(tabuleiro.tabuleiro[j][i].peca!=null)
                                  arq.write(tabuleiro.tabuleiro[j][i].peca.id+";");
                              else
                                   arq.write(-1+";");
                        }
                    }
                    arq.close();
                    JOptionPane.showMessageDialog(null, "Jogo Salvo com Sucesso!", "Salvar Jogo", JOptionPane.INFORMATION_MESSAGE);                    
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o arquivo", "Erro", JOptionPane.OK_OPTION);
              }
              catch (IOException e){
                  
              }
            
       }
      
    }
    
    public void carregarJogo(){
        BufferedReader leitor;
        p=Motor.getInstancia().getParametros();
        traduzirFileChooser();  
        JFileChooser fc = new JFileChooser();  
        fc.setDialogTitle("Carregar Jogo");
        fc.setCurrentDirectory(diretorio);
        fc.setFileFilter(new FileFilter() {
        public boolean accept(File f) {
               return f.getName().toLowerCase().endsWith(".xad") || f.isDirectory();
            }

            
            public String getDescription() {
                return "Jogos Salvos (.xad)";
            }
        });
        resposta = fc.showDialog(null, "Carregar");
        if (resposta==fc.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            try {
                
                leitor = new BufferedReader(new FileReader(arquivo));
                StringTokenizer token = new StringTokenizer(leitor.readLine(), ";");
                buffer.setData(token.nextToken()+"/"+token.nextToken()+'/'+token.nextToken());
                buffer.setHora(token.nextToken()+":"+token.nextToken());
                buffer.setVezDeQuem(token.nextToken());
                p.setTemCpu(Boolean.parseBoolean(token.nextToken()));
                p.setNomeJogador1(token.nextToken());
                if(!p.temCpu())
                    p.setNomeJogador2(token.nextToken());
                Motor.getInstancia().setParametros(p);
                //Carregamento das pecas
                int qtdPecas = Integer.parseInt(token.nextToken());
                List<Peca> pecas = new ArrayList<Peca>();
                for (int i = 0; i <= qtdPecas-1; i++) {
                    Peca p = new Peca();
                    p.id=Integer.parseInt(token.nextToken());
                    p.cor=token.nextToken();
                    p.ativa=Boolean.parseBoolean(token.nextToken());
                    p.foiMexida=Boolean.parseBoolean(token.nextToken());
                    p.selecionada=Boolean.parseBoolean(token.nextToken());
                    p.comp_X=Integer.parseInt(token.nextToken());
                    p.comp_Y=Integer.parseInt(token.nextToken());
                    p.posX=Integer.parseInt(token.nextToken());
                    p.posY=Integer.parseInt(token.nextToken());
                    p.sprite = new Sprite(token.nextToken(),2);
                    p.sprite.setInitialFrame(0);
                    p.sprite.setFinalFrame(1);
                    pecas.add(p);
                }
                buffer.setPecas(pecas);
                
                //Carregamento do tabuleiro
                Tabuleiro t = new Tabuleiro(8, 8, Constantes.TABULEIRO);
                Peca p = new Peca();
                p.id=Integer.parseInt(token.nextToken());
                p.cor=token.nextToken();
                p.ativa=Boolean.parseBoolean(token.nextToken());
                p.foiMexida=Boolean.parseBoolean(token.nextToken());
                p.selecionada=Boolean.parseBoolean(token.nextToken());
                p.comp_X=Integer.parseInt(token.nextToken());
                p.comp_Y=Integer.parseInt(token.nextToken());
                p.posX=Integer.parseInt(token.nextToken());
                p.posY=Integer.parseInt(token.nextToken());
                p.sprite = new Sprite(token.nextToken(),2);
                p.sprite.setInitialFrame(0);
                p.sprite.setFinalFrame(1);
                
                t.ultimaPeça=p;
                for (int j = 0; j <= 7; j++) {
                        for (int i = 0; i <= 7; i++) {
                             Casa c = new Casa();
                             c.ocupada=Boolean.parseBoolean(token.nextToken());
                             int id =Integer.parseInt(token.nextToken());
                             if(id==-1)
                                 c.peca=null;
                             else
                                 c.peca=this.retornaPecasLista(id);    
                             t.tabuleiro[j][i]=c;
                        }
                }            
                buffer.tabuleiro=t;
                
            leitor.close();
            Motor.getInstancia().setIsJogoCarregado(Boolean.TRUE);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Contexto.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                    Logger.getLogger(Contexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getResposta() {
        return resposta;
    }
    
    private void traduzirFileChooser(){    
               
       UIManager.put("FileChooser.lookInLabelMnemonic", "E");      
       UIManager.put("FileChooser.lookInLabelText", "Examinar em");    
               
       UIManager.put("FileChooser.saveInLabelMnemonic", "S");    
       UIManager.put("FileChooser.saveInLabelText", "Salvar em");    
               
       UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");    
       UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");     
               
       UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");    
       UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");     
       
       UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");    
       UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");     
               
       UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");     
       UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");     
              
       UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");     
       UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");     
      
       UIManager.put("FileChooser.fileNameLabelMnemonic", "N");    
       UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");     
               
       UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "A");    
       UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo");     
       
       UIManager.put("FileChooser.fileNameHeaderText", "Nome");    
       UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");    
       UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");    
       UIManager.put("FileChooser.fileDateHeaderText", "Data");    
       UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");    
               
       UIManager.put("FileChooser.cancelButtonText", "Cancelar");    
       UIManager.put("FileChooser.cancelButtonMnemonic", "C");    
       UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");    
              
       UIManager.put("FileChooser.openButtonText", "Abrir");    
       UIManager.put("FileChooser.openButtonMnemonic", "A");    
       UIManager.put("FileChooser.openButtonToolTipText", "Abrir");    
               
       UIManager.put("FileChooser.saveButtonText","Salvar");    
       UIManager.put("FileChooser.saveButtonToolTipText", "S");    
       UIManager.put("FileChooser.saveButtonToolTipText", "Salvar");    
               
       UIManager.put("FileChooser.updateButtonText","Alterar");    
       UIManager.put("FileChooser.updateButtonToolTipText", "A");    
       UIManager.put("FileChooser.updateButtonToolTipText", "Alterar");    
               
       UIManager.put("FileChooser.helpButtonText","Ajuda");    
       UIManager.put("FileChooser.helpButtonToolTipText", "A");    
       UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");    
               
       UIManager.put("FileChooser.acceptAllFileFilterText","Todos os arquivos");    
   }   
   
   
   private Peca retornaPecasLista(int idPeca) throws IOException{
       Peca peca=null;
       
       for (Iterator it = buffer.pecas.iterator(); it.hasNext();) {
           Peca p = (Peca)it.next();
           if(p.id==idPeca)
               peca=p;
       }
       
       return peca;
   }
   
}
