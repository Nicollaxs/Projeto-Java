package visao;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.*;

import modelo.Questao;

public class TelaQuestao extends JFrame implements ActionListener {

    private JButton buscarQuestao = new JButton("buscar");
    private JButton cadastrar = new JButton("cadastrar");
    private JTextField caixaBuscarQuestao = new JTextField();
    private JPanel painelTabelaQuestao = new JPanel(new GridLayout());
    private JTable tabelaQuestao;

    private DefaultTableModel tableModelQuestao = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };

    public TelaQuestao() {

        setTitle("Consulta de Concurso");
        setBounds(320, 120, 960, 640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        caixaBuscarQuestao.setBounds(230, 40, 380, 30);
        add(caixaBuscarQuestao);

        cadastrar.setBounds(800, 40, 150, 32);
        cadastrar.addActionListener(this::cadastro);
        add(cadastrar);

        buscarQuestao.setBounds(630, 40, 150, 32);
        buscarQuestao.addActionListener(this::buscar);
        add(buscarQuestao);

        tableModelQuestao.addColumn("codQuestao");
        tableModelQuestao.addColumn("Tipo");
        tableModelQuestao.addColumn("Materia");
        tableModelQuestao.addColumn("Enunciado");
        tableModelQuestao.addColumn("Resposta");

        tabelaQuestao = new JTable(tableModelQuestao);
        tabelaQuestao.setRowHeight(40);
        tabelaQuestao.setBackground(new Color(220, 220, 220));

        painelTabelaQuestao.setBounds(100, 100, 760, 350);
        painelTabelaQuestao.add(new JScrollPane(tabelaQuestao));
        add(painelTabelaQuestao);

        tabelaQuestao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModelMouseclicked(evt);
            }
        });

        setVisible(true);
    }

    public void buscar(ActionEvent evt) {
        String materia = caixaBuscarQuestao.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaQuestao.getModel();
        tableModel.setRowCount(0);
        ControleQuestao controleQuestao = new ControleQuestao();
        try {
            ArrayList<Questao> questoes = controleQuestao.listarQuestao(materia);
            questoes.forEach((Questao questoes1) -> {
                tableModel.addRow(new Object[] {
                        questoes1.getCodQuestao(),
                        questoes1.getTipo(),
                        questoes1.getMateria(),
                        questoes1.getEnunciado(),
                        questoes1.getResposta(),

                });
            });
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            Logger.getLogger(TelaDetalheQuestao.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public static void main(String[] args) {
        TelaQuestao tela = new TelaQuestao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cadastrar) {
            cadastro(e);

        }
    }

    private void tableModelMouseclicked(java.awt.event.MouseEvent evt) {
        // TelaDetalheQuestao telaDetalheQuestao = new TelaDetalheQuestao();
        if (evt.getClickCount() == 2) {
            TelaDetalheQuestao telaDetalheQuestao = new TelaDetalheQuestao();
            int selectedRow = tabelaQuestao.getSelectedRow();
            Integer codQuestao = (Integer) tableModelQuestao.getValueAt(selectedRow, 0);
            String tipo = (String) tableModelQuestao.getValueAt(selectedRow, 1);
            String materia = (String) tableModelQuestao.getValueAt(selectedRow, 2);
            String enunciado = (String) tableModelQuestao.getValueAt(selectedRow, 3);
            String resposta = (String) tableModelQuestao.getValueAt(selectedRow, 4);

            telaDetalheQuestao.BuscarQuestao(codQuestao, tipo, materia,
                    enunciado, resposta);

            telaDetalheQuestao.setVisible(true);
            this.dispose();
        }
    }

    public void cadastro(ActionEvent evt) {

        TelaDetalheQuestao telaDetalheQuestao = new TelaDetalheQuestao();

    }
}