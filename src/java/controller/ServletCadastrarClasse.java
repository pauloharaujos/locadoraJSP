package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.acervo.AplCadastrarAtor;
import model.application.acervo.AplCadastrarClasse;

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
		String varNome = request.getParameter("nome");
		String varValor = request.getParameter("valor");
		String varData = request.getParameter("data");
		String varOperacao = request.getParameter("cadastrar");
		
		System.out.println("OPERACAOOOOOOO : " + varOperacao);
		
		AplCadastrarClasse.inserirClasse(varNome, Integer.parseInt(varValor), varData);
	}

}
