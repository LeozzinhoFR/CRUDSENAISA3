package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ClienteRepository;


public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteRepository userRepository = new ClienteRepository();

	public  ServletCliente() 
			{

	        }

	protected void  doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
					{
						try {
								String acao = request.getParameter("acao");
								
								if  (acao != null && !acao.isEmpty() & acao.equalsIgnoreCase("deletar")) 
									{
									 String userId = request.getParameter("id");
									 userRepository.deletarCliente(userId);
									 request.setAttribute("msg", "Excluído com Sucesso!!!");
									 request.getRequestDispatcher("painel/inicio.jsp").forward(request, response);

									} else 
										   if  (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarAjax")) 
										       {
											   	String userId = request.getParameter("id");
											   	userRepository.deletarCliente(userId);
											   	response.getWriter().write("Excluído com Ajax");

										       } else 
										    	   	  if  (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("consultarAjax")) 
									    	   	  		  {
										    	   		  	String nome = request.getParameter("nomeBusca");
										    	   		  	List<Cliente> dadosCliente = userRepository.consultarClienteLista(nome);
										    	   		  	ObjectMapper mapa = new ObjectMapper();
										    	   		  	String json = mapa.writeValueAsString(dadosCliente);
										    	   		  	response.getWriter().write(json);

									    	   	  		  } else 
									    	   	  			     if  (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEditar")) 
									    	   	  			     	 {
									    	   	  			    	  String id = request.getParameter("id");
									    	   	  			    	  Cliente user01 = userRepository.consultarClienteID(id);
									    	   	  			    	  request.setAttribute("msg", "Usuário em Edição!!!");
									    	   	  			    	  request.setAttribute("user01", user01);
									    	   	  			    	  request.getRequestDispatcher("painel/inicio.jsp").forward(request, response);

									    	   	  			     	 } else {
									    	   	  			     		 		request.getRequestDispatcher("painel/inicio.jsp").forward(request, response);
									    	   	  			     	 		}
						} catch (Exception e) 	
								{
									// TODO: handle exception
								 e.printStackTrace();
								 RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
								 request.setAttribute("msg", e.getMessage());
								 redireciona.forward(request, response);
								}
					}

	protected void  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
					{
						try {
							 String mensagem = "Cadastro Realizado com Sucesso!!";
							 String id = request.getParameter("id");
							 String nome = request.getParameter("nome");
							 String endereco = request.getParameter("endereco");
							 String modalidade = request.getParameter("modalidade");

							 Cliente user01 = new Cliente();
							 user01.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
							 user01.setNome(nome);
							 user01.setEndereco(endereco);
							 user01.setModalidade(modalidade);

							 if  (userRepository.vericaCliente(user01.getNome()) && user01.getId() == null) 
							 	 {
								  mensagem = "Usuário já cadastrado, informe outro usuário!!!";

							 	 } else {
							 		 	  if  (user01.ehNovo()) 
							 		 	  	  {
							 		 		   mensagem = "Gravado com Sucesso!!";
							 		 	  	  } else {
						 		 	  		  		mensagem = "Atualizado com Sucesso!!";
							 		 	  	  		 }
							 		 	  
							 		 	  user01 = userRepository.insereCliente(user01);
							 	 		}

							 
							 request.setAttribute("msg", mensagem);
							 request.setAttribute("user01", user01);
							 request.getRequestDispatcher("painel/inicio.jsp").forward(request, response);

						} catch (Exception e) 
								{
									// TODO: handle exception
								  e.printStackTrace();
								  RequestDispatcher redireciona = request.getRequestDispatcher("erros.jsp");
								  request.setAttribute("msg", e.getMessage());
								  redireciona.forward(request, response);
								}
					}

}