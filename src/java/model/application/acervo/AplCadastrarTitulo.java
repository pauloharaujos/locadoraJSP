package model.application.acervo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import model.domain.acervo.Titulo;

public class AplCadastrarTitulo {
            
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;

	public static int inserirTitulo(String nome, int ano, String sinopse, String categoria, Diretor diretor, Classe classe, List atores){
		
		Titulo t1 = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
		if ("".equals(nome)) {
                    return ERRO_VALIDACAO_DADOS;			
		}
		
		t1 = new Titulo(nome, ano, sinopse, categoria, diretor, classe, atores); 
				
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(t1);
		  t.commit(); 
		  return SUCESSO;
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
        return -1;
	}
        
        public static int excluirTitulo(Titulo titulo){
		                        
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
						
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();                 
		  s = sf.openSession();                  
		  t = s.getTransaction();
		  t.begin();
		  s.delete(titulo);
		  t.commit(); 
		  return SUCESSO;
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
            return -1;
	}
}
