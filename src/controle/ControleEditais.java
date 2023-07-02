package controle;

import java.text.ParseException;
import java.util.ArrayList;
import dao.EditalDAO;
import dao.ExceptionDAO;
import modelo.Edital;

/**
 * Classe que controla os editais.
 * 
 * @author Samuel
 */
public class ControleEditais {

    /**
     * Cadastra um novo edital.
     * 
     * @param nome        O nome do edital.
     * @param dataInicio  A data de inicio do edital (no formato "dd/MM/yyyy").
     * @param dataTermino A data de termino do edital (no formato "dd/MM/yyyy").
     * @param localidade  A localidade do edital.
     * @param salario     O salario oferecido no edital.
     * @param qtdVagas    A quantidade de vagas disponiveis no edital.
     * @return true se o cadastro foi realizado com sucesso, false caso contrario.
     * @throws ParseException Se houver erro na conversao das datas.
     * @throws ExceptionDAO   Se ocorrer algum erro de acesso a dados.
     */
    public boolean cadEdital(String nome, String dataInicio, String dataTermino,
            String localidade, Float salario,
            int qtdVagas) throws ParseException, ExceptionDAO {
        if (nome != null && nome.length() > 0 && dataInicio != null && dataInicio.length() > 0
                && dataTermino != null && dataTermino.length() > 0 && localidade != null
                &&
                localidade.length() > 0
                && salario != null && salario > 0 &&
                qtdVagas > 0) {

            Edital edital = new Edital(nome, dataInicio, dataTermino, localidade, salario, qtdVagas);
            edital.CadastrarEdital(edital);

            return true;
        }
        return false;

    }

    /**
     * Lista editais com base no nome informado.
     * 
     * @param nome O nome a ser buscado nos editais.
     * @return Uma lista de editais com o nome especificado.
     * @throws ExceptionDAO Se ocorrer algum erro de acesso a dados.
     */
    public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
        return new EditalDAO().listarEditais(nome);
    }

    /**
     * Altera um edital existente.
     * 
     * @param codEdital   O codigo do edital a ser alterado.
     * @param nome        O novo nome do edital.
     * @param dataInicio  A nova data de inicio do edital (no formato "dd/MM/yyyy").
     * @param dataTermino A nova data de termino do edital (no formato
     *                    "dd/MM/yyyy").
     * @param localidade  A nova localidade do edital.
     * @param salario     O novo salario oferecido no edital.
     * @param qtdVagas    A nova quantidade de vagas disponíveis no edital.
     * @return true se a alteracao foi realizada com sucesso, false caso contrario.
     * @throws ExceptionDAO Se ocorrer algum erro de acesso a dados.
     */
    public boolean mudarEdital(int codEdital, String nome, String dataInicio, String dataTermino,
            String localidade, Float salario,
            int qtdVagas) throws ExceptionDAO {
        if (nome != null && nome.length() > 0 && dataInicio != null && dataInicio.length() > 0
                && dataTermino != null && dataTermino.length() > 0 && localidade != null
                &&
                localidade.length() > 0
                && salario != null && salario > 0 &&
                qtdVagas > 0) {

            Edital edital = new Edital(nome, dataInicio, dataTermino, localidade, salario, qtdVagas);

            edital.setCodEdital(codEdital);
            edital.mudarEdital(edital);

            return true;
        }
        return false;

    }

    /**
     * Deleta um edital existente.
     * 
     * @param codEdital O codigo do edital a ser deletado.
     * @return true se o edital foi deletado com sucesso, false caso contrario.
     * @throws ExceptionDAO Se ocorrer algum erro de acesso a dados.
     */
    public boolean deletarEdital(int codEdital) throws ExceptionDAO {
        if (codEdital == 0)
            return false;
        else {
            Edital edital = new Edital();
            edital.setCodEdital(codEdital);
            edital.deletarEdital(edital);
            return true;
        }
    }

}
