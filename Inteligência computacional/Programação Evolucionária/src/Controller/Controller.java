package Controller;

import Model.Populacao;

/**
 * Created by paulo on 20/04/17.
 */
public class Controller {
    private static Populacao populacao;
    private static int qntIndividuos = 10;
    private static int qntGeracoes = 200;


    public static void iniciarExecucao(){
        inicializaPopulacao();
        int i = 0 ;
        while(++i < qntGeracoes){

        }

    }

    private static void inicializaPopulacao(){
        populacao = new Populacao(qntIndividuos);
    }
    private static void imprimeResultados(){

    }
}
