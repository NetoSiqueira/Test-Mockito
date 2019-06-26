package service;


import repository.ContatoRepository;

public class Repository {
	private static ContatoRepository pessoaRepository;
	
	public static synchronized ContatoRepository getInstance(){
		pessoaRepository = new ContatoRepository();
		return pessoaRepository;
		
	}
}
