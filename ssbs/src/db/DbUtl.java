package db;

import java.sql.*;
import java.util.concurrent.locks.Condition;

import view.LoginView;

//import LoginView.LoginView;

public class DbUtl {
//private static final String useername = "root";
//private static final String password = "root";
//private static final String url = "jdbc:mysql://localhost:3306/test";
private  static Connection con = null;

 
public static Connection getConnection(){
	return  con;
}
static{
	try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}//加载驱动
 
try {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
  //获取连接}
public static void main(String args[]) { 
	LoginView l1 = new LoginView();
	
	}
}
	
	 
	


