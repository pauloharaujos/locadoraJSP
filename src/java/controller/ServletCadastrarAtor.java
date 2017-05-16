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
import model.domain.acervo.Ator;
import model.domain.acervo.Titulo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Servlet implementation class ServeletCadastro
 */
@WebServlet("/ServletCadastrarAtor")
public class ServletCadastrarAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarAtor() {
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
				
		if(valor.equals("incluirAtor")){
                    String varNome = request.getParameter("nome");
                    
                    int r = AplCadastrarAtor.inserirAtor(s, varNome);
			
                    if(r == AplCadastrarAtor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("alterarAtor")){
			
		}else if (valor.equals("excluirAtor")){
//                    int varIdAtor = Integer.parseInt(request.getParameter("ator"));
//                    
//                    Ator ator = null;
//                    SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
//                    Session s = sf.openSession();
//                    Criteria c  = s.createCriteria(Ator.class);
//                    List l = c.list();
//                    Iterator i = l.iterator();
//
//                    while(i.hasNext()){
//                        Ator a = (Ator) i.next();
//                        int id = a.getId();
//
//                        if((id == varIdAtor))
//                            ator = a;                   
//                    }           
//                    s.close();
//                    int r = AplCadastrarAtor.excluirAtor(ator);
//			
//                    if(r == AplCadastrarAtor.SUCESSO) {
//                        response.sendRedirect("msgCadastroSucesso.jsp");
//                    }else{
//                        response.sendRedirect("msgCadastroError.jsp");
//                    }
                }
		
	}

}
