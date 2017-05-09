package model;


import servicos.CromossomoGenerator;
import controller.Controlador;

import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class Individuo {

	private TreeMap<Integer,String> cromossomo;

	private Populacao populacao;

	private CopyOnWriteArrayList arvoreString;


	public Individuo() {
		CromossomoGenerator generator = new CromossomoGenerator();
		this.arvoreString = generator.randomFormula(Controlador.PROFUNDIDADE);
		this.cromossomo = criarCromossomo(arvoreString);
	}

	public Individuo(TreeMap<Integer,String> cromossomo) {

		this.cromossomo = cromossomo;
	}

	public TreeMap<Integer,String> criarCromossomo(CopyOnWriteArrayList arvoreString) {

		TreeMap<Integer,String> novoCromossomo = new TreeMap<Integer,String>();

		for(int i = 0; i < arvoreString.size(); i++){
			if(arvoreString.get(i) != "(" && arvoreString.get(i) != ")"){
				String no = (String)arvoreString.get(i);
				novoCromossomo.put(i, no);
			}
		}
		return novoCromossomo;
	}

	public TreeMap<Integer,String> getCromossomo() {
		return this.cromossomo;
	}

}
