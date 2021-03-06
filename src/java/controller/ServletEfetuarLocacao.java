/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.application.acervo.AplCadastrarAtor;
import model.application.acervo.AplCadastrarDiretor;
import model.application.acervo.AplCadastrarTitulo;
import model.application.cliente.AplEfetuarLocacao;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import model.domain.acervo.Item;
import model.domain.acervo.Titulo;
import model.domain.cliente.Cliente;
import model.domain.cliente.Locacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author paulo
 */
@WebServlet(name = "ServletEfetuarLocacao", urlPatterns = {"/ServletEfetuarLocacao"})
public class ServletEfetuarLocacao extends HttpServlet {

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
            out.println("<title>Servlet ServletEfetuarLocacao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEfetuarLocacao at " + request.getContextPath() + "</h1>");
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
	Session s = (Session) request.getAttribute("sessaoBD");	
				
	if(valor.equals("incluirLocacao")){
                    int varIdItem = Integer.parseInt(request.getParameter("item"));
                    int varIdCliente = Integer.parseInt(request.getParameter("cliente"));
                    int varValor = Integer.parseInt(request.getParameter("valor"));
                    String varDataPrevista = request.getParameter("dataPrevista");
                    String varDataAtual = request.getParameter("dataAtual");
                    
                    Item item = null;
                    Criteria c  = s.createCriteria(Item.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Item t1 = (Item) i.next();
                        int id = t1.getId();

                        if((id == varIdItem))
                            item = t1;                   
                    }    
                    
                    Cliente cliente = null;                 
                    c  = s.createCriteria(Cliente.class);
                    l = c.list();
                    i = l.iterator();

                    while(i.hasNext()){
                        Cliente c1 = (Cliente) i.next();
                        int id = c1.getNumIncricao();

                        if((id == varIdCliente))
                            cliente = c1;                   
                    }           
                    
                    int r = AplEfetuarLocacao.inserirLocacao(s, varDataAtual, varDataPrevista, "", varValor, 0, item, cliente);
			
			if(r == AplEfetuarLocacao.SUCESSO) {
                            response.sendRedirect("msgCadastroSucesso.jsp");
			}else{
                            response.sendRedirect("msgCadastroError.jsp");
                        }
		}else if (valor.equals("alterarLocacao")){
                    
                   int varId = Integer.parseInt(request.getParameter("id"));                   
                   int varIdCliente = Integer.parseInt(request.getParameter("cliente"));
                   int varValor = Integer.parseInt(request.getParameter("valor"));                    
                   int varMulta = Integer.parseInt(request.getParameter("multa"));
                   String varDtLocacao = request.getParameter("dtLocacao"); 
                   String varDtPrev = request.getParameter("dtDevolucaoPrev"); 
                                  
                    Criteria c  = s.createCriteria(Locacao.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Locacao l1 = null;
                    while(i.hasNext()){
                        l1 = (Locacao) i.next();
                        int id = l1.getId();

                        if(id  ==  varId){
                            l1.setValorCobrado(varValor);
                            l1.setMultaCobrada(varMulta);
                            l1.setDtLocacao(varDtLocacao);
                            l1.setDtDevolucaoPrevista(varDtPrev);
                            
                             c  = s.createCriteria(Cliente.class);
                             l = c.list();
                             i = l.iterator();
                             
                             while(i.hasNext()){
                                 Cliente c1 = (Cliente) i.next();
                                                             
                                 if(c1.getNumIncricao() == varIdCliente){
                                     l1.setCliente(c1);
                                 }
                             }                        
                        }
                    }
                    int r = AplEfetuarLocacao.alterarLocacao(s, l1);
			
                    if(r == AplEfetuarLocacao.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
			
		}else if (valor.equals("cancelarLocacao")){
                
                    int varIdLocacao = Integer.parseInt(request.getParameter("id"));
                    
                    Locacao locacao = null;               
                    Criteria c  = s.createCriteria(Locacao.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Locacao d1 = (Locacao) i.next();
                        int id = d1.getId();

                        if((id == varIdLocacao))
                            locacao = d1;                   
                    }                          
                    int r = AplEfetuarLocacao.cancelarLocacao(s, locacao);
			
                    if(r == AplEfetuarLocacao.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
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
