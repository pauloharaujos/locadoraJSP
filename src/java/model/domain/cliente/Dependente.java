package model.domain.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idDependente")
public class Dependente extends Cliente{
	
	@ManyToOne
	private Socio socio;

	public Dependente(String nome, int numIncricao, String dtNascimento, String sexo, int estahAtivo, Socio socio) {
		super(nome, numIncricao, dtNascimento, sexo, estahAtivo);
		this.socio = socio;
	}
	
	public Dependente(){
		
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
