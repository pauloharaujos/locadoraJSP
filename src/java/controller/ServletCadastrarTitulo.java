package controller;

import Hibernate.ConexaoSessionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.acervo.AplCadastrarAtor;
import model.application.acervo.AplCadastrarDiretor;

import model.application.acervo.AplCadastrarItem;
import model.application.acervo.AplCadastrarTitulo;
import model.application.cliente.AplCadastrarCliente;
import model.domain.acervo.Ator;
import model.domain.acervo.Classe;
import model.domain.acervo.Diretor;
import model.domain.acervo.Titulo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ServletCadastrarItem
 */
@WebServlet("/ServletCadastrarTitulo")
public class ServletCadastrarTitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarTitulo() {
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
            Session s = (Session) request.getAttribute("sessaoBD");
            
	    if(valor.equals("incluirTitulo")){
                
                    String varNome = request.getParameter("nome");
                    String[] atores = request.getParameterValues("atores");
                    int varIdDiretor = Integer.parseInt(request.getParameter("diretor"));
                    String varCategoria = request.getParameter("categoria");
                    int varIdClasse = Integer.parseInt(request.getParameter("classe"));
                    int varAno = Integer.parseInt(request.getParameter("ano"));
                    String varSinopse = request.getParameter("sinopse");
		    
                    List listaAtores = new ArrayList();
                    Diretor diretor = null;
                    Classe classe = null;           
                    
                    Criteria c  = s.createCriteria(Ator.class);
                    List l = c.list();
                    Iterator i = l.iterator();

                    while(i.hasNext()){
                        Ator a = (Ator) i.next();
                        int id = a.getId();

                        if(comparaAtor(id, atores) == 1)
                            listaAtores.add(a);
                    }                    
                    
                    c  = s.createCriteria(Diretor.class);
                    l = c.list();
                    i = l.iterator();

                    while(i.hasNext()){
                        Diretor d = (Diretor) i.next();
                        int id = d.getId();

                        if((id == varIdDiretor))
                            diretor = d;                   
                    }   
                    
                    c  = s.createCriteria(Classe.class);
                    l = c.list();
                    i = l.iterator();

                    while(i.hasNext()){
                        Classe c1 = (Classe) i.next();
                        int id = c1.getId();

                        if((id == varIdClasse))
                            classe = c1;                   
                    }                       

                   int r = AplCadastrarTitulo.inserirTitulo(s, varNome, varAno, varSinopse, varCategoria, diretor, classe, listaAtores);
			
                    if(r == AplCadastrarAtor.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
		}else if (valor.equals("alterarTitulo")){
                  
                    int varId = Integer.parseInt(request.getParameter("id"));
                    String varNome = request.getParameter("nome");
                   // String[] atores = request.getParameterValues("atores");
                    int varIdDiretor = Integer.parseInt(request.getParameter("diretor"));
                    String varCategoria = request.getParameter("categoria");
                    int varIdClasse = Integer.parseInt(request.getParameter("classe"));
                    int varAno = Integer.parseInt(request.getParameter("ano"));
                   // String varSinopse = request.getParameter("sinopse");
                                  
                    Criteria c  = s.createCriteria(Titulo.class);
                    List l = c.list();
                    Iterator i = l.iterator();
                    Titulo t = null;
                    while(i.hasNext()){
                        t = (Titulo) i.next();
                        int id = t.getId();

                        if(id  ==  varId){
                            t.setNome(varNome);
                            t.setCategoria(varCategoria);
                            t.setAno(varAno);
                            //t.setSinopse(varSinopse);
                            
                             c  = s.createCriteria(Diretor.class);
                             l = c.list();
                             i = l.iterator();
                             
                             while(i.hasNext()){
                                 Diretor d = (Diretor) i.next();
                                                             
                                 if(d.getId() == varIdDiretor){
                                     t.setDiretor(d);
                                 }
                             }
                         
                             c  = s.createCriteria(Classe.class);
                             l = c.list();
                             i = l.iterator();
                             
                             while(i.hasNext()){
                                 Classe c1 = (Classe) i.next();
                                                             
                                 if(c1.getId() == varIdClasse){
                                     t.setClasse(c1); 
                                 }
                             }
                        }
                    }                    
                    int r = AplCadastrarTitulo.alterarTitulo(s, t);
			
                    if(r == AplCadastrarTitulo.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
                    
		}else if (valor.equals("excluirTitulo")){                  
                    
                    int varIdTitulo = Integer.parseInt(request.getParameter("id"));
                    
                    Titulo titulo = null;                
                    Criteria c  = s.createCriteria(Titulo.class);
                    List l = c.list();
                    Iterator i = l.iterator();  

                    while(i.hasNext()){
                        Titulo t1 = (Titulo) i.next();
                        int id = t1.getId();

                        if((id == varIdTitulo))
                            titulo = t1;                   
                    }  
                                
                    int r = AplCadastrarTitulo.excluirTitulo(s, titulo);
			
                    if(r == AplCadastrarTitulo.SUCESSO) {
                        response.sendRedirect("msgCadastroSucesso.jsp");
                    }else{
                        response.sendRedirect("msgCadastroError.jsp");
                    }
			
		}
	}
        
        public int comparaAtor(int id, String[] atores){
            
            int i = 0, id2 = -1;
            
            while(i < atores.length){
                id2 = Integer.parseInt(atores[i]);
                if(id == id2)
                    return  1;
                i++;
            }                
            return 0;
        }
}
