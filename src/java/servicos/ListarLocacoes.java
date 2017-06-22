package servicos;

import Hibernate.ConexaoSessionFactory;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.domain.acervo.Item;
import model.domain.cliente.Cliente;
import model.domain.cliente.Locacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path ("/locacoes")
public class ListarLocacoes {
    private Gson gson = new Gson();
    
    @GET
    @Produces ("application/json")
    @Path ("/getLocacoes")
    public String getLocacoes(){
                    
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Locacao.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        return gson.toJson(l);
    }
    
    @GET
    @Produces ("application/json")
    @Path ("/getLocacoes")
    public String getItens(){
                     
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Item.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        return gson.toJson(l);
    }
    
    @GET
    @Produces ("application/json")
    @Path ("/getLocacoes")
    public String getClientes(){
                     
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Cliente.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        return gson.toJson(l);
    }
}
