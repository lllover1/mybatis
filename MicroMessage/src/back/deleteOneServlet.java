package back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MaintainService;

/**
 * 接受单条删除的信息，并传入service层
 */
@WebServlet("/DeleteOne.action")
public class deleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteOneServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        String id = request.getParameter("deleteId");
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOneCommand(id);
       
        request.getRequestDispatcher("/List.action").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
