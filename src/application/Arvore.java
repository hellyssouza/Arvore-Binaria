package application;

public class Arvore {
	private No raiz;

	public Arvore(long valor) {
		raiz = new No(valor);
	}

	public No inserir(long valor) {
		return inserir(raiz, valor);
	}

	public No remover(long valor) {
		return remover(raiz, valor);
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
		}
		
		return arvore;
	}
	
	private No remove_atual(No atual) {
		if(naoPossuiNenhumFilho(atual)) {
			return null;
		} else {
			if(possuiDoisFilhos(atual)) {
				return encontreMaiorElementoADireitaDoMeuFilhoAEsquerda(atual);
			} else {
				if(possuiApenasUmFilhoADireita(atual)) {
					return atual.getDireita();
				} else {
					if(possuiApenasUmFilhoAEsquerda(atual)) {
						return atual.getEsquerda();
					}
				}
			}
		}
		return atual;
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

	private No encontreMaiorElementoADireitaDoMeuFilhoAEsquerda(No atual) {
		No auxiliar = atual;
		No percoredor = atual.getEsquerda();
		while(percoredor.getDireita() != null) {
			auxiliar = percoredor;
			percoredor = auxiliar.getDireita();
		}
		
		percoredor.setDireita(atual.getDireita());

		if(!atual.getEsquerda().equals(percoredor)) {
			percoredor.setEsquerda(atual.getEsquerda());
		}
		
		atual = percoredor;
		percoredor = null;
		return atual;
	}
}
