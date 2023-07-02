package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsavel por fornecer a conexao com o banco de dados.
 * Essa classe utiliza o padrao de projeto Singleton para garantir
 * que apenas uma instancia da conexao seja criada durante a execucao
 * da aplicacao.
 * 
 * @author Samuel
 */
public class ConnectionMVC {

   /**
    * Obtem uma instancia da conexao com o banco de dados.
    * 
    * @return A instância da conexao.
    */
   public Connection getConnection() {
      Connection conn = null;

      try {
         // Carrega o driver JDBC do MySQL.
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

      try {
         // Estabelece a conexão com o banco de dados MySQL.
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc?useSSL=false", "root", "senha123");
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return conn;
   }
}
