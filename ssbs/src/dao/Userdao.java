package dao;

import java.sql.*;
import java.util.Date;
import java.util.concurrent.locks.Condition;

import model.User;
import db.DbUtl;

public class Userdao {
public boolean addNewUser(User u1) throws Exception   {     //注册新用户
	Connection con = DbUtl.getConnection();
	String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,current_date(),?);";
	 PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, u1.getUser_name());
			ps1.setString(2, u1.getPassword());
			ps1.setString(3, u1.getName());
			ps1.setString(4, u1.getId_num());
			ps1.setString(5, u1.getSex());
			ps1.setString(6, u1.getAddress());
			ps1.setString(7, u1.getEmail());
			ps1.setString(8, u1.getTel());
	//ps1.setDate(2, (java.sql.Date) new Date());
	boolean rs1 = true ;
	rs1 = ps1.execute();
	if(!rs1){System.out.println("charu");}
	return rs1;
}
public boolean updateUser(){
	return false;
}
public boolean LoginCheck(User u1) throws Exception{      //登录检查
	Connection con = DbUtl.getConnection();
	String sql = "select * from user where ` 用户名`=?  AND `密码`=? ";
	 PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, u1.getUser_name());
			ps1.setString(2, u1.getPassword());
	//ps1.setDate(2, (java.sql.Date) new Date());
			ResultSet rs=ps1.executeQuery();
			//当rs有值的话返回true
			boolean b = rs.next();
			return b;
			
}
}
