package model.domain.acervo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "titulo")
public class Titulo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int idTitulo;
	private String nome;
	private int ano;
	private String sinopse;
	private String categoria;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ator> atores;	
	
	@ManyToOne 
    @JoinColumn(name = "idDiretor", nullable = false, updatable = true)
	private Diretor diretor;
	
	@ManyToOne 
    @JoinColumn(name = "idClasse", nullable = false, updatable = true)
	private Classe classe;
	
	public Titulo(String nome, int ano, String sinopse, String categoria, Diretor diretor, Classe classe, List atores) {
	
		this.nome = nome;
		this.ano = ano;
		this.sinopse = sinopse;
		this.categoria = categoria;
		this.diretor = diretor;
		this.classe = classe;
		this.atores = atores;
	}
        
        public int getId(){
            return this.idTitulo;
        }

	public Titulo(){
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(ArrayList<Ator> atores) {
		this.atores = atores;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
        public String toString(){
            return this.nome;
        }
	
}
