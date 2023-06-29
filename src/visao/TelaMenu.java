package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu {
	private static JFrame janela = new JFrame("Estudo para concurso");
	private static JLabel titulo = new JLabel("Tela Menu");
	private static JButton questao = new JButton("Questoes");
	private static JButton edital = new JButton("Editais");
	
	 
	public TelaMenu() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(170, 10, 150, 40);
		questao.setBounds(170, 150, 100, 30);
		edital.setBounds(170, 100, 100, 30);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(questao);
		janela.add(edital);

		janela.setSize(450, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		/*questao.addActionListener(menu);
		edital.addActionListener(menu); */

	}
public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();

	}	
}
	


		
		

		


	

