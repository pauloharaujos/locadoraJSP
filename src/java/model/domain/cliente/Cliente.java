package model.domain.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "cliente")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente {
	
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	private String nome;
	private int numIncricao;
	private String dtNascimento;
	private String sexo;
	private int estahAtivo;	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)    
	private List<Locacao> locacoes;
	
	
	public Cliente(String nome, int numIncricao, String dtNascimento, String sexo, int estahAtivo) {
		
		this.nome = nome;
		this.numIncricao = numIncricao;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.estahAtivo = estahAtivo;
		this.locacoes = new ArrayList();
	}
	
	public Cliente(){
		
	}
        
        public int getId(){
            return this.idCliente;
        }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumIncricao() {
		return numIncricao;
	}

	public void setNumIncricao(int numIncricao) {
		this.numIncricao = numIncricao;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEstahAtivo() {
		return estahAtivo;
	}

	public void setEstahAtivo(int estahAtivo) {
		this.estahAtivo = estahAtivo;
	}
		
	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	public String toString(){
            return this.nome;
        }

}
