package org.tookerski.webstore.model;

public class User {

	private int id;
	private String username;
	private String nickname;
	private int usertype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		User other = (User) obj;
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
		return "Product [productId="+id+", name="+username+"]";
	}
}
