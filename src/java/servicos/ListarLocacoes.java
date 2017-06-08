package servicos;

import Hibernate.ConexaoSessionFactory;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.domain.cliente.Locacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path ("/locacoes")
public class ListarLocacoes {
    
    @GET
    @Produces (MediaType.APPLICATION_XML)
    @Path ("/getLocacoes")
    public List <Locacao> getLocacoes(){
                             
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Locacao.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        return l;
    }
}
