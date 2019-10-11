package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import connection.ConnectionMock;
import model.Person;
import repository.RepositoryMock;

public class RepositoryMockTest {
	@Mock
	ConnectionMock conexaoMock = Mockito.mock(ConnectionMock.class);
	
	@Mock
	private Connection connection = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement preStatement = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet resultSet = Mockito.mock(ResultSet.class);
	
	@Mock
	private Statement statement = Mockito.mock(Statement.class);
	
	Person pessoa = new Person();
	
	
	@Before
	public void setUp() throws Exception {
		Mockito.when(conexaoMock.getConexao()).thenReturn(connection);		
		Mockito.when(preStatement.executeUpdate()).thenReturn(1);
		Mockito.doNothing().when(preStatement).close();
		
	}
	
	@Before
	public void setAdicionar() throws SQLException {
		Mockito.when(connection.prepareStatement(Mockito.startsWith("INSERT"))).thenReturn(preStatement);
	}
	
	@Before
	public void setRemover() throws SQLException {
		Mockito.when(connection.prepareStatement(Mockito.startsWith("DELETE"))).thenReturn(preStatement);
	}
	
	@Before
	public void setEditar() throws SQLException {
		Mockito.when(connection.prepareStatement(Mockito.startsWith("UPDATE"))).thenReturn(preStatement);
	}
	
	@Before
	public void ListPessoa() throws SQLException {
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(Mockito.any(String.class))).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true, false);
	}
	
	
	@Before
	public void getPessoa() throws SQLException {
		Mockito.when(resultSet.getInt("nivelDeAmizade")).thenReturn(69);
		Mockito.when(resultSet.getString("nome")).thenReturn("Pessoa Mockado");
		Mockito.when(resultSet.getFloat("conta")).thenReturn(69.69F);
		Mockito.when(resultSet.getLong("numero")).thenReturn(69888L);
		
	}
	
	@Test
	public void cadastrarContatoExecutado() throws Exception {
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		repositoryMock.adicionarContato("Netao", 456, 1, 123);
		Mockito.verify(preStatement, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void cadastrarContato() throws Exception {
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		boolean resultado = repositoryMock.adicionarContato("Netao", 456, 1, 123);
		assertTrue(resultado);
	}
	
	@Test
	public void getContato() {
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		boolean resultado = repositoryMock.getContato().isEmpty(); 
		assertFalse(resultado);		
	}
	
	
	@Test
	public void editarContato() {
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		boolean resultado = repositoryMock.editar(123, "Netao", 456, 1);
		assertTrue(resultado);
	}
	
	@Test
	public void editarContatoExecutando() throws Exception{
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		 repositoryMock.editar(123, "Netao", 456, 1);
		 Mockito.verify(preStatement, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void removerContato() {
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		boolean resultado = repositoryMock.removerContato(123);
		assertTrue(resultado);
	}
	
	@Test
	public void removerContatoExecutando() throws Exception{
		RepositoryMock repositoryMock = RepositoryMock.getInstance();
		repositoryMock.setConexaoMock(conexaoMock);
		repositoryMock.removerContato(123);
		 Mockito.verify(preStatement, Mockito.times(1)).executeUpdate();
	}
	

}
