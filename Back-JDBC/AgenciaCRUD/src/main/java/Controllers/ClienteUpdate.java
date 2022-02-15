package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/Update")
public class ClienteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ClienteUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		
		Cliente cliente = ClienteDao.findByPk(clienteId);
		
		request.setAttribute("cliente", cliente);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));
		
		ClienteDao.update(cliente);
		
		ClienteCreateAndFind clienteCF = new ClienteCreateAndFind();
		clienteCF.doGet(request, response);
		
	}

}
