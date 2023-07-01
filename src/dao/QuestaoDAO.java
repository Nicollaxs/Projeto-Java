package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Edital;
import modelo.Exatas;
import modelo.Questao;

public class QuestaoDAO {
    private Connection connection;

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