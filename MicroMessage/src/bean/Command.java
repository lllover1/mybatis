package bean;

import java.util.List;



public class Command {
	private int id;
	private String cname;
	private String description;
	private List<CommandContent> contentList; 
	public Command() {
		
	}

	public List<CommandContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Command [id=" + id + ", cname=" + cname + ", description=" + description + ", contentList="
				+ contentList + "]";
	}
	
	
}
