import java.awt.*;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {

	private ArrayList<Peca> pecas = new ArrayList<Peca>();

	private static ArrayList<Peca> pecasForaDoJogo = new ArrayList<Peca>();
  
  private JLabel jogadordavez = new JLabel("Vez do jogador BRANCO");

	private String espacos;
	
	private JButton botao;

	
	//imagem do tabuleiro
	private Icon imagemTabuleiro;
	
	//imagens das pecas pretass
	private Icon imagemPeaoPreto;
	private Icon imagemCavalo1Preto;
	private Icon imagemCavalo2Preto;
	private Icon imagemTorre1Preto;
	private Icon imagemTorre2Preto;
	private Icon imagemBispo1Preto;
	private Icon imagemBispo2Preto;
	private Icon imagemRainhaPreto;
	private Icon imagemReiPreto;
	//imagens das pecas brancas
	private Icon imagemPeaoBranco;
		
	private Icon imagemCavalo1Branco;
	private Icon imagemCavalo2Branco;
		
	private Icon imagemTorre1Branco;
	private Icon imagemTorre2Branco;
		
	private Icon imagemBispo1Branco;
	private Icon imagemBispo2Branco;
		
	private Icon imagemRainhaBranco;
		
	private Icon imagemReiBranco;
	
	
	//Label pretos
	private JLabel imagemLabelPeaoPreto;
	private JLabel imagemLabelCavalo1Preto;
	private JLabel imagemLabelCavalo2Preto;
	private JLabel imagemLabelBispo1Preto;
	private JLabel imagemLabelBispo2Preto;
	private JLabel imagemLabelTorre1Preto;
	private JLabel imagemLabelTorre2Preto;
	private JLabel imagemLabelRainhaPreto;
	private JLabel imagemLabelReiPreto;
	//Label brancos
	private JLabel imagemLabelPeaoBranco;
	private JLabel imagemLabelCavalo1Branco;
	private JLabel imagemLabelCavalo2Branco;
	private JLabel imagemLabelBispo1Branco;
	private JLabel imagemLabelBispo2Branco;
	private JLabel imagemLabelTorre1Branco;
	private JLabel imagemLabelTorre2Branco;
	private JLabel imagemLabelRainhaBranco;
	private JLabel imagemLabelReiBranco;
	
	
	//tabuleiro
	private  JPanel tabuleiro;
		
		
	//janela do jogo
	private JFrame janelaJogo;
	
	//botao de reiniciar
	private JButton botaoReiniciar;
	
	//botao de instrucoes
	private JButton botaoInstrucoes;
	
	//botao de regras
	private JButton botaoRegras;
	
	//botao de sair
	private JButton botaoSair;
	
	//botao das pecas comidas
	private JButton botaoPecas;
	
	//coordenadas iniciais
	int xTabuleiro = 50, yTabuleiro = 50, xPecaPreta = 50, yPecaPreta = 50,xPecaBranca = 50,yPecaBranca = 410;
	
		
	//construtor do tabuleiro (serve para reiniciar jogo)
	public Tabuleiro(){
		janelaJogo = new JFrame();
		janelaJogo.setTitle("Xadrez");
		janelaJogo.setIconImage(new ImageIcon("image/chess.png").getImage());
		this.MontaComponentes();
	}
	
	private void MontaComponentes(){
		botaoReiniciar = new JButton("Reiniciar");
		botaoSair = new JButton("Sair");
		botaoInstrucoes = new JButton("Instrucoes");
		botaoRegras = new JButton("Regras");
		botaoPecas = new JButton("Cemiterio");
		
		//criando nova instancia de imagem do tabuleiro
		imagemTabuleiro = new ImageIcon("image/board_chess.png");
		
		//criando novas instancias de imagens das pecas pretas
		imagemPeaoPreto = new ImageIcon("image/peaoPreto.png");
		imagemCavalo1Preto = new ImageIcon("image/cavaloPreto.png");
		imagemCavalo2Preto = new ImageIcon("image/cavaloPreto.png");
		imagemBispo1Preto = new ImageIcon("image/bispoPreto.png");
		imagemBispo2Preto = new ImageIcon("image/bispoPreto.png");
		imagemTorre1Preto = new ImageIcon("image/torrePreto.png");
		imagemTorre2Preto = new ImageIcon("image/torrePreto.png");
		imagemReiPreto = new ImageIcon("image/reiPreto.png");
		imagemRainhaPreto = new ImageIcon("image/rainhaPreto.png");
		//criando novas instancias de imagens das pecas pretas
		imagemPeaoBranco = new ImageIcon("image/peaoBranco.png");
		imagemCavalo1Branco = new ImageIcon("image/cavaloBranco.png");
		imagemCavalo2Branco = new ImageIcon("image/cavaloBranco.png");
		imagemBispo1Branco = new ImageIcon("image/bispoBranco.png");
		imagemBispo2Branco = new ImageIcon("image/bispoBranco.png");
		imagemTorre1Branco = new ImageIcon("image/torreBranco.png");
		imagemTorre2Branco = new ImageIcon("image/torreBranco.png");
		imagemReiBranco = new ImageIcon("image/reiBranco.png");
		imagemRainhaBranco = new ImageIcon("image/rainhaBranco.png");
										
		
		tabuleiro = new JPanel();
		
		//O layout do tabuleiro Ã© definido como nulo (por enquanto)
		tabuleiro.setLayout(null);

		jogadordavez.setFont(new Font("", Font.BOLD, 23));
		//define tamanho e posicao dos botoes
		jogadordavez.setBounds(50, 0, 600, 50);
		botaoReiniciar.setBounds(550, 350, 100, 30);
		botaoInstrucoes.setBounds(550, 384, 100, 30);
		botaoRegras.setBounds(550, 418, 100, 30);
		botaoSair.setBounds(550, 452, 100, 30);
		botaoPecas.setBounds(550,100,100,70);
				
		//adiciona ação nos botoes ao clicar com o mouse neles
		botaoRegras.addActionListener(new ApareceJanelaRegras("Janela de regras"));
		botaoInstrucoes.addActionListener(new ApareceJanelaInstrucoes("Janela de instrucoes"));
		botaoSair.addActionListener(new FechaJogo());
		botaoReiniciar.addActionListener(new ReiniciaJogo(this));
		botaoPecas.addActionListener(new AparecePecasComidas("Pecas fora do jogo"));
		tabuleiro.add(jogadordavez);
		tabuleiro.add(botaoReiniciar);
		tabuleiro.add(botaoInstrucoes);
		tabuleiro.add(botaoRegras);
		tabuleiro.add(botaoSair);
		tabuleiro.add(botaoPecas);	
				
		montarTabuleiro();
				
		tabuleiro.setBounds(10, 10, 500, 500);
				
		//adiciona o tabuleiro no frame
		janelaJogo.getContentPane().add(tabuleiro);
		
		//Define o tamanho da Janela
		janelaJogo.setSize(700, 600);
		janelaJogo.setResizable(false);
		
		//esperar confirmacao do usuario para fechar realmente
		janelaJogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janelaJogo.addWindowListener(new ApareceJanelaFechaJogo());
		
		janelaJogo.setVisible(true);
	}
	
	public ArrayList<Peca> getPecas() {
		return pecas;
	}

	void addCelulaBranca(Espaco espaco){
		botao = new JButton ();
		
		botao.setIcon(new ImageIcon("image/white.png"));
		botao.setBounds(xTabuleiro, yTabuleiro, 60, 60);
		botao.setBorder(null);
		botao.setName("branco");

		if(espaco.getNome() != null){
			 botao.add(espaco);			
		}
		
	     botao.setContentAreaFilled(false);
	     Movimentacao mov = new Movimentacao(botao,this,tabuleiro);
	     botao.addMouseListener(mov);
			 	
		tabuleiro.add(botao);
	}
	
	void addCelulaPreta(Espaco espaco){
		botao = new JButton ();
		

		
		botao.setIcon(new ImageIcon("image/brown.png"));
		botao.setBounds(xTabuleiro, yTabuleiro, 60, 60);
		botao.setBorder(null);
		botao.setName("preto");
		
		if(espaco.getNome() != null){
			botao.add(espaco);			
		}
		
		botao.setContentAreaFilled(false);
		Movimentacao mov = new Movimentacao(botao,this,tabuleiro);
		botao.addMouseListener(mov);
		
		tabuleiro.add(botao);

	}

	
	
	public void montarTabuleiro() {
		for(int i = 0; i < 8; ++i){
			for(int j = 0; j < 8;++j){
				if(i == 6){		
					//Adiciona Peao Branco
					imagemLabelPeaoBranco = new JLabel(imagemPeaoBranco);
					imagemLabelPeaoBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
					
					Peao PeaoBranco = new Peao(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelPeaoBranco,this);
					PeaoBranco.setTipo("peao");
					pecas.add(PeaoBranco);
					imagemLabelPeaoBranco.addMouseListener(PeaoBranco);
					
					tabuleiro.add(imagemLabelPeaoBranco);
					xPecaBranca += 60;
					
				}
				if(i == 7){
					//Adiciona torre 1 branca
					if(j == 0){
						xPecaBranca = 50;
						yPecaBranca += 60;
						imagemLabelTorre1Branco = new JLabel(imagemTorre1Branco);
						
						imagemLabelTorre1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Torre torreBranco = new Torre(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelTorre1Branco,this);
						torreBranco.setTipo("torre");
						pecas.add(torreBranco);
						imagemLabelTorre1Branco.addMouseListener(torreBranco);
						
						tabuleiro.add(imagemLabelTorre1Branco);
					}
					//adiciona bispo 1 branco
					else if(j == 2){
						imagemLabelBispo1Branco = new JLabel(imagemBispo1Branco);
						
						imagemLabelBispo1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Bispo bispoBranco = new Bispo(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelBispo1Branco,this);
						bispoBranco.setTipo("bispo");
						pecas.add(bispoBranco);
						imagemLabelBispo1Branco.addMouseListener(bispoBranco);
						
						tabuleiro.add(imagemLabelBispo1Branco);
					}
					//adiciona rei branco
					else if(j == 4){
						imagemLabelReiBranco = new JLabel(imagemReiBranco);
						
						imagemLabelReiBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Rei reiBranco = new Rei(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelReiBranco,this);
						reiBranco.setTipo("rei");
						pecas.add(reiBranco);
						imagemLabelReiBranco.addMouseListener(reiBranco);
						
						tabuleiro.add(imagemLabelReiBranco);
					}
					//adiciona cavalo 2 branco
					else if(j == 6){
						imagemLabelCavalo2Branco = new JLabel(imagemCavalo2Branco);
						
						imagemLabelCavalo2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Cavalo cavaloBranco = new Cavalo(xPecaPreta,yPecaPreta,Color.WHITE,imagemLabelCavalo2Branco,this);
						cavaloBranco.setTipo("cavalo");
						pecas.add(cavaloBranco);
						imagemLabelCavalo2Branco.addMouseListener(cavaloBranco);
						
						tabuleiro.add(imagemLabelCavalo2Branco);
					}
					//adiciona cavalo 1 branco
					else if(j == 1){
						imagemLabelCavalo1Branco = new JLabel(imagemCavalo1Branco);
						
						imagemLabelCavalo1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Cavalo cavaloBranco = new Cavalo(xPecaPreta,yPecaPreta,Color.WHITE,imagemLabelCavalo1Branco,this);
						cavaloBranco.setTipo("cavalo");
						pecas.add(cavaloBranco);
						imagemLabelCavalo1Branco.addMouseListener(cavaloBranco);
						
						tabuleiro.add(imagemLabelCavalo1Branco);
					}
					//adiciona rainha branca
					else if(j == 3){
						imagemLabelRainhaBranco = new JLabel(imagemRainhaBranco);
						
						imagemLabelRainhaBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Rainha rainhaBranco = new Rainha(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelRainhaBranco,this);
						rainhaBranco.setTipo("rainha");
						pecas.add(rainhaBranco);
						imagemLabelRainhaBranco.addMouseListener(rainhaBranco);
						
						tabuleiro.add(imagemLabelRainhaBranco);
					}
					//adiciona bispo 2 branco
					else if(j == 5){
						imagemLabelBispo2Branco = new JLabel(imagemBispo2Branco);
						
						imagemLabelBispo2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Bispo bispoBranco = new Bispo(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelBispo2Branco,this);
						bispoBranco.setTipo("bispo");
						pecas.add(bispoBranco);
						imagemLabelBispo2Branco.addMouseListener(bispoBranco);
						
						tabuleiro.add(imagemLabelBispo2Branco);
					}
					//adiciona torre 2 branco
					else if(j == 7){
						imagemLabelTorre2Branco = new JLabel(imagemTorre2Branco);
						
						imagemLabelTorre2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Torre torreBranco = new Torre(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelTorre2Branco,this);
						torreBranco.setTipo("torre");
						pecas.add(torreBranco);
						imagemLabelTorre2Branco.addMouseListener(torreBranco);
						
						tabuleiro.add(imagemLabelTorre2Branco);
					}
					xPecaBranca += 60;
				}
				if(i % 2 == 0 ){
					if(j % 2 == 0){
						//adiciona a torre 1 preta
						if(i == 0 && j == 0){
							imagemLabelTorre1Preto = new JLabel(imagemTorre1Preto);
							
							imagemLabelTorre1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Torre torrePreto = new Torre(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelTorre1Preto,this);
							torrePreto.setTipo("torre");
							pecas.add(torrePreto);
							imagemLabelTorre1Preto.addMouseListener(torrePreto);
							
							tabuleiro.add(imagemLabelTorre1Preto);
						}
						//adiciona bispo 1 preto
						else if(i == 0 && j == 2){
							imagemLabelBispo1Preto = new JLabel(imagemBispo1Preto);
							
							imagemLabelBispo1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Bispo bispoPreto = new Bispo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelBispo1Preto,this);
							bispoPreto.setTipo("bispo");
							pecas.add(bispoPreto);
							imagemLabelBispo1Preto.addMouseListener(bispoPreto);
							
							tabuleiro.add(imagemLabelBispo1Preto);
						}
						//adiciona rei preto
						else if(i == 0 && j == 4){
							imagemLabelReiPreto = new JLabel(imagemReiPreto);
							
							imagemLabelReiPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Rei reiPreto = new Rei(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelReiPreto,this);
							reiPreto.setTipo("rei");
							pecas.add(reiPreto);
							imagemLabelReiPreto.addMouseListener(reiPreto);
							
							tabuleiro.add(imagemLabelReiPreto);
						}
						//adiciona cavalo 2 preto
						else if(i == 0 && j == 6){
							imagemLabelCavalo2Preto = new JLabel(imagemCavalo2Preto);
							
							imagemLabelCavalo2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Cavalo cavaloPreto = new Cavalo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelCavalo2Preto,this);
							cavaloPreto.setTipo("cavalo");
							pecas.add(cavaloPreto);
							imagemLabelCavalo2Preto.addMouseListener(cavaloPreto);
							
							tabuleiro.add(imagemLabelCavalo2Preto);
						}
						
						
						if(i==0 || i==1 ){
							addCelulaBranca(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaBranca(new Espaco("branco"));
						}
						else{
							addCelulaBranca(new Espaco(null));							
						}
					}
					else{
						//adiciona cavalo 1 preto
						if(i == 0 && j == 1){
							imagemLabelCavalo1Preto = new JLabel(imagemCavalo1Preto);
							
							imagemLabelCavalo1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Cavalo cavaloPreto = new Cavalo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelCavalo1Preto,this);
							cavaloPreto.setTipo("cavalo");
							pecas.add(cavaloPreto);
							imagemLabelCavalo1Preto.addMouseListener(cavaloPreto);
							
							tabuleiro.add(imagemLabelCavalo1Preto);
						}
						//adiciona rainha preto
						else if(i == 0 && j == 3){
							imagemLabelRainhaPreto = new JLabel(imagemRainhaPreto);
							
							imagemLabelRainhaPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Rainha rainhaPreto = new Rainha(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelRainhaPreto,this);
							rainhaPreto.setTipo("rainha");
							pecas.add(rainhaPreto);
							imagemLabelRainhaPreto.addMouseListener(rainhaPreto);
							
							tabuleiro.add(imagemLabelRainhaPreto);
						}
						//adiciona bispo 2 preto
						else if(i == 0 && j == 5){
							imagemLabelBispo2Preto = new JLabel(imagemBispo2Preto);
							
							imagemLabelBispo2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Bispo bispoPreto = new Bispo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelBispo2Preto,this);
							bispoPreto.setTipo("bispo");
							pecas.add(bispoPreto);
							imagemLabelBispo2Preto.addMouseListener(bispoPreto);
							
							tabuleiro.add(imagemLabelBispo2Preto);
						}
						//adiciona torre 2 preto
						else if(i == 0 && j == 7){
							imagemLabelTorre2Preto = new JLabel(imagemTorre2Preto);
							
							imagemLabelTorre2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Torre torrePreto = new Torre(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelTorre2Preto,this);
							torrePreto.setTipo("torre");
							pecas.add(torrePreto);
							imagemLabelTorre2Preto.addMouseListener(torrePreto);
							
							tabuleiro.add(imagemLabelTorre2Preto);
						}
						if(i==0 || i==1){
							addCelulaPreta(new Espaco("preto"));
						}
						else if( i == 6 || i == 7){
							addCelulaPreta(new Espaco("branco"));
						}
						else{
							addCelulaPreta(new Espaco(null));							
						}
					}
					
				}
				else{
					//adiciona peao preto
					if(i == 1){
						imagemLabelPeaoPreto = new JLabel(imagemPeaoPreto);
						imagemLabelPeaoPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
						
						Peao PeaoPreto = new Peao(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelPeaoPreto,this);
						PeaoPreto.setTipo("peao");
						pecas.add(PeaoPreto);
						imagemLabelPeaoPreto.addMouseListener(PeaoPreto);
						
						tabuleiro.add(imagemLabelPeaoPreto);
					}
										
					if(j % 2 == 0){
						if(i==0 || i==1){
							addCelulaPreta(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaPreta(new Espaco("branco"));
						}
						else{
							addCelulaPreta(new Espaco(null));							
						}
					}
					else{
						if(i==0 || i==1){
							addCelulaBranca(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaBranca(new Espaco("branco"));
						}
						else{
							addCelulaBranca(new Espaco(null));							
						}
					}
				}
		
				xTabuleiro+=60;
				xPecaPreta+=60;
				
			}
			yPecaPreta+=60;
			xPecaPreta = 50;
			yTabuleiro+=60;
			xTabuleiro = 50;
		}

	}
	
	public void travaSelecao(Peca peca){
		for(int i=0; i<pecas.size();i++){
			if(pecas.get(i).getCor() == peca.getCor()){
				if(pecas.get(i)instanceof Peao && pecas.get(i) != peca){
					Peao p = (Peao)pecas.get(i);
					p.setPodeSelecionar(false);
				}
				else if(pecas.get(i)instanceof Rei && pecas.get(i) != peca){
					Rei rei = (Rei)pecas.get(i);
					rei.setPodeSelecionar(false);
				}
				else if(pecas.get(i)instanceof Bispo && pecas.get(i) != peca){
					Bispo bispo = (Bispo)pecas.get(i);
					bispo.setPodeSelecionar(false);
				}
				else if(pecas.get(i)instanceof Rainha && pecas.get(i) != peca){
					Rainha rainha = (Rainha)pecas.get(i);
					rainha.setPodeSelecionar(false);
				}
				else if(pecas.get(i)instanceof Torre && pecas.get(i) != peca){
					Torre torre = (Torre)pecas.get(i);
					torre.setPodeSelecionar(false);
				}
				else if(pecas.get(i)instanceof Cavalo && pecas.get(i) != peca){
					Cavalo cavalo = (Cavalo)pecas.get(i);
					cavalo.setPodeSelecionar(false);
				}
			}
			else{
				pecas.get(i).setPodeSelecionar(false);
			}
		}
	}
	public void destravaSelecao(boolean moved,Color cor){
		if(moved){
			for(int i=0; i<pecas.size();i++){
				Peca p = pecas.get(i);
				if(p instanceof Peao){
					Peao peao = (Peao)pecas.get(i);
					if(peao.getCor() != cor){
						peao.setPodeSelecionar(true);
					}
					else{
						peao.setPodeSelecionar(false);
					}
				}
				else if(p instanceof Rei){
					Rei rei = (Rei)pecas.get(i);
					if(rei.getCor() != cor){
						rei.setPodeSelecionar(true);
					}
					else{
						rei.setPodeSelecionar(false);
					}
				}
				else if(p instanceof Bispo){
					Bispo bispo = (Bispo)pecas.get(i);
					if(bispo.getCor() != cor){
						bispo.setPodeSelecionar(true);
					}
					else{
						bispo.setPodeSelecionar(false);
					}
				}
				else if(p instanceof Rainha){
					Rainha rainha = (Rainha)pecas.get(i);
					if(rainha.getCor() != cor){
						rainha.setPodeSelecionar(true);
					}
					else{
						rainha.setPodeSelecionar(false);
					}
				}
				else if(p instanceof Torre){
					Torre torre = (Torre)pecas.get(i);
					if(torre.getCor() != cor){
						torre.setPodeSelecionar(true);
					}
					else{
						torre.setPodeSelecionar(false);
					}
				}
				else if(p instanceof Cavalo){
					Cavalo cavalo = (Cavalo)pecas.get(i);
					if(cavalo.getCor() != cor){
						cavalo.setPodeSelecionar(true);
					}
					else{
						cavalo.setPodeSelecionar(false);
					}
				}
			}
			if(cor == Color.WHITE){
				jogadordavez.setText("Vez do jogador PRETO");				
			}
			else{
				jogadordavez.setText("Vez do jogador BRANCO");
			}
		}
		else{
			for(int i=0; i<pecas.size();i++){
				Peca p = pecas.get(i);
				if(p instanceof Peao){
					Peao peao = (Peao)pecas.get(i);
					if(peao.getCor() == cor){
						peao.setPodeSelecionar(true);
					}
				}
				else if(p instanceof Rei){
					Rei rei = (Rei)pecas.get(i);
					if(rei.getCor() == cor){
						rei.setPodeSelecionar(true);
					}
				}
				else if(p instanceof Bispo){
					Bispo bispo = (Bispo)pecas.get(i);
					if(bispo.getCor() == cor){
						bispo.setPodeSelecionar(true);
					}
				}
				else if(p instanceof Rainha){
					Rainha rainha = (Rainha)pecas.get(i);
					if(rainha.getCor() == cor){
						rainha.setPodeSelecionar(true);
					}
				}
				else if(p instanceof Torre){
					Torre torre = (Torre)pecas.get(i);
					if(torre.getCor() == cor){
						torre.setPodeSelecionar(true);
					}
				}
				else if(p instanceof Cavalo){
					Cavalo cavalo = (Cavalo)pecas.get(i);
					if(cavalo.getCor() == cor)
						cavalo.setPodeSelecionar(true);
					}
				}
		}
	}
	
	public void exibirTabuleiro() {
		
	}

	public void atualizarTabuleiro() {
		janelaJogo.repaint();
	}

	public void reiniciarTabuleiro() {

		this.pecasForaDoJogo.clear();

		xTabuleiro = 50; 
		yTabuleiro = 50; 
		xPecaPreta = 50; 
		yPecaPreta = 50;
		xPecaBranca = 50;
		yPecaBranca = 410;
		this.janelaJogo.getContentPane().remove(tabuleiro);
		for(int i=0; i<pecas.size();i++){
			Peca p = pecas.get(i);
			if(p instanceof Peao){
				Peao peao = (Peao)pecas.get(i);
				if(peao.getCor() != Color.BLACK){
					peao.setPodeSelecionar(true);
				}
				else{
					peao.setPodeSelecionar(false);
				}
			}
			else if(p instanceof Rei){
				Rei rei = (Rei)pecas.get(i);
				if(rei.getCor() != Color.BLACK){
					rei.setPodeSelecionar(true);
				}
				else{
					rei.setPodeSelecionar(false);
				}
			}
			else if(p instanceof Bispo){
				Bispo bispo = (Bispo)pecas.get(i);
				if(bispo.getCor() != Color.BLACK){
					bispo.setPodeSelecionar(true);
				}
				else{
					bispo.setPodeSelecionar(false);
				}
			}
			else if(p instanceof Rainha){
				Rainha rainha = (Rainha)pecas.get(i);
				if(rainha.getCor() != Color.BLACK){
					rainha.setPodeSelecionar(true);
				}
				else{
					rainha.setPodeSelecionar(false);
				}
			}
			else if(p instanceof Torre){
				Torre torre = (Torre)pecas.get(i);
				if(torre.getCor() != Color.BLACK){
					torre.setPodeSelecionar(true);
				}
				else{
					torre.setPodeSelecionar(false);
				}
			}
			else if(p instanceof Cavalo){
				Cavalo cavalo = (Cavalo)pecas.get(i);
				if(cavalo.getCor() != Color.BLACK){
					cavalo.setPodeSelecionar(true);
				}
				else{
					cavalo.setPodeSelecionar(false);
				}
			}
		}
		jogadordavez.setText("Vez do jogador BRANCO");
		this.janelaJogo.repaint();
		this.MontaComponentes();
		this.janelaJogo.repaint();
		
		
	}

	public boolean validarMovimento(Peca peca, Object c,Rei r) {
		
		if(peca instanceof Peao){
			Peao p = (Peao)peca;
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				p.movimentarPeca(null,espaco, tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(p.getPosicaox(),p.getPosicaoy(),tabuleiro,p,p.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}				
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				p.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num ataque
					if(r.verificarXeque(p.getPosicaox(),p.getPosicaoy(),tabuleiro,p,p.getCor())){
	                      JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		}
		else if(peca instanceof Rei){
			Rei rei = (Rei) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				rei.movimentarPeca(null,espaco,tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(rei.getPosicaox(),rei.getPosicaoy(),tabuleiro,rei,rei.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				rei.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num ataque
				if(r.verificarXeque(rei.getPosicaox(),rei.getPosicaoy(),tabuleiro,rei,rei.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(peca instanceof Bispo){
			Bispo bispo = (Bispo) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				bispo.movimentarPeca(null,espaco,tabuleiro);

				//verifica xeque do rei num movimento
				if(r.verificarXeque(bispo.getPosicaox(),bispo.getPosicaoy(),tabuleiro,bispo,bispo.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				bispo.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num ataque
				if(r.verificarXeque(bispo.getPosicaox(),bispo.getPosicaoy(),tabuleiro,bispo,bispo.getCor())){
                      JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(peca instanceof Rainha){
			Rainha rainha = (Rainha) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				rainha.movimentarPeca(null,espaco,tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(rainha.getPosicaox(),rainha.getPosicaoy(),tabuleiro,rainha,rainha.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				rainha.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num ataque
				if(r.verificarXeque(rainha.getPosicaox(),rainha.getPosicaoy(),tabuleiro,rainha,rainha.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(peca instanceof Torre){
			Torre torre = (Torre) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				torre.movimentarPeca(null,espaco,tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(torre.getPosicaox(),torre.getPosicaoy(),tabuleiro,torre,torre.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				torre.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(torre.getPosicaox(),torre.getPosicaoy(),tabuleiro,torre,torre.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(peca instanceof Cavalo){
			Cavalo cavalo = (Cavalo) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				cavalo.movimentarPeca(null,espaco,tabuleiro);
				
				//verifica xeque do rei num movimento
				if(r.verificarXeque(cavalo.getPosicaox(),cavalo.getPosicaoy(),tabuleiro,cavalo,cavalo.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}		
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				cavalo.movimentarPeca(pecaNaFrente,null, tabuleiro);
				
				//verifica xeque do rei num ataque
				if(r.verificarXeque(cavalo.getPosicaox(),cavalo.getPosicaoy(),tabuleiro,cavalo,cavalo.getCor())){
	                  JOptionPane.showMessageDialog(null,"Xeque!","Xadrez",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		return false;
	}

	public boolean validarXeque() {
		return false;
	}

	public void declararEmpate() {

	}
	
	public void repaint(){
		
		super.repaint();
	}
	public static ArrayList<Peca> getPecasForaDoJogo() {
		return pecasForaDoJogo;
	}

	public void setPecasForaDoJogo(ArrayList<Peca> pecasForaDoJogo) {
		this.pecasForaDoJogo = pecasForaDoJogo;
	}
	
	public JButton getBotao(){
		return botao;
	}
	
	public JPanel getPainel(){
		return tabuleiro;
	}

}