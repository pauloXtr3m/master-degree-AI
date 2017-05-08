package model;


import servicos.CromossomoGenerator;
import controller.Controlador;


public class Individuo {

	private Arvore cromossomo;

	private Populacao populacao;

	private String arvoreString;


	public Individuo() {
		CromossomoGenerator generator = new CromossomoGenerator();
		this.arvoreString = generator.randomFormula(Controlador.PROFUNDIDADE);
		this.cromossomo = criarCromossomo(arvoreString);
	}

	public Individuo(Arvore cromossomo) {
        this.cromossomo = cromossomo;
	}

	public Arvore criarCromossomo(String arvoreString) {
		return null;
	}

	public Arvore getCromossomo() {
		return this.cromossomo;
	}

}
