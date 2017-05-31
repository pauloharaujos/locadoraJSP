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
	
	public static int inserirLocacao(Session s, String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva,
			int valorCobrado, int multaCobrada, Item item, Cliente cliente){
		
            Locacao l = null;	
		
//		if ("".equals(nome)) {
//                    return ERRO_VALIDACAO_DADOS;			
//		}
		
            l = new Locacao(dtLocacao, dtDevolucaoPrevista, dtDevolucaoEfetiva, valorCobrado, multaCobrada, item, cliente);		
            s.save(l);
	    return SUCESSO;
		
	}  
        
        public static int cancelarLocacao(Session s, Locacao locacao){		                        
	    s.delete(locacao);	
	    return SUCESSO;
	}
        
        public static int alterarLocacao(Session s, Locacao locacao){		                        
	    s.update(locacao);	
	    return SUCESSO;
	}
}
