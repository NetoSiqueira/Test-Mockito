package view;

import java.util.Scanner;

import controller.impl.ContatoController;
import model.Pessoa;

public class App {
	 Scanner navegar = new Scanner(System.in); 
	 ContatoController contatoControler = new ContatoController();

	 public void app(){
	 	while(true){
	 		System.out.println("Digite 1: Para adicionar uma pessoa na lista:");
	 		System.out.println("Digite 2: Para listar:");
	 		System.out.println("Digite 3: Para excluir");
	 		System.out.println("Digite 4: Para editar");
	 		int menu = navegar.nextInt();

	 		switch (menu) {

	 			case 1:
	 				System.out.println("Digite seu nome:");
	 				String nome = navegar.next();
	 				System.out.println("Digite seu numero:");
	 				long numero = navegar.nextInt();
	 				System.out.println("Digite sua conta");
	 				float conta = navegar.nextFloat();
	 				System.out.println("Digite seu nivel de amizade");
	 				int nivel = navegar.nextInt();
	 				if(conta ==0 || numero== 0 || nome == null || nivel ==0 ){
	 					System.out.println("Algum valor e invalido. O 0 em valores fora o nome são considerados invalido e sem a adição de nome o nome se torna invalido");
	 				}else{
	 					Pessoa pessoa = new Pessoa(nivel, nome, numero, conta);
	 					contatoControler.adicionarContato(pessoa);
	 					}

	 				
	 			break;

	 			case 2:

	 			contatoControler.listarContato();

	 				break;
	 
	 				case 3:

	 				System.out.println("Digite seu numero:");
		 			long numero1 = navegar.nextInt();
		 			contatoControler.removerContato(numero1);

	 				break;

	 			case 4:
	 				System.out.println("Digite seu numero:");
		 			long numero2 = navegar.nextInt();		
		 			System.out.println("Digite seu nome:");
	 				String nome2 = navegar.next();
	 				System.out.println("Digite sua conta");
	 				float conta2 = navegar.nextFloat();
	 				System.out.println("Digite seu nivel de amizade");
	 				int nivel2 = navegar.nextInt();
	 				Pessoa pessoa = new Pessoa(nivel2, nome2, numero2, conta2);	
	 				contatoControler.editarContato(pessoa);
	 				break;
	 				default:
	 					System.out.println("Essa navegação não existe");
	 					break;
	 	}
	 }
}
}
