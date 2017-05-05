package servicos;

import model.Populacao;
import model.Individuo;

public abstract class Operacao {

	private Populacao populacao;

	protected abstract Populacao realizaOperacao(Populacao populacao);

	protected abstract Individuo realizaOperacaoIndividuo(Individuo individuo);
	

}
