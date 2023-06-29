package controle;

import java.text.ParseException;
import dao.ExceptionDAO;
import modelo.Exatas;
import modelo.Humanas;

public class ControleQuestao {

    // tipo, enunciado, alternativa, materia;
    String ex = "exatas";
    String hum = "humanas";

    public boolean cadQuestao(String tipo, String enunciado, String alternativa,
            String materia, String resposta) throws ParseException, ExceptionDAO {
        if (resposta.equals(ex)) {

            if (tipo != null && tipo.length() > 0 && enunciado != null &&
                    enunciado.length() > 0
                    && alternativa != null && alternativa.length() > 0 && enunciado != null &&
                    enunciado.length() > 0 && materia != null && materia.length() > 0) {

                Exatas questao = new Exatas(tipo, enunciado, alternativa, materia, resposta);

                return true;
            }
        } else if (resposta.equals(hum)) {
            if (tipo != null && tipo.length() > 0 && enunciado != null &&
                    enunciado.length() > 0
                    && alternativa != null && alternativa.length() > 0 && enunciado != null &&
                    enunciado.length() > 0 && materia != null && materia.length() > 0) {

                Humanas questao = new Humanas(tipo, enunciado, alternativa, materia, resposta);

                return true;
            }
        }

        return false;

    }

}
