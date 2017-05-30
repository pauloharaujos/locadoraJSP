package model.application.acervo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Hibernate.ConexaoSessionFactory;
import static model.application.acervo.AplCadastrarAtor.SUCESSO;
import model.domain.acervo.Ator;
import model.domain.acervo.Diretor;

public class AplCadastrarDiretor {
	
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;
	
	public static int inserirDiretor(Session s, String nome){
		
            Diretor d = null;
            d = new Diretor(nome);
            s.save(d);
            return SUCESSO;
	}     
        
        public static int excluirDiretor(Session s, Diretor diretor){	                     
             s.delete(diretor);		  
             return SUCESSO;
	}
        
        public static int alterarDiretor(Session s, Diretor diretor){
            s.update(diretor);	
            return SUCESSO;		
	}
}
