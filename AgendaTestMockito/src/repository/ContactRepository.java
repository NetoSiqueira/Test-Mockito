package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Person;



public class ContactRepository {
	// a conex com o banco de dados
	private Connection connection;

	public ContactRepository() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Boolean addContato(Person contato) {
		String sql = "INSERT INTO Pessoa(nivelDeAmizade ,nome, numero, conta) VALUES (?, ?, ?, ?)";

		try {
			// prepared statement para inserir
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, contato.getNivelDeAmizade());
			stmt.setString(2, contato.getNome());
			stmt.setLong(3, contato.getNumero());
			stmt.setFloat(4, contato.getConta());

			// executa
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public Boolean deleteContato(Person contato) {
		String sql = "DELETE FROM Pessoa WHERE numero = ?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setFloat(1, contato.getNumero());

			// executa
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public ArrayList<Person> getListContatos() {
		String sql = "SELECT * FROM Pessoa;";
		ArrayList<Person> listaContato = new ArrayList<Person>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nivelDeAmizade = Integer.parseInt(rs.getString("nivelDeAmizade"));
				String nome = rs.getString("nome");
				long numero = Long.parseLong(rs.getString("numero"));
				float conta = Float.parseFloat(rs.getString("conta"));

				Person contato = new Person(nivelDeAmizade, nome, numero, conta);
				

				listaContato.add(contato);
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return listaContato;
	}

	public Person getPessoa(long numero) {
		String sql = "SELECT * FROM Pessoa WHERE numero = ?;";

		Person contato = new Person();
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, numero);

			// executa
			// stmt.execute();

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				contato.setNumero(numero);
				contato.setConta(Float.parseFloat(rs.getString("conta")));
				contato.setNome(rs.getString("nome"));
				contato.setNivelDeAmizade(Integer.parseInt(rs.getString("nivelDeAmizade")));
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return contato;
	}
	
	
	public boolean editar(long numero, String nome, float conta, int nivelDeAmizade) {
		String comandoSQL = "UPDATE pessoa SET nome = ?, conta = ?, nivelDeAmizade = ? WHERE numero = ?";
		try {
			PreparedStatement preparedStatemet = connection.prepareStatement(comandoSQL);
			preparedStatemet.setString(1, nome);
			preparedStatemet.setFloat(2,conta);
			preparedStatemet.setInt(3, nivelDeAmizade);
			preparedStatemet.setLong(4, numero);
			int quantidade  = preparedStatemet.executeUpdate();
			preparedStatemet.close();
			connection.close();
			if(quantidade > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
