package Model;

import java.util.ArrayList;

/**
 * Created by paulo on 19/04/17.
 */
public class Populacao {

    private ArrayList<Individuo> individuos;

    public Populacao(int qntIndividuos){
        this.individuos = new ArrayList<>();

        for(int i = 0; i < qntIndividuos; i++){
            this.individuos.add(new Individuo());
        }
    }


    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }
}
