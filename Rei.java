import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rei extends Peca {
	
	//posicao da peca selecionada
	private int posicaox;
	private int posicaoy;
	
	private Tabuleiro tabuleiro;
	
	//cor da peca
	private Color cor;
	
	//booleana que diz se existe ou nao alguma peca selecionada
	private boolean podeSelecionar = true;
	
	//booleana que diz se a peca esta selecionada
	private boolean selecionada = false;
	
	//imagem da peca
	private JLabel icon;

	
	public Rei(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.cor = cor;
		this.icon = img;
		this.tabuleiro = tabuleiro;
	}

	public boolean verificarXeque() {
		return false;
	}

	public void usarJogadaEspecial() {

	}

	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		if(espaco!=null && pecaNaFrente == null){
			
			//rei branco movimenta para frente
			if(posicaoy - 59 == espaco.getY() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
				icon.setBounds(posicaox, posicaoy-59, 50,50);
				this.posicaoy = posicaoy-59;
				tabuleiro.remove(espaco);
				espaco.add(new JLabel());
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+59);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			//rei branco movimenta para tras
			else if(posicaoy + 59 == espaco.getY() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
				System.out.println("movimento do rei branco pra tras");
				icon.setBounds(posicaox, posicaoy+59, 50,50);
				this.posicaoy = posicaoy+59;
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("branco"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-59);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			//rei preto movimenta para frente
			else if(posicaoy + 59 == espaco.getY() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
				System.out.println("entrou");
				icon.setBounds(posicaox, posicaoy+59, 50,50);
				this.posicaoy = posicaoy+59;
				tabuleiro.remove(espaco);
				espaco.add(new JLabel());
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-59);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			//rei preto movimenta para tras
			if(posicaoy - 59 == espaco.getY() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
				icon.setBounds(posicaox, posicaoy-59, 50,50);
				this.posicaoy = posicaoy-59;
				tabuleiro.remove(espaco);
				espaco.add(new JLabel());
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+59);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
		}
	}
	
	public void mouseClicked(MouseEvent e){
		System.out.println("entrou1");
		if(this.selecionada){
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
		}
		else if(podeSelecionar){
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
	

	public void atacarPeca() {

	}
}
