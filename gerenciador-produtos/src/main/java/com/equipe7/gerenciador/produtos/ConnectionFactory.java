package produtos;

/**
 *
 * @author mvdo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionFactory {
     
    public static Connection createConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/produtobd"; //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = ""; //senha do MySQL
         
        Connection conexao;
        conexao = DriverManager.getConnection(url, user, password);
         
        return conexao;
    }
}