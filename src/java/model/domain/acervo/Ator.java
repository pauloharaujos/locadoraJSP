package model.domain.acervo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ator {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;	
	
	public Ator(String nome) {		
		this.nome = nome;		
	}
	
	public Ator(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
