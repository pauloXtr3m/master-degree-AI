package Controller;

import Model.Individuo;
import Model.Populacao;

import java.util.ArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Fitness {

    public static void avaliaPopulacao(Populacao populacao){
        ArrayList individuos = populacao.getIndividuos();

        for(Object individuo: individuos){
            avaliaIndividuo(Individuo.parseIndividuo(individuo));
        }
    }

    public static double avaliaIndividuo(Individuo individuo){
        double x = individuo.getX();
        double y = individuo.getY();
        double score = 0;
        score = 0.5 + (Math.pow(Math.sin(Math.sqrt(Math.pow(x,2) + Math.pow(y,2))), 2) - 0.5) /
                (Math.pow((1 + (0.001 * (Math.pow(x,2) + Math.pow(y,2)))), 2));

        return score;
    }
}