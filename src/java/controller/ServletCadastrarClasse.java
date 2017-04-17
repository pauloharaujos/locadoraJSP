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
import model.application.acervo.AplCadastrarClasse;
import model.application.acervo.AplCadastrarDiretor;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarClasse
 */
@WebServlet("/ServletCadastrarClasse")
public class ServletCadastrarClasse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarClasse() {
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

		
                if(valor.equals("incluirClasse")){
                    String varNome = request.getParameter("nome");
                    String varValor = request.getParameter("valor");
                    String varData = request.getParameter("data");
                    String varOperacao = request.getParameter("cadastrar");
                    
                    int r = AplCadastrarClasse.inserirClasse(varNome, Integer.parseInt(varValor), varData);
			
                    if(r == AplCadastrarClasse.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("alterarClasse")){
			
		}else if (valor.equals("excluirClasse")){
                    int varIdClasse = Integer.parseInt(request.getParameter("classe"));
                    
                    Classe classe = null;
                    SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                    Session s = sf.openSession();
                    Criteria c  = s.createCriteria(Classe.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Classe c1 = (Classe) i.next();
                        int id = c1.getId();

                        if((id == varIdClasse))
                            classe = c1;                   
                    }                      
                    int r = AplCadastrarClasse.excluirClasse(classe);
			
                    if(r == AplCadastrarClasse.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
			
		}		
	}
}
