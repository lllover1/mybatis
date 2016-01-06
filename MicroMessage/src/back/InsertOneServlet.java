package back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MaintainService;




/**
 * 插入单条数据
 */
@WebServlet("/InsertOne.action")
public class InsertOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertOneServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String cname = request.getParameter("command");
		String description = request.getParameter("description");
		
		String[] content = request.getParameterValues("content");
		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(cname,description,content);
		response.sendRedirect(request.getContextPath()+"/List.action");
  	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
