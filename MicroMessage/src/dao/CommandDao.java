package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Command;

import connection.DBAcess;
/**
 * 
 * @author ��ָ�����ݿ�Ĳ���
 *
 */
public class CommandDao {
	/*
	 * ��ָ����в�ѯ������List
	 */
	
	public List<Command> getCommandList(String cname,String description){
		List<Command> commandList = new ArrayList<Command>();
		//�������ݿ�������
		DBAcess dbAcess = new DBAcess();
		 //��ò������ݿ��SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		Command command = new Command();
		command.setCname(cname);
		command.setDescription(description);
		//���ؼ������
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
		//�������ݿ�������
		DBAcess dbAcess = new DBAcess();
		 //��ò������ݿ��SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		//���ؼ������
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
		//�������ݿ�������
		DBAcess dbAcess = new DBAcess();
		 //��ò������ݿ��SQLSession
		SqlSession sqlSession = dbAcess.getSqlSession();
		//���ؼ������
		InterfaceCommand interfaceCommand = sqlSession.getMapper(InterfaceCommand.class);
		sqlSession.commit();
		i = interfaceCommand.totleNum(commandMap);
		
		if(sqlSession!=null){
			sqlSession.close();
			
		}
		return i;
	}
	
	/*
	 * ɾ������
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

