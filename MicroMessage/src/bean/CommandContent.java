package bean;

public class CommandContent {
	private int id;
	private String content;
	private int messageId;
	private Command command;
	
	public CommandContent(){
		
	}

	
	public Command getCommand() {
		return command;
	}


	public void setCommand(Command command) {
		this.command = command;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "CommandContent [id=" + id + ", content=" + content + ", messageId=" + messageId + "]";
	}
	
	
}
