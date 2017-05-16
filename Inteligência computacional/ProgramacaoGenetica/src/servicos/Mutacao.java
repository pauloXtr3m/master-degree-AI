package servicos;

import model.Populacao;
import model.Individuo;

import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Mutacao extends Operacao {

	public Populacao realizaOperacao(Populacao populacao) {
		CopyOnWriteArrayList<Individuo> populacaoIndividuos = populacao.getIndividuos();
		CopyOnWriteArrayList<Individuo> novosIndividuos = new CopyOnWriteArrayList<>();


		for (Individuo individuo: populacaoIndividuos) {

			novosIndividuos.add(realizaOperacaoIndividuo(individuo));

		}

		return new Populacao(novosIndividuos);
	}

	public Individuo realizaOperacaoIndividuo(Individuo individuo) {

		TreeMap cromossomo = individuo.getCromossomo();
		int noEscolhido = 0;
		boolean naoFuncao = true;
		String no;

		while(naoFuncao){
			noEscolhido = (int)(Math.random()*cromossomo.size());
			no = (String)cromossomo.get(noEscolhido);
			naoFuncao = CromossomoGenerator.isFuncao(no);
		}
		String funcaoRandom = CromossomoGenerator.funcaoRand();
		cromossomo.replace(noEscolhido, funcaoRandom);


		return new Individuo(cromossomo);
	}


}
