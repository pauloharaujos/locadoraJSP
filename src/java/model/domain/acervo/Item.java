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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import model.domain.cliente.Locacao;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int idItem;
	private int numSerie;
	private String dtAquisicao;
	private String tipoItem;
	
	@ManyToOne 
        @JoinColumn(name = "idTitulo", nullable = false, updatable = true)
	private Titulo titulo;
	
	@OneToMany(fetch = FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<Locacao> locacoes;
	
	public Item(int numSerie, String dtAquisicao, String tipoItem, Titulo titulo) {
		
		this.numSerie = numSerie;
		this.dtAquisicao = dtAquisicao;
		this.tipoItem = tipoItem;
		this.titulo = titulo;
		this.setLocacoes(new ArrayList());
	}
	
	public Item(){
		
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public String getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(String dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	
}
