package model;

import java.util.Date;

public class User {
	private String password=null;
	private String user_name=null;
	private String name=null;
	private String id_num=null;
	private String sex=null;
	//private Date birthday;
	private String address=null;
	private String email=null;
	private Date create_date=null;
	private String tel=null;
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id) {
		this.id_num = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
