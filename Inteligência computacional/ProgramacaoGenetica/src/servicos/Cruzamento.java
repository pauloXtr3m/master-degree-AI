package servicos;

import model.Populacao;
import model.Individuo;

import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cruzamento extends Operacao {

	public Populacao realizaOperacao(Populacao populacao) {
		CopyOnWriteArrayList<Individuo> pais = populacao.getIndividuos();
		CopyOnWriteArrayList<Individuo> novosIndividuos = pais;
		Individuo[] paisDaVez = new Individuo[2];

		for(int i = 0; i < pais.size(); i = i+1){
			if(i % 2 == 0) {
				paisDaVez[0] = pais.get(i);
				paisDaVez[1] = pais.get(i + 1);

				Individuo[] filhos = realizaOperacaoCruzamento(paisDaVez);

				for(Individuo filho: filhos){
					novosIndividuos.add(filho);
				}
			}

		}

		return new Populacao(novosIndividuos);
	}


	public Individuo[] realizaOperacaoCruzamento(Individuo[] pais) {

		for(int i = 0; i < pais.length; i++){

			TreeMap cromossomo = pais[i].getCromossomo();

			boolean noErrado = true;

			while(noErrado){

				int escolheNo = (int)(Math.random()*cromossomo.size());
				System.out.println(escolheNo);

				if(cromossomo.get(escolheNo).equals('+')
						|| cromossomo.get(escolheNo).equals('-')
						|| cromossomo.get(escolheNo).equals('/')
						|| cromossomo.get(escolheNo).equals('*')){

					// falta guardar nó escolhido e sai do while
					noErrado = false;
				}
			}
		}
		return null;
	}



}
