package dao;

import java.util.List;
import java.util.Map;

import bean.Command;
/*
 * 与数据库配置文件进行映射，保证传入参数的规范化
 */
public interface InterfaceCommand {
	public List<Command> queryCommandList(Command command);
	public List<Command> getCommandPage(Map<String,Object> commandMap);
	public int totleNum(Map<String,Object> commandMap);
	public List<Command> getCommandByPage(Map<String,Object> commandMap);
	public void delete(List<Command> commandList);
	public void insertOne(Command command);
}
