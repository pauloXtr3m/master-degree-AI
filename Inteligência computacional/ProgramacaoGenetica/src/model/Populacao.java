package model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Populacao {

	private CopyOnWriteArrayList<Individuo> individuos;

	public Populacao(int tamPopulacao) {
		individuos = new CopyOnWriteArrayList<Individuo>();
		for(int i = 0 ; i < tamPopulacao; i++){
			individuos.add(new Individuo());
		}
	}

	public void Populacao(CopyOnWriteArrayList<Individuo> populacao) {
		this.individuos = populacao;
	}

	public void addIndividuo(Individuo individuo) {
		this.individuos.add(individuo);
	}

	public void removePorIndice(int indice) {
		this.individuos.remove(indice);
	}

	public Individuo retornaPorIndice(int indice) {
		return this.individuos.get(indice);
	}

	public CopyOnWriteArrayList<Individuo> getIndividuos() {
		return individuos;
	}
}
