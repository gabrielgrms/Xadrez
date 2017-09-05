import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class Peca extends MouseAdapter {

	private Color cor;
	private boolean selecionada = false;
	private boolean podeSelecionar = true;
	private boolean morta = false;
	String tipo;
	
	//seta o tipo de peça que sera construida
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	//retorna o tipo da peca
	public String getTipo(){
		return tipo;
	}
	
	public boolean isMorta() {
		return morta;
	}

	public void setMorta(boolean morta) {
		this.morta = morta;
	}

	public void movimentarPeca() {

	}

	public void atacarPeca() {

	}

	public boolean isSelecionada() {
		return selecionada;
	}

	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}

	public boolean podeSelecionar() {
		return podeSelecionar;
	}

	public void setPodeSelecionar(boolean podeSelecionar) {
		this.podeSelecionar = podeSelecionar;
	}

	public Color getCor() {
		return cor;
	}
	
	
}