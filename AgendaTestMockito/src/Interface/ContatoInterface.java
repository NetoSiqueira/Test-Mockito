package Interface;

import java.util.List;

import model.Pessoa;

public interface ContatoInterface {

	public void adicionarContato(Pessoa pessoa);
	public void removerContato(Pessoa pessoa);
	public List<Pessoa> listarContato();
	public boolean editarContato(Pessoa pessoa);
}
