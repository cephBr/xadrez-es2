/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import Interface.Tabuleiro;
import Interface.Peca;
import Interface.Casa;
import MaquinaRegras.Posicao;
import Parametros.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author leandrogaluzzi
 */
public class MiniMax {
    private FuncaoAvaliacao funcaoAvaliacao = new FuncaoAvaliacao();
    private FuncaoAvaliacaoIA funcaoAvaliacaoIA = new FuncaoAvaliacaoIA();
    
  
    
    public Peca copiarPeca(Peca peca){
        Peca auxPeca;
        auxPeca = peca;
        return auxPeca;
    }
    
    
    
    

    public List todasPosicoesValidas(Tabuleiro tab, String corLado){
        
        List<Movimento> arrayTodasPosicoes = new ArrayList<Movimento>();
        List<Posicao> arrayPeca = new ArrayList<Posicao>();
        
        Casa[][] casa;
        Movimento movimento;
      
        Posicao posFinal;
        
        
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if(null!=tab && tab.estaOcupado(i, j)){                   
                        Peca peca = tab.retornaPeca(i, j);
                        if(peca.retornaCor().equals(corLado)){  
                                casa = tab.retornaCasa(i, j);  
                            
                                arrayPeca = tab.mov.posicoesValidas(casa, peca); 
                                
                                if (!(arrayPeca.isEmpty())){
                                    
                                    for(int index=0;index<arrayPeca.size();index++){
                                      
                                        posFinal = arrayPeca.get(index);
                                        
                                        movimento = new Movimento(posFinal,peca);
                                        
                                        arrayTodasPosicoes.add(movimento);
                                    }   
                                }
                        }
                }
           
            }
        }
       
        return arrayTodasPosicoes;
    }
    
    public List todasPosicoesValidasIA(TabuleiroIA tab, String corLado){
        
        List<Movimento> arrayTodasPosicoes = new ArrayList<Movimento>();
        List<Posicao> arrayPeca = new ArrayList<Posicao>();
        
        Casa[][] casa;
        Movimento movimento;
      
        Posicao posFinal;
        
       
        
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                
                if(null!=tab && tab.estaOcupado(i, j)){                   
                        Peca peca = tab.retornaPeca(i, j);
                        if(peca.retornaCor().equals(corLado)){  
                                casa = tab.retornaCasa(i, j);  
                               
                                arrayPeca = tab.mov.posicoesValidas(casa, peca); 
                                
                                if (!(arrayPeca.isEmpty())){
                                   
                                    for(int index=0;index<arrayPeca.size();index++){
                                      
                                        posFinal = arrayPeca.get(index);
                                        
                                        movimento = new Movimento(posFinal,peca);
                                        
                                        arrayTodasPosicoes.add(movimento);
                                    }   
                                }
                        }
                }
           
            }
        }
       
        return arrayTodasPosicoes;
    }
    
    // IA AlphaBetaNegamax
   /* 
    public int AlphaBetaNegamax(TabuleiroIA tab, int depth, String corLado, String corOponente,int alpha,int beta){
            
            System.out.println("=================");
        
            int val;
            
            int d = depth;
            System.out.println("depth = "+d);
            
            FuncaoAvaliacaoIA funcaoAvaliacaoIA = new FuncaoAvaliacaoIA();
            int evaluate = funcaoAvaliacaoIA.calcularAvaliacaoComparativa(tab);
            int forcaPreto = funcaoAvaliacaoIA.calcularAvaliacao(tab, corLado); 
            System.out.println("Evaluate = "+evaluate);
            System.out.println("Preto = "+forcaPreto);
            List<Movimento> arrayMovimentos= new ArrayList<Movimento>();
            arrayMovimentos = this.todasPosicoesValidasIA(tab, corLado);
            
        
            TabuleiroIA auxTab = new TabuleiroIA(8,8);
            
            if (d==0){
                    
                    return evaluate;       
            }
            System.out.println("alpha = "+alpha);
            System.out.println("beta = "+beta);
            
            
            for(int i=0; i < arrayMovimentos.size();i++){
                    
                    auxTab.copiarPecasIA(tab);   
                    tab.ocuparIA(arrayMovimentos.get(i).getPosFin(),arrayMovimentos.get(i).getPeca());
                    evaluate = -AlphaBetaNegamax(tab,depth-1,corOponente,corLado,-beta,-alpha);
                    System.out.println("Evaluate i ="+i+", = "+evaluate);
                    tab.copiarPecasIA(auxTab);
                    if (evaluate>=beta){
                        
                        evaluate = beta;
                    }
                    if (evaluate > alpha){
                        alpha = evaluate;
                    }    
            }
            
            System.out.println("=================");
            return alpha;
            
    }
    
    
  
    // IA MiniMax
    
    public int Minimax(TabuleiroIA tab,int depth,String corLado, String corOponente){
        if(corLado.equals(Constantes.PRETO)){
            return this.Max(tab,depth,corLado,corOponente);
        } else{
            return this.Min(tab,depth,corOponente,corLado);
        }
        
        
    }
    
    private int Max(TabuleiroIA tab,int depth,String corLado,String corOponente){
        
        int d = depth;
        
        FuncaoAvaliacaoIA funcaoAvaliacaoIA = new FuncaoAvaliacaoIA();
        int evaluate = funcaoAvaliacaoIA.calcularAvaliacaoComparativa(tab);
        
        List<Movimento> arrayMovimentos= new ArrayList<Movimento>();
        arrayMovimentos = this.todasPosicoesValidasIA(tab, corLado);
        System.out.println("size = "+arrayMovimentos.size());
        
        TabuleiroIA auxTab = new TabuleiroIA(8,8);
        
        
        int best = -999999;
        if(depth<=0){
            System.out.println("depth = 0");
            return evaluate;
        }
        for(int i=0;i<arrayMovimentos.size();i++){
             auxTab.copiarPecasIA(tab);
            
            tab.ocuparIA(arrayMovimentos.get(i).getPosFin(), arrayMovimentos.get(i).getPeca());
            int val = Min(tab,d-1,corOponente,corLado);
            tab.copiarPecasIA(auxTab);
            
            if(val > best){
                best = val;
            } 
        }
         return best;
        
    }
    
    private int Min(TabuleiroIA tab,int depth,String corLado,String corOponente){
        
       int d = depth;
        
        FuncaoAvaliacaoIA funcaoAvaliacaoIA = new FuncaoAvaliacaoIA();
        int evaluate = funcaoAvaliacaoIA.calcularAvaliacaoComparativa(tab);
        
        List<Movimento> arrayMovimentos= new ArrayList<Movimento>();
        arrayMovimentos = this.todasPosicoesValidasIA(tab, corLado);
        
         TabuleiroIA auxTab = new TabuleiroIA(8,8);
        
        
        int best = 999999;
        if(depth<=0){
            return evaluate;
        }
        for(int i=0;i<arrayMovimentos.size();i++){
             auxTab.copiarPecasIA(tab);
            
            tab.ocuparIA(arrayMovimentos.get(i).getPosFin(), arrayMovimentos.get(i).getPeca());
            int val = Min(tab,d-1,corOponente,corLado);
            tab.copiarPecasIA(auxTab);
            
            if(val < best){
                best = val;
            } 
        }
         return best;
        
    }
    
    
    
    //IA Negamax
    
    
    public int Negamax(TabuleiroIA tab, int depth, String corLado,String corOponente){
        
        int d = depth;
        System.out.println("depth = "+d);
        int evaluate = funcaoAvaliacaoIA.calcularAvaliacaoComparativa(tab);
        System.out.println("Evaluate = "+evaluate);
        
        List<Movimento> arrayMovimentos= new ArrayList<Movimento>();
        arrayMovimentos = this.todasPosicoesValidasIA(tab, corLado);
        
        TabuleiroIA auxTab = new TabuleiroIA(8,8);
        
        int best = -999999;
        
        
        
        if (d<=0){
                return evaluate;
        }
        
         for(int i=0;i<arrayMovimentos.size();i++){
             System.out.println("=========");
             System.err.println("For, i = "+i);
             auxTab.copiarPecasIA(tab);
            
            tab.ocuparIA(arrayMovimentos.get(i).getPosFin(), arrayMovimentos.get(i).getPeca());
            int val = -Negamax(tab,d-1,corOponente,corLado);
            System.out.println("Valor = "+val);
            tab.copiarPecasIA(auxTab);
            
            if(val > best){
                best = val;
                System.out.println("Best = "+best);
            } 
        }
         return best;
    }
    
    
    
    
    
    public void IA(Tabuleiro tab,int depth){
       
        System.out.println("IA on");
        
        int d = depth; 
        String corLado = Constantes.PRETO;
        String corOponente = Constantes.BRANCO;
        TabuleiroIA tabIA = new TabuleiroIA(8,8);
        tabIA.copiarPecas(tab);
        
   
    }
    
     
    
     */
    
    
    
    public Movimento Minimax(Tabuleiro tab, String corPlayerAtual, String corOutroPlayer, int depth){
        
        List<Movimento> arrayMovimentos = new ArrayList<Movimento>();
        
        arrayMovimentos = this.todasPosicoesValidas(tab, corPlayerAtual);
        
        int highest_seen_value = Integer.MIN_VALUE;
        
        FuncaoAvaliacao evalue = new FuncaoAvaliacao();
        
        Movimento best_move = null;
        
        for(int i=0; i<=arrayMovimentos.size();i++ ){
            int value = 0;
            try{
                TabuleiroIA tabIA = new TabuleiroIA(8,8);
                tabIA.copiarPecas(tab);
                Movimento move = arrayMovimentos.get(i);
                //int bestboardvalue= evalue.calcularAvaliacaoIA(tabIA, corPlayerAtual);
                
                
                if(corPlayerAtual.equals(Constantes.PRETO)){
                    if(value>highest_seen_value){
                        highest_seen_value = value;
                        best_move = move;
                    }   
                } 
                } catch (Exception e){
                    
                }     
        }
        return best_move;
        
    }
    
    
    public int minimaxValue(Tabuleiro tab, String corPlayerAtual, String corOutroPlayer, int depth, int bestBoardValue){
        
        FuncaoAvaliacao evalue = new FuncaoAvaliacao();
        
        int jogadaAtual = bestBoardValue;
        int ret_val = 0;
        if(depth==0){
            ret_val = bestBoardValue;
        }else if(corPlayerAtual.equals(Constantes.PRETO)){
             List<Movimento> arrayMovimentos = new ArrayList<Movimento>();
            arrayMovimentos = this.todasPosicoesValidas(tab, corOutroPlayer);
            int highest_seen_value = Integer.MIN_VALUE;
            int oldvalue = Integer.MIN_VALUE;
            int value = 0;
            for(int i=0;i<arrayMovimentos.size();i++){
                TabuleiroIA tabIA = new TabuleiroIA(8,8);
                //tabIA = tab.copiarPecas(tab);
                Movimento move = arrayMovimentos.get(i);
                
                
            }
            
            
        }
        
        return 3;
    }
    

    
    
    public Movimento RandomIA(Tabuleiro tab){
       
        
        List<Movimento> arrayMovimentos= new ArrayList<Movimento>();
        arrayMovimentos = this.todasPosicoesValidas(tab, Constantes.PRETO);
      
        Random generator = new Random();
        int count = arrayMovimentos.size();
        int randomIndex = generator.nextInt( count-1 );
        
        Movimento mov = arrayMovimentos.get(randomIndex);
        
        return mov;
    }
    
    
    
    
    
    
}
