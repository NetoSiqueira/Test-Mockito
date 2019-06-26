package controller.impl;

import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import service.ContatoService;

public class ContatoController{
	ContatoService contatoService = new ContatoService();	
	ArrayList<Pessoa> pessoaRepository = new ArrayList<Pessoa>();
	


	public boolean adicionarContato(Pessoa pessoa) {
		try {
		if(pessoa.getConta() == 0 || pessoa.getNome() ==null || pessoa.getNumero() == 0 || pessoa.getNivelDeAmizade() ==0){
			 return false;
			
		}else{
			for (Pessoa pessoa1 : contatoService.listarContato()) {
				if(pessoa.getNumero() == pessoa1.getNumero()){
					return false;
				}
			}
			contatoService.adicionarContato(pessoa);	
		}
		
	} catch (Exception e) {
		return false;
	}
		 return true;
	}


	public boolean removerContato(long numero) {
		try {
			
		for (Pessoa pessoa : contatoService.listarContato()) {
			if(pessoa.getNumero() == numero){
				contatoService.removerContato(pessoa);
				return true;
			}
			}
		return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	public List<Pessoa> getSizeList(){
		return contatoService.listarContato();
	}
	
	public void listarContato() {
		List<Pessoa> lista = new ArrayList<>();
		lista = contatoService.listarContato();
		for (Pessoa pessoa : lista) {
			System.out.println("Nome: "+pessoa.getNome());
			System.out.println("Numero: "+pessoa.getNumero());
			System.out.println("Conta: "+pessoa.getConta());
			System.out.println("Nivel de amizade: "+pessoa.getNivelDeAmizade());
			System.out.println("--------------------------------------------");
		}
		
	}

	public boolean editarContato(Pessoa pessoa) {
		
		return contatoService.editarContato(pessoa);
	}
	
	

}
