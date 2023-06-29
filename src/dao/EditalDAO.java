package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import modelo.Edital;

public class EditalDAO {
    // String nome, String dataInicio, String dataTermino, String local, String
    // salario, String qtdVagas
    public void CadastrarEdital(Edital edital) throws ExceptionDAO {
        String sql = "INSERT INTO edital (nome, dataInicio, dataTermino, local, salario, qtdVagas) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, edital.getNome());
            pStatement.setDate(2, new Date(edital.getDataInicio().getTime()));
            pStatement.setDate(3, new Date(edital.getDataTermino().getTime()));
            pStatement.setString(4, edital.getLocalidade());
            pStatement.setString(5, edital.getSalario());
            pStatement.setString(6, edital.getQtdVagas());
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar Edital: " + e.getMessage());
        }
    }

    public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
        String sql = "SELECT * FROM edital WHERE nome LIKE ? ORDER BY nome";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, "%" + nome + "%");
            ResultSet rs = pStatement.executeQuery();

            ArrayList<Edital> editais = new ArrayList<>();

            while (rs.next()) {
                Edital edital = new Edital();
                edital.setNome(rs.getString("nome"));
                edital.setDataInicio(rs.getDate("dataInicio"));
                edital.setDataTermino(rs.getDate("dataTermino"));
                edital.setLocalidade(rs.getString("local"));
                edital.setSalario(rs.getString("salario"));
                edital.setQtdVagas(rs.getString("qtdVagas"));
                editais.add(edital);
            }

            return editais;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar o Edital: " + e.getMessage());
        }
    }
}
