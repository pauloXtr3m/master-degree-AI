package model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Populacao {

	private CopyOnWriteArrayList<Individuo> individuos;

	public Populacao() {

	}

	public void Populacao(Populacao populacao) {

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
