package controller;

import Hibernate.ConexaoSessionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.acervo.AplCadastrarAtor;

import model.application.acervo.AplCadastrarClasse;
import model.application.acervo.AplCadastrarTitulo;
import model.application.cliente.AplCadastrarDependente;
import model.domain.acervo.Ator;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import model.domain.cliente.Socio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarDependente
 */
@WebServlet("/ServletCadastrarDependente")
public class ServletCadastrarDependente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarDependente() {
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
                String varNome = request.getParameter("nome");
		int varInscricao = Integer.parseInt(request.getParameter("inscricao"));
		String varDtNasc = request.getParameter("dtNasc");		
		int varAtivo = Integer.parseInt(request.getParameter("ativo"));
		String varSexo = request.getParameter("sexo");
                int varIdSocio = Integer.parseInt(request.getParameter("socio"));
				
                 if(valor.equals("incluirDependente")){
		                        
                    Socio socio = null;
                    SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                    Session s = sf.openSession();
                    
                    Criteria c  = s.createCriteria(Socio.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Socio so = (Socio) i.next();
                        int id = so.getId();

                        if(id == varIdSocio)
                            socio = so;
                    }    
                   int r = AplCadastrarDependente.inserirDependente(varNome, varInscricao, varDtNasc, varSexo, varAtivo, socio);
			
                    if(r == AplCadastrarDependente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("alterarDependente")){
			
		}
	}

}
