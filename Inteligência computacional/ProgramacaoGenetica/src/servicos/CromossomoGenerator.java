package servicos;

/**
 * Created by paulo on 08/05/17.
 */
public class CromossomoGenerator {
    String[] all;
    String[] funcoes;
    String[] next;



    public CromossomoGenerator(){
        inicializarAll();
        inicializarFuncoes();
        inicializarNext();
    }

    public String randomFormula(int maxProfundidade){
        StringBuilder formula = new StringBuilder("");
        int profundidade = 0;
        if(maxProfundidade>1){
                formula.append("(");
                String nextFuncao = randomNext(this.funcoes);
                formula.append(nextFuncao);
                if(nextFuncao.equals("sin")|| nextFuncao.equals("cos")||nextFuncao.equals("sqrt")){
                    formula.append(randomFormula(maxProfundidade-1));
                    formula.append(")");

                } else{
                    formula.append(randomFormula(maxProfundidade-1));
                    formula.append(randomFormula(maxProfundidade-1));
                    formula.append(")");
                }

        } else if(maxProfundidade == 1){
            formula.append(randomNext(this.next));
        }

        return formula.toString();
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
        funcoes[4] = "^";
        funcoes[5] = "sin";
        funcoes[6] = "cos";
        funcoes[7] = "sqrt";
    }
    private void inicializarNext(){
        next = new String[3];
        next[1] = Integer.toString((int)(Math.random()*10));
        next[2] = "a";
        next[3] = "b";
    }

    public String randomNext(String[] randVetor){

        int rand = (int)(Math.random()*randVetor.length);

        return this.next[rand];
    }


}
