package servicos;

import bsh.EvalError;
import bsh.Interpreter;
import model.Populacao;
import model.Individuo;
import sun.reflect.generics.tree.Tree;

import java.nio.channels.ConnectionPendingException;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fitness {

	public Populacao retornaPais(Populacao populacao){
		CopyOnWriteArrayList<Individuo> individuos = populacao.getIndividuos();
		double[] fitnessPais = new double[individuos.size()/2];
		Individuo[] pais = new Individuo[individuos.size()/2];

		for(int i = 0; i < fitnessPais.length; i++){
			fitnessPais[i] = 0;
		}

		for(Individuo individuo: individuos){

			double fitnessIndividuo = calculaFitnessIndividuo(individuo);

			for(int j = 0; j < fitnessPais.length; j++){
				if(fitnessPais[j]<fitnessIndividuo){
					fitnessPais[j] = fitnessIndividuo;
					pais[j] = individuo;
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

	public Double calculaFitnessIndividuo(Individuo individuo) {
		TreeMap cromossomo = individuo.getCromossomo();

		String expression = CromossomoGenerator.parseExpression(cromossomo);
		String preExpression = "fitness = ";

		expression = preExpression + expression;

		Interpreter interpreter = new Interpreter();
        Double fitness = 0.00;
		try{
			interpreter.set("a",(Math.random()*20));
			interpreter.set("b", (Math.random()*20));
            interpreter.eval(expression);
            fitness = (Double)interpreter.get("fitness");

		}catch (EvalError e){
		    fitness = 0.00;
        }

		return fitness;
	}

}
