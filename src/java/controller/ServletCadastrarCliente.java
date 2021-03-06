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
import model.application.acervo.AplCadastrarTitulo;
import model.application.cliente.AplCadastrarCliente;
import model.domain.acervo.Ator;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import model.domain.acervo.Titulo;
import model.domain.cliente.Cliente;
import model.domain.cliente.Dependente;
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
		Session s = (Session) request.getAttribute("sessaoBD");
                
                 if(valor.equals("incluirDependente")){
                     
                    String varNome = request.getParameter("nome");		
                    String varDtNasc = request.getParameter("dtNasc");		
                    int varAtivo = Integer.parseInt(request.getParameter("ativo"));
                    String varSexo = request.getParameter("sexo");
                    int varIdSocio = Integer.parseInt(request.getParameter("socio"));
		                        
                    Socio socio = null;                   
                    
                    Criteria c  = s.createCriteria(Socio.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Socio so = (Socio) i.next();
                        int id = so.getNumIncricao();

                        if(id == varIdSocio)
                            socio = so;
                    }   
                
                   int r = AplCadastrarCliente.inserirDependente(s, varNome, varDtNasc, varSexo, varAtivo, socio);
			
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
                    
                    int r = AplCadastrarCliente.inserirSocio(s, varNome, varDtNasc, varSexo, varAtivo, varCPF, varEndereco, varTel);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }             
			
		}else if (valor.equals("excluirCliente")){
		    int varIdCliente = Integer.parseInt(request.getParameter("id"));
                    
                    Cliente cliente = null;                  
                    Criteria c  = s.createCriteria(Cliente.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Cliente c1 = (Cliente) i.next();
                        int id = c1.getNumIncricao();

                        if((id == varIdCliente))
                            cliente = c1;                   
                    }       
               
                    int r = AplCadastrarCliente.excluirCliente(s, cliente);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
                }else if (valor.equals("alterarDependente")){
                    
                    int varId = Integer.parseInt(request.getParameter("id"));
                    String varNome = request.getParameter("nome");                  
                    String varSexo = request.getParameter("sexo");                   
                    int varAtivo = Integer.parseInt(request.getParameter("ativo"));
                    int varIdSocio = Integer.parseInt(request.getParameter("socio"));             
                                  
                    Criteria c  = s.createCriteria(Dependente.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Dependente d = null;
                    while(i.hasNext()){
                        d = (Dependente) i.next();
                        int id = d.getNumIncricao();
                            
                        if(id  ==  varId){ //Se encontrar o Dependente, entao alterar os dados dele
                            d.setNome(varNome);
                            d.setSexo(varSexo);
                            d.setEstahAtivo(varAtivo);                            
                            
                            //Vamos buscar o objeto socio pelo numInscricao e alterar neste dependente
                             c  = s.createCriteria(Socio.class);
                             l = c.list();
                             i = l.iterator();
                             
                             while(i.hasNext()){
                                 Socio s1 = (Socio) i.next();
                                                             
                                 if(s1.getNumIncricao() == varIdSocio){
                                     d.setSocio(s1);
                                 }
                             }                         
                        }                        
                    }                    
                    int r = AplCadastrarCliente.alterarCliente(s, d);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
                    
                }else if (valor.equals("alterarSocio")){
                    
                    int varId = Integer.parseInt(request.getParameter("id"));
                    String varNome = request.getParameter("nome");                  
                    String varSexo = request.getParameter("sexo");                   
                    int varAtivo = Integer.parseInt(request.getParameter("ativo"));
                    String varCPF = request.getParameter("cpf");
                    String varEndereco = request.getParameter("endereco");
                    String varTelefone = request.getParameter("telefone");
                                  
                    Criteria c  = s.createCriteria(Socio.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Socio s1 = null;
                    while(i.hasNext()){
                        s1 = (Socio) i.next();
                        int id = s1.getNumIncricao();
                            
                        if(id  ==  varId){ //Se encontrar o Dependente, entao alterar os dados dele
                            s1.setNome(varNome);
                            s1.setSexo(varSexo);
                            s1.setEstahAtivo(varAtivo);
                            s1.setCpf(varCPF);
                            s1.setEndereco(varEndereco);
                            s1.setTel(varTelefone);
                        }                        
                    }                    
                    int r = AplCadastrarCliente.alterarCliente(s, s1);
			
                    if(r == AplCadastrarCliente.SUCESSO) {
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
