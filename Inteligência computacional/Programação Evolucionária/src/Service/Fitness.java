package Service;

import Model.Individuo;
import Model.Populacao;

import java.util.ArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Fitness {

    /**
     * Avalia toda a populacao
     * @param populacao
     */
    public static double[] avaliaPopulacao(Populacao populacao){
        ArrayList individuos = populacao.getIndividuos();
        double[] scores = new double[individuos.size()];

        for(Object objeto: individuos){
            scores[individuos.indexOf(objeto)] = avaliaIndividuo(Individuo.parseIndividuo(objeto));
        }
        return scores;
    }

    /**
     * Avalia individuo
     * @param individuo
     * @return score
     */
    public static double avaliaIndividuo(Individuo individuo){
        double x = individuo.getX();
        double y = individuo.getY();
        double score = 0;
        score = 0.5 + (Math.pow(Math.sin(Math.sqrt(Math.pow(x,2) + Math.pow(y,2))), 2) - 0.5) /
                (Math.pow((1 + (0.001 * (Math.pow(x,2) + Math.pow(y,2)))), 2));

        return score;
    }
}