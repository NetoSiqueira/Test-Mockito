package people;

import controller.impl.ContactController;
import model.Person;

public class People {
	public static void main(String[] args){
		ContactController contatoControler = new ContactController();
		for(int i =18601; i< 18900; i++) {
			Person pessoa = new Person(i, "pessoa" +i, i, i+1);
			contatoControler.addContact(pessoa);
		}
	}
}
