package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMock {
	private final String url = "jdbc:postgresql://localhost:5432/pessoa";
    private final String usuario = "usuario";
    private final String senha = "senha";
    
    private Connection conexaoMock;
     
   public ConexaoMock() throws SQLException {
        this.conexaoMock = DriverManager.getConnection(url, usuario, senha);
    }
    
    public Connection getConexao() {
    	return this.conexaoMock;
    }
}
