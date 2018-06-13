import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ListaSeq {
	private int dados[]; // Vetor que contém os dados da lista 
	private int nElementos; 
	private int tamMax;
	
	Text texts[] = new Text[10];
	Arrow arrows[] = new Arrow[10];
	Circle circles[] = new Circle[10];
	
	
	public void createUI (Group pane) {
		for (int i = 0; i < 10; i++) {
			this.circles[i] = new Circle (80*(i+1), 200, 30);
			this.circles[i].setStroke(Color.BLACK);
			this.circles[i].setFill(Color.WHITE);
			this.texts[i] = new Text(circles[i].getCenterX() - 10, circles[i].getCenterY() + 5, "");
			this.arrows[i] = new Arrow (80*(i+1) + 30, 200, 80*(i+2) - 30, 200);
			
		}		
		for (int i = 0; i < 10; i++) {
			pane.getChildren().addAll(this.circles[i], this.arrows[i], this.texts[i]);
		}
	}
    
    public ListaSeq(){
    		tamMax = 10;
    		nElementos = 0;
    		dados = new int[tamMax];
    }
    
    public ListaSeq(int n){
    		tamMax = n;
    		nElementos = 0;
		dados = new int[tamMax];
    }

    /** Verifica se a Lista está vazia */
    public boolean vazia(){
		if (nElementos == 0 )
			return true;
		else
			return false;
	}
	
    /**Verifica se a Lista está cheia */
    public boolean cheia(){
		if (nElementos == tamMax)
			return true;
		else
			return false;
	}
	
    /**Obtém o tamanho da Lista*/
    public int tamanho(){
		return nElementos;
	}
    
    /** Obtém o i-ésimo elemento de uma lista.
    		Retorna -1 se a posição for inválida. */
    public int elemento(int pos){
        
    	/* Se posição estiver fora dos limites <= 0 
         * ou > tamanho da lista */
        if ((pos > nElementos) || (pos <= 0))
            return -1;

       return dados[pos-1];
	}

    /**	Retorna a posição de um elemento pesquisado.
    		Retorna -1 caso não seja encontrado */
	public int posicao (int valor){
	    /* Procura elemento a elemento, se o dado está na
	    		lista. Se estiver, retorna a sua posição no array+1 */
	    for (int i = 0; i < nElementos; i++){
	        if (dados[i] == valor){
	            return (i + 1);
	        }
	    }

	    return -1;
	}
	
	/**	Retorna a posição de um elemento pesquisado.
	Retorna -1 caso não seja encontrado */
	public int posicao (int valor, int desloc){
		/* Procura elemento a elemento, se o dado está na
		lista. Se estiver, retorna a sua posição no array+1 */
		for (int i = desloc+1; i < nElementos; i++){
		    if (dados[i] == valor){
		        return (i + 1);
		    }
		}
		
		return -1;
	}
	
	/**Insere um elemento em uma determinada posição
    		Retorna false se a lista estiver cheia ou
    		a posição for inválida. Caso contrário retorna true */
	public boolean insere (int pos, int dado){
	    /* Verifica se a lista está cheia ou se a posicao a ser
	    inserida eh invalida (i.e., > tamanho da lista+1*/
	    if (cheia() || (pos > nElementos+1) || (pos <=0)){
	        return false;
	    }

	    /* Desloca os elementos após pos, uma posicao a
	    direita. Isso serve para abrir espaço para insercao
	    do novo elemento */
	    for (int i = nElementos; i >= pos; i--){
	 		 dados[i] = dados[i-1];
	 		 texts[i].setText(texts[i-1].getText());;
	 		 
	    }

	    /* Insere o dado na posicao correta */
	    dados[pos - 1] = dado;
	    texts[pos - 1].setText(dado + "");

	 	/* Incrementa o numero de elementos na lista */
	    nElementos++;
	    return true;
	}
	
	/**Remove um elemento de uma determinada posição
    Retorna o valor do elemento removido. -1 caso a remoção falhe  */
	public int remove(int pos){
	    int dado;
		/* Verifica se a posicao eh valida */
	    if ((pos > nElementos) || (pos < 1 )) 
			   return -1;

	    /* Armazena o dado a ser removido na var "dado" */
	    dado = dados[pos-1];
	    

	    /* Desloca todos os elementos após 'pos', uma
	    posicao a esquerda */
	    for (int i = pos - 1; i < nElementos - 1; i++){
	 		  dados[i] = dados[i+1];
	 		  texts[i].setText(texts[i+1].getText());
		}
	    

	   /* Decrementa o numero de elementos na lista */
	    nElementos--;
	    texts[nElementos].setText("");
	    return dado;
	}
}
