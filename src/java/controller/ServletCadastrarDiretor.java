package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.acervo.AplCadastrarAtor;
import model.application.acervo.AplCadastrarDiretor;

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
		String varNome = request.getParameter("nome");
				
		if(valor.equals("incluirDiretor")){
			int r = AplCadastrarDiretor.inserirDiretor(varNome);
			
			if(r == AplCadastrarDiretor.SUCESSO) {
                            response.sendRedirect("msgCadastroSucesso.jsp");
			}else{
                            response.sendRedirect("msgCadastroError.jsp");
                        }
		}else if (valor.equals("alterarDiretor")){
			
		}
	}

}
