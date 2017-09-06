import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rei extends Peca {
	
	//posicao da peca selecionada
	private int posicaox;
	private int posicaoy;
	private int posicaoxIni;
	private boolean morta = false;
	private int posicaoyIni;
	private boolean roque = true;
	
	private Tabuleiro tabuleiro;
	
	//cor da peca
	private Color cor;
	
	//booleana que diz se existe ou nao alguma peca selecionada
	private  boolean podeSelecionar = true;
	
	//booleana que diz se a peca esta selecionada
	private  boolean selecionada = false;
	
	//imagem da peca
	private JLabel icon;
	
	private static int posicaoXreiPreto = 290,posicaoYreiPreto = 50,posicaoXreiBranco = 290,posicaoYreiBranco = 470;
	
	public int getPosicaoxIni() {
		return posicaoxIni;
	}

	public void setPosicaoxIni(int posicaoxIni) {
		this.posicaoxIni = posicaoxIni;
	}

	public int getPosicaoyIni() {
		return posicaoyIni;
	}

	public void setPosicaoyIni(int posicaoyIni) {
		this.posicaoyIni = posicaoyIni;
	}
	
	public Rei(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.posicaoxIni = posicaox - 40;
		this.posicaoyIni = posicaoy - 40;
		this.cor = cor;
		this.icon = img;
		this.tabuleiro = tabuleiro;
		if(this.cor == Color.BLACK){
			this.podeSelecionar = false;
		}
	}
	
	private boolean verificaEspacoSuperiorEsquerda(int posicaoXpeca,int posicaoYpeca,JPanel tabuleiro,Color cor){
		
		//a peca que esta na direcao do rei eh branca
		if(cor == Color.WHITE){
			while(posicaoXpeca - 60 != this.getPosicaoXreiPreto() && posicaoYpeca - 60 != this.getPosicaoYreiPreto()){
				if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60)instanceof JButton){
					
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca - 60;
				posicaoYpeca = posicaoYpeca - 60;
			}
			return true;
		}
		
		//a peca que esta na direcao do rei eh preta
		if(cor == Color.BLACK){
			while(posicaoXpeca - 60 != this.getPosicaoXreiBranco() && posicaoYpeca - 60 != this.getPosicaoYreiBranco()){
				if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60)instanceof JButton){
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca - 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca - 60;
				posicaoYpeca = posicaoYpeca - 60;
			}
			return true;
		}
		return false;
}
	
	private boolean verificaEspacoSuperiorDireita(int posicaoXpeca,int posicaoYpeca,JPanel tabuleiro,Color cor){
		
		//a peca que esta na direcao do rei eh branca
		if(cor == Color.WHITE){
			while(posicaoXpeca + 60 != this.getPosicaoXreiPreto() && posicaoYpeca - 60 != this.getPosicaoYreiPreto()){
				if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60)instanceof JButton){
					
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca + 60;
				posicaoYpeca = posicaoYpeca - 60;
			}
			return true;
		}
		
		//a peca que esta na direcao do rei eh preta
		if(cor == Color.BLACK){
			while(posicaoXpeca + 60 != this.getPosicaoXreiBranco() && posicaoYpeca - 60 != this.getPosicaoYreiBranco()){
				if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60)instanceof JButton){
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca - 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca + 60;
				posicaoYpeca = posicaoYpeca - 60;
			}
			return true;
		}
		return false;
}

	private boolean verificaEspacoInferiorDireita(int posicaoXpeca,int posicaoYpeca,JPanel tabuleiro,Color cor){
		//a peca que esta na direcao do rei eh branca
		if(cor == Color.WHITE){
			while(posicaoXpeca + 60 != this.getPosicaoXreiPreto() && posicaoYpeca + 60 != this.getPosicaoYreiPreto()){
				if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60)instanceof JButton){
					
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca + 60;
				posicaoYpeca = posicaoYpeca + 60;
			}
			return true;
		}
		
		//a peca que esta na direcao do rei eh preta
		if(cor == Color.BLACK){
			while(posicaoXpeca + 60 != this.getPosicaoXreiBranco() && posicaoYpeca + 60 != this.getPosicaoYreiBranco()){
				if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60)instanceof JButton){
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca + 60, posicaoYpeca + 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca + 60;
				posicaoYpeca = posicaoYpeca + 60;
			}
			return true;
		}
		return false;
	}

	private boolean verificaEspacoInferiorEsquerda(int posicaoXpeca,int posicaoYpeca,JPanel tabuleiro,Color cor){
		//a peca que esta na direcao do rei eh branca
		if(cor == Color.WHITE){
			while(posicaoXpeca - 60 != this.getPosicaoXreiPreto() && posicaoYpeca + 60 != this.getPosicaoYreiPreto()){
				if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60)instanceof JButton){
					
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca - 60;
				posicaoYpeca = posicaoYpeca + 60;
			}
			return true;
		}
		
		//a peca que esta na direcao do rei eh preta
		if(cor == Color.BLACK){
			while(posicaoXpeca - 60 != this.getPosicaoXreiBranco() && posicaoYpeca + 60 != this.getPosicaoYreiBranco()){
				if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60)instanceof JButton){
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoXpeca - 60, posicaoYpeca + 60);
			
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoXpeca = posicaoXpeca - 60;
				posicaoYpeca = posicaoYpeca + 60;
			}
			return true;
		}
		return false;
	}

	public boolean verificarXeque(int posicaoXpeca,int posicaoYpeca, JPanel tabuleiro,Peca peca, Color cor) {
		int x,y;
		
		//verifica se a peca (branca) que movimentou esta deixando o rei (preto) em xeque
		if(cor == Color.WHITE){
			
			//verifica se o peao esta dando xeque no rei (peao so ataca pelas diagonais e de uma em uma celula)
			if(peca.getTipo().equals("peao")){
				
				
				//rei esta na diagonal superior direita do peao
				if(posicaoXpeca > this.getPosicaoXreiPreto() && posicaoYpeca > this.getPosicaoYreiPreto()
						&& (posicaoXpeca - this.getPosicaoXreiPreto()) == 60 && (posicaoYpeca - this.getPosicaoYreiPreto()) == 60)
					return true;
				
				//rei esta na diagonal superior esquerda do peao
				if(posicaoXpeca < this.getPosicaoXreiPreto() && posicaoYpeca > this.getPosicaoYreiPreto()
						&& (this.getPosicaoXreiPreto() - posicaoXpeca) == 60 && (posicaoYpeca - this.getPosicaoYreiPreto()) == 60)
					return true;
				
				return false;
			}
			
			//verifica se o rei esta dando xeque no rei (rei ataca em todas as direcoes celula por celula)
			else if(peca.getTipo().equals("rei")){
				
			}
			
			//verifica se o bispo esta dando xeque no rei (bispo ataca pelas diagonais)
			else if(peca.getTipo().equals("bispo")){
				
				//diagonal superior esquerda
				if(this.getPosicaoXreiPreto() < posicaoXpeca && this.getPosicaoYreiPreto() < posicaoYpeca){
						//verifica se o rei esta na mesma diagonal que o bispo
						if((this.getPosicaoXreiPreto() - posicaoXpeca) == (this.getPosicaoYreiPreto() - posicaoYpeca)){
							
							//verifica se existe alguma peca no caminho do bispo
							if(verificaEspacoSuperiorEsquerda(posicaoXpeca,posicaoYpeca,tabuleiro,Color.WHITE)){
								return true;
							}
							return false;
						}
						return false;
				}
				
				//diagonal superior direita
				else if(this.getPosicaoXreiPreto() > posicaoXpeca && this.getPosicaoYreiPreto() < posicaoYpeca){
					//verifica se o rei esta na mesma diagonal que o bispo
					if((this.getPosicaoXreiPreto() - posicaoXpeca) == (posicaoYpeca - this.getPosicaoYreiPreto())){
						
						//verifica se existe alguma peca no caminho do bispo
						if(verificaEspacoSuperiorDireita(posicaoXpeca,posicaoYpeca,tabuleiro,Color.WHITE)){
							return true;
						}
						return false;
					}
					return false;
				}
				
				//diagonal inferior esquerda
				else if(this.getPosicaoXreiPreto() < posicaoXpeca && this.getPosicaoYreiPreto() > posicaoYpeca){
					//verifica se o rei esta na mesma diagonal que o bispo
					if((posicaoXpeca - this.getPosicaoXreiPreto()) == (this.getPosicaoYreiPreto() - posicaoYpeca)){

						//verifica se existe alguma peca no caminho do bispo
						if(verificaEspacoInferiorEsquerda(posicaoXpeca,posicaoYpeca,tabuleiro,Color.WHITE)){
							return true;
						}
						return false;
					}
					return false;
				}
				
				//diagonal inferior direita
				else if(this.getPosicaoXreiPreto() > posicaoXpeca && this.getPosicaoYreiPreto() > posicaoYpeca){
					
						if((this.getPosicaoXreiPreto() - posicaoXpeca) == (this.getPosicaoYreiPreto() - posicaoYpeca) ){
							
							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoInferiorDireita(posicaoXpeca,posicaoYpeca,tabuleiro,Color.WHITE)){
								return true;
							}
							return false;
						}
						return false;
				}
				return false;
				
			}
			
			//verifica se o cavalo esta dando xeque no rei (cavalo ataca em l)
			else if(peca.getTipo().equals("cavalo")){
				
			}
			
			//verifica se a torre esta dando xeque no rei (torre ataca em horizontal e vertical)
			else if(peca.getTipo().equals("torre")){
				
			}
			
			//verifica se a rainha esta dando xeque no rei (rainha ataca em todas as posicoes)
			else if(peca.getTipo().equals("rainha")){
				
			}
			
			return false;
		}
		
		//verifica se a peca (preta) que movimentou esta deixando o rei (branco) em xeque
		else if(cor == Color.BLACK){
			//System.out.println("entrou");
			//verifica se o peao esta dando xeque no rei (peao so ataca pelas diagonais e de uma em uma celula)
			if(peca.getTipo().equals("peao")){
				
				//rei esta na diagonal inferior esquerda do peao
				if(posicaoXpeca < this.getPosicaoXreiBranco() && posicaoYpeca < this.getPosicaoYreiBranco()
						&& (this.getPosicaoXreiBranco() - posicaoXpeca) == 60 && (this.getPosicaoYreiBranco() - posicaoYpeca) == 60)
					return true;
				
				
				//rei esta na diagonal inferior direita do peao
				if(posicaoXpeca > this.getPosicaoXreiBranco() && posicaoYpeca < this.getPosicaoYreiBranco()
						&& (posicaoXpeca - this.getPosicaoXreiBranco()) == 60 && (this.getPosicaoYreiBranco() - posicaoYpeca) == 60)
					return true;
				
				return false;
			}
			
			//verifica se o rei esta dando xeque no rei (rei ataca em todas as direcoes celula por celula)
			else if(peca.getTipo().equals("rei")){
				
			}
			
			//verifica se o bispo esta dando xeque no rei (bispo ataca pelas diagonais)
			else if(peca.getTipo().equals("bispo")){
				//diagonal superior esquerda
				if(this.getPosicaoXreiBranco() < posicaoXpeca && this.getPosicaoYreiBranco() < posicaoYpeca){
						//verifica se o rei esta na mesma diagonal que o bispo
						if((this.getPosicaoXreiBranco() - posicaoXpeca) == (this.getPosicaoYreiBranco() - posicaoYpeca)){
							
							//verifica se existe alguma peca no caminho do bispo
							if(verificaEspacoSuperiorEsquerda(posicaoXpeca,posicaoYpeca,tabuleiro,Color.BLACK)){
								return true;
							}
							return false;
						}
						return false;
				}
				
				//diagonal superior direita
				else if(this.getPosicaoXreiBranco() > posicaoXpeca && this.getPosicaoYreiBranco() < posicaoYpeca){
					//verifica se o rei esta na mesma diagonal que o bispo
					if((this.getPosicaoXreiBranco() - posicaoXpeca) == (posicaoYpeca - this.getPosicaoYreiBranco())){
						
						//verifica se existe alguma peca no caminho do bispo
						if(verificaEspacoSuperiorDireita(posicaoXpeca,posicaoYpeca,tabuleiro,Color.BLACK)){
							return true;
						}
						return false;
					}
					return false;
				}
				
				//diagonal inferior esquerda
				else if(this.getPosicaoXreiBranco() < posicaoXpeca && this.getPosicaoYreiBranco() > posicaoYpeca){
					//verifica se o rei esta na mesma diagonal que o bispo
					if((posicaoXpeca - this.getPosicaoXreiBranco()) == (this.getPosicaoYreiBranco() - posicaoYpeca)){

						//verifica se existe alguma peca no caminho do bispo
						if(verificaEspacoInferiorEsquerda(posicaoXpeca,posicaoYpeca,tabuleiro,Color.BLACK)){
							return true;
						}
						return false;
					}
					return false;
				}
				
				//diagonal inferior direita
				else if(this.getPosicaoXreiBranco() > posicaoXpeca && this.getPosicaoYreiBranco() > posicaoYpeca){
					
						if((this.getPosicaoXreiBranco() - posicaoXpeca) == (this.getPosicaoYreiBranco() - posicaoYpeca) ){
							
							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoInferiorDireita(posicaoXpeca,posicaoYpeca,tabuleiro,Color.BLACK)){
								return true;
							}
							return false;
						}
						return false;
				}
				return false;
			}
			
			//verifica se o cavalo esta dando xeque no rei (cavalo ataca em l)
			else if(peca.getTipo().equals("cavalo")){
				
			}
			
			//verifica se a torre esta dando xeque no rei (torre ataca em horizontal e vertical)
			else if(peca.getTipo().equals("torre")){
				
			}
			
			//verifica se a rainha esta dando xeque no rei (rainha ataca em todas as posicoes)
			else if(peca.getTipo().equals("rainha")){
				
			}
			
			return false;
		}
		
		return false;
	}

	public void usarJogadaEspecial(JLabel torre, JPanel tabuleiro) {
		if(this.roque){
			//Troca o rei preto com a torre a direita
			if(this.posicaox == 290 && this.posicaoy == 50 && this.cor == Color.BLACK){
				if(tabuleiro.getComponentAt(350, 50) instanceof JButton && tabuleiro.getComponentAt(410, 50) instanceof JButton){
					Torre t = (Torre)torre.getMouseListeners()[0];
					if(t.getPosicaox() == 470 && t.getPosicaoy() == 50){
						this.posicaox = 410;
						t.setPosicaox(350);
						JButton espacoAtualRei = (JButton)tabuleiro.getComponentAt(410, 50);
						espacoAtualRei.add(new Espaco("preto"));
						this.icon.setBounds(posicaox, posicaoy, 50, 50);
						JLabel tower = t.getIcon();
						JButton espacoAtualTorre = (JButton)tabuleiro.getComponentAt(350, 50);
						tabuleiro.remove(espacoAtualTorre);
						tower.setBounds(t.getPosicaox(), t.getPosicaoy(), 50, 50);
						tabuleiro.add(espacoAtualTorre);
						espacoAtualTorre.add(new Espaco("preto"));
						JButton espacoAntigoRei = (JButton)tabuleiro.getComponentAt(290, 50);
						JButton espacoAntigoTorre = (JButton)tabuleiro.getComponentAt(470, 50);
						espacoAntigoRei.remove(0);
						espacoAntigoTorre.remove(0);
						this.tabuleiro.atualizarTabuleiro();					
					}
				}
				//Troca o rei preto com a torre a esquerda
				else if(tabuleiro.getComponentAt(230, 50) instanceof JButton  && tabuleiro.getComponentAt(170, 50) instanceof JButton && tabuleiro.getComponentAt(110, 50) instanceof JButton){
					Torre t = (Torre)torre.getMouseListeners()[0];
					if(t.getPosicaox() == 50 && t.getPosicaoy() == 50){
						this.posicaox = 170;
						t.setPosicaox(230);
						JButton espacoAtualRei = (JButton)tabuleiro.getComponentAt(170, 50);
						espacoAtualRei.add(new Espaco("preto"));
						this.icon.setBounds(posicaox, posicaoy, 50, 50);
						JLabel tower = t.getIcon();
						JButton espacoAtualTorre = (JButton)tabuleiro.getComponentAt(230, 50);
						JButton espaco = (JButton)tabuleiro.getComponentAt(170, 50);
						tabuleiro.remove(espaco);
						tower.setBounds(t.getPosicaox(), t.getPosicaoy(), 50, 50);
						tabuleiro.add(espaco);
						espacoAtualTorre.add(new Espaco("preto"));
						JButton espacoAntigoRei = (JButton)tabuleiro.getComponentAt(290, 50);
						JButton espacoAntigoTorre = (JButton)tabuleiro.getComponentAt(50, 50);
						espacoAntigoRei.remove(0);
						espacoAntigoTorre.remove(0);
						this.tabuleiro.atualizarTabuleiro();					
					}
				}
			}
			//Troca o rei branco com a torre a direita
			else if(this.posicaox == 290 && this.posicaoy == 470 && this.cor == Color.WHITE){
				if(tabuleiro.getComponentAt(350, 470) instanceof JButton && tabuleiro.getComponentAt(410, 470) instanceof JButton){
					Torre t = (Torre)torre.getMouseListeners()[0];
					if(t.getPosicaox() == 470 && t.getPosicaoy() == 470){
						this.posicaox = 410;
						t.setPosicaox(350);
						JButton espacoAtualRei = (JButton)tabuleiro.getComponentAt(410, 470);
						espacoAtualRei.add(new Espaco("branco"));
						this.icon.setBounds(posicaox, posicaoy, 50, 50);
						JLabel tower = t.getIcon();
						JButton espacoAtualTorre = (JButton)tabuleiro.getComponentAt(350, 470);
						tabuleiro.remove(espacoAtualTorre);
						tower.setBounds(t.getPosicaox(), t.getPosicaoy(), 50, 50);
						tabuleiro.add(espacoAtualTorre);
						espacoAtualTorre.add(new Espaco("branco"));
						JButton espacoAntigoRei = (JButton)tabuleiro.getComponentAt(290, 470);
						JButton espacoAntigoTorre = (JButton)tabuleiro.getComponentAt(470, 470);
						espacoAntigoRei.remove(0);
						espacoAntigoTorre.remove(0);
						this.tabuleiro.atualizarTabuleiro();					
					}
				}
				//Troca o rei branco com a torre a esquerda
				else if(tabuleiro.getComponentAt(230, 470) instanceof JButton  && tabuleiro.getComponentAt(170, 470) instanceof JButton && tabuleiro.getComponentAt(110, 470) instanceof JButton){
					Torre t = (Torre)torre.getMouseListeners()[0];
					if(t.getPosicaox() == 50 && t.getPosicaoy() == 470){
						this.posicaox = 170;
						t.setPosicaox(230);
						JButton espacoAtualRei = (JButton)tabuleiro.getComponentAt(170, 470);
						espacoAtualRei.add(new Espaco("branco"));
						tabuleiro.remove(espacoAtualRei);
						this.icon.setBounds(posicaox, posicaoy, 50, 50);
						tabuleiro.add(espacoAtualRei);
						JLabel tower = t.getIcon();
						JButton espacoAtualTorre = (JButton)tabuleiro.getComponentAt(230, 470);
						tabuleiro.remove(espacoAtualTorre);
						tower.setBounds(t.getPosicaox(), t.getPosicaoy(), 50, 50);
						tabuleiro.add(espacoAtualTorre);
						espacoAtualTorre.add(new Espaco("branco"));
						JButton espacoAntigoRei = (JButton)tabuleiro.getComponentAt(290, 470);
						JButton espacoAntigoTorre = (JButton)tabuleiro.getComponentAt(50, 470);
						espacoAntigoRei.remove(0);
						espacoAntigoTorre.remove(0);
						this.tabuleiro.atualizarTabuleiro();					
					}
				}
			}
		}
	}

	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		this.desativaHighlight();
		
		if(this.cor == Color.BLACK && this.posicaox != 290 && this.posicaoy == 50){
			this.roque = false;
		}
		else if(this.cor == Color.WHITE && (this.posicaox != 290 || this.posicaoy != 470)){
			this.roque = false;
		}
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.WHITE){
					//rei branco movimenta para frente			
					if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox, posicaoy-60, 50,50);
							this.posicaoy = posicaoy-60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();		
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta para tras
					else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox, posicaoy+60, 50,50);
							this.posicaoy = posicaoy+60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox - 60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox - 60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy, 50,50);
							
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					//rei branco movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy, 50,50);
							
							this.posicaox = posicaox - 60;
						
							this.setPosicaoXReiBranco(posicaox);
							this.setPosicaoYReiBranco(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "branco"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(false,this.cor);
					}
			}
			
			else if(this.cor == Color.BLACK){
					//rei preto movimenta para frente
					if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox, posicaoy+60, 50,50);
							this.posicaoy = posicaoy+60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta para tras
					else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox, posicaoy-60, 50,50);
							this.posicaoy = posicaoy-60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox - 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox - 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox + 60, posicaoy, 50,50);
							
							this.posicaox = posicaox + 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
					
					//rei preto movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							icon.setBounds(posicaox - 60, posicaoy, 50,50);
							
							this.posicaox = posicaox - 60;
							
							this.setPosicaoXReiPreto(posicaox);
							this.setPosicaoYReiPreto(posicaoy);
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
							espacoAntigo.remove(0);
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(true,this.cor);
							this.tabuleiro.repaint();
						}
						else{
							Espaco espacoAux = (Espaco) espaco.getComponent(0);
							
							//clicou num espaco que tem uma peca de mesma cor
							if(espacoAux.getNome() == "preto"){
								this.selecionada = false;
								this.tabuleiro.destravaSelecao(false,this.cor);
							}
							
							//clicou numa peca de outra cor para atacar
							else{
								this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
							}
						}
					}
				}
				else{
					this.selecionada = false;
					this.tabuleiro.destravaSelecao(false,this.cor);
				}
		}
		else if(pecaNaFrente!=null){
			
			espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			
			if(this.cor == Color.WHITE){
				//rei branco movimenta para frente			
				if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox, posicaoy-60, 50,50);
						this.posicaoy = posicaoy-60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();		
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta para tras
				else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox, posicaoy+60, 50,50);
						this.posicaoy = posicaoy+60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta na diagonal superior direita
				else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta na diagonal superior esquerda
				else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta na diagonal inferior direita
				else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta na diagonal inferior esquerda
				else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta para o lado direito
				else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy, 50,50);
						
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//rei branco movimenta para o lado esquerdo
				else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy, 50,50);
						
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				if(pecaNaFrente.getMouseListeners()[0] instanceof Torre){
					usarJogadaEspecial(pecaNaFrente, tabuleiro);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao(false,this.cor);
				}
				else{
					this.selecionada = false;
					this.tabuleiro.destravaSelecao(false,this.cor);
				}
		}
		
		else if(this.cor == Color.BLACK){
				//rei preto movimenta para frente
				if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox, posicaoy+60, 50,50);
						this.posicaoy = posicaoy+60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta para tras
				else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox, posicaoy-60, 50,50);
						this.posicaoy = posicaoy-60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta na diagonal superior direita
				else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta na diagonal superior esquerda
				else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta na diagonal inferior direita
				else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta na diagonal inferior esquerda
				else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta para o lado direito
				else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox + 60, posicaoy, 50,50);
						
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//rei preto movimenta para o lado esquerdo
				else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						icon.setBounds(posicaox - 60, posicaoy, 50,50);
						
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao(true,this.cor);
						this.tabuleiro.repaint();
					}
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao(false,this.cor);
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				//Roque
				if(pecaNaFrente.getMouseListeners()[0] instanceof Torre){
					usarJogadaEspecial(pecaNaFrente, tabuleiro);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao(false,this.cor);
				}
				else{
					this.selecionada = false;
					this.tabuleiro.destravaSelecao(false,this.cor);
				}
			}			
		}
	}
	
	public void atacarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		//clica no canto do espaco
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.BLACK){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				espaco.remove(0);
				
				icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = espaco.getY();
				this.posicaox = espaco.getX();
				
				this.setPosicaoXReiPreto(posicaox);
				this.setPosicaoYReiPreto(posicaoy);
				
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("preto"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao(true,this.cor);
				this.tabuleiro.repaint();
			}
			else if(this.cor == Color.WHITE){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaNaFrente.getMouseListeners()[0]);
				new PecaMorta().check(pecaNaFrente.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				espaco.remove(0);
				
				icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = espaco.getY();
				this.posicaox = espaco.getX();
				
				this.setPosicaoXReiBranco(posicaox);
				this.setPosicaoYReiBranco(posicaoy);
				
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("branco"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao(true,this.cor);
				this.tabuleiro.repaint();
			}
		}
		//clica no JLabel
		else if(pecaNaFrente != null){
			if(this.cor == Color.BLACK){
				
				espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaNaFrente.getMouseListeners()[0]);
				new PecaMorta().check(pecaNaFrente.getMouseListeners()[0]);
				int posicaoAtualX = pecaNaFrente.getX();
				int posicaoAtualY = pecaNaFrente.getY();
				
				tabuleiro.remove(pecaNaFrente);
				espaco.remove(0);
				
				icon.setBounds(posicaoAtualX, posicaoAtualY, 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = posicaoAtualY;
				this.posicaox = posicaoAtualX;
				
				this.setPosicaoXReiPreto(posicaox);
				this.setPosicaoYReiPreto(posicaoy);
				
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("preto"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao(true,this.cor);
				this.tabuleiro.repaint();
				
			}
			else if(this.cor == Color.WHITE){
				espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaNaFrente.getMouseListeners()[0]);
				new PecaMorta().check(pecaNaFrente.getMouseListeners()[0]);
				int posicaoAtualX = pecaNaFrente.getX();
				int posicaoAtualY = pecaNaFrente.getY();
				
				tabuleiro.remove(pecaNaFrente);
				espaco.remove(0);
				
				icon.setBounds(posicaoAtualX, posicaoAtualY, 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = posicaoAtualY;
				this.posicaox = posicaoAtualX;
				
				this.setPosicaoXReiBranco(posicaox);
				this.setPosicaoYReiBranco(posicaoy);
				
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("branco"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao(true,this.cor);
				this.tabuleiro.repaint();
			}	
			else{
				this.selecionada = false;
				this.tabuleiro.destravaSelecao(false,this.cor);
			}
		}
			this.selecionada = false;
			this.tabuleiro.destravaSelecao(false,this.cor);
	}
	
	public void mouseClicked(MouseEvent e){
		if(this.morta){
		}
		else if(this.selecionada){	
			this.desativaHighlight();
			this.selecionada = false;
			this.tabuleiro.destravaSelecao(false,this.cor);
		}
		else if(podeSelecionar){
			this.ativaHighlight();
			this.selecionada = true;
			tabuleiro.travaSelecao(this);
			
		}
		else if(!podeSelecionar){
			Movimentacao barraPeca = new Movimentacao(null, tabuleiro, null);
			barraPeca.setPecaBarra(this.icon);
			barraPeca.mouseClicked(e);
		}
	}
	
	public boolean getSelecionada(){
		return this.selecionada;
	}
	
	public JLabel getIcon() {
		return icon;
	}
	
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
	
	public boolean isPodeSelecionar() {
		return podeSelecionar;
	}
	
	public void setPodeSelecionar(boolean podeSelecionar) {
		this.podeSelecionar = podeSelecionar;
	}
	
	public boolean getPodeSelecionar() {
		return this.podeSelecionar;
	}

	public int getPosicaox() {
		return posicaox;
	}

	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}

	public int getPosicaoy() {
		return posicaoy;
	}

	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}
	public void desativaHighlight(){
		//desativa o highlight
		//verifica se o espaco clicado eh branco
		if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("branco")){	
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/white.png"));
		}
		
		//verifica se o espaco clicado eh preto
		else if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("preto")){
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/brown.png"));
		}
	}
	
	public void ativaHighlight(){
		//ativa o highlight
		//verifica se o espaco clicado eh branco
		if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("branco")){	
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/whiteHighlight.png"));
		}
		
		//verifica se o espaco clicado eh preto
		else if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("preto")){
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/brownHighlight.png"));
		}
	}
	
	public void setPosicaoXReiBranco(int x){
		this.posicaoXreiBranco = x;
	}
	
	public void setPosicaoYReiBranco(int y){
		this.posicaoYreiBranco = y;
	}
	
	public void setPosicaoXReiPreto(int x){
		this.posicaoXreiPreto= x;
	}
	
	public void setPosicaoYReiPreto(int y){
		this.posicaoYreiPreto = y;
	}	
	
	public int getPosicaoXreiBranco() {
		return posicaoXreiBranco;
	}

	public int getPosicaoYreiBranco() {
		return posicaoYreiBranco;
	}

	public int getPosicaoXreiPreto() {
		return posicaoXreiPreto;
	}

	public int getPosicaoYreiPreto() {
		return posicaoYreiPreto;
	}
}
