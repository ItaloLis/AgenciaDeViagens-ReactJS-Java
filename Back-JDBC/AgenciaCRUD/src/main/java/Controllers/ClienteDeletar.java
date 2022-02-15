package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

@WebServlet("/Delete")
public class ClienteDeletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteDeletar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDao.delete(clienteId);
		
		ClienteCreateAndFind clienteCF = new ClienteCreateAndFind();
		clienteCF.doGet(request, response);
		
	}


}
