package service;

import java.util.ArrayList;
import java.util.List;

import Interface.ContactInterface;
import model.Person;

public class ContactService implements ContactInterface{

	public String funciona;

	@Override
	public void addContact(Person pessoa) {
		
			Repository.getInstance().addContato(pessoa);
		
			this.funciona= "Realizado com sucesso";	
		
	}

	@Override
	public  void removeContact(Person pessoa) {
		
			Repository.getInstance().deleteContato(pessoa);
			this.funciona= "Removido com sucesso";	
			}
		
		
	

	@Override
	public List<Person> listContact() {
		this.funciona= "Listado com sucesso";
		return Repository.getInstance().getListContatos();
	
	}

	@Override
	public boolean editContact(Person pessoa) {
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
