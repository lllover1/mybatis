package interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;



import entity.Page;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare", args = { Connection.class })})
public class PageInterceptor implements Interceptor{

	@SuppressWarnings("unchecked")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject =MetaObject.forObject(
				statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		
		String id = mappedStatement.getId();
		if(id.matches(".+ByPage$")){
			BoundSql boundSql = statementHandler.getBoundSql();
		    String sql = boundSql.getSql();
		    
		    String countSql = "SELECT COUNT(a.C_ID) from ( "+sql+" ) a";
		    Connection connection = (Connection)invocation.getArgs()[0];
		    PreparedStatement countStatement = connection.prepareStatement(countSql);
		    ParameterHandler parameterHandler = 
		    		(ParameterHandler) metaObject.getValue("delegate.parameterHandler");
		    parameterHandler.setParameters(countStatement);
		    ResultSet rs =countStatement.executeQuery();
		    
		    Map<String,Object> commandMap = (Map<String, Object>)boundSql.getParameterObject();
		    Page page = (Page) commandMap.get("page");
		    int temp = 0;
		    if(rs.next()){
		    	temp = rs.getInt(1);
		    }
		    
		    page.setTotleNum(temp);
		    page.count();
		    String pageSql = sql+" limit "+page.getDbIndex()+","+page.getDbNum();
		    metaObject.setValue("delegate.boundSql.sql", pageSql);
		    
		}
		
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		
		
	}

}
