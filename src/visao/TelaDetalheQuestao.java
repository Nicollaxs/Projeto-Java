package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controle.ControleQuestao;

/**
 * Classe que representa a tela de detalhe de uma questao.
 * 
 * <p>
 * Essa classe extende a classe JFrame e implementa a interface ActionListener,
 * sendo responsável por exibir e manipular os detalhes de uma questao no
 * sistema.
 * 
 * @author Pc
 * @version a
 */
public class TelaDetalheQuestao extends JFrame implements ActionListener {
    JLabel tipo, enunciado, resposta, materia;
    JLabel exatas;
    JLabel humanas;
    JButton salvarQ;
    JButton deletarQ;
    private JTextArea caixaEnunciado;
    private JTextArea caixaResposta;
    private JTextField caixaMateria;
    private JTextField caixatipo;
    private Integer codQuestao = 0;

    /**
     * Construtor da classe TelaDetalheQuestao.
     * 
     * <p>
     * Cria uma nova instancia da tela de detalhe de questao, configurando seus
     * componentes,
     * definindo seu tamanho, layout e visibilidade.
     */
    public TelaDetalheQuestao() {
        // botoes
        salvarQ = new JButton("Salvar");
        deletarQ = new JButton("Deletar");

        //

        exatas = new JLabel("(Exatas ou");
        humanas = new JLabel("Humanas)");

        tipo = new JLabel("Tipo : ");
        materia = new JLabel("Materia : ");
        enunciado = new JLabel("Enunciado : ");
        resposta = new JLabel("Resposta : ");
        tipo.setBounds(20, 30, 100, 30);
        materia.setBounds(20, 70, 100, 30);
        enunciado.setBounds(20, 120, 100, 30);
        resposta.setBounds(20, 230, 100, 30);

        // botoes
        salvarQ.setBounds(120, 350, 100, 30);
        deletarQ.setBounds(250, 350, 100, 30);
        salvarQ.addActionListener(this);
        deletarQ.addActionListener(this);

        exatas.setBounds(250, 30, 100, 30);
        add(exatas);
        humanas.setBounds(315, 30, 100, 30);
        add(humanas);

        setLayout(null);
        setTitle("Cadastro de Questao");
        add(salvarQ);
        add(deletarQ);

        add(tipo);
        add(enunciado);
        add(resposta);
        add(materia);

        // tipo
        caixatipo = new JTextField(20);
        caixatipo.setBounds(120, 30, 100, 30);
        getContentPane().add(caixatipo);
        caixatipo.setColumns(10);

        // materia

        caixaMateria = new JTextField(20);
        caixaMateria.setBounds(120, 70, 100, 30);
        getContentPane().add(caixaMateria);
        caixaMateria.setColumns(10);

        // enunciado

        caixaEnunciado = new JTextArea(10, 10);
        caixaEnunciado.setBounds(120, 120, 300, 100);
        getContentPane().add(caixaEnunciado);
        caixaEnunciado.setColumns(10);
        caixaEnunciado.setLineWrap(true);
        caixaEnunciado.setWrapStyleWord(true);

        // Resposta

        caixaResposta = new JTextArea(10, 10);
        caixaResposta.setBounds(120, 230, 300, 70);
        getContentPane().add(caixaResposta);
        caixaResposta.setColumns(10);
        caixaResposta.setLineWrap(true);
        caixaResposta.setWrapStyleWord(true);

        setSize(600, 550);
        setVisible(true);

    }

    /**
     * Metodo para limpar os campos da tela de detalhe de questao.
     */
    private void limparTela() {
        caixatipo.setText("");
        caixaMateria.setText("");
        caixaEnunciado.setText("");
        caixaResposta.setText("");
    }

    /**
     * Metodo para buscar os detalhes de uma questao no banco de dados e exibi-los
     * na tela.
     * 
     * @param codQuestao O codigo da questao a ser buscada.
     * @param tipo       O tipo da questao (Exatas ou Humanas).
     * @param materia    A materia da questao.
     * @param enunciado  O enunciado da questao.
     * @param resposta   A resposta da questao.
     */

    public void BuscarQuestao(int codQuestao, String tipo, String materia, String enunciado, String resposta) {
        this.codQuestao = codQuestao;
        this.caixatipo.setText(tipo);
        this.caixaMateria.setText(materia);
        this.caixaEnunciado.setText(enunciado);
        this.caixaResposta.setText(resposta);

    }

    /**
     * Metodo para tratar o evento de clique no botao "Salvar".
     * 
     * @param evt O evento de clique no botao.
     */
    public void cadastrarbutton(ActionEvent evt) {

        boolean sucesso;
        try {
            ControleQuestao controleQuestao = new ControleQuestao();
            if (this.codQuestao == 0) {

                if (caixatipo.getText().equals("Exatas")) {
                    sucesso = controleQuestao.cadQuestaoExatas(caixatipo.getText(), caixaMateria.getText(),
                            caixaEnunciado.getText(), caixaResposta.getText());
                    // JOptionPane.showMessageDialog(null, "Foi cadastrado uma questao de exatas
                    // !");

                } else {
                    sucesso = controleQuestao.cadQuestaoHumanas(caixatipo.getText(), caixaMateria.getText(),
                            caixaEnunciado.getText(), caixaResposta.getText());
                    // JOptionPane.showMessageDialog(null, "Foi cadastrado uma questao de humanas
                    // !");
                }
            } else {
                sucesso = controleQuestao.mudarQuestao(this.codQuestao, caixatipo.getText(), caixaMateria.getText(),
                        caixaEnunciado.getText(), caixaResposta.getText());
            }
            if (sucesso == true) {
                JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }

    }

    /**
     * metodo para tratar o evento de clique no botao "Deletar".
     * 
     * @param evt O evento de clique no botao.
     */

    public void deletarbutton(ActionEvent evt) {

        boolean sucesso;

        ControleQuestao controleQuestao = new ControleQuestao();

        try {
            sucesso = controleQuestao.deletarQuestao(this.codQuestao);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O edital foi apagado com sucesso");
                this.limparTela();
            } else
                JOptionPane.showMessageDialog(null,
                        "O edital não foi apagado. Por favor, selecione um edital !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    /**
     * Metodo para limpar os campos da tela apos um cadastro de questao.
     */
    private void limparTelaCadastroQuestao() {
        this.limparTela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == salvarQ) {
            cadastrarbutton(e);

        }
        if (src == deletarQ) {
            deletarbutton(e);

        }

    }
}