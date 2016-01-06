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
 * �б�ҳ���ʼ������
 */
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//����request���� Ϊutf-8
		req.setCharacterEncoding("utf-8");
		//��ȡ��ҳ����������
		String cname = req.getParameter("cname");
		String description = req.getParameter("description");
		String currentPage = req.getParameter("currentPage");
		//System.out.println("��������"+currentPage);
		Page page = new Page();
		if(currentPage==null){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		//����MessageService���е�getMessageList������ò�ѯ����
        CommandService commandService = new CommandService();
		//messageList���ܲ�ѯ����
		List<Command> commandList = new ArrayList<Command>();
		commandList = commandService.getCommandByPage(cname, description,page);
		//��ѯ������ݷ���request��
		//���ݷŻ�request,��ҳ�������»�ȡ
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
