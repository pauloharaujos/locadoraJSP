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
import model.application.cliente.AplCadastrarDependente;
import model.domain.acervo.Titulo;
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
                int varNumSerie = Integer.parseInt(request.getParameter("numSerie"));
		int varIdTitulo = Integer.parseInt(request.getParameter("titulo"));
		String varDtAq = request.getParameter("dtAq");
		String varTipo= request.getParameter("tipo");
                
                if(valor.equals("incluirItem")){
		    
                    Titulo titulo = null;
                    SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                    Session s = sf.openSession();
                    Criteria c  = s.createCriteria(Titulo.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Titulo t = (Titulo) i.next();
                        int id = t.getId();

                        if((id == varIdTitulo))
                            titulo = t;                   
                    }       

                   int r = AplCadastrarItem.inserirItem(varNumSerie, varDtAq, varTipo, titulo);
			
                    if(r == AplCadastrarAtor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("alterarItem")){
			
		}
                
                
                
	}

}
