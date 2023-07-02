package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controle.ControleQuestao;

public class TelaDetalheQuestao extends JFrame implements ActionListener {

    JLabel tipo, enunciado, resposta, materia;
    JButton salvarQ;
    JButton deletarQ;
    private JTextArea caixaEnunciado;
    private JTextArea caixaResposta;
    private JTextField caixaMateria;
    private JTextField caixatipo;

    // private JComboBox<String> exatasButton;
    private Integer codQuestao = 0;

    public TelaDetalheQuestao() {
        // botoes
        salvarQ = new JButton("Salvar");
        deletarQ = new JButton("Deletar");

        //
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

        setLayout(null);

        add(salvarQ);
        add(deletarQ);

        add(tipo);
        add(enunciado);
        add(resposta);
        add(materia);

        String[] resposta = { "Exatas", "Humanas" };
        /*
         * exatasButton = new JComboBox<>(resposta);
         * exatasButton.setBounds(120, 30, 100, 20);
         * getContentPane().add(exatasButton);
         * add(exatasButton);
         * salvarQ.addActionListener(this);
         */

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

        // salvarQ.addActionListener(this);

        setSize(600, 550);
        setVisible(true);

    }

    private void limparTela() {
        caixatipo.setText("");
        caixaMateria.setText("");
        caixaEnunciado.setText("");
        caixaResposta.setText("");
    }

    public void BuscarQuestao(int codQuestao, String tipo, String materia, String enunciado, String resposta) {
        this.codQuestao = codQuestao;
        this.caixatipo.setText(tipo);
        this.caixaMateria.setText(materia);
        this.caixaEnunciado.setText(enunciado);
        this.caixaResposta.setText(resposta);

    }

    public static void main(String[] args) {
        new TelaDetalheQuestao();
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

    public void cadastrarbutton(ActionEvent evt) {
        // String tipo = exatasButton.getSelectedItem().toString();

        boolean sucesso;
        try {
            ControleQuestao controleQuestao = new ControleQuestao();
            if (this.codQuestao == 0) {

                if (caixatipo.getText().equals("Exatas")) {
                    sucesso = controleQuestao.cadQuestaoExatas(caixatipo.getText(), caixaMateria.getText(),
                            caixaEnunciado.getText(), caixaResposta.getText());
                    JOptionPane.showMessageDialog(null, "Foi cadastrado uma questao de exatas !");

                } else {
                    sucesso = controleQuestao.cadQuestaoHumanas(caixatipo.getText(), caixaMateria.getText(),
                            caixaEnunciado.getText(), caixaResposta.getText());
                    JOptionPane.showMessageDialog(null, "Foi cadastrado uma questao de humanas !");
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

    private void limparTelaCadastroQuestao() {
        this.limparTela();
    }
}