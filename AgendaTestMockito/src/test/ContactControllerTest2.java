package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.impl.ContactController;
import model.Person;
import service.ContactService;

public class ContactControllerTest2 {
	ContactController contatoControler = new ContactController();
	ContactService contatoService = new ContactService();
	@Test
	public void removerCorretamente() {
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		boolean reposta = contatoControler.removeContact(pessoa.getNumero());
		assertTrue(reposta);
	
	}
	
	@Test
	public void removerErrado() {
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		boolean reposta = contatoControler.removeContact(666);
		assertFalse(reposta);
	
	}
	
	@Test
	public void editarCorretamente(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		Person pessoa2 = new Person(2, "netao", 123, 567);
		boolean reposta = contatoControler.editContact(pessoa2);
		assertTrue(reposta);
	}
	
//	@Test
//	public void editarErrado(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoControler.addContact(pessoa);
//		Pessoa pessoa2 = new Pessoa(2, "netao", 1234, 567);
//		boolean reposta = contatoControler.editContact(pessoa2);
//		assertFalse(reposta);
//	}
	@Test
	public void editarNull(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		Person pessoa2 = new Person(0, "netao", 1234, 567);
		boolean reposta = contatoControler.editContact(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull2(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		Person pessoa2 = new Person(2, null, 1234, 567);
		boolean reposta = contatoControler.editContact(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull3(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		Person pessoa2 = new Person(2, "netao", 0, 567);
		boolean reposta = contatoControler.editContact(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull4(){
		Person pessoa = new Person(1, "neto", 123, 456);
		contatoControler.addContact(pessoa);
		Person pessoa2 = new Person(2, "netao", 1234, 0);
		boolean reposta = contatoControler.editContact(pessoa2);
		assertFalse(reposta);
	}


}
