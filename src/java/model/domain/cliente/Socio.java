package model.domain.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="numInscricao")
public class Socio extends Cliente{

	private String cpf;
	private String endereco;
	private String tel;
	
	public Socio(String nome, String dtNascimento, String sexo, int estahAtivo, String cpf, String endereco, String tel) {
		super(nome, dtNascimento, sexo, estahAtivo);
		this.cpf = cpf;
		this.endereco = endereco;
		this.tel = tel;
	}
	
	public Socio(){
		
	}        

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
