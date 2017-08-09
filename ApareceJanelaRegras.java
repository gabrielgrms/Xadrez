import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ApareceJanelaRegras implements ActionListener{

	public void actionPerformed(ActionEvent actionEvent) {
		JOptionPane.showMessageDialog(null,"MOVIMENTA��O DE PE�AS\r\n" + 
				"Torre - A movimenta��o da torre se d� somente de forma horizontal (linhas do tabuleiro) ou vertical (colunas do tabuleiro).\r\n" + 
				"Bispo - Esta pe�a se movimenta somente nas diagonais do tabuleiro.\r\n" + 
				"Dama - Uma dama pode se movimentar tanto na horizontal como na vertical (assim como uma torre) ou nas diagonais (assim como um bispo).\r\n" + 
				"Rei - Se movimenta em qualquer dire��o mas com limita��o quanto ao n�mero de casas. O limite de casas que um rei pode se deslocar � de uma casa por lance. O rei NUNCA pode fazer um movimento que resulte em um xeque para ele.\r\n" + 
				"Pe�o - O pe�o somente pode fazer movimentos adjacentes � sua posi��o anterior, isto �, n�o pode retroceder. O pe�o, assim como o rei s� pode deslocar-se 1 casa � frente por lance, no entanto, quando o pe�o ainda est� na sua posi��o inicial, este pode dar um salto de 2 casas � frente.\r\n" + 
				"Cavalo - � a �nica pe�a que pode \"saltar\" sobre outras pe�as. A movimenta��o do cavalo � feita em forma de \"L\", ou seja, anda 2 casas em qualquer dire��o (vertical ou horizontal) e depois mais uma em sentido perpendicular.\r\n" + 
				"Nenhuma pe�a, quando deslocada, pode ocupar uma casa que j� est� sendo ocupada por outra pe�a da mesma cor.\r\n" + 
				"Quando a casa de destino de uma pe�a, quando em movimento, estiver sendo ocupada por uma pe�a de cor advers�ria, a pe�a em movimento efetuar� a captura da avers�ria.\r\n" + 
				"A captura feita por pe�as do tipo pe�o s� � poss�vel quando a pe�a a ser capturada estiver deslocada uma linha � frente e 1 coluna a direita ou a esquerda. A captura se d� na diagonal.\r\n" + 
				"MOVIMENTOS ESPECIAIS\r\n" + 
				"Roque - � um movimento que envolve 2 pe�as da mesma cor. S�o elas o Rei e qualquer uma das torres. O roque � feito ao mover o rei 2 casas para qualquer lado na horizontal. Para se fazer um roque � obrigat�rio satisfazer as seguintes condi��es:\r\n" + 
				"O Rei n�o pode ter sido mexido at� o momento do roque. Tem que estar na posi��o inicial.\r\n" + 
				"Assim como o Rei, a Torre tambem n�o pode ter sido mexida, portanto deve estar na sua posi��o inicial.\r\n" + 
				"As casas pelas quais o Rei ir� passar, n�o podem estar sob amea�a das pe�as advers�rias.\r\n" + 
				"N�o pode haver nenhuma pe�a obstruindo o caminho onde passar�o Rei e Torre.\r\n" + 
				"OBS: Para efetuar o Roque, clique sobre o Rei e clique sobre a posi��o desejada. O sistema mover� a Torre automaticamente.\r\n" + 
				"Captura en-passant - Esta captura � um tipo especial feita por pe�es. Regras para a captura en-passant:\r\n" + 
				"O pe�o a ser capturado deve ter feito o lance inicial de 2 casas.\r\n" + 
				"O pe�o que vai fazer a captura, pode faz�-la como se o pe�o a ser capturado estivesse exatamente 1 casa � frente da sua posi��o inicial e deslocado 1 coluna a esquerda ou a direita como na captura normal.\r\n" + 
				"PROMO��ES DE PE�ES\r\n" + 
				"Um pe�o, ao alcan�ar a �ltima linha do tabuleiro (no caso das brancas a linha 8, e no caso das pretas a linha 1) � promovido, o jogador � obrigado a escolher entre uma das seguintes pe�as para substitu�-lo:\r\n" + 
				"Dama\r\n" + 
				"Torre\r\n" + 
				"Bispo\r\n" + 
				"Cavalo\r\n" + 
				"VIT�RIA\r\n" + 
				"S� existem 2 formas de um jogador vencer. S�o elas:\r\n" + 
				"Se o jogador fazer um Xeque-Mate ao advers�rio.\r\n" + 
				"Se o advers�rio desistir da partida.\r\n" + 
				"Na sala ranqueada, ainda um jogador pode ganhar se o seu advers�rio atingir o tempo limite.\r\n" + 
				"EMPATES\r\n" + 
				"Uma partida � considerada empatada quando:\r\n" + 
				"Um jogador n�o puder mais efetuar jogadas consideradas legais.\r\n" + 
				"Um jogador propor o empate e o outro aceitar.\r\n" + 
				"Os jogadores n�o tiverem mais pe�as suficientes para dar xeque-mate ao advers�rio. � considerado material insuficiente:\r\n" + 
				"O Rei e um Bispo\r\n" + 
				"O Rei e um Cavalo\r\n" + 
				"O Rei e dois Cavalos contra um Rei sozinho\r\n" + 
				"Um jogador oferecer xeque-perp�tuo.\r\n" + 
				"Forem feitas 50 jogadas sem captura e sem movimenta��o de pe�o.\r\n" + 
				"Determinada posi��o ocorrer pela 3� vez durante uma partida.\r\n" + 
				"REI AFOGADO\r\n" + 
				"O \"rei afogado\" � uma posi��o que ocorre em duas circunst�ncias ao mesmo tempo:\r\n" + 
				"O jogador da vez n�o tem jogadas legais para realizar\r\n" + 
				"O rei do jogador da vez n�o est� em xeque e n�o pode movimentar nenhuma pe�a;\r\n" + 
				"Quando isto acontece, se diz que o rei est� \"afogado\" e a partida termina em empate.","Regras do jogo",JOptionPane.PLAIN_MESSAGE);
	}
}