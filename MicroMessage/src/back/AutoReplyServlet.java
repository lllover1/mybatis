package back;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandService;

/**
 * 自动回复功能
 */
@WebServlet("/AutoReply.action")
public class AutoReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AutoReplyServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/xml");

		response.setCharacterEncoding("utf-8");
		String cname = request.getParameter("content");
		CommandService messageService =  new CommandService();
		String content = messageService.getContentByCname(cname);
		System.out.println(content);
		PrintWriter out = response.getWriter();
		out.write(content);
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
