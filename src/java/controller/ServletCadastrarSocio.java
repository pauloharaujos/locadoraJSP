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
import model.application.cliente.AplCadastrarDependente;
import model.application.cliente.AplCadastrarSocio;
import model.domain.cliente.Socio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarSocio
 */
@WebServlet("/ServletCadastrarSocio")
public class ServletCadastrarSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarSocio() {
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
                String varCPF = request.getParameter("cpf");
                String varTel = request.getParameter("telefone");
                String varEndereco = request.getParameter("endereco");
		String varDtNasc = request.getParameter("dtNasc");		
		int varAtivo = Integer.parseInt(request.getParameter("ativo"));
		String varSexo = request.getParameter("sexo");                
				
                 if(valor.equals("incluirSocio")){
		   
                     int r = AplCadastrarSocio.inserirSocio(varNome, varDtNasc, varSexo, varAtivo, varCPF, varEndereco, varTel);
			
                    if(r == AplCadastrarSocio.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }                 
                   
                    }else if (valor.equals("alterarSocio")){
			
                    }
        }
}


