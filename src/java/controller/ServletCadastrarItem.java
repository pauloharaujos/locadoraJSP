package controller;

import Hibernate.ConexaoSessionFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.acervo.AplCadastrarAtor;

import model.application.acervo.AplCadastrarItem;
import model.application.cliente.AplCadastrarCliente;
import model.domain.acervo.Ator;
import model.domain.acervo.Diretor;
import model.domain.acervo.Item;
import model.domain.acervo.Titulo;
import model.domain.cliente.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarItem
 */
@WebServlet("/ServletCadastrarItem")
public class ServletCadastrarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("operacao");
                Session s = (Session) request.getAttribute("sessaoBD");
                
                if(valor.equals("incluirItem")){
                    int varNumSerie = Integer.parseInt(request.getParameter("numSerie"));
                    int varIdTitulo = Integer.parseInt(request.getParameter("titulo"));
                    String varDtAq = request.getParameter("dtAq");
                    String varTipo= request.getParameter("tipo");
		    
                    Titulo titulo = null;                    
                    Criteria c  = s.createCriteria(Titulo.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Titulo t = (Titulo) i.next();
                        int id = t.getId();

                        if((id == varIdTitulo))
                            titulo = t;                   
                    }  

                   int r = AplCadastrarItem.inserirItem(s, varNumSerie, varDtAq, varTipo, titulo);
			
                    if(r == AplCadastrarAtor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("excluirItem")){
                    int varIdItem = Integer.parseInt(request.getParameter("id"));
                    
                    Item item = null;                  
                    Criteria c  = s.createCriteria(Item.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Item i1 = (Item) i.next();
                        int id = i1.getId();

                        if((id == varIdItem))
                            item = i1;                   
                    }    
                  
                    int r = AplCadastrarItem.excluirItem(s, item);
			
                    if(r == AplCadastrarItem.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
                } else if(valor.equals("alterarItem")){
                    
                    int varId = Integer.parseInt(request.getParameter("id"));
                    int varIdTitulo = Integer.parseInt(request.getParameter("titulo"));
                    String tipo = request.getParameter("tipo");
                    int serie = Integer.parseInt(request.getParameter("serie"));
                    String dtAq = request.getParameter("dtAq");
                    
                    Criteria c  = s.createCriteria(Item.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Item i1 = null;
                    while(i.hasNext()){
                        i1 = (Item) i.next();
                        int id = i1.getId();
                       
                        if(id  ==  varId){ //Encontrou esse item pelo ID
                            //Buscar o novo titulo deste item e setar
                            c  = s.createCriteria(Titulo.class);
                            l = c.list();
                            i = l.iterator();
                             
                            while(i.hasNext()){
                                Titulo t = (Titulo) i.next();
                                                             
                                if(t.getId() == varIdTitulo){
                                    i1.setTitulo(t);
                                 }
                             }
                            
                            //Realiza o restante das alteraçõs (Numero de Serie, Tipo, Data)
                            
                            i1.setDtAquisicao(dtAq);
                            i1.setNumSerie(serie);
                            i1.setTipoItem(tipo);
                        }
                                                     
                    }             
                    int r = AplCadastrarItem.alterarItem(s, i1);
			
                    if(r == AplCadastrarItem.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
			
                }
	}

}
