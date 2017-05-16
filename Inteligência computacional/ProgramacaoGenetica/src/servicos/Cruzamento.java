package servicos;

import model.Populacao;
import model.Individuo;

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

		return cruzarIndividuos(pais, nosEscolhidos);
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

                String provavelFuncao = (String)cromossomo.get(escolheNo);

                if (CromossomoGenerator.isFuncao(provavelFuncao)
                        ||CromossomoGenerator.isFuncaoMath(provavelFuncao)){

					nosEscolhidos[contNos] = escolheNo;
					contNos++;
					noErrado = false;
				}
            }
		}
		return nosEscolhidos;
	}

	public Individuo[] cruzarIndividuos(Individuo[] pais, int[] nosEscolhidos){
		TreeMap[] subTrees = new TreeMap[pais.length];
        Individuo[] filhos = new Individuo[pais.length];
        String[] nos;
	    for(int i = 0; i < pais.length; i++){
            TreeMap cromossomo = pais[i].getCromossomo();
            int contCruzamento = 0;

            switch (i){
                case 0:
                    contCruzamento = nosEscolhidos[1];
                    break;
                case 1:
                    contCruzamento = nosEscolhidos[0];
                    break;

            }
            subTrees[i] = retornaSubarvoreEscolhida(nosEscolhidos[i], cromossomo, contCruzamento);

            for(int j = nosEscolhidos[i]; j < cromossomo.size(); j++){
                cromossomo.remove(j);
            }

            filhos[i] = new Individuo(cromossomo);

        }

        for(int i = 0; i < pais.length; i++){
            TreeMap cromossomo = filhos[i].getCromossomo();

            switch (i){
                case 0:
                    cromossomo.putAll(subTrees[1]);
                    filhos[i] = new Individuo(cromossomo);
                    break;
                case 1:
                    cromossomo.putAll(subTrees[0]);
                    filhos[i] = new Individuo(cromossomo);
                    break;

            }
        }


		return filhos;
	}

    /**
     * Retorna subarvore abaixo do nó escolhido para cruzamento
     * @param noEscolhido
     * @param cromossomo
     * @return subarvore com nós e keys formatadas(ordem crescente)
     */
	public TreeMap retornaSubarvoreEscolhida(int noEscolhido, TreeMap cromossomo, int contCruzamento){
        SortedMap subTree = cromossomo.subMap(noEscolhido, cromossomo.size()-1);
        TreeMap novoCromosso = new TreeMap();

        for(int j = noEscolhido; j < cromossomo.size(); j++){

            novoCromosso.put(contCruzamento, cromossomo.get(j));
            contCruzamento++;
        }
        return novoCromosso;
    }


}

