package visao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import controle.ControleEditais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.TelaEdital;
import modelo.Edital;

public class TelaDetalheEdital extends JFrame implements ActionListener {
    JLabel nomeJLabel = new JLabel("Nome :");
    JLabel dataInicioJLabel = new JLabel("Data Inicio :");
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
    private Integer codEdital=0;
    //String nome = null;

    public TelaDetalheEdital() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        caixaNome.setBounds(120, 50, 100, 30);
        add(caixaNome);
        nomeJLabel.setBounds(20, 50, 100, 30);
        add(nomeJLabel);

        caixadataInicio.setBounds(120, 90, 100, 30);
        add(caixadataInicio);
        dataInicioJLabel.setBounds(20, 90, 100, 30);
        add(dataInicioJLabel);

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

    private void limparTela(){
            caixaNome.setText("");
        caixadataInicio.setText("");
        caixadataTermino.setText("");
        caixalocal.setText("");
        caixaqtdVagas.setText("0");
        caixasalario.setText("0");
    }

    public void BuscarEditais(int codEdital, String nome, String dataInicio, String dataTermino, String local,
            String salario,
            String qtdvagas) {
                this.codEdital=codEdital;
        this.caixaNome.setText(nome);
        this.caixadataInicio.setText(dataInicio);
        this.caixadataTermino.setText(dataTermino);
        this.caixalocal.setText(local);
        this.caixasalario.setText(salario);
        this.caixaqtdVagas.setText(qtdvagas);

    }

    public static void main(String[] args) {
        new TelaDetalheEdital();
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

public void salvarbutton(ActionEvent evt) {

        boolean sucesso;
        try {
            ControleEditais controleEditais = new ControleEditais();

            if (this.codEdital == 0) {
                sucesso = controleEditais.cadEdital(caixaNome.getText(), caixadataInicio.getText(),
                        caixadataTermino.getText(), caixalocal.getText(), caixasalario.getText(),
                        caixaqtdVagas.getText());
            } else {
                sucesso = controleEditais.mudarEdital(this.codEdital, caixaNome.getText(), caixadataInicio.getText(),
                        caixadataTermino.getText(), caixalocal.getText(), caixasalario.getText(),
                        caixaqtdVagas.getText());
            }

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso");
                this.limparTelaCadastroEdital();
            } else {
                JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void deletarbutton(ActionEvent evt) {

        boolean sucesso;
        
            ControleEditais controleEditais = new ControleEditais();

            try {
                sucesso = controleEditais.deletarEdital(this.codEdital);
                if(sucesso){
                JOptionPane.showMessageDialog(null, "O edital foi apagado com sucesso");
                this.limparTela();
            } else 
                JOptionPane.showMessageDialog(null, "O edital não foi apagado. Por favor, selecione um edital !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    private void limparTelaCadastroEdital() {
this.limparTela();
    }

}