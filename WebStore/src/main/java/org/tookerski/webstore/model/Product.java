package org.tookerski.webstore.model;

public class Product {

	private int id;
	private String title;
	private String image;
	private Double price;
	private Double buyPrice;
	private String summary;
	private String detail;
	private boolean isBuy;
	private boolean isSell;
	private long buyTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}

	public long getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}

	@Override
	public boolean equals(Object obj){
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id==0){
			if (other.id!=0)
				return false;
		}else if(!(id==other.id))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id==0)?0:id);
		return result;
	}
	@Override
	public String toString(){
		return "Product [productId="+id+", name="+title+"]";
	}
}
