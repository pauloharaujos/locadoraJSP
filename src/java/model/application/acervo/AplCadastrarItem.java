package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import model.domain.acervo.Ator;
import model.domain.acervo.Item;
import model.domain.acervo.Titulo;

public class AplCadastrarItem {
	

	public static void inserirItem(int numSerie, String dtAquisicao, String tipoItem, Titulo titulo){
		
		Item i = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
		if (numSerie == 0) {
			//return ERRO_VALIDACAO_DADOS;			
		}
		
		i = new Item(numSerie, dtAquisicao, tipoItem, titulo);
				
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(i);
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
