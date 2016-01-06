package bean;
/*
 * 与message 对应的实体类
 */

public class Message {
	//主键
	private int id;  
	//命令
	private String command;
	//命令描述
	private String description;
	//命令内容
	private String content;
	
	public Message () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
