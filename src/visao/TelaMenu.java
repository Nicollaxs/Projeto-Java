package visao;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que representa a tela de menu do sistema de estudo para concursos.
 * 
 * <p>
 * Essa classe extende a classe JFrame e implementa a interface ActionListener,
 * sendo responsavel por exibir o menu principal do sistema, onde o usuario pode
 * acessar as funcionalidades relacionadas a questoes e editais de concursos.
 * 
 * <p>
 * O menu exibe dois botoes: um para acessar a tela de questoes (TelaQuestao)
 * e outro para acessar a tela de editais (TelaEdital).
 * 
 * <p>
 * Os botoes sao configurados com listeners para tratar os eventos de clique e
 * direcionar o usuario para as respectivas telas.
 * 
 * <p>
 * A classe tambem possui um metodo main para executar a tela de menu.
 * 
 * @see JFrame
 * @see ActionListener
 * @see TelaQuestao
 * @see TelaEdital
 * 
 * @version 1.0
 * 
 * @author Pc
 */
public class TelaMenu extends JFrame implements ActionListener {

	private static JLabel titulo = new JLabel("Tela Menu");
	private static JButton questao = new JButton("Questoes");
	private static JButton edital = new JButton("Editais");
	private static JPanel painel = new JPanel();

	/**
	 * Construtor da classe TelaMenu.
	 * 
	 * <p>
	 * Cria uma nova instancia da tela de menu, configurando seus componentes,
	 * definindo seu tamanho, layout e visibilidade.
	 */
	public TelaMenu() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(170, 10, 150, 40);
		questao.setBounds(170, 150, 100, 30);
		edital.setBounds(170, 100, 100, 30);

		setLayout(null);
		setTitle("Menu");
		add(titulo);
		add(questao);
		add(edital);
		questao.addActionListener(this);
		edital.addActionListener(this);

		titulo.setForeground(Color.WHITE);

		// Painel
		getContentPane().add(titulo);

		getContentPane().setBackground(new Color(0, 0, 30));
		add(painel);

		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

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

	/**
	 * Metodo para abrir a tela de edital.
	 * 
	 * <p>
	 * Esse metodo e chamado ao clicar no botao "Editais" e abre a tela onde sao
	 * exibidos os editais disponiveis para consulta.
	 * 
	 * @param evt O evento de clique no botao "Editais".
	 */
	public void edital(ActionEvent evt) {

		TelaEdital telaEdital = new TelaEdital();

	}

	/**
	 * Metodo para abrir a tela de questao.
	 * 
	 * <p>
	 * Esse metodo e chamado ao clicar no botao "Questoes" e abre a tela onde sao
	 * exibidas as questoes disponiveis para estudo.
	 * 
	 * @param evt O evento de clique no botao "Questoes".
	 */
	public void questao(ActionEvent evt) {

		TelaQuestao telaQuestao = new TelaQuestao();

	}

}