package servicos;

import java.util.concurrent.CopyOnWriteArrayList;


public class CromossomoGenerator {
    String[] all;
    String[] funcoes;
    String[] next;



    public CromossomoGenerator(){
        inicializarAll();
        inicializarFuncoes();
        inicializarNext();
    }

    public CopyOnWriteArrayList<String> randomFormula(int maxProfundidade){
        CopyOnWriteArrayList<String> formula = new CopyOnWriteArrayList<String>();
        int profundidade = 0;

        if(maxProfundidade>1){
                formula.add("(");
                String nextFuncao = randomNext(this.funcoes);

                formula.add(nextFuncao);

                if(nextFuncao.equals("sin")|| nextFuncao.equals("cos")||nextFuncao.equals("sqrt")){
                    formula.addAll(randomFormula(maxProfundidade-1));


                } else{
                    formula.addAll(randomFormula(maxProfundidade-1));
                    formula.addAll(randomFormula(maxProfundidade-1));

                }
                formula.add(")");

        } else if(maxProfundidade == 1){
            formula.add(randomNext(this.next));
        }

        for(String str: formula){
            System.out.print(formula);
        }
        System.out.println("\nFinalizou\n");

        return formula;
    }
    private void inicializarAll(){
        all = new String[12];
        all[0] = "(";
        all[1] = ")";
        all[2] = "+";
        all[3] = "-";
        all[4] = "/";
        all[5] = "*";
        all[6] = "^";
        all[7] = "sin";
        all[8] = "cos";
        all[9] = "sqrt";
        all[10] = "a";
        all[11] = "b";
    }
    private void inicializarFuncoes(){
        funcoes = new String[8];
        funcoes[0] = "+";
        funcoes[1] = "-";
        funcoes[2] = "/";
        funcoes[3] = "*";
        funcoes[4] = "Math.pow";
        funcoes[5] = "Math.sin";
        funcoes[6] = "Math.cos";
        funcoes[7] = "Math.sqrt";
    }
    private void inicializarNext(){
        next = new String[3];
        next[0] = Integer.toString((int)(Math.random()*10));
        next[1] = "a";
        next[2] = "b";
    }

    public String randomNext(String[] randVetor){

        int rand = (int)(Math.random()*randVetor.length);

        return randVetor[rand];
    }


}
