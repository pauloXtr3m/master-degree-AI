package servicos;

import model.Populacao;
import model.Individuo;
import sun.reflect.generics.tree.Tree;

import java.nio.channels.ConnectionPendingException;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fitness {

	public Populacao retornaPais(Populacao populacao){
		CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();
		float[] fitnessPais = new float[individuos.size()/2];
		Individuo[] pais = new Individuo[individuos.size()/2];

		for(int i = 0; i < fitnessPais.length; i++){
			fitnessPais[i] = 0;
		}

		for(Individuo i: individuos){

			float fitnessIndividuo = calculaFitnessIndividuo(i);

			for(int j = 0; j < fitnessPais.length; j++){
				if(fitnessPais[j]<fitnessIndividuo){
					fitnessPais[j] = fitnessIndividuo;
					pais[j] = i;
					break;
				}
			}
		}

		for(Individuo i: individuos){
			individuos.remove(i);
		}

		for(int i = 0; i < pais.length; i++){
			individuos.add(pais[i]);
		}

		return new Populacao(individuos);
	}

	public void calculaFitnessPopulacao(Populacao populacao) {
		CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();

		for(Individuo i: individuos){
			calculaFitnessIndividuo(i);
		}
	}

	public Float calculaFitnessIndividuo(Individuo individuo) {
		TreeMap cromossomo = individuo.getCromossomo();
		String cromossomoStr = cromossomo.toString();

		//falta formatar expressao para float

		//float fitness = Float.parseFloat("2+5");

		float fitness = 0;

		return fitness;
	}

}
