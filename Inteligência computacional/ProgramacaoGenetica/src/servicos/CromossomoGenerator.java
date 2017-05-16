package servicos;

import com.sun.org.apache.xpath.internal.operations.Number;
import jdk.nashorn.internal.runtime.NumberToString;

import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CromossomoGenerator {
    private static String[] all;
    private static String[] funcoes;
    private static String[] next;
    private static final String SIN = "Math.sin", COS = "Math.cos", SQRT = "Math.sqrt", POW = "Math.pow";



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
                String nextFuncao = randomNext(funcoes);

                formula.add(nextFuncao);

                if(nextFuncao.equals(SIN)|| nextFuncao.equals(COS)||nextFuncao.equals(SQRT)){
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
        funcoes[5] = SIN;
        funcoes[6] = COS;
        funcoes[7] = SQRT;
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

            } else if(isFuncaoMath(no)){
                expression.append(no);
                expression.append("(");
                contParenteses++;
                if(no.equals(POW)){
                    no = (String)cromossomo.get(i + 1);
                    if(isTerminal(no)){
                        expression.append(no);
                        i = i + 1;
                        expression.append(",");
                        no = (String)cromossomo.get(i + 1);

                        if(isTerminal(no)){
                            i = i + 1;
                            expression = fecharExpressao(no, expression);
                            if(!pilha.isEmpty()){
                                expression.append(pilha.pop());
                            }
                        }
                    } else{
                        pilha.add(",");
                    }
                }else{

                    no = (String)cromossomo.get(i + 1);
                    if(isTerminal(no)){
                        i = i + 1;
                        expression = fecharExpressao(no, expression);
                        if(!pilha.isEmpty()){
                            expression.append(pilha.pop());
                        }
                    }
                }

            } else{
                expression.append(no);
                expression.append(pilha.pop());
                no = (String)cromossomo.get(i + 1);
                expression.append(no);
                expression.append(")");
                contParenteses--;
                if(!pilha.isEmpty()){
                    expression.append(pilha.pop());
                }


                i = i + 1;

            }

            if(i == cromossomo.size()-1){
                if(contParenteses>0){
                    expression.append(")");
                    contParenteses--;
                }
            }
        }
        return expression.toString();
    }

    public static boolean isFuncao(String str){
        if (str.equals("+")
                || str.equals("-")
                || str.equals("/")
                || str.equals("*")){
            return true;

        }else{
            return false;
        }
    }
    public static boolean isFuncaoMath(String str){
        if (str.equals(SQRT)
                || str.equals(COS)
                || str.equals(SIN)
                || str.equals(POW) ) {
            return true;

        }else{
            return false;
        }
    }
    public static boolean isTerminal(String str){
        if (str.equals("a")
                || str.equals("b")
                || isNumeric(str)){
            return true;

        }else{
            return false;
        }
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static String funcaoRand(){
        int rand = (int) (Math.random()*funcoes.length);

        return funcoes[rand];
    }

    public static StringBuilder fecharExpressao(String no, StringBuilder expression){

        expression.append(no);
        expression.append(")");
        return expression;
    }

}
