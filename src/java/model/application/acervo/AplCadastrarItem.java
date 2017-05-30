package model.application.acervo;

import org.hibernate.Session;
import model.domain.acervo.Item;
import model.domain.acervo.Titulo;

public class AplCadastrarItem {
	
    public static int SUCESSO = 1;
    public static int ERRO_VALIDACAO_DADOS = 0;

    public static int inserirItem(Session s, int numSerie, String dtAquisicao, String tipoItem, Titulo titulo){
		
       Item i = null;
				
       if (numSerie == 0) {
            return ERRO_VALIDACAO_DADOS;			
       }		
       i = new Item(numSerie, dtAquisicao, tipoItem, titulo);
       s.save(i);
       return SUCESSO;		
    }
        
    public static int excluirItem(Session s, Item item){		
	s.delete(item);
	return SUCESSO;		
    }
    
    public static int alterarItem(Session s, Item item){		
	s.update(item);
	return SUCESSO;		
    }
}
