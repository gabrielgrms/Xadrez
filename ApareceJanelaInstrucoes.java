import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;

public class ApareceJanelaInstrucoes implements ActionListener{
	private JFrame ajuda;
	private JScrollPane scrollPane;
	private JTextPane textomov;
	private JPanel painel;
	  public ApareceJanelaInstrucoes(String titulo){
		  this.ajuda = new JFrame(titulo);
	    }
	public void actionPerformed(ActionEvent actionEvent) {
		this.montaJanela(); 
		ajuda.setVisible(true);
	}
	
	private void montaJanela(){
		this.painel = new JPanel();
		this.scrollPane = new JScrollPane();
		this.textomov = new JTextPane();
		this.textomov.setEditable(false);
		this.textomov.setText("Para jogar esse xadrez temos algumas instru��es: \r\n" + 
				"- Para movimentar uma pe�a basta clicar na pe�a que ser� movimentada e ent�o ela ser� marcada com uma borda, ap�s isso basta clicar no lugar para qual a pe�a ir� mover. OBS: Caso o movimento seja inv�lido a pe�a n�o movimentar�\r\n" + 
				"- Para atacar uma pe�a inimiga basta clica na pe�a que atacar� e depois na que ser� atacada\r\n" + 
				"- Nesse xadrez temos um cemit�rio para todas as pe�as que foram comidas por outras, assim voc� pode monitorar quais pe�as foram eliminadas do jogo\r\n" + 
				"- Nesse xadrez temos uma se��o de regras! Caso voc� n�o saiba jogar xadrez temos todas as regras referente a esse jogo l�! D� uma conferida!\r\n" + 
				"- A vez do jogador ser� mostrada no canto direito, logo acima do cemit�rio\r\n" + 
				"- O bot�o de reiniciar pode ser utilizado para reiniciar completamente o jogo, ou seja, todas as pe�as retornaram as suas posi��es iniciais\r\n" + 
				"");
		GroupLayout layout = new GroupLayout(painel);
		this.painel.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(textomov));
		layout.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(textomov));
		layout.setVerticalGroup(vGroup);
		scrollPane.setViewportView(painel);
		ScrollPaneLayout scrollPaneLayout = new ScrollPaneLayout(); 
		scrollPaneLayout.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneLayout.setVerticalScrollBarPolicy(ScrollPaneLayout.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setLayout(scrollPaneLayout);
		ajuda.getContentPane().add(this.scrollPane,BorderLayout.CENTER);
		ajuda.setSize(500, 500);
	   // ajuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   /* ajuda.addWindowListener(
         new WindowAdapter() {
                public void windowClosing(WindowEvent e){                                        
                    System.exit(0);                                
                }
            }); */ //talvez colocar no tabuleiro para melhorar o desempenho     
	}
}