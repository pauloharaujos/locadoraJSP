package servicos;

import Hibernate.ConexaoSessionFactory;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.application.cliente.AplEfetuarLocacao;
import model.domain.acervo.Item;
import model.domain.cliente.Cliente;
import model.domain.cliente.Locacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path ("/locacoes")
public class Locacoes {
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
        s.close();
        return gson.toJson(l);
    }
    
    @GET
    @Produces ("application/json")
    @Path ("/getItens")
    public String getItens(){
                     
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Item.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        s.close();
        return gson.toJson(l);
    }
    
    @GET
    @Produces ("application/json")
    @Path ("/getClientes")
    public String getClientes(){
                     
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        Criteria c  = s.createCriteria(Cliente.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List l = c.list();  
        s.close();
        return gson.toJson(l);
    }
    
    @POST    
    @Consumes ("application/json")
    @Path("/efetuarLocacao")
    public void efetuarLocacao(String content){
        Gson g = new Gson();
        Locacao l = (Locacao) g.fromJson(content, Locacao.class);    
        SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
        Session s = sf.openSession();
        AplEfetuarLocacao.inserirLocacao(s, l);
        s.close();
    }
}
