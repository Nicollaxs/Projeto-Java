package controle;

import java.text.ParseException;
import java.util.ArrayList;
import dao.ExceptionDAO;
import dao.QuestaoDAO;
import modelo.Exatas;
import modelo.Humanas;
import modelo.Questao;

/**
 * Classe que controla as questoes.
 * 
 * @author Pc
 */
public class ControleQuestao {

    /**
     * Cadastra uma nova questao de Exatas.
     * 
     * @param tipo      O tipo da questão (Exatas).
     * @param materia   A materia à qual a questao pertence.
     * @param enunciado O enunciado da questao.
     * @param resposta  A resposta correta da questao.
     * @return true se o cadastro foi realizado com sucesso, false caso contrário.
     * @throws ParseException Se houver erro na conversao das datas.
     * @throws ExceptionDAO   Se ocorrer algum erro de acesso a dados.
     */
    public boolean cadQuestaoExatas(String tipo, String materia, String enunciado, String resposta)
            throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0 && enunciado != null
                && enunciado.length() > 0 && resposta != null && resposta.length() > 0) {

            Exatas questoes = new Exatas(tipo, materia, enunciado, resposta);
            questoes.CadastrarQuestao(questoes);

            return true;
        }
        return false;

    }

    /**
     * Lista questoes com base na materia informada.
     * 
     * @param materia A matéria a ser buscada nas questoes.
     * @return Uma lista de questoes com a materia especificada.
     * @throws ExceptionDAO Se ocorrer algum erro de acesso a dados.
     */
    public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
        return new QuestaoDAO().listarQuestao(materia);
    }

    /**
     * Cadastra uma nova questao de Humanas.
     * 
     * @param tipo      O tipo da questao (Humanas).
     * @param materia   A materia à qual a questao pertence.
     * @param enunciado O enunciado da questao.
     * @param resposta  A resposta correta da questao.
     * @return true se o cadastro foi realizado com sucesso, false caso contrario.
     * @throws ParseException Se houver erro na conversao das datas.
     * @throws ExceptionDAO   Se ocorrer algum erro de acesso a dados.
     */
    public boolean cadQuestaoHumanas(String tipo, String materia, String enunciado, String resposta)
            throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0 && enunciado != null
                && enunciado.length() > 0 && resposta != null && resposta.length() > 0) {

            Humanas questoes2 = new Humanas(tipo, materia, enunciado, resposta);
            questoes2.CadastrarQuestao(questoes2);

            return true;
        }
        return false;

    }

    /**
     * Altera uma questao existente.
     * 
     * @param codQuestao O codigo da questão a ser alterada.
     * @param tipo       O novo tipo da questao.
     * @param materia    A nova materia a qual a questao pertence.
     * @param enunciado  O novo enunciado da questao.
     * @param resposta   A nova resposta correta da questao.
     * @return true se a alteracao foi realizada com sucesso, false caso contrario.
     * @throws ParseException Se houver erro na conversao das datas.
     * @throws ExceptionDAO   Se ocorrer algum erro de acesso a dados.
     */
    public boolean mudarQuestao(int codQuestao, String tipo, String materia, String enunciado, String resposta)
            throws ParseException, ExceptionDAO {
        if (tipo != null && tipo.length() > 0 && materia != null && materia.length() > 0 && enunciado != null
                && enunciado.length() > 0 && resposta != null && resposta.length() > 0) {

            Exatas questoes = new Exatas(tipo, materia, enunciado, resposta);
            questoes.setCodQuestao(codQuestao);
            questoes.mudarQuestao(questoes);

            return true;
        }
        return false;

    }

    /**
     * Deleta uma questao existente.
     * 
     * @param codQuestao O codigo da questao a ser deletada.
     * @return true se a questao foi deletada com sucesso, false caso contrario.
     * @throws ExceptionDAO Se ocorrer algum erro de acesso a dados.
     */
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