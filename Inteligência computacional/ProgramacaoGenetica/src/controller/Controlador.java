package controller;

import com.sun.org.apache.bcel.internal.generic.POP;
import model.Populacao;
import servicos.*;

public class Controlador {

	private Populacao populacao;

	public static final int PROFUNDIDADE = 3;

	private int geracoes = 20;

	private int tamPopulacao = 8;



	private void iniciaPopulacao() {
		this.populacao = new Populacao(tamPopulacao);
	}

	public void iniciaExecucao() {
		iniciaPopulacao();
		int i = 0;
		Operacao operacao;
		while(++i < geracoes){

			int escolhaOperacao = (int)Math.round((Math.random()*1));
			int probabOperacao = (int)(Math.random()*100);

			switch (escolhaOperacao){
				case 0:
					if(probabOperacao <= 98){
						Fitness fitness = new Fitness();
						Populacao melhoresPais = fitness.retornaPais(this.populacao);
						operacao = new Cruzamento();
						this.populacao = operacao.realizaOperacao(melhoresPais);
					}
					break;
				case 1:

					if(probabOperacao > 98){
						operacao = new Mutacao();
						this.populacao = operacao.realizaOperacao(this.populacao);
					}

					break;
			}

			System.out.println("Geração: "+ i);
		}
	}

}
