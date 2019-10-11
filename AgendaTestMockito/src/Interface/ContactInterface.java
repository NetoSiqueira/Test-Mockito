package Interface;

import java.util.List;

import model.Person;

public interface ContactInterface {

	public void addContact(Person pessoa);
	public void removeContact(Person pessoa);
	public List<Person> listContact();
	public boolean editContact(Person pessoa);
}
