/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application.cliente;

import Hibernate.ConexaoSessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.cliente.Socio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author paulo
 */
@WebServlet(name = "ServletCadastrarCliente", urlPatterns = {"/ServletCadastrarCliente"})
public class ServletCadastrarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCadastrarCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCadastrarCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String valor = request.getParameter("operacao");	
				
                 if(valor.equals("incluirDependente")){
                     
                    String varNome = request.getParameter("nome");		
                    String varDtNasc = request.getParameter("dtNasc");		
                    int varAtivo = Integer.parseInt(request.getParameter("ativo"));
                    String varSexo = request.getParameter("sexo");
                    int varIdSocio = Integer.parseInt(request.getParameter("socio"));
		                        
                    Socio socio = null;
                    SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                    Session s = sf.openSession();
                    
                    Criteria c  = s.createCriteria(Socio.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Socio so = (Socio) i.next();
                        int id = so.getNumIncricao();

                        if(id == varIdSocio)
                            socio = so;
                    }    
                   int r = AplCadastrarCliente.inserirDependente(varNome, varDtNasc, varSexo, varAtivo, socio);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("incluirSocio")){
                    
                    String varNome = request.getParameter("nome");	
                    String varCPF = request.getParameter("cpf");
                    String varTel = request.getParameter("telefone");
                    String varEndereco = request.getParameter("endereco");
                    String varDtNasc = request.getParameter("dtNasc");		
                    int varAtivo = Integer.parseInt(request.getParameter("ativo"));
                    String varSexo = request.getParameter("sexo");             
                    
                    int r = AplCadastrarCliente.inserirSocio(varNome, varDtNasc, varSexo, varAtivo, varCPF, varEndereco, varTel);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }             
			
		}else if (valor.equals("excluirCliente")){
			
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
