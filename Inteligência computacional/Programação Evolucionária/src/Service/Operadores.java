package Service;

import Model.Individuo;
import Model.Populacao;

import java.util.ArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Operadores {
    public static Populacao mutaPopulacao(Populacao populacao){
        ArrayList individuos = populacao.getIndividuos();

        for(Object objeto: individuos){
            int index = individuos.indexOf(objeto);
            Individuo individuoMutado = mutaIndividuo(Individuo.parseIndividuo(objeto));
            individuos.remove(index);
            individuos.add(index, individuoMutado);
        }

        return populacao;
    }

    public static Individuo mutaIndividuo(Individuo individuo){
        return individuo;
    }

}
