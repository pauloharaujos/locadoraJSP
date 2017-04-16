package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory; 
import model.domain.acervo.Ator;

public class AplCadastrarAtor {
	
	
	public static void inserirAtor(String nome){
		
		Ator a = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
		if ("".equals(nome)) {
			//return ERRO_VALIDACAO_DADOS;			
		}
		
		a = new Ator(nome);
		a.setNome(nome);
		
		try{
		 sf = ConexaoSessionFactory.getSessionFactory();
                  //sf = HibernateUtil.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(a);
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
