package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import visao.TelaQuestao;

public class TelaMenu extends JFrame implements ActionListener {
	private static JFrame janela = new JFrame("Estudo para concurso");
	private static JLabel titulo = new JLabel("Tela Menu");
	private static JButton questao = new JButton("Questoes");
	private static JButton edital = new JButton("Editais");

	public TelaMenu() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(170, 10, 150, 40);
		questao.setBounds(170, 150, 100, 30);
		edital.setBounds(170, 100, 100, 30);

		setLayout(null);

		add(titulo);
		add(questao);
		add(edital);
		questao.addActionListener(this);
		edital.addActionListener(this);

		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		/*
		 * questao.addActionListener(menu);
		 * edital.addActionListener(menu);
		 */

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == edital) {
			edital(e);

		}
		if (src == questao) {
			questao(e);

		}

	}

	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();

	}

	public void edital(ActionEvent evt) {

		TelaEdital telaEdital = new TelaEdital();

	}

	public void questao(ActionEvent evt) {

		TelaQuestao telaQuestao = new TelaQuestao();

	}

}