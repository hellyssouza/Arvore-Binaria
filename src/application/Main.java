package application;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		No no = null;
		Arvore arvore = new Arvore(45);
	
		arvore.inserir(5);
		arvore.inserir(4);
		arvore.inserir(6);
		arvore.inserir(1);
		arvore.inserir(2);
		arvore.inserir(0);
		
		no = arvore.remover(5);
		no = arvore.remover(3);
	}
}
