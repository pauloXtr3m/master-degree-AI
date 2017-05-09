package servicos;

import model.Populacao;
import model.Individuo;

public abstract class Operacao {

	protected Populacao populacao;

	public abstract Populacao realizaOperacao(Populacao populacao);


}
