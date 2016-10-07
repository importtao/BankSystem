package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtl;
import model.Card;

public class Carddao {
	public List<Card> select(String s1) throws SQLException{
		Connection con = DbUtl.getConnection();
		String sql = "select  `����` from card where `����`=?";
		 PreparedStatement ps1 = con.prepareStatement(sql);
		 ps1.setString(1, s1);
		 ResultSet r1 = ps1.executeQuery();
		 Card c = null;
		List<Card> result = new ArrayList<Card>();
		 while(r1.next()){
			c = new Card();
			c.setCard_number(r1.getString("����"));
			result.add(c);
		 }
		return result;
		}
	public List<Card> selectAll(String kh) throws SQLException{
		Connection con = DbUtl.getConnection();
		String sql = "select * from card where `����`='"+kh+"'";
		PreparedStatement ps1 = con.prepareStatement(sql);
		 //ps1.setString(1, s1);
		 ResultSet r1 = ps1.executeQuery();
		 Card c = null;
		List<Card> result = new ArrayList<Card>();
		 while(r1.next()){
			c = new Card();
			c.setCard_number(r1.getString("����"));
			c.setCreate_date(r1.getDate("��������"));
			c.setUser_name(r1.getString("����"));
			c.setYue(r1.getInt(" ���"));
			result.add(c);
			System.out.print(r1.getString("����"));
		 }
		return result;
		}
	
	public boolean AddCard(Card c,String n) throws SQLException {
		Connection con = DbUtl.getConnection();
		String sql = "INSERT INTO card VALUES (?,0,current_date(),?,'"+n+"');";
		 PreparedStatement ps1 = con.prepareStatement(sql);
				ps1.setString(1, c.getCard_number());
				ps1.setString(2, c.getPassword());
				
		//ps1.setDate(2, (java.sql.Date) new Date());
		boolean rs1 = true ;
		rs1 = ps1.execute();
		if(!rs1){System.out.println("charu");}
		return rs1;	
	}
	public void update(String kh,int yu) throws SQLException {
		Connection con = DbUtl.getConnection();
		System.out.print(kh);
		//System.out.print("ȡ��");
		//System.out.print(yu);
		String sql = "UPDATE card SET ` ���`="+yu+" WHERE `����`='"+kh+"'";
		//String sql = "UPDATE card SET ` ���`=4000 WHERE `����`='1234567890'";
		PreparedStatement ps1 = con.prepareStatement(sql);
		 //ps1.setString(1, s1);
		 int r1 = ps1.executeUpdate();
		 System.out.print(r1);
	}
	}
	

