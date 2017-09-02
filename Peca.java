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
	String tipo;

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

	public boolean isPodeSelecionar() {
		return podeSelecionar;
	}

	public void setPodeSelecionar(boolean podeSelecionar) {
		this.podeSelecionar = podeSelecionar;
	}
	
	//seta o tipo de peça que sera construida
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
	
}