
import javafx.application.Application;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import javafx.event.EventHandler;


public class ProjetoED extends Application {
	public static final int LT = 640; // largura da tela
	public static final int AT = 480; // altura da tela
	public static final int QB = 8; // qntd de botoes
	public static final int TB = LT / QB; //tamanho dos botões
	
	Button listaSeqButton = new Button("Lista Seq.");
	Button LSEButton = new Button("Lista Enc.");
	
	Button pilhaSeqButton = new Button("Pilha Seq.");
	Button pilhaEncButton = new Button("Pilha Enc.");
	Button filaSeqButton = new Button("Fila Seq.");
	Button filaEncButton = new Button("Fila Enc.");
	
	// para todos
	TextField inserirText = new TextField();
	Button inserirButton = new Button("Inserir");
	
	TextField removerText = new TextField();
	Button removerButton = new Button("Remover");
	
	
	
	
	// para listas
	Button elementoButton = new Button("Elemento");
	TextField elementoInsereText = new TextField();
	Text elementoText = new Text();
	
	Button posicaoButton = new Button("Posicao");
	Text posicaoText = new Text();
	TextField posicaoBuscaText = new TextField();
	TextField posicaoInsereText = new TextField();
	
	
	
	// para pilhas
	Button empilharButton = new Button("Empilhar");
	Button desempilharButton = new Button("Desempilhar");
	Button topoButton = new Button("Topo");
	Text topoText = new Text();
	
	// para filas
	Button enfilarButton = new Button("Enfilar");
	Button desenfilarButton = new Button("Desenfilar");
	Button primeiroButton = new Button("Primeiro");
	Text primeiroText = new Text();
	
	// para todos
	Button tamanhoButton = new Button("Tamanho");
	Text tamanhoText = new Text();
	
