package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import static model.application.acervo.AplCadastrarDiretor.SUCESSO;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;


public class AplCadastrarClasse {
    
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;

    public static int inserirClasse(Session s, String nome, int valor, String data){
		
	Classe c = null;
		
	if ("".equals(nome)) {
            return ERRO_VALIDACAO_DADOS;			
        }		
	c = new Classe(nome, valor, data);
	s.save(c);
	return SUCESSO;	
    }
    
    public static int excluirClasse(Session s, Classe classe){		                        
	s.delete(classe);
	return SUCESSO;		
    }
    
    public static int alterarClasse(Session s, Classe classe){
		                        
	s.update(classe);
	return SUCESSO;		
    }
}
