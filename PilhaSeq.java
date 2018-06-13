import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PilhaSeq {
		private int dados[]; // Vetor que contém os dados da lista 
		private int topo; 
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
		
	    public PilhaSeq(){
	    		tamMax = 10;
	    		dados = new int[tamMax];
	    		
	    		topo = -1;
	    	}
	    
	    public PilhaSeq(int n){
	    		tamMax = n;
	    		dados = new int[tamMax];
	    		
	    		topo = -1;
	    }

	    /** Verifica se a Pilha está vazia */
	    public boolean vazia(){
	    		if (topo == -1)
	    			return true;
	    	   else 
	    	      return false;
		}
		
	    /**Verifica se a Pilha está cheia */
	    public boolean cheia(){
	        if (topo == (tamMax-1))
	  		  return true;
	      else
	  		  return false;
		}
		
	    /**Obtém o tamanho da Pilha*/
	    public int tamanho(){
			return topo+1;
		}
	    
	    /** Consulta o elemento do topo da Pilha.
			Retorna -1 se a pilha estiver vazia, 
			caso contrário retorna o valor que está no topo da pilha. */
	 	public int top () {
	      if (vazia()) 
	         return -1; // pilha vazia
	 	  
	      return dados[topo];
	 	}
	     
		 /** Insere um elemento no topo da pilha.
		  Retorna false se a pilha estiver cheia. 
		  Caso contrário retorna true */
	 	public boolean push (int valor) {
	 		if (cheia()) 
	 			return false;  // err: pilha cheia 
	 		
	 		topo++;
	 		dados[topo] = valor; 
	 		texts[topo].setText(valor+"");
	 		return true;
		 }   

		 /** Retira o elemento do topo da pilha.
		  Retorna -1 se a pilha estiver vazia. */
	 	public int pop() {          
	 		if (vazia()) 
	 			return -1; // Pilha vazia
	 		
	 		int valor = dados[topo]; 
	 		texts[topo].setText("");
	 		topo--; 
	 		return valor;
	 	}
	}