	Button limparButton = new Button("Limpar");
	Button criarButton = new Button("Criar");
	TextField criarText = new TextField();
	
	
	public void carregaButtons() {
		listaSeqButton.setLayoutX(TB * 0);
		listaSeqButton.setLayoutY(0);
		listaSeqButton.setMaxSize(TB, 25);
		listaSeqButton.setMinSize(TB, 25);
		
		LSEButton.setLayoutX(TB * 1);
		LSEButton.setLayoutY(0);
		LSEButton.setMaxSize(TB, 25);
		LSEButton.setMinSize(TB, 25);
			
		pilhaSeqButton.setLayoutX(TB * 2);
		pilhaSeqButton.setLayoutY(0);
		pilhaSeqButton.setMaxSize(TB, 25);
		pilhaSeqButton.setMinSize(TB, 25);
		
		pilhaEncButton.setLayoutX(TB * 3);
		pilhaEncButton.setLayoutY(0);
		pilhaEncButton.setMaxSize(TB, 25);
		pilhaEncButton.setMinSize(TB, 25);
		
		filaSeqButton.setLayoutX(TB * 4);
		filaSeqButton.setLayoutY(0);
		filaSeqButton.setMaxSize(TB, 25);
		filaSeqButton.setMinSize(TB, 25);
		
		filaEncButton.setLayoutX(TB * 5);
		filaEncButton.setLayoutY(0);
		filaEncButton.setMaxSize(TB, 25);
		filaEncButton.setMinSize(TB, 25);

		
		
		
		// Botoes 
		// Inserir
		inserirText.setLayoutX(TB * 0);
		inserirText.setLayoutY(25);
		inserirText.setMaxSize(TB, 25);
		inserirText.setMinSize(TB, 25);
		inserirButton.setLayoutX(TB);
		inserirButton.setLayoutY(25);
		inserirButton.setMaxSize(TB, 25);
		inserirButton.setMinSize(TB, 25);
		// Remover
		removerText.setLayoutX(TB * 2);
		removerText.setLayoutY(25);
		removerText.setMaxSize(TB, 25);
		removerText.setMinSize(TB, 25);
		removerButton.setLayoutX(TB * 3);
		removerButton.setLayoutY(25);
		removerButton.setMaxSize(TB, 25);
		removerButton.setMinSize(TB, 25);		
		// para todos
		// Tamanho
		tamanhoButton.setLayoutX(TB * 7);
		tamanhoButton.setLayoutY(25);
		tamanhoButton.setMaxSize(TB, 25);
		tamanhoButton.setMinSize(TB, 25);
		// Exibe Tamanho
		tamanhoText.setLayoutX(TB * 6.45);
		tamanhoText.setLayoutY(45);
		// Botoes para listas
		// elemento
		elementoButton.setLayoutX(TB * 4);
		elementoButton.setLayoutY(50);
		elementoButton.setMaxSize(TB, 25);
		elementoButton.setMinSize(TB, 25);
		elementoInsereText.setLayoutX(TB*3);
		elementoInsereText.setLayoutY(50);
		elementoInsereText.setMaxSize(TB, 25);
		elementoInsereText.setMinSize(TB, 25);
		elementoInsereText.setPromptText("Buscar posicao");
		elementoText.setLayoutX(TB * 5.45);
		elementoText.setLayoutY(70);
		// posicao (valor)
		posicaoText.setLayoutX((TB * 2.45));
		posicaoText.setLayoutY(70);
		posicaoButton.setLayoutX(TB*1);
		posicaoButton.setLayoutY(50);
		posicaoButton.setMaxSize(TB, 25);
		posicaoButton.setMinSize(TB, 25);
		posicaoBuscaText.setLayoutX(TB*0);
		posicaoBuscaText.setLayoutY(50);
		posicaoBuscaText.setMaxSize(TB, 25);
		posicaoBuscaText.setMinSize(TB, 25);
		posicaoBuscaText.setPromptText("Buscar valor");
		
		posicaoInsereText.setLayoutX(TB * 0);
		posicaoInsereText.setLayoutY(25);
		posicaoInsereText.setMaxSize(TB, 25);
		posicaoInsereText.setMinSize(TB, 25);
		// 

		// Botoes para pilhas
		// Empilhar
		empilharButton.setLayoutX(TB);
		empilharButton.setLayoutY(25);
		empilharButton.setMaxSize(TB, 25);
		empilharButton.setMinSize(TB, 25);
		// Desempilhar
		desempilharButton.setLayoutX(TB * 3);
		desempilharButton.setLayoutY(25);
		desempilharButton.setMaxSize(TB, 25);
		desempilharButton.setMinSize(TB, 25);
		// Topo
		topoButton.setLayoutX(TB * 5);
		topoButton.setLayoutY(25);
		topoButton.setMaxSize(TB, 25);
		topoButton.setMinSize(TB, 25);
		// Exibe topo
		topoText.setLayoutX(TB * 4.45);
		topoText.setLayoutY(45);
		
		
		// Botoes para as Filas
		// Enfilar
		enfilarButton.setLayoutX(TB);
		enfilarButton.setLayoutY(25);
		enfilarButton.setMaxSize(TB, 25);
		enfilarButton.setMinSize(TB, 25);
		// Desenfilar
		desenfilarButton.setLayoutX(TB * 3);
		desenfilarButton.setLayoutY(25);
		desenfilarButton.setMaxSize(TB, 25);
		desenfilarButton.setMinSize(TB, 25);
		// Primeiro
		primeiroButton.setLayoutX(TB * 5);
		primeiroButton.setLayoutY(25);
		primeiroButton.setMaxSize(TB, 25);
		primeiroButton.setMinSize(TB, 25);
		// Exibe primeiro 
		primeiroText.setLayoutX(TB * 4.45);
		primeiroText.setLayoutY(45);

		
		criarText.setLayoutX(TB * 0);
		criarText.setLayoutY(50);
		criarText.setMaxSize(TB, 25);
		criarText.setMinSize(TB, 25);
		
		criarButton.setLayoutX(TB*1);
		criarButton.setLayoutY(50);
		criarButton.setMaxSize(TB, 25);
		criarButton.setMinSize(TB, 25);
		
		limparButton.setLayoutX(TB * 2);
		limparButton.setLayoutY(50);
		limparButton.setMaxSize(TB, 25);
		limparButton.setMinSize(TB, 25);
	}
	
