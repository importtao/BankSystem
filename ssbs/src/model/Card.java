package model;

import java.util.Date;
import java.util.List;

public class Card {
	private String card_number;
	private Integer yue;
	private Date create_date;
	private String password;
	private String user_name;
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getYue() {
		return yue;
	}
	public void setYue(Integer yue) {
		this.yue = yue;
	}
	
	
}
