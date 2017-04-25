package Controller;

import Model.Populacao;
import Service.Fitness;
import Service.Operadores;

/**
 * Created by paulo on 20/04/17.
 */
public class Controller {
    private static Populacao uniao;
    private static Populacao populacao;
    private static Populacao filhos;
    private static int qntIndividuos = 10;
    private static int qntGeracoes = 200;
    private static double[] scores;
    public static double melhorFitness = 0;
    public static int taxaMutacao = 99999;


    public static void iniciarExecucao(){
        inicializaPopulacao();
        int i = 0 ;
        while(++i < qntGeracoes){
            filhos = Operadores.mutaPopulacao(populacao);
            uniao = Operadores.retornaUniao(populacao, filhos);
            populacao = Fitness.retornaMelhores(uniao);
            scores = Fitness.avaliaPopulacao(populacao);
            imprimeResultados();
            verificaMelhorFitness();
        }
        System.out.println("Melhor fitness: " + melhorFitness);

    }

    private static void inicializaPopulacao(){
        populacao = new Populacao(qntIndividuos);
    }

    private static void imprimeResultados(){
        for(double i: scores){
            System.out.println(i);
        }
        System.out.println("\n\n");
    }
    private static void verificaMelhorFitness(){

        for(double i: scores){
            if(i > melhorFitness){
                melhorFitness = i;
            }
        }

    }
}
