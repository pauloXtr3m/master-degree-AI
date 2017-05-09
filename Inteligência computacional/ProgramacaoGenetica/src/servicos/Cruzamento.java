package servicos;

import model.Populacao;
import model.Individuo;

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

	public Individuo realizaOperacaoIndividuo(Individuo individuo) {
		return null;
	}

	public Individuo[] realizaOperacaoCruzamento(Individuo[] pais) {
		return null;
	}



}
