package teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Pessoa;
import service.ContatoService;

public class ContatoServiceTeste {
	ContatoService contatoService = new ContatoService();

	@Test
	public void adicionarCorreto() {
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoService.adicionarContato(pessoa);
		 assertEquals("Realizado com sucesso", contatoService.funciona);
	
	}
	
	@Test
	public void removerCorreto(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoService.adicionarContato(pessoa);
		contatoService.removerContato(pessoa);
		assertEquals("Removido com sucesso", contatoService.funciona);
		
	}
	
//	@Test
//	public void removerNull(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoService.adicionarContato(pessoa);
//		contatoService.removerContato(pessoa);
//	
//		contatoService.removerContato(pessoa);
//		assertNull(contatoService);
//		
//	}
	
//	@Test
//	public void ListarCorreto(){
//		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
//		contatoService.adicionarContato(pessoa);
//		
//		Pessoa pessoa2 = new Pessoa(12, "neto2", 1232, 4562);
//		contatoService.adicionarContato(pessoa2);
//		boolean lista = contatoService.listarContato();
//		assertFalse(condition);
//	
//		
//	}
	@Test
	public void ListarErrado(){
		Pessoa pessoa = new Pessoa(1, "neto", 123, 456);
		contatoService.adicionarContato(pessoa);
		
		Pessoa pessoa2 = new Pessoa(12, "neto2", 1232, 4562);
		contatoService.adicionarContato(pessoa2);
		List<Pessoa> lista = contatoService.listarContato();
		assertNotEquals(1, lista.size());
	
		
	}
}
