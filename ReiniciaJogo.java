import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ReiniciaJogo implements ActionListener{
	Tabuleiro tabuleiro;
	public ReiniciaJogo(Tabuleiro a){
		tabuleiro = a;
	}
	public void actionPerformed(ActionEvent e) {
		int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja reiniciar o jogo?", null, JOptionPane.YES_NO_OPTION);
		if(selectedOption == JOptionPane.YES_OPTION){
			tabuleiro.reiniciarTabuleiro();	   			
		}	
	}
}