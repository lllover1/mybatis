package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import bean.Command;
import bean.CommandContent;
import dao.CommandDao;
import entity.Page;
import util.FixData;
/*
 * 获得指令内容
 */
public class CommandService implements FixData{
	/*
	 * 根据命令和描述获取指令集合
	 */
	public List<Command> getCommandList(String cname,String description, Page page) {
		CommandDao commandDao = new CommandDao();
		Command command = new Command();
		command.setCname(cname);
		command.setDescription(description);
		Map<String,Object> commandMap = new HashMap<String, Object>();
		page.setTotleNum(commandDao.getTotleNum(commandMap));
		page.count();
		commandMap.put("command",command);
		commandMap.put("page", page);
		return commandDao.getCommandPage(commandMap);
	}
	
	public List<Command> getCommandByPage(String cname,String description, Page page) {
		CommandDao commandDao = new CommandDao();
		Command command = new Command();
		command.setCname(cname);
		command.setDescription(description);
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("command",command);
		commandMap.put("page", page);
		return commandDao.getCommandPage(commandMap);
	}
	
	/*
	 * 根据命令获得指令内容
	 */
	
	public String getContentByCname (String cname) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList = new ArrayList<Command>();
		
		if(HELP_COMMAND.equals(cname)){
			StringBuilder strb = new StringBuilder();
			commandList = commandDao.getCommandList(null, null);
			
			for(int i = 0; i<commandList.size();i++){
				strb.append("回复："+commandList.get(i).getCname()+"["+commandList.get(i).getDescription()+"]");
				strb.append("<br/>");
			}
			
			return strb.toString();
		}else{
			commandList = commandDao.getCommandList(cname, null);
			
			if(commandList!=null&commandList.size()>0){
				List<CommandContent> contentList = commandList.get(0).getContentList();
				int temp = new Random().nextInt(contentList.size());
				return contentList.get(temp).getContent();
			}else{
				return AUOTO_SENTANCE;
			}
		}
	}
	
	
	/*public String getMessageByCommand(String command) {
		MessageDao messageDao =  new MessageDao();
		List<Message> messageList =  new ArrayList<Message>();
		
		if(HELP_COMMAND.equals(command)){
			StringBuilder string = new StringBuilder();
			messageList = messageDao.queryMessageList(null, null);
			for(int i = 0;i<messageList.size();i++){
				string.append("回复："+messageList.get(i).getCommand()+"["+messageList.get(i).getDescription()+"] <br/>");
				
			}
			return string.toString();
		}else{
			messageList = messageDao.queryMessageList(command, null);
			if(messageList!=null&&messageList.size()>0){
				return messageList.get(0).getContent();
			}
			else{
				return AUOTO_SENTANCE;
			}
		}
		
	}*/
}
