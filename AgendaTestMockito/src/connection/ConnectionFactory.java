package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	public Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/agendaVev";
		String usuario = "postgres";
		String senha = "postgres";
		try {

			Class.forName("org.postgresql.Driver");

			System.out.println("Conexão realizada com sucesso.");
			return DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			System.out.println(
					"Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \n Recompile e execute novamente.");
			throw new RuntimeException(e);

		}
	}
}
