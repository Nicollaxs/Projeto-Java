package controle;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import dao.EditalDAO;
import dao.ExceptionDAO;
import modelo.Edital;

public class ControleEditais {

    public boolean cadEdital(String nome, String dataInicio, String dataTermino,
            String localidade, String salario,
            String qtdVagas) throws ParseException, ExceptionDAO {
        if (nome != null && nome.length() > 0 && validarData(dataInicio)
                && validarData(dataTermino) && localidade != null
                &&
                localidade.length() > 0
                && salario != null && salario.length() > 0 && qtdVagas != null &&
                qtdVagas.length() > 0) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dataInicio);
            Date data2 = formato.parse(dataTermino);

            Edital edital = new Edital(nome, data, data2, localidade, salario, qtdVagas);
            edital.CadastrarEdital(edital);

            return true;
        }
        return false;

    }

    public static boolean validarData(String dataString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate data = LocalDate.parse(dataString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
        return new EditalDAO().listarEditais(nome);
    }

    public boolean alterarEdital(int codEdital, String nome, String dataInicio, String dataTermino,
            String localidade, String salario,
            String qtdVagas) {
                return true;

    }

}
