package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import model.domain.acervo.Diretor;

public class AplCadastrarDiretor {
	
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;
	
	public static int inserirDiretor(String nome){
		
		Diretor d = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
		if ("".equals(nome)) {
                    return ERRO_VALIDACAO_DADOS;			
		}
		
		d = new Diretor(nome);
		d.setNome(nome);
		
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(d);
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
