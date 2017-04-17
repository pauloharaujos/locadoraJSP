package model.domain.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="numInscricao")
public class Dependente extends Cliente{
	
	@ManyToOne
	private Socio socio;

	public Dependente(String nome,  String dtNascimento, String sexo, int estahAtivo, Socio socio) {
		super(nome, dtNascimento, sexo, estahAtivo);
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
