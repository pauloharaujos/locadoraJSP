package model.application.cliente;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import model.domain.cliente.Socio;

public class AplCadastrarSocio {
	
	public static void inserirSocio(String nome, int inscricao, String dtNascimento, String sexo, int estahAtivo, String cpf, String endereco, String tel){
		
		Socio s1 = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
		if ("".equals(nome)) {
			//return ERRO_VALIDACAO_DADOS;			
		}
		
		s1 = new Socio(nome, inscricao, dtNascimento, sexo, estahAtivo, cpf, endereco, tel);
				
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(s1);
		  t.commit(); 
		  //return SUCESSO;
		}catch(HibernateException e){
			System.err.println("/*----------------------ERRO------------------*");
			System.err.println(e.getMessage());
			System.err.println(e.getMessage());
			System.err.println("*-----------------------*");
			System.err.println(e.toString());
			System.err.println("/*----------------------ERRO------------------*");
			
			if(t != null) {
				t.rollback();
			}
			
			//return EXCEPTION_BANCO_DADOS;
		}finally{
			if(s != null) {
				s.close();
			}
		}
	}
}
