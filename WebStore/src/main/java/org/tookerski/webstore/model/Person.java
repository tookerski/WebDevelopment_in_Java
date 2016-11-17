package org.tookerski.webstore.model;

public class Person {

	private int userId;
	private String userName;
	private String password;
	private String nickName;
	private boolean userType;
	
	public Person(){
		super();
	}

	public Person(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public Person(int userId, String userName, String password, String nickName, boolean userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		Person other = (Person) obj;
		if (userId==0){
			if (other.userId!=0)
				return false;
		}else if(!(userId==other.userId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId==0)?0:userId);
		return result;
	}
	@Override
	public String toString(){
		return "Product [productId="+userId+", name="+userName+"]";
	}
}
