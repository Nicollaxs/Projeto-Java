package dao;

/**
 * Classe de excecao personalizada para o DAO (Data Access Object).
 * 
 * <p>
 * Essa classe representa uma excecao especifica que pode ser lancada pelos
 * objetos DAO
 * quando ocorrem erros relacionados ao acesso aos dados, como falhas na
 * comunicacao com o
 * banco de dados, problemas de autenticacao ou outras situacoes que impecam a
 * realizacao
 * das operacoes de acesso a dados.
 * 
 * <p>
 * A classe extende a classe Exception, que e a classe base para todas as
 * excecoes em Java,
 * permitindo que a excecao personalizada tenha uma mensagem de erro
 * customizada.
 * 
 * @version a
 * @since a
 * 
 * @see Exception
 * @see DAO
 * 
 * @author Samuel
 */
public class ExceptionDAO extends Exception {

    /**
     * Construtor da excecao.
     * 
     * <p>
     * Este construtor cria uma nova instancia da excecao com uma mensagem de erro
     * personalizada.
     * A mensagem informada sera acessivel atraves do metodo getMessage() da classe
     * Exception.
     * 
     * @param mensagem A mensagem de erro a ser associada com a excecao.
     */
    public ExceptionDAO(String mensagem) {
        super(mensagem);
    }

}
