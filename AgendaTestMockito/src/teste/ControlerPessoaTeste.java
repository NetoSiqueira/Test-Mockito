package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import controller.impl.ContatoController;
import model.Pessoa;
import service.ContatoService;

public class ControlerPessoaTeste {
	ContatoController contatoControler = new ContatoController();
	ContatoService contatoService = new ContatoService();
//	@Test
//	public void addCorretamente() {
//		Pessoa pessoa = new Pessoa(1, "netaooo", 1235, 4568);
//		boolean reposta = contatoControler.adicionarContato(pessoa);
//		assertTrue(reposta);
//	
//	}
	
	@Test
	public void addNumeroIgual() {
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		 contatoControler.adicionarContato(pessoa);
		 
		 Pessoa pessoa1 = new Pessoa(11, "neto1", 123, 4256);
		 boolean reposta = contatoControler.adicionarContato(pessoa1);
		assertFalse(reposta);
	
	}
	
	@Test
	public void addComNull() {
		Pessoa pessoa = new Pessoa(0, "neto", 123, 456);
		boolean reposta = contatoControler.adicionarContato(pessoa);
		assertFalse(reposta);
		
	}
	
	@Test
	public void addComNull2() {
		Pessoa pessoa2 = new Pessoa(1, null, 123, 456);
		boolean reposta2 = contatoControler.adicionarContato(pessoa2);
		assertFalse(reposta2);
	}
	
	@Test
	public void addComNull3() {
		Pessoa pessoa3 = new Pessoa(1, "Neto", 0, 456);
		boolean reposta3 = contatoControler.adicionarContato(pessoa3);
		assertFalse(reposta3);
		
	}
	@Test
	public void addComNull4() {
		Pessoa pessoa4 = new Pessoa(1, "Neto", 123, 0);
		boolean reposta4 = contatoControler.adicionarContato(pessoa4);
		assertFalse(reposta4);
		
	}
	
	@Test
	public void ListCorretamente() {
		Pessoa pessoa = new Pessoa(12, "neto2", 1232, 4562);
		 contatoControler.adicionarContato(pessoa);
		Pessoa pessoa1 = new Pessoa(1, "neto", 123, 456);
		 contatoControler.adicionarContato(pessoa1);
		 boolean lista = contatoControler.getSizeList().isEmpty();
		 assertFalse(lista);
		
	}
	
	@Test
	public void ListErrada() {
		Pessoa pessoa = new Pessoa(12, "neto2", 1232, 4562);
		 contatoControler.adicionarContato(pessoa);
		Pessoa pessoa1 = new Pessoa(1, "neto", 123, 456);
		 contatoControler.adicionarContato(pessoa1);
		 List<Pessoa> lista = contatoControler.getSizeList();
		 assertNotEquals(2, lista.size());
		
	}
	
	@Test
	public void removerCorretamente() {
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		boolean reposta = contatoControler.removerContato(pessoa.getNumero());
		assertTrue(reposta);
	
	}
	
	@Test
	public void removerErrado() {
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		boolean reposta = contatoControler.removerContato(666);
		assertFalse(reposta);
	
	}
	
	@Test
	public void editarCorretamente(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		Pessoa pessoa2 = new Pessoa(2, "netao", 123, 567);
		boolean reposta = contatoControler.editarContato(pessoa2);
		assertTrue(reposta);
	}
	
//	@Test
//	public void editarErrado(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoControler.adicionarContato(pessoa);
//		Pessoa pessoa2 = new Pessoa(2, "netao", 1234, 567);
//		boolean reposta = contatoControler.editarContato(pessoa2);
//		assertFalse(reposta);
//	}
	@Test
	public void editarNull(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		Pessoa pessoa2 = new Pessoa(0, "netao", 1234, 567);
		boolean reposta = contatoControler.editarContato(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull2(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		Pessoa pessoa2 = new Pessoa(2, null, 1234, 567);
		boolean reposta = contatoControler.editarContato(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull3(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		Pessoa pessoa2 = new Pessoa(2, "netao", 0, 567);
		boolean reposta = contatoControler.editarContato(pessoa2);
		assertFalse(reposta);
	}
	@Test
	public void editarNull4(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoControler.adicionarContato(pessoa);
		Pessoa pessoa2 = new Pessoa(2, "netao", 1234, 0);
		boolean reposta = contatoControler.editarContato(pessoa2);
		assertFalse(reposta);
	}

}
