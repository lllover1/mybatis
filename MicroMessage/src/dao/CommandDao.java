package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Command;

import connection.DBAcess;
/**
 * 
 * @author 对指令数据库的操作
 *
 */
public class CommandDao {
	/*
	 * 对指令进行查询，返回List
	 */
	
	public List<Command> getCommandList(String cname,String description){
		List<Command> commandList = new ArrayList<Command>();
		//创建数据库连接类
		DBAcess dbAcess = new DBAcess();
		 //获得操作数据库的SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		Command command = new Command();
		command.setCname(cname);
		command.setDescription(description);
		//返回检索结果
		InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
		sqlSession.commit();
		commandList = interfaceCommand.queryCommandList(command);
		
		if(sqlSession!=null){
			sqlSession.close();
		}
		return commandList;
	}
	
	public List<Command> getCommandPage(Map<String,Object> commandMap){
		List<Command> commandList = new ArrayList<Command>();
		//创建数据库连接类
		DBAcess dbAcess = new DBAcess();
		 //获得操作数据库的SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		//返回检索结果
		InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
		sqlSession.commit();
		commandList = interfaceCommand.getCommandByPage(commandMap);
		
		if(sqlSession!=null){
			sqlSession.close();
			
		}
		return commandList;
	}
	
	public int getTotleNum(Map<String,Object> commandMap){
		int i;
		//创建数据库连接类
		DBAcess dbAcess = new DBAcess();
		 //获得操作数据库的SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		//返回检索结果
		InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
		sqlSession.commit();
		i = interfaceCommand.totleNum(commandMap);
		
		if(sqlSession!=null){
			sqlSession.close();
			
		}
		return i;
	}
	
	/*
	 * 删除单个
	 */
    public void delete(List<Command> commandList){
	    DBAcess dbAcess = new DBAcess();
		SqlSession sqlSession = dbAcess.getSqlSession();
		InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
		System.out.println(commandList.get(0).getId());
		interfaceCommand.delete(commandList);
		sqlSession.commit();
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
    
    public void insertOne(Command command) {
    	DBAcess dbAcess = new DBAcess();
    	SqlSession sqlSession = dbAcess.getSqlSession();
    	InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
    	interfaceCommand.insertOne(command);
    	sqlSession.commit();
    	if(sqlSession!=null){
    		sqlSession.close();
    	}
    }
}