	@Override
	public void start(Stage stage) throws Exception {	
		
		carregaButtons();
	
		Text text = new Text();
		text.setLayoutX(300);
		text.setLayoutY(300);
		
		final Group root = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, posicaoText);
		
		
		Scene mainScene = new Scene(root, LT, AT);
		
		stage.setTitle("Projeto ED");
		stage.setScene(mainScene);
		
		
		
		listaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				inserirText.setLayoutX(TB * 1);
				inserirText.setLayoutY(25);
				inserirText.setMaxSize(TB, 25);
				inserirText.setMinSize(TB, 25);
				inserirButton.setLayoutX(TB *2);
				inserirButton.setLayoutY(25);
				inserirButton.setMaxSize(TB, 25);
				inserirButton.setMinSize(TB, 25);
				
				removerText.setLayoutX(TB * 3);
				removerText.setLayoutY(25);
				removerText.setMaxSize(TB, 25);
				removerText.setMinSize(TB, 25);		
				removerButton.setLayoutX(TB * 4);
				removerButton.setLayoutY(25);
				removerButton.setMaxSize(TB, 25);
				removerButton.setMinSize(TB, 25);		
				

				ListaSeq lista = new ListaSeq();
				
				ScrollPane sp = new ScrollPane();
				Group listaSeqGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, inserirButton, inserirText, removerButton, removerText, tamanhoButton, tamanhoText, elementoText, elementoButton, posicaoInsereText, posicaoButton, posicaoBuscaText, posicaoText, elementoInsereText);
				sp.setContent(listaSeqGroup);
				Scene listaSeqScene = new Scene(sp, LT, AT);
				
				
				
				lista.createUI(listaSeqGroup);
				stage.setScene(listaSeqScene);
				
				inserirButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						lista.insere((Integer.parseInt(posicaoInsereText.getText())), (Integer.parseInt(inserirText.getText())));
					}
				}));
				removerButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						lista.remove(Integer.parseInt(removerText.getText()));
					}
				}));
				
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(lista.tamanho() + "");
					}
				}));
				posicaoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						posicaoText.setText( lista.posicao( Integer.parseInt(posicaoBuscaText.getText()) ) + "" );
					}
				}));
				elementoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						elementoText.setText( lista.elemento( Integer.parseInt(elementoInsereText.getText()) ) + "" );
					}
				}));
			}
		}));
		LSEButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				inserirText.setLayoutX(TB * 1);
				inserirText.setLayoutY(25);
				inserirText.setMaxSize(TB, 25);
				inserirText.setMinSize(TB, 25);
				inserirText.setPromptText("valor");
				inserirButton.setLayoutX(TB *2);
				inserirButton.setLayoutY(25);
				inserirButton.setMaxSize(TB, 25);
				inserirButton.setMinSize(TB, 25);
				
				removerText.setLayoutX(TB * 3);
				removerText.setLayoutY(25);
				removerText.setMaxSize(TB, 25);
				removerText.setMinSize(TB, 25);		
				removerButton.setLayoutX(TB * 4);
				removerButton.setLayoutY(25);
				removerButton.setMaxSize(TB, 25);
				removerButton.setMinSize(TB, 25);		
				

				LSE lista = new LSE();
				
				ScrollPane sp = new ScrollPane();
				Group LSEGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, inserirButton, inserirText, removerButton, removerText, tamanhoButton, tamanhoText, elementoText, elementoButton, posicaoInsereText, posicaoButton, posicaoBuscaText, posicaoText, elementoInsereText);
				sp.setContent(LSEGroup);
				Scene LSEScene = new Scene(sp, LT, AT);
				
				stage.setScene(LSEScene);
				
				inserirButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						lista.insere((Integer.parseInt(posicaoInsereText.getText())), (Integer.parseInt(inserirText.getText())));
						lista.createUI(LSEGroup, Integer.parseInt(posicaoInsereText.getText()));
						
					}
				}));
				removerButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
