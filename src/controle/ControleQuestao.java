package controle;

import java.text.ParseException;
import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.QuestaoDAO;

import modelo.Exatas;
import modelo.Humanas;
import modelo.Questao;

public class ControleQuestao {

    public boolean cadQuestaoExatas(String tipo, String materia, String enunciado,
            String resposta) throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0
                && enunciado != null && enunciado.length() > 0 && resposta != null
                && resposta.length() > 0) {

            Exatas questoes = new Exatas(tipo, materia, enunciado, resposta);
            questoes.CadastrarQuestao(questoes);

            return true;
        }
        return false;

    }

    public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
        return new QuestaoDAO().listarQuestao(materia);
    }

    public boolean cadQuestaoHumanas(String tipo, String materia, String enunciado,
            String resposta) throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0
                && enunciado != null && enunciado.length() > 0 && resposta != null
                && resposta.length() > 0) {

            Humanas questoes2 = new Humanas(tipo, materia, enunciado, resposta);
            questoes2.CadastrarQuestao(questoes2);

            return true;
        }
        return false;

    }

    public boolean mudarQuestao(int codQuestao, String tipo, String materia, String enunciado,
            String resposta) throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0
                && enunciado != null && enunciado.length() > 0 && resposta != null
                && resposta.length() > 0) {

            Exatas questoes = new Exatas(tipo, materia, enunciado, resposta);

            questoes.setCodQuestao(codQuestao);
            questoes.mudarQuestao(questoes);

            return true;
        }
        return false;

    }

    public boolean deletarQuestao(int codQuestao) throws ExceptionDAO {
        if (codQuestao == 0)
            return false;
        else {
            Exatas questao = new Exatas();
            questao.setCodQuestao(codQuestao);
            questao.deletarQuestao(questao);
            return true;
        }
    }
}
