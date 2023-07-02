package visao;

import javax.swing.*;
import controle.ControleEditais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que representa a tela de detalhe de um edital.
 * 
 * <p>
 * Essa classe extende a classe JFrame e implementa a interface ActionListener,
 * sendo responsavel por exibir e manipular os detalhes de um edital no sistema.
 * 
 * @author Pc
 * @version a
 */
public class TelaDetalheEdital extends JFrame implements ActionListener {
    JLabel nomeJLabel = new JLabel("Nome :");
    JLabel dataInicioJLabel = new JLabel("Data Inicio :");
    JLabel dataCorreta = new JLabel("(Ano-mes-dia)");
    JLabel dataCorreta2 = new JLabel("(Ano-mes-dia)");
    JLabel dataTerminoJLabel = new JLabel("Data Termino :");
    JLabel locaJLabel = new JLabel("Local :");
    JLabel salarioJLabel = new JLabel("Salario :");
    JLabel qtdVagasJLabel = new JLabel("Vagas :");

    JTextField caixaNome = new JTextField();
    JTextField caixadataInicio = new JTextField();
    JTextField caixadataTermino = new JTextField();
    JTextField caixalocal = new JTextField();
    JTextField caixasalario = new JTextField();
    JTextField caixaqtdVagas = new JTextField();

    JButton Salvar = new JButton("Salvar");
    JButton Deletar = new JButton("Deletar");

    private Integer codEdital = 0;
    private TelaEdital telaEdital;

    /**
     * Construtor da classe TelaDetalheEdital.
     * 
     * <p>
     * Cria uma nova instancia da tela de detalhe de edital, configurando seus
     * componentes,
     * definindo seu tamanho, layout e visibilidade.
     */
    public TelaDetalheEdital() {

        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Cadastro de Questa");
        caixaNome.setBounds(120, 50, 100, 30);
        add(caixaNome);
        nomeJLabel.setBounds(20, 50, 100, 30);
        add(nomeJLabel);

        caixadataInicio.setBounds(120, 90, 100, 30);
        add(caixadataInicio);
        dataInicioJLabel.setBounds(20, 90, 100, 30);
        add(dataInicioJLabel);

        dataCorreta.setBounds(300, 90, 100, 30);
        add(dataCorreta);

        dataCorreta2.setBounds(300, 130, 100, 30);
        add(dataCorreta2);

        caixadataTermino.setBounds(120, 130, 100, 30);
        add(caixadataTermino);
        dataTerminoJLabel.setBounds(20, 130, 100, 30);
        add(dataTerminoJLabel);

        caixalocal.setBounds(120, 170, 100, 30);
        add(caixalocal);
        locaJLabel.setBounds(20, 170, 100, 30);
        add(locaJLabel);
        caixalocal.setColumns(10);

        caixasalario.setBounds(120, 210, 100, 30);
        add(caixasalario);
        salarioJLabel.setBounds(20, 210, 100, 30);
        add(salarioJLabel);

        caixaqtdVagas.setBounds(120, 260, 100, 30);
        add(caixaqtdVagas);
        qtdVagasJLabel.setBounds(20, 250, 100, 30);
        add(qtdVagasJLabel);

        Salvar.setBounds(120, 350, 100, 30);
        Salvar.addActionListener(this);
        add(Salvar);

        Deletar.setBounds(250, 350, 100, 30);
        Deletar.addActionListener(this);
        add(Deletar);

        setVisible(true);

    }

    /**
     * Metodo para limpar os campos da tela de detalhe de edital.
     */
    private void limparTela() {
        caixaNome.setText("");
        caixadataInicio.setText("");
        caixadataTermino.setText("");
        caixalocal.setText("");
        caixaqtdVagas.setText("0");
        caixasalario.setText("0");
    }

    /**
     * Metodo para buscar os detalhes de um edital no banco de dados e exibi-los na
     * tela.
     * 
     * @param codEdital   O codigo do edital a ser buscado.
     * @param nome        O nome do edital.
     * @param dataInicio  A data de abertura do concurso.
     * @param dataTermino A data de encerramento do concurso.
     * @param local       O local onde sera realizado o concurso.
     * @param salario     O valor do salario para os aprovados no concurso.
     * @param qtdvagas    A quantidade de vagas disponiveis para o concurso.
     */
    public void BuscarEditais(int codEdital, String nome, String dataInicio, String dataTermino, String local,
            Float salario,
            int qtdvagas) {
        this.codEdital = codEdital;
        this.caixaNome.setText(nome);
        this.caixadataInicio.setText(dataInicio);
        this.caixadataTermino.setText(dataTermino);
        this.caixalocal.setText(local);
        this.caixasalario.setText(Float.toString(salario));
        this.caixaqtdVagas.setText(Integer.toString(qtdvagas));

    }

    /**
     * metodo para tratar o evento de clique no botao "Salvar".
     * 
     * @param evt O evento de clique no botao.
     */
    public void salvarbutton(ActionEvent evt) {

        boolean sucesso;
        try {
            ControleEditais controleEditais = new ControleEditais();

            String nome = caixaNome.getText();
            String dataInicioS = caixadataInicio.getText();
            String dataTerminoS = caixadataTermino.getText();
            String local = caixalocal.getText();
            float salario = Float.parseFloat(caixasalario.getText());
            int qtdVagas = Integer.parseInt(caixaqtdVagas.getText());

            if (this.codEdital == 0) {
                sucesso = controleEditais.cadEdital(nome, dataInicioS,
                        dataTerminoS, local, salario,
                        qtdVagas);
            } else {
                sucesso = controleEditais.mudarEdital(this.codEdital, nome, dataInicioS,
                        dataTerminoS, local, salario,
                        qtdVagas);
            }

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso");
                this.limparTelaCadastroEdital();
            } else {
                JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente");
        }
    }

    /**
     * Metodo para tratar o evento de clique no botao "Deletar".
     * 
     * @param evt O evento de clique no botao.
     */
    public void deletarbutton(ActionEvent evt) {

        boolean sucesso;

        ControleEditais controleEditais = new ControleEditais();

        try {
            sucesso = controleEditais.deletarEdital(this.codEdital);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O edital foi apagado com sucesso");
                this.limparTela();
            } else
                JOptionPane.showMessageDialog(null, "O edital não foi apagado. Por favor, selecione um edital !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    /**
     * Metodo para limpar os campos da tela apos um cadastro de edital.
     */
    private void limparTelaCadastroEdital() {
        this.limparTela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == Salvar) {
            salvarbutton(e);
        }
        if (src == Deletar) {
            deletarbutton(e);
        }

    }

}