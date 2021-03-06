package model.domain.acervo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ator")
public class Ator {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAtor;
    private String nome;      
	
	public Ator(String nome) {		
		this.nome = nome;		
	}
	
	public Ator(){
		
	}
        
        public int getId(){
            return this.idAtor;
        }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
        public String toString(){
            return this.nome;
        }
}