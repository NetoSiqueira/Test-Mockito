package controller.impl;

import java.util.ArrayList;
import java.util.List;

import model.Person;
import service.ContactService;

public class ContactController{
	ContactService contatoService = new ContactService();	
	ArrayList<Person> pessoaRepository = new ArrayList<Person>();
	


	public boolean addContact(Person pessoa) {
		try {
		if(pessoa.getConta() == 0 || pessoa.getNome() ==null || pessoa.getNumero() == 0 || pessoa.getNivelDeAmizade() ==0){
			 return false;
			
		}else{
			for (Person pessoa1 : contatoService.listContact()) {
				if(pessoa.getNumero() == pessoa1.getNumero()){
					return false;
				}
			}
			contatoService.addContact(pessoa);	
		}
		
	} catch (Exception e) {
		return false;
	}
		 return true;
	}


	public boolean removeContact(long numero) {
		try {
			
		for (Person pessoa : contatoService.listContact()) {
			if(pessoa.getNumero() == numero){
				contatoService.removeContact(pessoa);
				return true;
			}
			}
		return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	public List<Person> getSizeList(){
		return contatoService.listContact();
	}
	
	public void listContact() {
		List<Person> lista = new ArrayList<>();
		lista = contatoService.listContact();
		for (Person pessoa : lista) {
			System.out.println("Nome: "+pessoa.getNome());
			System.out.println("Numero: "+pessoa.getNumero());
			System.out.println("Conta: "+pessoa.getConta());
			System.out.println("Nivel de amizade: "+pessoa.getNivelDeAmizade());
			System.out.println("--------------------------------------------");
		}
		
	}

	public boolean editContact(Person pessoa) {
		
		return contatoService.editContact(pessoa);
	}
	
	

}
