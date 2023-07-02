package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Edital;

/**
 * Classe responsavel por realizar operacoes de acesso ao banco de dados
 * relacionadas a entidade Edital.
 * 
 * @see modelo.Edital
 * @author Samuel
 */
public class EditalDAO {
    private Connection connection;

    /**
     * Cadastra um novo Edital no banco de dados.
     * 
     * @param edital O objeto Edital a ser cadastrado.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public void CadastrarEdital(Edital edital) throws ExceptionDAO {
        String sql = "INSERT INTO edital (nome, dataInicio, dataTermino, local, salario, qtdVagas) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, edital.getNome());
            pStatement.setString(2, edital.getDataInicio());
            pStatement.setString(3, edital.getDataTermino());
            pStatement.setString(4, edital.getLocalidade());
            pStatement.setFloat(5, edital.getSalario());
            pStatement.setInt(6, edital.getQtdVagas());
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar Edital: " + e.getMessage());
        }
    }

    /**
     * Lista todos os Editais que possuam o nome (total ou parcial) informado.
     * 
     * @param nome O nome do Edital a ser buscado.
     * @return Uma lista contendo os Editais encontrados.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
        String sql = "SELECT * FROM edital WHERE nome LIKE ? ORDER BY nome";

        try (Connection connection = new ConnectionMVC().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, "%" + nome + "%");
            ResultSet rs = pStatement.executeQuery();

            ArrayList<Edital> editais = new ArrayList<>();

            while (rs.next()) {
                Edital edital = new Edital();
                edital.setCodEdital(rs.getInt("codEdital"));
                edital.setNome(rs.getString("nome"));
                edital.setDataInicio(rs.getString("dataInicio"));
                edital.setDataTermino(rs.getString("dataTermino"));
                edital.setLocalidade(rs.getString("local"));
                edital.setSalario(rs.getFloat("salario"));
                edital.setQtdVagas(rs.getInt("qtdVagas"));
                editais.add(edital);
            }

            return editais;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar o Edital: " + e.getMessage());
        }
    }

    /**
     * Altera os dados de um Edital no banco de dados.
     * 
     * @param edital O objeto Edital com os novos dados a serem atualizados.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */
    public void mudarEdital(Edital edital) throws ExceptionDAO {
        String sql = "Update Edital set nome = ?, dataInicio = ?, dataTermino = ?, local = ?, salario = ?, qtdVagas = ? where codEdital= ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {

            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, edital.getNome());
            pStatement.setString(2, edital.getDataInicio());
            pStatement.setString(3, edital.getDataTermino());
            pStatement.setString(4, edital.getLocalidade());
            pStatement.setFloat(5, edital.getSalario());
            pStatement.setInt(6, edital.getQtdVagas());
            pStatement.setInt(7, edital.getCodEdital());

            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar o Edital: " + e.getMessage());
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
     * Deleta um Edital do banco de dados com base no seu codigo de identificacao.
     * 
     * @param edital O objeto Edital a ser deletado.
     * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
     */

    public void deletarEdital(Edital edital) throws ExceptionDAO {
        String sql = "Delete from Edital where codEdital = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {

            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, edital.getCodEdital());
            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deleltar o Edital: " + e.getMessage());
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