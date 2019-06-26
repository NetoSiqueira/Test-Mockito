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

			System.out.println("Conex�o realizada com sucesso.");
			return DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			System.out.println(
					"Problemas na conex�o. Verifique a digita��o dos nomes e a exist�ncia da fonte de dados. \n Recompile e execute novamente.");
			throw new RuntimeException(e);

		}
	}
}
