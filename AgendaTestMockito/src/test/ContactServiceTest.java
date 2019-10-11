package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Person;
import service.ContactService;

public class ContactServiceTest {
	ContactService contatoService = new ContactService();

	@Test
	public void adicionarCorreto() {
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoService.addContact(pessoa);
		 assertEquals("Realizado com sucesso", contatoService.funciona);
	
	}
	
	@Test
	public void removerCorreto(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoService.addContact(pessoa);
		contatoService.removeContact(pessoa);
		assertEquals("Removido com sucesso", contatoService.funciona);
		
	}
	
//	@Test
//	public void removerNull(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoService.addContact(pessoa);
//		contatoService.removerContato(pessoa);
//	
//		contatoService.removerContato(pessoa);
//		assertNull(contatoService);
//		
//	}
	
//	@Test
//	public void ListarCorreto(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoService.addContact(pessoa);
//		
//		Pessoa pessoa2 = new Pessoa(12, "neto2", 1232, 4562);
//		contatoService.addContact(pessoa2);
//		boolean lista = contatoService.listarContato();
//		assertFalse(condition);
//	
//		
//	}
	@Test
	public void ListarErrado(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoService.addContact(pessoa);
		
		Person pessoa2 = new Person(12, "neto2", 1232, 4562);
		contatoService.addContact(pessoa2);
		List<Person> lista = contatoService.listContact();
		assertNotEquals(1, lista.size());
	
		
	}
}
