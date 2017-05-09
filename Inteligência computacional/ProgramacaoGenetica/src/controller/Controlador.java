package controller;

import model.Populacao;

public class Controlador {

	private Populacao populacao;

	public static final int PROFUNDIDADE = 2;

	private int geracoes = 200;

	private int tamPopulacao = 10;



	public void iniciaPopulacao() {
		this.populacao = new Populacao(tamPopulacao);
	}

	public void iniciaExecucao() {
		iniciaPopulacao();
		int i = 0;
		while(++i < geracoes){

			int rand = (int)(Math.random()*100);

			if((rand > 0) && (rand < 90)){
				//cruzamento

			}else if((rand >= 90) && (rand < 98)){
				//recombinação

			} else {
				//mutação

			}
		}
	}

}
