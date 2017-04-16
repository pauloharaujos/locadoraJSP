package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.acervo.AplCadastrarAtor;


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
		String varNome = request.getParameter("nome");
				
		if(valor.equals("incluirAtor")){
			int r = AplCadastrarAtor.inserirAtor(varNome);
			
			if(r == AplCadastrarAtor.SUCESSO) {
                            response.sendRedirect("msgCadastroSucesso.jsp");
			}else{
                            response.sendRedirect("msgCadastroError.jsp");
                        }
		}else if (valor.equals("alterarAtor")){
			
		}
		
	}

}
