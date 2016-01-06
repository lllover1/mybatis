package back;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Command;
import entity.Page;
import service.CommandService;

/*
 * 列表页面初始化控制
 */
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置request编码 为utf-8
		req.setCharacterEncoding("utf-8");
		//获取网页表单输入内容
		String cname = req.getParameter("cname");
		String description = req.getParameter("description");
		String currentPage = req.getParameter("currentPage");
		//System.out.println("字数串："+currentPage);
		Page page = new Page();
		if(currentPage==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		//调用MessageService类中的getMessageList方法获得查询内容
        CommandService commandService = new CommandService();
		//messageList接受查询内容
		List<Command> commandList = new ArrayList<Command>();
		commandList = commandService.getCommandByPage(cname, description,page);
		//查询后的内容放入request中
		//内容放回request,网页可以重新获取
	    req.setAttribute("cname", cname);
		req.setAttribute("description", description);
		req.setAttribute("commandList",commandList);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3859568573002696103L;



} 
