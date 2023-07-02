package controle;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import dao.EditalDAO;
import dao.ExceptionDAO;
import modelo.Edital;

public class ControleEditais {

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

    public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
        return new EditalDAO().listarEditais(nome);
    }

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