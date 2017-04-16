package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.acervo.AplCadastrarItem;
import model.application.cliente.AplCadastrarDependente;

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
		String varNumSerie = request.getParameter("numSerie");
		String varTitulo = request.getParameter("titulo");
		String varDtAq = request.getParameter("dtAq");
		String varTipo= request.getParameter("tipo");
	
				
		AplCadastrarItem.inserirItem(Integer.parseInt(varNumSerie), varDtAq, varTipo, null);
	}

}
