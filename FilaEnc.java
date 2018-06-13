
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class FilaEnc {
	private No inicio;  // aponta para o inicio da fila 
	private No fim;    	// aponta para o fim da fila  a
	private static int nElementos;
	
	public void createUI(Group pane) {
		pane.getChildren().addAll(this.fim.circle, this.fim.arrow, this.fim.text);
	}
	public void deleteFromUI(Group pane) {
		pane.getChildren().removeAll(this.inicio.circle, this.inicio.arrow, this.inicio.text);
		No aux = inicio;
		pane.getChildren().removeAll(aux.circle, aux.arrow, aux.text);
		for (int j = 0; j < nElementos; j ++) {
			aux.circle.setCenterX(aux.circle.getCenterX() - 80);
			aux.text.setLayoutX(aux.text.getLayoutX() - 80);
			aux.arrow.setLayoutX(aux.arrow.getLayoutX() - 80);
			aux = aux.getProx();
		}
	}
		
	/** Cria uma Fila  */
	public FilaEnc() {
		inicio = null;
		fim = null;
		nElementos = 0;
	}

	/**Verifica se a Fila está vazia */
	public boolean vazia () {
		if (nElementos == 0)
			return true;
		else
			return false;
	}

	/** Obtém o tamanho da Fila */
	public int tamanho () {
		return nElementos;
	}

	/** Consulta o elemento do início da fila
	    Retorna -1 se a fila estiver vazia */
	public int primeiro () {
		if (vazia())
			return -1; // Erro: Fila vazia 

		return inicio.getConteudo();
	}

	/** Insere um elemento no fim de uma fila
	    Retorna false se a mem. for insuficiente, true caso contrário*/
	public boolean insere (int valor) {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(null);

	    if (vazia()){    /*Inserção em fila vazia */
	        inicio = novoNo;
	    }
	    else {
			fim.setProx(novoNo); /* liga com a fila */
		}
		fim = novoNo; /* atualiza o novo fim */
	    nElementos++;
	    novoNo.createUI();
	    return true;
	}

	/**Retira o elemento do início da fila e retorna o seu valor
	    Retorna -1 se a fila estiver vazia. */
	public int remove() {
		if (vazia()) {
	        return -1; // Erro: Fila vazia 
	    }

		int valor = primeiro();
		No p = inicio;
		if (inicio == fim){ // Fila com 1 elemento 
			fim = null;
			inicio = null;
	 	}
	 	else{
			inicio = p.getProx();
	 	}	
		/* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    p= null;

	    nElementos--;
		return valor;
	}

	class No {
		private int conteudo;
		private No prox;

		Text text;
		Arrow arrow;
		Circle circle;
		
		public void createUI () {
			this.circle = new Circle(80 * (FilaEnc.nElementos), 200, 30);
			this.circle.setStroke(Color.BLACK);
			this.circle.setFill(Color.WHITE);
			this.text = new Text(circle.getCenterX() - 10, circle.getCenterY() + 5,conteudo + "");
			this.arrow = new Arrow(80 * (FilaEnc.nElementos) + 30, circle.getCenterY(), 80 * (1 + FilaEnc.nElementos) - 30, circle.getCenterY());
//			pane.getChildren().addAll(this.circle, this.arrow, this.text);
		}


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
	
}