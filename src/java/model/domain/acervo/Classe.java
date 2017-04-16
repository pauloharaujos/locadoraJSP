package model.domain.acervo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classe {
	
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int idClasse;
	private String nome;
	private int valor;
	private String prazoDevolucao;	
	
	public Classe(String nome, int valor, String prazoDevolucao) {
		
		this.nome = nome;
		this.valor = valor;
		this.prazoDevolucao = prazoDevolucao;
	}
	
	public Classe(){
		
	}
        
        public int getId(){
            return this.idClasse;
        }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getPrazoDevolucao() {
		return prazoDevolucao;
	}

	public void setPrazoDevolucao(String prazoDevolucao) {
		this.prazoDevolucao = prazoDevolucao;
	}
        
        public String toString(){
            return this.nome;
        }
	
}
