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

	public void movimentarPeca() {

	}

	public void atacarPeca() {

	}
	
	public void ativaHighlight(){
		
	}
	
	public void desativaHighlight(){
		
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
	
}