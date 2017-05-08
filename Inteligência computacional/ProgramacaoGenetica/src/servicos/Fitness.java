package servicos;

import model.Arvore;
import model.Populacao;
import model.Individuo;

import java.util.concurrent.CopyOnWriteArrayList;

public class Fitness {

	public void calculaFitnessPopulacao(Populacao populacao) {
		CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();

		for(Individuo i: individuos){
			calculaFitnessIndividuo(i);
		}
	}

	public void calculaFitnessIndividuo(Individuo individuo) {
		Arvore arvore = new Arvore();

	}

}
