package service;

import java.util.ArrayList;
import java.util.List;

import Interface.ContatoInterface;
import model.Pessoa;

public class ContatoService implements ContatoInterface{

	public String funciona;

	@Override
	public void adicionarContato(Pessoa pessoa) {
		
			Repository.getInstance().addContato(pessoa);
		
			this.funciona= "Realizado com sucesso";	
		
	}

	@Override
	public  void removerContato(Pessoa pessoa) {
		
			Repository.getInstance().deleteContato(pessoa);
			this.funciona= "Removido com sucesso";	
			}
		
		
	

	@Override
	public List<Pessoa> listarContato() {
		this.funciona= "Listado com sucesso";
		return Repository.getInstance().getListContatos();
	
	}

	@Override
	public boolean editarContato(Pessoa pessoa) {
		try {
			if(pessoa.getConta() == 0 || pessoa.getNome() ==null || pessoa.getNumero() == 0 || pessoa.getNivelDeAmizade() ==0){
			 return false;
				
		}else{
			Repository.getInstance().editar(pessoa.getNumero(), pessoa.getNome(), pessoa.getConta(), pessoa.getNivelDeAmizade());
			
			return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		
	}

	
}
