package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;
import visao.TelaDetalheEdital;

public class TelaQuestao {

    JFrame janela;
    JFrame janelaTeste;
    JLabel texto;
    JButton cadastrarButton;
    JButton atualizarButton;
        
    public String [] questoes = {"Questao1", "Questao2", "Questao3","QuestaoTeste1"};
    public JList lista = new JList(questoes);


    public TelaQuestao(){
        teste();
    }

    //mudar esse "TESTE"
    public void teste(){

        cadastrarButton = new JButton("Cadastrar");
        atualizarButton = new JButton("Atualizar");
        texto = new JLabel("Lista de questoes");

    janela = new JFrame();
   
    texto.setBounds(130, 10, 150, 30);
    lista.setBounds(20, 50, 350, 120);
    lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	lista.setVisibleRowCount(10);

    cadastrarButton.setBounds(70, 177, 100, 30);
    atualizarButton.setBounds(200, 177, 100, 30);

    janela.setLayout(null);
    
    janela.add(lista);
    janela.add(cadastrarButton);
    janela.add(atualizarButton);
    janela.add(texto);
    
    lista.setBounds(20, 50, 350, 120);


    janela.setSize(500, 500);
    janela.setVisible(true);


    }
    
    public static void main(String[] args) {
        
    
    new TelaQuestao();


    }
    
}

