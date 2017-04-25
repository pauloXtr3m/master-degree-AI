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

    public static Populacao retornaCampeoesTorneio(Populacao populacao){
        double[] scores = avaliaPopulacao(populacao);
        int qntPais = scores.length/2;
        double[] melhores = new double[qntPais];
        int[] vitorias = new int[scores.length];

        CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();
        CopyOnWriteArrayList<Individuo> melhoresPais = new CopyOnWriteArrayList<>();

        //seleção por torneio
        for(int i = 0; i < scores.length; i++){

            //inicialmente preenche o vetor, se está
            //com alguma posição vazia
            if(i < qntPais){
                melhores[i] = scores[i];
                vitorias[i]++;

            } else{
                for(int j = 0; j < qntPais; j++){
                    int rand = (int)(Math.random() * scores.length);
                    if(scores[rand]>melhores[j]){
                        melhores[j] = scores[rand];
                        vitorias[rand]++;
                        break;
                    }
                }
            }

        }
        int[] maisVitorias = new int[qntPais];
        int[] indicesEscolhidos = new int[qntPais];

        //Verifica qual individuo tem mais vitorias
        // e guarda seus indices
        for(int i = 0; i < scores.length; i++){

            if(i < qntPais){
                maisVitorias[i] = vitorias[i];
            }else{
                for(int j = 0; j < qntPais; j++){
                    if(maisVitorias[j]<vitorias[i]){
                        maisVitorias[j] = vitorias[i];
                        indicesEscolhidos[j] = i;
                        break;
                    }
                }
            }

        }

        for(int i = 0 ; i < maisVitorias.length; i++){
            melhoresPais.add(individuos.get(maisVitorias[i]));
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
        score = (0.5 + Math.pow(Math.sin(Math.sqrt(powxy)),2) - 0.5) / (Math.pow((1 + (0.001 * (powxy))), 2));

        return score;
    }

}