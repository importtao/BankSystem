package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Card;
import dao.Carddao;

public class SelectView {
	public String un;
	String title;
	ImageJpanel p1 = new ImageJpanel();
	JButton b1 = new JButton("返回");
	JTextArea j1 = new JTextArea();
	JFrame f = new JFrame("查询");
SelectView(String s) throws SQLException{
	j1.setEditable(false);
	
	f.setLocationRelativeTo(null);
	f.setLocation(700,400);
	f.setSize(450,400);
	f.setBackground(Color.gray);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.add(p1);
	p1.setImage(new ImageIcon("./src/img/45.4.jpg").getImage());
    GroupLayout imageJpanel1Layout = new GroupLayout(
			p1);
	p1.setLayout(imageJpanel1Layout);
	p1.add(b1);
	b1.setBounds(0,0, 60, 30);
	p1.add(j1);
	j1.setBounds(50, 30, 350, 200);
	j1.setVisible(true);
	j1.setColumns(5);
	j1.setLineWrap(true);
	j1.setBackground(f.getBackground());
	j1.setFont(new Font("f1",20,35));
	Carddao cd = new Carddao();
	Card c = new Card();
	Carddao cd1 = new Carddao();
	List<Card> result12 =cd1.selectAll(s);
	List<Card> result1 = cd1.selectAll(s);
	Card c123 = result12.get(0);
	un = c123.getUser_name();
Card c12 = result1.get(0);
	String n1=c12.getCard_number(); 
	String n2=c12.getUser_name();
	String n3=c12.getYue().toString();
	
	title = "卡号:"+n1+"\n"
	+"用户名："+n2+"\n"
	+"余额："+n3+"\n";
	j1.append(title);
	b1.addActionListener(new ActionListener() {          //返回按钮
	public void actionPerformed(ActionEvent e) {
						f.dispose();
						try {
							MainView l1 = new MainView(un);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
	}	 
}
