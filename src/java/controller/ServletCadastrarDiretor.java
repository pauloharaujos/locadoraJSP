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

import model.application.acervo.AplCadastrarDiretor;
import model.domain.acervo.Ator;
import model.domain.acervo.Diretor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarDiretor
 */
@WebServlet("/ServletCadastrarDiretor")
public class ServletCadastrarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarDiretor() {
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
				
		if(valor.equals("incluirDiretor")){
                    String varNome = request.getParameter("nome");
			int r = AplCadastrarDiretor.inserirDiretor(s, varNome);
			
			if(r == AplCadastrarDiretor.SUCESSO) {
                            response.sendRedirect("msgCadastroSucesso.jsp");
			}else{
                            response.sendRedirect("msgCadastroError.jsp");
                        }
		}else if (valor.equals("alterarDiretor")){
                    int varId = Integer.parseInt(request.getParameter("id"));
                    String varNome = request.getParameter("nome");
                                
                    Criteria c  = s.createCriteria(Diretor.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Diretor d1 = null;
                    while(i.hasNext()){
                        d1 = (Diretor) i.next();
                        int id = d1.getId();

                        if(id  ==  varId)
                            d1.setNome(varNome);                             
                    }               
                    int r = AplCadastrarDiretor.alterarDiretor(s, d1);
			
                    if(r == AplCadastrarDiretor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }  
			
		}else if (valor.equals("excluirDiretor")){
                    int varIdDiretor = Integer.parseInt(request.getParameter("id"));
                    
                    Diretor diretor = null;                 
                    Criteria c  = s.createCriteria(Diretor.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Diretor d1 = (Diretor) i.next();
                        int id = d1.getId();

                        if((id == varIdDiretor))
                            diretor = d1;                   
                    }     
                 
                    int r = AplCadastrarDiretor.excluirDiretor(s, diretor);
			
                    if(r == AplCadastrarDiretor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}
	}

}
