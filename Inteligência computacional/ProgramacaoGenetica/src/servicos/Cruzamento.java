package servicos;

import model.Populacao;
import model.Individuo;
import sun.reflect.generics.tree.Tree;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cruzamento extends Operacao {

	public Populacao realizaOperacao(Populacao populacao) {
		CopyOnWriteArrayList<Individuo> pais = populacao.getIndividuos();
		CopyOnWriteArrayList<Individuo> novosIndividuos = pais;
		Individuo[] paisDaVez = new Individuo[2];

		for (int i = 0; i < pais.size(); i = i + 1) {
			if ((i == 0)||(i % 2 == 0)) {
				paisDaVez[0] = pais.get(i);
				paisDaVez[1] = pais.get(i + 1);

				Individuo[] filhos = realizaOperacaoCruzamento(paisDaVez);

				for (Individuo filho : filhos) {
					novosIndividuos.add(filho);
				}
			}

		}

		return new Populacao(novosIndividuos);
	}


	public Individuo[] realizaOperacaoCruzamento(Individuo[] pais) {

		int[] nosEscolhidos = escolherNos(pais);
        cruzarIndividuos(pais, nosEscolhidos);

		return null;
	}

	public int[] escolherNos(Individuo[] pais) {

		int[] nosEscolhidos = new int[2];
        int contNos = 0;

		for (int i = 0; i < pais.length; i++) {

			TreeMap cromossomo = pais[i].getCromossomo();


			boolean noErrado = true;

			while (noErrado) {
                int escolheNo = 0;

			    while(escolheNo == 0 ){
			        escolheNo = (int) (Math.random() * cromossomo.size());
                }
                System.out.println(escolheNo);

				if (cromossomo.get(escolheNo).equals('+')
						|| cromossomo.get(escolheNo).equals('-')
						|| cromossomo.get(escolheNo).equals('/')
						|| cromossomo.get(escolheNo).equals('*')
                        || cromossomo.get(escolheNo).equals("Math.pow")
                        || cromossomo.get(escolheNo).equals("Math.sqrt")
                        || cromossomo.get(escolheNo).equals("Math.cos")
                        || cromossomo.get(escolheNo).equals("Math.sin")) {

					nosEscolhidos[contNos] = escolheNo;
					contNos++;
					noErrado = false;
				}
			}
		}
		return nosEscolhidos;
	}

	public Individuo[] cruzarIndividuos(Individuo[] pais, int[] nosEscolhidos){
		SortedMap[] subTrees = new SortedMap[pais.length];

	    for(int i = 0; i < pais.length; i++){
            TreeMap cromossomo = pais[i].getCromossomo();
            subTrees[i] = cromossomo.subMap(nosEscolhidos[i], cromossomo.size()-1);
        }

		return new Individuo[10];
	}

}