//						lista.removeUI(LSEGroup);
						lista.removeUI(LSEGroup, Integer.parseInt(removerText.getText()));
						lista.remove(Integer.parseInt(removerText.getText()));
						
						
					}
				}));
				
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(lista.tamanho() + "");
					}
				}));
				posicaoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						posicaoText.setText( lista.posicao( Integer.parseInt(posicaoBuscaText.getText()) ) + "" );
					}
				}));
				elementoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						elementoText.setText( lista.elemento( Integer.parseInt(elementoInsereText.getText()) ) + "" );
					}
				}));
			}

		}));
				pilhaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				PilhaSeq pilha = new PilhaSeq();
				
				ScrollPane sp = new ScrollPane();
				Group pilhaSeqGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, empilharButton, inserirText, desempilharButton, removerText, tamanhoButton, tamanhoText, topoButton, topoText);
				sp.setContent(pilhaSeqGroup);
				Scene pilhaSeqScene = new Scene(sp, LT, AT);
				
				
				
				pilha.createUI(pilhaSeqGroup);
				stage.setScene(pilhaSeqScene);
				
				empilharButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						pilha.push(Integer.parseInt(inserirText.getText()));
					}
				}));
				desempilharButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						pilha.pop();
					}
				}));
				topoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						topoText.setText(pilha.top() + "");
					}
				}));
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(pilha.tamanho() + "");
					}
				}));
			}
		}));
		pilhaEncButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				PilhaEnc pilha = new PilhaEnc();
				
				ScrollPane sp = new ScrollPane();
				Group pilhaEncGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, empilharButton, inserirText, desempilharButton, removerText, tamanhoButton, tamanhoText, topoButton, topoText);
				sp.setContent(pilhaEncGroup);
				Scene pilhaEncScene = new Scene(sp, LT, AT);
				
				stage.setScene(pilhaEncScene);
				
				empilharButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						pilha.push(Integer.parseInt(inserirText.getText()));
						pilha.createUI(pilhaEncGroup);
					}
				}));
				desempilharButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						pilha.deleteFromUI(pilhaEncGroup);
						pilha.pop();
					}
				}));
				topoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						topoText.setText(pilha.top() + "");
					}
				}));
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(pilha.tamanho() + "");
					}
				}));
			}
		}));
		filaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FilaSeq fila = new FilaSeq();
				
				ScrollPane sp = new ScrollPane();
				Group filaSeqGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, enfilarButton, inserirText, desenfilarButton, primeiroButton, primeiroText, tamanhoButton, tamanhoText);
				sp.setContent(filaSeqGroup);
				Scene filaSeqScene = new Scene(sp, LT, AT);
				
				fila.createUI(filaSeqGroup);
				
				stage.setScene(filaSeqScene);
				
				enfilarButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						fila.insere(Integer.parseInt(inserirText.getText()));
					}
				}));
				desenfilarButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						fila.remove();
					}
				}));
				primeiroButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						primeiroText.setText(fila.primeiro() + "");
					}
				}));
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(fila.tamanho() + "");
					}
				}));
			}
		}));		
		filaEncButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FilaEnc fila = new FilaEnc();
				
				ScrollPane sp = new ScrollPane();
				Group filaEncGroup = new Group(listaSeqButton, LSEButton, pilhaSeqButton, pilhaEncButton,filaSeqButton, filaEncButton, enfilarButton, inserirText, desenfilarButton, primeiroButton, primeiroText, tamanhoButton, tamanhoText);
				sp.setContent(filaEncGroup);
				Scene filaEncScene = new Scene(sp, LT, AT);
				
				stage.setScene(filaEncScene);
				
				
				
				enfilarButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						fila.insere(Integer.parseInt(inserirText.getText()));
						fila.createUI(filaEncGroup);
					}
				}));
				desenfilarButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						fila.deleteFromUI(filaEncGroup);
						fila.remove();
						
					}
				}));
				primeiroButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						primeiroText.setText(fila.primeiro() + "");
					}
				}));
				tamanhoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						tamanhoText.setText(fila.tamanho() + "");
					}
				}));
			}
		}));
		inserirButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
			}
		}));
		removerButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
			}
		}));
		// para filas
		// enfilar
//		enfilarButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
////				
//			}
//		}));
		// primeiro da fila
		primeiroButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primeiroText.setText("21");
			}
		}));
		stage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
