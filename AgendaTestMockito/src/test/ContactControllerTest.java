package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import controller.impl.ContactController;
import model.Person;
import service.ContactService;

public class ContactControllerTest {
	ContactController contatoControler = new ContactController();
	ContactService contatoService = new ContactService();
//	@Test
//	public void addCorretamente() {
//		Pessoa pessoa = new Pessoa(1, "netaooo", 1235, 4568);
//		boolean reposta = contatoControler.addContact(pessoa);
//		assertTrue(reposta);
//	
//	}
	
	@Test
	public void addNumeroIgual() {
		Person pessoa = new Person(1, "neto", 123, 456);
		 contatoControler.addContact(pessoa);
		 
		 Person pessoa1 = new Person(11, "neto1", 123, 4256);
		 boolean reposta = contatoControler.addContact(pessoa1);
		assertFalse(reposta);
	
	}
	
	@Test
	public void addComNull() {
		Person pessoa = new Person(0, "neto", 123, 456);
		boolean reposta = contatoControler.addContact(pessoa);
		assertFalse(reposta);
		
	}
	
	@Test
	public void addComNull2() {
		Person pessoa2 = new Person(1, null, 123, 456);
		boolean reposta2 = contatoControler.addContact(pessoa2);
		assertFalse(reposta2);
	}
	
	@Test
	public void addComNull3() {
		Person pessoa3 = new Person(1, "Neto", 0, 456);
		boolean reposta3 = contatoControler.addContact(pessoa3);
		assertFalse(reposta3);
		
	}
	@Test
	public void addComNull4() {
		Person pessoa4 = new Person(1, "Neto", 123, 0);
		boolean reposta4 = contatoControler.addContact(pessoa4);
		assertFalse(reposta4);
		
	}
	
	@Test
	public void ListCorretamente() {
		Person pessoa = new Person(12, "neto2", 1232, 4562);
		 contatoControler.addContact(pessoa);
		Person pessoa1 = new Person(1, "neto", 123, 456);
		 contatoControler.addContact(pessoa1);
		 boolean lista = contatoControler.getSizeList().isEmpty();
		 assertFalse(lista);
		
	}
	
	@Test
	public void ListErrada() {
		Person pessoa = new Person(12, "neto2", 1232, 4562);
		 contatoControler.addContact(pessoa);
		Person pessoa1 = new Person(1, "neto", 123, 456);
		 contatoControler.addContact(pessoa1);
		 List<Person> lista = contatoControler.getSizeList();
		 assertNotEquals(2, lista.size());
		
	}
	
	
}
