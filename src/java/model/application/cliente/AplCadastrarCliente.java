package model.application.cliente;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import model.domain.cliente.Cliente;
import model.domain.cliente.Dependente;
import model.domain.cliente.Socio;


public class AplCadastrarCliente {
	
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;
    
    public static int inserirDependente(Session s,  String nome, String dtNascimento, String sexo, int estahAtivo, Socio socio){
		
	Dependente d1 = null;
	
	if ("".equals(nome)) {
            return ERRO_VALIDACAO_DADOS;			
        }
	d1 = new Dependente(nome, dtNascimento, sexo, estahAtivo, socio);
	s.save(d1);
	return SUCESSO;	
    }
    
    public static int inserirSocio(Session s, String nome, String dtNascimento, String sexo, int estahAtivo, String cpf, String endereco, String tel){
		
	Socio s1 = null;
		
	if ("".equals(nome)) {
            return ERRO_VALIDACAO_DADOS;			
	}
	s1 = new Socio(nome, dtNascimento, sexo, estahAtivo, cpf, endereco, tel);
	s.save(s1);
	return SUCESSO;		
    }
        
    public static int excluirCliente(Session s, Cliente cliente){		                        
	s.delete(cliente);
	return SUCESSO;		
    } 
    
    public static int alterarCliente(Session s, Cliente cliente){		                        
	s.update(cliente);
	return SUCESSO;		
    } 

}
