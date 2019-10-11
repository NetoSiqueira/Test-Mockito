package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionMock;
import model.Person;



public class RepositoryMock {
	private ArrayList<Person> pessoas; 
	private static RepositoryMock repositoryMock = new RepositoryMock();
	private ConnectionMock conexaoMock;
	
	private RepositoryMock() {
		pessoas = new ArrayList<Person>();
	}
	
	public static RepositoryMock getInstance() {
		return repositoryMock;
	}
	
	public void setConexaoMock(ConnectionMock conexaoMock) {
		this.conexaoMock = conexaoMock;
	}
	
	public boolean adicionarContato(String nome, float conta, int nivelDeAmizade, long numero) {
		String comandoSQL = "INSERT INTO pessoa(nome, conta, nivelDeAmizade, numero) VALUES (?, ?, ?,?);";
		try {
			Connection connection = conexaoMock.getConexao();
			PreparedStatement preparedStatemet = connection.prepareStatement(comandoSQL);
			preparedStatemet.setString(1, nome);
			preparedStatemet.setFloat(2,conta);
			preparedStatemet.setInt(3, nivelDeAmizade);
			preparedStatemet.setLong(4, numero);
			
			int quantidade  = preparedStatemet.executeUpdate();
			preparedStatemet.close();
			if(quantidade>0) 
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexaoMock.getConexao().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Person> getContato(){
		String comandoSQL = "SELECT * FROM pessoa";
		try {
			Connection connection = conexaoMock.getConexao();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(comandoSQL);
			while(rs.next()) {
				Person contato = new Person();
				contato.setNumero(rs.getLong("numero"));
				contato.setConta(rs.getFloat("conta"));
				contato.setNome(rs.getString("nome"));
				contato.setNivelDeAmizade(rs.getInt("nivelDeAmizade"));
				this.pessoas.add(contato);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.pessoas;
	}
	
	public boolean editar(long numero, String nome, float conta, int nivelDeAmizade) {
		String comandoSQL = "UPDATE pessoa SET nome = ?, conta = ?, nivelDeAmizade = ? WHERE numero = ?";
		try {
			Connection connection = conexaoMock.getConexao();
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
	
	public boolean removerContato(long numero) {
		String comandoSQL = "DELETE FROM pessoa WHERE numero = ?";
		try {
			Connection connection = conexaoMock.getConexao();
			PreparedStatement preparedStatemet = connection.prepareStatement(comandoSQL);
			preparedStatemet.setLong(1, numero);
			int quantidade = preparedStatemet.executeUpdate();
			if(quantidade > 0) {
				return true;
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
