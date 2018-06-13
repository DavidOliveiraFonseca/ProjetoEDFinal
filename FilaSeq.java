import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import javafx.scene.text.Text;

public class FilaSeq{
	private int dados[];
	private int inicio;
	private int fim;
	
	private int nElementos;
	private int tamMax;
	
	Text texts[] = new Text[10];
	Arrow arrows[] = new Arrow[10];
	Circle circles[] = new Circle[10];
	
	
	
	public void createUI (Group pane) {
//		this.arrow0 = new Arrow(80*1 + 30, 200, 80*2 - 30, 200);
		for (int i = 0; i < 10; i++) {
			this.circles[i] = new Circle (80*(i+1), 200, 30);
			this.circles[i].setStroke(Color.BLACK);
			this.circles[i].setFill(Color.WHITE);
//			this.texts[i] = new Text(80*(i+1) - 10, 205, "");
			this.texts[i] = new Text(circles[i].getCenterX() - 10, circles[i].getCenterY() + 5, "");
			this.arrows[i] = new Arrow (80*(i+1) + 30, 200, 80*(i+2) - 30, 200);
			
		}		
		for (int i = 0; i < 10; i++) {
			pane.getChildren().addAll(this.circles[i], this.arrows[i], this.texts[i]);
		}
	}
	public FilaSeq() {
		inicio = 0;
		fim = -1;
		nElementos = 0;
		
		tamMax = 10;
		dados =  new int[tamMax];
	}
	
	public FilaSeq(int n) {
		inicio = 0;
		fim = -1;
		nElementos = 0;
		
		tamMax = n;
		dados =  new int[tamMax];
	}

	/** Verifica se a Fila está vazia */
	public boolean vazia () {
		if (nElementos == 0)
			return true;
		else
			return false;
	}

	/**Verifica se a Fila está cheia */
	public boolean cheia () {
		if (nElementos == tamMax)
			return true;
		else
			return false;
	}

	/** Obtém o tamanho da Fila */
	public int tamanho() {
		return nElementos;
	}

	/** Consulta o elemento do início da fila.
	    Retorna -1 se a fila estiver vazia. */
	public int primeiro() {
		if (vazia())
			return -1; // Erro: Fila vazia 
		
		return dados[inicio];
	}

	/**Insere um elemento no fim de uma fila
    Retorna false se a fila estiver cheia, true caso contrário. */
	public boolean insere(int valor) {
		if (cheia()){
			return false;
		}
	
		fim = (fim + 1) % tamMax; // Circularidade 
	    dados[fim] = valor;
	    texts[fim].setText(valor + "");;
		nElementos++;
		return true;
	}

	/**Remove o elemento do início da fila e retorna o valor removido.
	    Retorna -1 se a fila estiver vazia.*/
	public int remove() {
		if (vazia())
			return -1;
	
		int res = primeiro();
		texts[inicio].setText("");
		inicio = (inicio + 1) % tamMax; //Circularidade
		nElementos--;
		return res;
	}

}
