package visao;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.Edital;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleQuestao;

public class TelaDetalheQuestao implements ActionListener, ListSelectionListener {

    JFrame janelaCadastro;
    JLabel tipo, enunciado, alternativa, materia;
    JButton salvar;
    JButton deletar;
    private JTextField caixaTipo;
    private JTextField caixaEnunciado;
    private JTextField caixaAlternativa;
    private JTextField caixaMateria;
    JComboBox exatasButton;

    public TelaDetalheQuestao() {
        QuestaoTela();
    }

    public void QuestaoTela() {

        // botoes
        salvar = new JButton("Salvar");
        deletar = new JButton("Deletar");

        //
        tipo = new JLabel("Tipo : ");
        enunciado = new JLabel("Enunciado : ");
        alternativa = new JLabel("Alternativa : ");
        materia = new JLabel("Materia : ");

        janelaCadastro = new JFrame();

        tipo.setBounds(20, 50, 100, 30);
        enunciado.setBounds(20, 90, 100, 30);
        alternativa.setBounds(20, 130, 100, 30);
        materia.setBounds(20, 170, 100, 30);

        // botoes
        salvar.setBounds(120, 350, 100, 30);
        deletar.setBounds(250, 350, 100, 30);

        janelaCadastro.setLayout(null);

        janelaCadastro.add(salvar);
        janelaCadastro.add(deletar);

        janelaCadastro.add(tipo);
        janelaCadastro.add(enunciado);
        janelaCadastro.add(alternativa);
        janelaCadastro.add(materia);

        String[] resposta = { "exatas", "humanas" };

        JComboBox comboBox = new JComboBox(resposta);

        comboBox.setBounds(120, 50, 100, 30);
        janelaCadastro.getContentPane().add(comboBox);
        janelaCadastro.add(comboBox);

        // tipo

        // enunciado

        caixaEnunciado = new JTextField(20);
        caixaEnunciado.setBounds(120, 90, 100, 30);
        janelaCadastro.getContentPane().add(caixaEnunciado);
        caixaEnunciado.setColumns(10);

        // alternativa

        caixaAlternativa = new JTextField(20);
        caixaAlternativa.setBounds(120, 130, 100, 30);
        janelaCadastro.getContentPane().add(caixaAlternativa);
        caixaAlternativa.setColumns(10);

        // materia

        caixaMateria = new JTextField(20);
        caixaMateria.setBounds(120, 170, 100, 30);
        janelaCadastro.getContentPane().add(caixaMateria);
        caixaMateria.setColumns(10);

        salvar.addActionListener(this);

        janelaCadastro.setSize(500, 450);
        janelaCadastro.setVisible(true);

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valorTipo = caixaTipo.getText();
                String valorEnunciado = caixaEnunciado.getText();
                String valorAlternativa = caixaAlternativa.getText();
                String valorMateria = caixaMateria.getText();
                String valorResposta = comboBox.getSelectedItem().toString();

                try {
                    ControleQuestao controleQuestoes = new ControleQuestao();
                    boolean sucesso = controleQuestoes.cadQuestao(valorTipo, valorEnunciado, valorAlternativa,
                            valorMateria, valorResposta);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "O cadastro foi realizado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex);
                }
            }
        });

    }

    public static void main(String[] args) {
        new TelaDetalheQuestao();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'valueChanged'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
/*
 * enunciado;
 * private String alternativa;
 * private String materia;
 */