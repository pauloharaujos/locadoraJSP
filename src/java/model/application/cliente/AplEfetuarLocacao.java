/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application.cliente;

import Hibernate.ConexaoSessionFactory;
import static model.application.cliente.AplCadastrarCliente.SUCESSO;
import model.domain.acervo.Diretor;
import model.domain.acervo.Item;
import model.domain.cliente.Cliente;
import model.domain.cliente.Locacao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author paulo
 */
public class AplEfetuarLocacao {
    
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;
	
	public static int inserirLocacao(String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva,
			int valorCobrado, int multaCobrada, Item item, Cliente cliente){
		
		Locacao l = null;
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
		
		
//		if ("".equals(nome)) {
//                    return ERRO_VALIDACAO_DADOS;			
//		}
		
		l = new Locacao(dtLocacao, dtDevolucaoPrevista, dtDevolucaoEfetiva, valorCobrado, multaCobrada, item, cliente);		
		
		try{
		  sf = ConexaoSessionFactory.getSessionFactory();
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.save(l);
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
        
        public static int cancelarLocacao(Locacao locacao){
		                        
		SessionFactory sf = null;
		Session s = null;
		Transaction t = null;
						
		try{
		 sf = ConexaoSessionFactory.getSessionFactory();                 
		  s = sf.openSession();	
		  t = s.getTransaction();
		  t.begin();
		  s.delete(locacao);
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
