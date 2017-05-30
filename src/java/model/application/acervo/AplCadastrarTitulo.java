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

	public static int inserirTitulo(Session s, String nome, int ano, String sinopse, String categoria, Diretor diretor, Classe classe, List atores){
		
            Titulo t1;		
            t1 = new Titulo(nome, ano, sinopse, categoria, diretor, classe, atores); 
            s.save(t1);
            return SUCESSO;
	}
        
        public static int excluirTitulo(Session s, Titulo titulo){		                        
	    s.delete(titulo);
	    return SUCESSO;		
	}
        
        public static int alterarTitulo(Session s, Titulo titulo){
            s.update(titulo);
	    return SUCESSO;
	}
}
