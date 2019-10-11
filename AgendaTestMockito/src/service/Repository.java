package service;


import repository.ContactRepository;

public class Repository {
	private static ContactRepository pessoaRepository;
	
	public static synchronized ContactRepository getInstance(){
		pessoaRepository = new ContactRepository();
		return pessoaRepository;
		
	}
}
