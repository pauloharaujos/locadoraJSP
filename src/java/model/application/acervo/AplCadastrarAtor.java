package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory; 
import model.domain.acervo.Ator;

public class AplCadastrarAtor {

    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;
	
	public static int inserirAtor(Session s, String nome){
		                
            Ator a = null;		
		
            if ("".equals(nome)) {
                return ERRO_VALIDACAO_DADOS;			
            }
		
            a = new Ator(nome);		
		
            s.save(a);		 
            return SUCESSO;
		         
        }
               
        public static int excluirAtor(Session s, Ator ator){					
            s.delete(ator);
            return SUCESSO;				
	}
        
        public static int alterarAtor(Session s, Ator ator){
            s.update(ator);	
            return SUCESSO;		
	}
}
