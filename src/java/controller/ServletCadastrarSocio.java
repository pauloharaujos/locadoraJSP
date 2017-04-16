package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.acervo.AplCadastrarAtor;
import model.application.cliente.AplCadastrarSocio;

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
		String varNome = request.getParameter("nome");
		String varCPF = request.getParameter("cpf");
		String varEndereco = request.getParameter("endereco");
		String varInscricao = request.getParameter("inscricao");
		String varDtNasc = request.getParameter("dtNasc");
		
		
		AplCadastrarSocio.inserirSocio(varNome, Integer.parseInt(varInscricao), varDtNasc, "masculino", 0, varCPF, varEndereco, "996785742");
	}

}
