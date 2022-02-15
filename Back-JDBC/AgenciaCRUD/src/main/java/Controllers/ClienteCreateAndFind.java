package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteCreateAndFind() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("pesquisa");
		
		if (search == null) {
			search="";
		}
		
		List<Cliente> clientes = ClienteDao.find(search);
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListaClientes.jsp");
		dispatcher.forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));
		
		ClienteDao.create(cliente);
		
		doGet(request, response);
	}

}
