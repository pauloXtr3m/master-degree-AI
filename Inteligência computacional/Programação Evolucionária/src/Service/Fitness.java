package Service;

import Model.Individuo;
import Model.Populacao;
import com.sun.org.apache.bcel.internal.generic.POP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Fitness {

    public static Populacao retornaMelhores(Populacao populacao){
        double[] scores = avaliaPopulacao(populacao);
        int qntPais = scores.length/2;
        double[] melhores = new double[qntPais];
        int[] indices = new int[qntPais];

        CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();
        CopyOnWriteArrayList<Individuo> melhoresPais = new CopyOnWriteArrayList<>();

        for(int i = 0; i < scores.length; i++){

            if(i < qntPais){

                melhores[i] = scores[i];
                indices[i] = i;

            } else{
                for(int j = 0; j < qntPais; j++){

                    if(scores[i]>melhores[j]){
                        melhores[j] = scores[i];
                        indices[j] = i;
                        break;
                    }
                }
            }

        }

        for(int i = 0 ; i < indices.length; i++){
            melhoresPais.add(individuos.get(indices[i]));
        }

        return new Populacao(melhoresPais);

    }

    /**
     * Avalia toda a populacao
     * @param populacao
     */
    public static double[] avaliaPopulacao(Populacao populacao){
        CopyOnWriteArrayList individuos = populacao.getIndividuos();
        double[] scores = new double[individuos.size()];


        for(int i = 0; i< individuos.size(); i++){
            scores[i] = avaliaIndividuo((Individuo) individuos.get(i));
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
        double powxy = Math.pow(x,2) + Math.pow(y,2);
        score = (0.5 + (Math.sin(Math.sqrt(powxy)) - 0.5)) / (Math.pow((1 + (0.001 * (powxy))), 2));

        return score;
    }
}