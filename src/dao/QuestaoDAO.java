
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Exatas;
import modelo.Questao;

/**
 * Classe responsavel por realizar operacoes de acesso ao banco de dados
 * relacionadas a entidade Questao, especialmente voltada para questoes da area
 * de Exatas.
 * 
 * 
 * @see modelo.Questao
 * @see modelo.Exatas
 * @see modelo.Edital
 * @author Samuel
 */
public class QuestaoDAO {
    private Connection connection;

    /**
     * Cadastra uma nova questao da area de Exatas no banco de dados.
     * 
     * @param questao A questao a ser cadastrada.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public void CadastrarQuestao(Questao questao) throws ExceptionDAO {
        String sql = "INSERT INTO questao ( tipo, materia, enunciado, resposta) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, questao.getTipo());
            pStatement.setString(2, questao.getMateria());
            pStatement.setString(3, questao.getEnunciado());
            pStatement.setString(4, questao.getResposta());

            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar Questao: " + e.getMessage());
        }
    }

    /**
     * Lista todas as questoes da area de Exatas que possuam a materia (total ou
     * parcial) informada.
     * 
     * @param materia A materia das questoes a serem buscadas.
     * @return Uma lista contendo as questoes encontradas.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
        String sql = "SELECT * FROM questao WHERE materia LIKE ? ORDER BY materia";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, "%" + materia + "%");
            ResultSet rs = pStatement.executeQuery();

            ArrayList<Questao> questoes = new ArrayList<>();

            while (rs.next()) {
                Exatas exatas = new Exatas();

                exatas.setCodQuestao(rs.getInt("codQuestao"));
                exatas.setTipo(rs.getString("tipo"));
                exatas.setMateria(rs.getString("materia"));
                exatas.setEnunciado(rs.getString("enunciado"));
                exatas.setResposta(rs.getString("resposta"));

                questoes.add(exatas);

            }

            return questoes;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar o Questao: " + e.getMessage());
        }
    }

    /**
     * Altera os dados de uma questao da area de Exatas no banco de dados.
     * 
     * @param exatas A questao da area de Exatas com os novos dados a serem
     *               atualizados.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public void mudarQuestao(Exatas exatas) throws ExceptionDAO {
        String sql = "Update Questao set tipo = ?, materia = ?, enunciado = ?, resposta = ? where codQuestao= ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {

            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, exatas.getTipo());
            pStatement.setString(2, exatas.getMateria());
            pStatement.setString(3, exatas.getEnunciado());
            pStatement.setString(4, exatas.getResposta());
            pStatement.setInt(5, exatas.getCodQuestao());

            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar o Questao : " + e.getMessage());
        } finally {

            try {
                if (pStatement != null) {
                    pStatement.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o pStatement" + e);

            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão:" + e);

            }
        }

    }

    /**
     * Deleta uma questao da área de Exatas do banco de dados com base no seu codigo
     * de identificacao.
     * 
     * @param questao A questao a ser deletada.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public void deletarQuestao(Exatas questao) throws ExceptionDAO {
        String sql = "Delete from questao where codQuestao = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {

            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, questao.getCodQuestao());
            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar a Questao: " + e.getMessage());
        } finally {

            try {
                if (pStatement != null) {
                    pStatement.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o pStatement" + e);

            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão:" + e);

            }
        }

    }

}