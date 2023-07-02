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

/**
 * Classe que representa a tela de consulta e cadastro de questoes para
 * concursos.
 * 
 * <p>
 * Essa classe extende a classe JFrame e implementa a interface ActionListener,
 * sendo responsavel por exibir a tela onde o usuario pode consultar questoes
 * cadastradas
 * e cadastrar novas questoes para o banco de dados.
 * 
 * <p>
 * A tela possui uma caixa de busca onde o usuario pode inserir o nome da
 * materia para
 * filtrar as questoes exibidas na tabela. Alem disso, a tela exibe uma tabela
 * com as
 * questoes cadastradas, exibindo informcoes como o codigo da questao, tipo,
 * materia,
 * enunciado e resposta.
 * 
 * <p>
 * Os botoes "Buscar" e "Cadastrar" permitem realizar acoes na tela:
 * - O botao "Buscar" aciona o metodo de busca, filtrando as questoes de acordo
 * com a materia
 * digitada na caixa de busca.
 * - O botao "Cadastrar" aciona o metodo de cadastro, abrindo uma nova tela
 * (TelaDetalheQuestao)
 * para que o usuario possa cadastrar uma nova questao.
 * 
 * <p>
 * Ao clicar duas vezes em uma questao na tabela, e aberta uma tela
 * (TelaDetalheQuestao) com
 * os detalhes da questao selecionada.
 * 
 * <p>
 * A classe tambem possui um metodo main para executar a tela de consulta de
 * questoes.
 * 
 * @see JFrame
 * @see ActionListener
 * @see TelaDetalheQuestao
 * @see Questao
 * 
 * @version a
 * @since a
 * 
 * @author Pc
 */
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

    /**
     * Construtor da classe TelaQuestao.
     * 
     * <p>
     * Cria uma nova instancia da tela de consulta e cadastro de questoes,
     * configurando
     * seus componentes, definindo seu tamanho, layout e visibilidade.
     */
    public TelaQuestao() {

        setTitle("Consulta de Questao");
        setBounds(320, 120, 960, 640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 30));
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

    /**
     * Metodo para buscar questoes de acordo com a materia digitada.
     * 
     * <p>
     * Esse metodo e chamado ao clicar no botao "Buscar". Ele recupera o texto
     * digitado
     * na caixa de busca e utiliza o objeto ControleQuestao para buscar as questoes
     * relacionadas
     * a materia informada. As questoes encontradas sao exibidas na tabela.
     * 
     * @param evt O evento de clique no botao "Buscar".
     */
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

    /**
     * Método para tratar o evento de clique na tabela de questões.
     * 
     * <p>
     * Esse metodo e chamado ao clicar duas vezes em uma questao na tabela. Ele
     * obtem
     * os dados da questao selecionada na tabela e abre uma nova tela
     * (TelaDetalheQuestao)
     * para exibir os detalhes dessa questao.
     * 
     * @param evt O evento de clique na tabela de questoes.
     */
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

    /**
     * Metodo de acao para o botao "Cadastrar".
     * 
     * <p>
     * Esse metodo e chamado ao clicar no botao "Cadastrar". Ele cria uma nova
     * instancia
     * da tela de detalhes de questao (TelaDetalheQuestao), permitindo que o usuario
     * possa
     * cadastrar uma nova questao.
     * 
     * @param evt O evento de clique no botao "Cadastrar".
     */
    public void cadastro(ActionEvent evt) {

        TelaDetalheQuestao telaDetalheQuestao = new TelaDetalheQuestao();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cadastrar) {
            cadastro(e);

        }
    }
}