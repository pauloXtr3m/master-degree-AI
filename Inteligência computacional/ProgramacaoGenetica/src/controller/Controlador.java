package controller;

import com.sun.org.apache.bcel.internal.generic.POP;
import model.Populacao;
import servicos.*;

public class Controlador {

	private Populacao populacao;

	public static final int PROFUNDIDADE = 4;

	private int geracoes = 200;

	private int tamPopulacao = 8;



	private void iniciaPopulacao() {
		this.populacao = new Populacao(tamPopulacao);
	}

	public void iniciaExecucao() {
		iniciaPopulacao();
		int i = 0;
		Operacao operacao;
		while(++i < geracoes){

			int rand = (int)(Math.random()*100);

			if((rand > 0) && (rand < 98)){
				//CRUZAMENTO

				Fitness fitness = new Fitness();
				Populacao melhoresPais = fitness.retornaPais(this.populacao);
				operacao = new Cruzamento();
				this.populacao = operacao.realizaOperacao(melhoresPais);

			} else {
				//MUTAÇÃO

				operacao = new Mutacao();
				this.populacao = operacao.realizaOperacao(this.populacao);
			}
		}
	}

}
