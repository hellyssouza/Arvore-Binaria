package application;

public class Arvore {
	private No raiz;

	public Arvore(long valor) {
		raiz = new No(valor);
	}

	public void inserir(long valor) {
		raiz = inserir(raiz, valor);
	}

	public void remover(long valor) {
		raiz = remover(raiz, valor);
	}

	private No inserir(No arvore, long valor) {

		if (arvore == null) {
			arvore = new No(valor);
		} else {
			if (valor < arvore.getValor()) {
				if (arvore.getEsquerda() != null) {
					inserir(arvore.getEsquerda(), valor);
				} else {
					arvore.setEsquerda(new No(valor));
				}
			} else {
				if (valor > arvore.getValor()) {
					if (arvore.getDireita() != null) {
						inserir(arvore.getDireita(), valor);
					} else {
						arvore.setDireita(new No(valor));
					}
				}
			}
		}

		return arvore;
	}

	private No remover(No arvore, long valor) {

		if (arvore != null) {
			if (arvore.getValor() == valor) {
				arvore = remove_atual(arvore);
			} else {
				if (valor < arvore.getValor()) {
					arvore.setEsquerda(remover(arvore.getEsquerda(), valor));
				} else {
					if (valor > arvore.getValor()) {
						arvore.setDireita(remover(arvore.getDireita(), valor));
					}
				}
			}
		} else {
			System.out.println("Arvore n�o possui elementos.");
		}

		return arvore;
	}

	private No remove_atual(No atual) {
		if (naoPossuiNenhumFilho(atual)) {
			return null;
		} else {
			if (possuiDoisFilhos(atual)) {
				return recupereMaiorADireitaDaSubArvoreAEsquerda(atual);
			} else {
				if (possuiApenasUmFilhoADireita(atual)) {
					return atual.getDireita();
				} else {
					if (possuiApenasUmFilhoAEsquerda(atual)) {
						return atual.getEsquerda();
					}
				}
			}
		}
		return atual;
	}

	public void imprimirPreOrdem() {
		imprimirPreOrdem(raiz);
	}

	public void imprimirEmOrdem() {
		imprimirEmOrdem(raiz);
	}

	public void imprimirPosOrdem() {
		imprimirPosOrdem(raiz);
	}

	public long altura() {
		return altura(raiz);
	}

	private void imprimirPreOrdem(No arvore) {
		if (arvore == null) {
			return;
		}

		if (arvore != null) {
			System.out.println(arvore.getValor());
			imprimirPreOrdem(arvore.getEsquerda());
			imprimirPreOrdem(arvore.getDireita());
		}
	}

	private void imprimirEmOrdem(No arvore) {
		if (arvore == null) {
			return;
		}

		if (arvore != null) {
			imprimirEmOrdem(arvore.getEsquerda());
			System.out.println(arvore.getValor());
			imprimirEmOrdem(arvore.getDireita());
		}
	}

	private void imprimirPosOrdem(No arvore) {
		if (arvore == null) {
			return;
		}

		if (arvore != null) {
			imprimirPosOrdem(arvore.getEsquerda());
			imprimirPosOrdem(arvore.getDireita());
			System.out.println(arvore.getValor());
		}
	}

	private long altura(No arvore) {

		if (arvore != null) {
			long alturaDireita, alturaEsquerda;

			alturaEsquerda = altura(arvore.getEsquerda());
			alturaDireita = altura(arvore.getDireita());

			if (alturaEsquerda > alturaDireita)
				return alturaEsquerda + 1;
			else
				return alturaDireita + 1;
		}

		return 0;
	}

	private boolean possuiApenasUmFilhoAEsquerda(No atual) {
		return atual.getEsquerda() != null && atual.getDireita() == null;
	}

	private boolean possuiApenasUmFilhoADireita(No atual) {
		return atual.getDireita() != null && atual.getEsquerda() == null;
	}

	private boolean naoPossuiNenhumFilho(No atual) {
		return atual.getEsquerda() == null && atual.getDireita() == null;
	}

	private boolean possuiDoisFilhos(No atual) {
		return atual.getEsquerda() != null && atual.getDireita() != null;
	}

	private No recupereMaiorADireitaDaSubArvoreAEsquerda(No atual) {
		No percoredor = atual.getEsquerda();
		No auxiliar = atual;

		while (percoredor.getDireita() != null) {
			auxiliar = percoredor;
			percoredor = auxiliar.getDireita();
		}

		percoredor.setDireita(atual.getDireita());

		if (noEscolhidoEDiferenteDoFilhoAEsquerdaDoNoAtual(percoredor, atual)) {
			if (noEscolhidoParaTrocaPossuiFilhoAEsquerda(percoredor)) {
				No ultimoNoAEsquerda = reculpereUltimoNoMaisAEsquerda(percoredor);
				ultimoNoAEsquerda.setEsquerda(atual.getEsquerda());
			} else {
				percoredor.setEsquerda(atual.getEsquerda());
			}
			auxiliar.setDireita(null);
		}

		atual = percoredor;
		percoredor = null;
		return atual;
	}

	private No reculpereUltimoNoMaisAEsquerda(No escolhido) {
		No percoredor = escolhido.getEsquerda();

		while (percoredor.getEsquerda() != null) {
			percoredor = percoredor.getEsquerda();
		}

		return percoredor;
	}

	private boolean noEscolhidoEDiferenteDoFilhoAEsquerdaDoNoAtual(No escolhido, No atual) {
		return !atual.getEsquerda().equals(escolhido);
	}

	private boolean noEscolhidoParaTrocaPossuiFilhoAEsquerda(No escolhido) {
		return escolhido.getEsquerda() != null;
	}
}
