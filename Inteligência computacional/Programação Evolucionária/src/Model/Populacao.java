package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Populacao {

    private CopyOnWriteArrayList<Individuo> individuos;

    public Populacao(int qntIndividuos){

        this.individuos = new CopyOnWriteArrayList<>();

        for(int i = 0; i < qntIndividuos; i++){
            this.individuos.add(new Individuo());
        }

    }
    public Populacao(CopyOnWriteArrayList<Individuo> individuos){
        this.individuos = individuos;
        Collections.synchronizedList(this.individuos);

    }


    public CopyOnWriteArrayList<Individuo> getIndividuos() {
        return individuos;
    }
}
