
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PilhaEnc {
	No topo;
	private static int nElementos;
	
	public void createUI(Group pane) {
		pane.getChildren().addAll(this.topo.circle, this.topo.arrow, this.topo.text);
	}
	public void deleteFromUI(Group pane) {
	pane.getChildren().removeAll(this.topo.circle, this.topo.arrow, this.topo.text);
		
	}
	
	public PilhaEnc(){
		topo = null;
		nElementos = 0;
	}
	
	/** Verifica se a Pilha está vazia*/
	public boolean vazia () {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/** Obtém o tamanho da Pilha*/
	public int tamanho() {
	    return nElementos;

	/*  No p = topo;
	    	int i = 0;
	    	while(p != null){
	       p = p.getProx();
	       i++;
	    }
	    return i;
	*/
	}

	/** Consulta o elemento do topo da Pilha
	    Retorna -1 se a pilha estiver vazia.*/
	public int top (){
	    if (vazia()){
	        return -1; // Pilha vazia 
	    }

	    return topo.getConteudo();
	}

	/** Insere um elemento no topo da pilha.
	    Retorna true se a insercao funcionar*/
	public boolean push(int valor) {
	    
		// Aloca memoria para novo no e preenche conteudo 
	    No novoNo = new No();
	    novoNo.setConteudo(valor);

	    // Faz o novo no apontar pro atual topo da pilha
	    novoNo.setProx(topo);
	    
	    // Atualiza o topo da pilha que agora sera o novo nó 
	    topo = novoNo;

	    // Atualiza o tamanho da pilha 
	    nElementos++;
	    novoNo.createUI();
	    return true;
	}

	/** Retira o elemento do topo da pilha.
	    Retorna -1 se a pilha estiver vazia.
	    Caso contrário retorna o valor removido */
	public int pop () {
	    if (vazia()) {
	    		return -1; // pilha vazia 
	    }
	    // Guarda o nó que é topo da pilha e o seu conteudo
	    No p = topo;
	    int valor = p.getConteudo();

	    /* Modifica o topo da pilha para ser o proximo elemento (2o elemento da pilha) */
	    /* Isso equivale a retirar o 1o elemento (topo) da pilha */
	    topo = p.getProx();

	    // Decrementa o tamanho da pilha 
	    nElementos--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    p= null;

	    return valor;
	}
	
	class No {
		private int conteudo;
		private No prox;
		
		Text text;
		Arrow arrow;
		Circle circle;
		
		public void createUI () {
			this.circle = new Circle(80 * (PilhaEnc.nElementos), 200, 30);
			this.circle.setStroke(Color.BLACK);
			this.circle.setFill(Color.WHITE);
			this.text = new Text(circle.getCenterX() - 10, circle.getCenterY() + 5,conteudo + "");
			this.arrow = new Arrow(80 * (PilhaEnc.nElementos) + 30, circle.getCenterY(), 80 * (1 + PilhaEnc.nElementos) - 30, circle.getCenterY());
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

