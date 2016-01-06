package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.CommandContent;
import connection.DBAcess;
public class ContentDao {
	public void insertContent (List<CommandContent> contentList){
		DBAcess dbAcess = new DBAcess();
		SqlSession sqlSession = dbAcess.getSqlSession();
		InterfaceContent interfaceContent = sqlSession.getMapper(InterfaceContent.class);
	    interfaceContent.insertContent(contentList);
	    sqlSession.commit();
	    if(sqlSession!=null){
	    	sqlSession.close();
	    }
	}

}
