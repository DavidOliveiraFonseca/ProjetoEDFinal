
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class LSE {
	class No {
		private int conteudo;
		private No prox;
		
		Text text;
		Arrow arrow;
		Circle circle;
		
		public void createUI () {
			this.circle = new Circle(80 * (LSE.nElementos), 200, 30);
			this.circle.setStroke(Color.BLACK);
			this.circle.setFill(Color.WHITE);
			this.text = new Text(circle.getCenterX() - 10, circle.getCenterY() + 5,conteudo + "");
			this.arrow = new Arrow(80 * (LSE.nElementos) + 30, circle.getCenterY(), 80 * (1 + LSE.nElementos) - 30, circle.getCenterY());
//			pane.getChildren().addAll(this.circle, this.arrow, this.text);
		}
//		public void deleteUI () {
//			circle.getParent().getChildren().removeAll(this.circle, this.arrow, this.text);
//		}
		
		public No(){
			setProx(null);
		}

		public int getConteudo() {
			return conteudo;
		}

		public void setConteudo(int conteudo) {
			this.conteudo = conteudo;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}
	}

	
	
	private No cabeca;
	private static int nElementos;

	public void createUI(Group pane, int pos) {
		No aux = cabeca;
		for ( int i = 1; i < pos + 1; i++) {
			if (i == pos ) {
				pane.getChildren().addAll(aux.circle, aux.arrow, aux.text);
			
//				pane.getChildren().removeAll(aux.circle, aux.arrow, aux.text);
			}
			aux = aux.getProx();
		}
	}
	
	public void removeUI(Group pane, int pos) {
//		pane.getChildren().removeAll(cabeca.circle, cabeca.arrow, cabeca.text);
		No aux = cabeca;
		No aux2;
		for ( int i = 1; i < pos + 1; i++) {
			if (i == pos) {
				aux2 = aux;
				pane.getChildren().removeAll(aux.circle, aux.arrow, aux.text);
				aux2 = aux2.getProx();
				for (int j = pos; j < nElementos; j ++) {
					aux2.circle.setCenterX(aux2.circle.getCenterX() - 80);
					aux2.text.setLayoutX(aux2.text.getLayoutX() - 80);
					aux2.arrow.setLayoutX(aux2.arrow.getLayoutX() - 80);
					aux2 = aux2.getProx();
				}
			}
			aux = aux.getProx();
		}
	}
//	public void deleteFromUI(Group pane, int posicao) {
////		No aux = inicio;
////		aux = aux.getProx();
////		for (int i = 1; i <= nElementos; i++) {
////			aux.circle.setCenterX(80 * i);
////			aux.text.setLayoutX(aux.circle.getCenterX() - 10);
//////			aux.arrow.setArrowPath(80 * (i + 1) + 30, circle.getCenterY(), 80 * (1 + i + 1) - 30, circle.getCenterY());
////			aux.arrow.setArrowPath((80 * i) + 30, aux.circle.getCenterY(), 80 * (1 + i) - 30, aux.circle.getCenterY());
////			aux.getProx();
////		}
//		pane.getChildren().removeAll(this.topo.circle, this.topo.arrow, this.topo.text);
//	}

	
	public LSE(){
		cabeca = null;
		nElementos = 0;
	}
	
	/** Verifica se a Lista est� vazia */
	public boolean vazia() {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/**Obt�m o tamanho da Lista*/
	public int tamanho() {
	    //return nElementos;
		No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}

	/** Obt�m o i-�simo elemento de uma lista
	    Retorna o valor encontrado. */
	public int elemento (int pos) {
	    if (vazia()) {
	        return -1; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return -1; // Posicao invalida 
	    }
	    
	    No aux = cabeca;
	    // Percorre a lista do 1o elemento at� pos 
	    for (int i =1; i < pos; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }

	    return aux.getConteudo();
	}

	/**Retorna a posi��o de um elemento pesquisado.
	    Retorna -1 caso n�o seja encontrado */
	public int posicao (int dado) {
	    int cont = 1;
	    No aux;

	    /* Lista vazia */
	    if (vazia()) {
	        return -1;
	    }

	    /* Percorre a lista do inicio ao fim at� encontrar o elemento*/
	    aux = cabeca;
		while (aux != null) {
	        /* Se encontrar o elemento, retorna sua posicao n;*/
	        if (aux.getConteudo() == dado){
	            return cont;
	        }

	        /* modifica "aux" para apontar para o proximo elemento da lista */
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	/** Insere n� em lista vazia */
	private boolean insereInicioLista(int valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    
	    novoNo.setProx(cabeca);
	    nElementos++;
	    novoNo.createUI();
	    cabeca = novoNo;
	    return true;
	}

	/** Insere n� no meio da lista */
	private boolean insereMeioLista(int pos, int dado){
	    
	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Localiza a pos. ANTERIOR onde ser� inserido o novo n�
	    No aux = cabeca;
	    for (int i =1; i < pos-1; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }
	    /*while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // pos. inv�lida 
	    		return false;
	    }*/

	    // Insere novo elemento apos aux
	    /*novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);*/
	    
	    // Insere novo elemento apos aux
	    No p = aux.getProx();
	    novoNo.setProx(p);
	    aux.setProx(novoNo);
	    
	    nElementos++;
	    novoNo.createUI();
	    return true;
	}

	/** Insere n� no fim da lista */
	private boolean insereFimLista(int dado){
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Procura o final da lista 
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    this.nElementos++;
	    novoNo.createUI();
	    aux.setProx(novoNo);

	    
	    
	    return true;
	}

	/**Insere um elemento em uma determinada posi��o
	    Retorna true se conseguir inserir e 
	    false caso contrario */
	public boolean insere(int pos, int dado) {
		if ((vazia()) && (pos != 1)){
	        return false; /* lista vazia mas posicao inv*/
	    }

	 	/* inser��o no in�cio da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    /* inser��o no fim da lista */
	    else if (pos == nElementos+1){
	        return insereFimLista(dado);
	   }
	   /* inser��o no meio da lista */
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	/** Remove elemento do in�cio da lista */
	private int removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    nElementos--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos){
	     No atual = null, antecessor = null;
	     int dado = -1;
	     int cont = 1;

	     /* Localiza o n� que ser� removido*/
	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.getProx();
	           cont++;
	     }

	     if (atual == null) { /* pos. inv�lida */
	        return -1;
	     }

	    /* retira o elemento da lista */
	    dado = atual.getConteudo();
	    antecessor.setProx(atual.getProx());
	    nElementos--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    atual = null;
	    return dado;
	}

	/**Remove um elemento de uma determinada posi��o
	    Retorna o valor a ser removido. 
	    -1 se a posi��o for inv�lida ou a lista estiver vazia*/
	public int remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    		return -1;
	    }

	    // Remo��o do elemento da cabe�a da lista 
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remo��o em outro lugar da lista
	    else{
	        return removeNaLista(pos);
	    }
	}
}