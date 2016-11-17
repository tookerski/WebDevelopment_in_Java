package org.tookerski.webstore.model;

import java.math.BigDecimal;

public class Product {

	private int id;
	private BigDecimal price;
	private String title;
	private String image;
	private String script;
	private String content;
	public Product(){
		super();
	}
	public Product(int id, BigDecimal price, String title) {
		super();
		this.id = id;
		this.price = price;
		this.title = title;
	}
	public Product(int id, BigDecimal price, String title, String image, String script, String content) {
		super();
		this.id = id;
		this.price = price;
		this.title = title;
		this.image = image;
		this.script = script;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
