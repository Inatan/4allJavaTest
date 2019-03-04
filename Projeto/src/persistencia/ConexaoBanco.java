package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * essa classe é utilizada para a conexão com o banco de dados
 * @author Inatan
 */
public class ConexaoBanco {
    //Atributos estáticos com os dados do Banco de Dados
    private static final String URL = "jdbc:mysql://localhost:3306/prova4all";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    //Método que efetua a conexão com o MySQL
    public static Connection getConexao() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USUARIO, SENHA); // conexão
        } catch (SQLException se) {
            throw new SQLException("Erro ao conectar...! " + se.getMessage());
        }//fecha catch
        return c;
    }//fecha metodo
}//fecha classe
