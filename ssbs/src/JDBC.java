


import java.sql.*;

public class JDBC {



  public static void main(String args[]) throws SQLException, ClassNotFoundException   {
	 Class.forName("com.mysql.jdbc.Driver");//加载驱动
	 
	 Connection  con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	  //获取连接
	 Statement ps1= con.createStatement();
	 /*ResultSet rs1=ps1.executeQuery("select * from user;");//*/
	  boolean rs1=ps1.execute("INSERT INTO user VALUES('koro','123','童扬','4',5,'6','7',0000-00-00,9);");
  
  
  }
 
	 
}  

  

