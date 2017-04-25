package Service;

import Controller.Controller;
import Model.Individuo;
import Model.Populacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Operadores {
    public static Populacao mutaPopulacao(Populacao populacao){
        CopyOnWriteArrayList individuos = populacao.getIndividuos();

        for(Object objeto: individuos){
            int index = individuos.indexOf(objeto);
            Individuo individuoMutado = mutaIndividuo(Individuo.parseIndividuo(objeto));
            individuos.remove(index);
            individuos.add(index, individuoMutado);
        }

        return populacao;
    }

    public static Individuo mutaIndividuo(Individuo individuo){
        long x = individuo.getX();
        long y = individuo.getY();
        int mutacao = (int)(Math.random()*Controller.taxaMutacao);
        int sinal =  (int)Math.round(Math.random() * 1);

        switch(sinal){
            case 0:
                x = x + mutacao;
                y = y + mutacao;
                break;
            case 1:
                x = x - mutacao;
                y = y - mutacao;
                break;
            default:
                x = x + mutacao;
                y = y + mutacao;
                break;
        }

        individuo.setX(x);
        individuo.setY(y);

        return individuo;
    }

    public static Populacao retornaUniao(Populacao populacao1, Populacao populacao2){
        CopyOnWriteArrayList<Individuo> individuosUniao = populacao1.getIndividuos();
        CopyOnWriteArrayList<Individuo> individuos2 = populacao1.getIndividuos();

        individuosUniao.addAll(individuos2);

        return new Populacao(individuosUniao);
    }

}
