package view;

import controller.impl.ContatoController;
import model.Pessoa;

public class Povoar {
	public static void main(String[] args){
		ContatoController contatoControler = new ContatoController();
		for(int i =18001; i< 18500; i++) {
			Pessoa pessoa = new Pessoa(i, "pessoa" +i, i, i+1);
			contatoControler.adicionarContato(pessoa);
		}
	}
}
