package controle;

import javax.swing.JList;

public class ControleDados {
    
    public String [] questoes = {"Questao1", "Questao2", "Questao3","QuestaoTeste1"};
    public JList lista = new JList(questoes);

    public String [] editais = {"Edital1", "Edital2", "Edital3"};
    public JList listaed = new JList(editais);

}
