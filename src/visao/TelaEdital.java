package visao;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.ControleEditais;
import modelo.Edital;

public class TelaEdital extends JFrame implements ActionListener {

    private JButton buscar = new JButton("buscar");

    private JButton cadastrar = new JButton("cadastrar");
    private JTextField caixaBuscar = new JTextField();
    private JPanel painelTabela = new JPanel(new GridLayout());
    private JTable tabela;

    private DefaultTableModel tableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };

    public TelaEdital() {

        setTitle("Consulta de Concurso");
        setBounds(320, 120, 960, 640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        caixaBuscar.setBounds(230, 40, 380, 30);
        add(caixaBuscar);

        cadastrar.setBounds(760, 40, 150, 32);
        cadastrar.addActionListener(this::cadastro);
        add(cadastrar);

        buscar.setBounds(630, 40, 150, 32);
        buscar.addActionListener(this::buscar);
        add(buscar);

        tableModel.addColumn("Codigo");
        tableModel.addColumn("Nome");
        tableModel.addColumn("DataInicio");
        tableModel.addColumn("DataTermino");
        tableModel.addColumn("local");
        tableModel.addColumn("salario");
        tableModel.addColumn("qtd vagas");

        tabela = new JTable(tableModel);
        tabela.setRowHeight(40);
        tabela.setBackground(new Color(220, 220, 220));

        painelTabela.setBounds(100, 100, 760, 350);
        painelTabela.add(new JScrollPane(tabela));
        add(painelTabela);

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModelMouseclicked(evt);
            }
        });

        setVisible(true);
    }

    public void buscar(ActionEvent evt) {
        String nome = caixaBuscar.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
        tableModel.setRowCount(0);
        ControleEditais controleEditais = new ControleEditais();
        try {
            ArrayList<Edital> editais = controleEditais.listarEditais(nome);
            editais.forEach((Edital edital) -> {
                tableModel.addRow(new Object[] {
                        edital.getCodEdital(),
                        edital.getNome(),
                        edital.getDataInicio(),
                        edital.getDataTermino(),
                        edital.getLocalidade(),
                        edital.getSalario(),
                        edital.getQtdVagas()
                });
            });
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            Logger.getLogger(TelaDetalheEdital.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cadastrar) {
            cadastro(e);
        }

    }

    public static void main(String[] args) {
        TelaEdital tela = new TelaEdital();

    }

    private void tableModelMouseclicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            TelaDetalheEdital telaDetalheEdital = new TelaDetalheEdital();
            int selectedRow = tabela.getSelectedRow();
            Integer codEdital = (Integer) tableModel.getValueAt(selectedRow, 0);
            String nome = (String) tableModel.getValueAt(selectedRow, 1);
            String dataInicio = (String) tableModel.getValueAt(selectedRow, 2);
            String dataTermino = (String) tableModel.getValueAt(selectedRow, 3);
            String local = (String) tableModel.getValueAt(selectedRow, 4);
            Float salario = (Float) tableModel.getValueAt(selectedRow, 5);
            int qtdVagas = (Integer) tableModel.getValueAt(selectedRow, 6);

            telaDetalheEdital.BuscarEditais(codEdital, nome, dataInicio, dataTermino, local, salario, qtdVagas);

            telaDetalheEdital.setVisible(true);
            this.dispose();
        }
    }

    public void cadastro(ActionEvent evt) {

        TelaDetalheEdital telaDetalheEdital = new TelaDetalheEdital();

    }

}