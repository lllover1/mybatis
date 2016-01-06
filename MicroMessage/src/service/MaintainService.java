package service;

import java.util.ArrayList;
import java.util.List;

import bean.Command;
import bean.CommandContent;
import dao.CommandDao;
import dao.ContentDao;


/**
 * 
 * 负责接受servlet传入的参数，并调用Dao层
 *
 */
public class MaintainService {
	
	/*
	 * 单条删除，调用dao层的deleteOne进行删除操作
	 */
	public void deleteOneCommand(String id){
		CommandDao commandDao = new CommandDao();
		Command command = new Command();
		List<Command> commandList = new ArrayList<Command>();
		if(id!=null){
			command.setId(Integer.valueOf(id));
			commandList.add(command);
			commandDao.delete(commandList);
		}
	}
	/*
	 * 多条删除
	 */
	public void deleteManyCommand(String[] ids){
		CommandDao commandDao = new CommandDao();
		Command command = null;
		List<Command> commandList = new ArrayList<Command>();
		if(ids!=null){
			for(String s:ids){
				command = new Command();
				command.setId(Integer.valueOf(s));
				commandList.add(command);
				
			}
			commandDao.delete(commandList);
		}
	}
	
	public void insertOne(String cname,String description,String[] content) {
		CommandDao commandDao = new CommandDao();
		Command command = new Command();
		command.setCname(cname);
		command.setDescription(description);
		commandDao.insertOne(command);
		int temp =command.getId();
	
		List<CommandContent> contentList = new ArrayList<CommandContent>();
		CommandContent commandContent = null;
		for(int i=0;i<content.length;i++){
		  commandContent = new CommandContent();
		  commandContent.setContent(content[i]);
		  commandContent.setMessageId(temp);
		  contentList.add(commandContent);
		}
		ContentDao contentDao = new ContentDao();
		contentDao.insertContent(contentList);
		
	}
	
}
