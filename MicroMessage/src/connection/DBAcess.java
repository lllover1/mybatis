package connection;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * mybatis�������ݿ�
 */

public class DBAcess {
	/*
	 * ��ȡ����
	 */
	public SqlSession getSqlSession() {
		Reader reader = null;
		try {
			//���һ�������ļ��Ķ�ȡ
			 reader =
					Resources.getResourceAsReader("config/Configuration.xml");
		} catch (IOException e) {
			
			System.out.println("�����ļ���ȡʧ��");
		}
		
		//ͨ�������ļ����sessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
	
}
