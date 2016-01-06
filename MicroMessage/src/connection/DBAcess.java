package connection;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * mybatis连接数据库
 */

public class DBAcess {
	/*
	 * 获取连接
	 */
	public SqlSession getSqlSession() {
		Reader reader = null;
		try {
			//获得一个配置文件的读取
			 reader =
					Resources.getResourceAsReader("config/Configuration.xml");
		} catch (IOException e) {
			
			System.out.println("配置文件读取失败");
		}
		
		//通过配置文件获得sessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
	
}
