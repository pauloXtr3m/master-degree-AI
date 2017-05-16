package servicos;

import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CromossomoGenerator {
    private static String[] all;
    private static String[] funcoes;
    private static String[] next;



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

    public static String parseExpression(TreeMap cromossomo){

        StringBuilder expression = new StringBuilder().append("");
        int contParenteses = 0;
        Stack pilha = new Stack();
        for(int i = 0; i < cromossomo.size();i++){
            String no = (String)cromossomo.get(i);


            if(isFuncao(no)){
                expression.append("(");
                pilha.add(no);
                contParenteses++;
            }else{
                expression.append(no);
                expression.append(pilha.pop());
                no = (String)cromossomo.get(i + 1);
                expression.append(no);
                expression.append(")");

                if(!pilha.isEmpty()){
                    expression.append(pilha.pop());
                }

                i = i + 1;
            }
        }
        return expression.toString();
    }

    public static boolean isFuncao(String str){
        if (str.equals('+')
                || str.equals('-')
                || str.equals('/')
                || str.equals('*')
                || str.equals("Math.pow")
                || str.equals("Math.sqrt")
                || str.equals("Math.cos")
                || str.equals("Math.sin")) {
            return true;

        }else{
            return false;
        }
    }

    public static String funcaoRand(){
        int rand = (int) (Math.random()*funcoes.length);

        return funcoes[rand];
    }

}
