package entity;

import util.FixData;

/*
 * 分页的实体类
 */
public class Page implements FixData{
	/*
	 * 总条数
	 */
	private int totleNum;
	/*
	 * 总的页数
	 */
	private int totlePage;
	/*
	 *当前页数 
	 */
	private int currentPage;
	/*
	 * 每页显示条数
	 */
	private int eachPageNum=EACH_PAGE_NUM;
	private int dbIndex;
	private int dbNum;
	
	 /*
	  * 根据总条数算出总页数
	  */
	public void count(){
		int totlePageTemp = this.totleNum/this.eachPageNum;
		
		int plus = (this.totleNum % this.eachPageNum==0?0:1);
		
		this.totlePage = totlePageTemp+plus;
		if(this.totlePage<=0){
			this.totlePage=1;
		}
		
		if(this.totlePage<this.currentPage){
			this.currentPage=this.totlePage;
		}
		
		if(this.currentPage<=0){
			this.currentPage=1;
		}
		
		this.dbIndex = (this.currentPage-1)*this.eachPageNum;
        this.dbNum = this.eachPageNum;		
		
	}
	public int getTotleNum() {
		return totleNum;
	}
	public void setTotleNum(int totleNum) {
		this.totleNum = totleNum;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	
	}
	public int getEachPageNum() {
		return eachPageNum;
	}
	public void setEachPageNum(int eachPageNum) {
		this.eachPageNum = eachPageNum;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNum() {
		return dbNum;
	}
	public void setDbNum(int dbNum) {
		this.dbNum = dbNum;
	}

}
