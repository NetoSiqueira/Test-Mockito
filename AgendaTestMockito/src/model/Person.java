package model;

public class Person {
private int nivelDeAmizade = 0 ;	
private String nome;
private long numero = 0;
private float conta= 0;



public Person(int nivelDeAmizade, String nome, long numero, float conta) {
	this.nivelDeAmizade = nivelDeAmizade;
	this.nome = nome;
	this.numero = numero;
	this.conta = conta;
}

public Person() {
	// TODO Auto-generated constructor stub
}

public int getNivelDeAmizade() {
	return nivelDeAmizade;
}
public void setNivelDeAmizade(int nivelDeAmizade) {
	this.nivelDeAmizade = nivelDeAmizade;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getNumero() {
	return numero;
}
public void setNumero(long numero) {
	this.numero = numero;
}
public float getConta() {
	return conta;
}
public void setConta(float conta) {
	this.conta = conta;
}


}
