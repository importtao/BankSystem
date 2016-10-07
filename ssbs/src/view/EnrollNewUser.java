package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import dao.Userdao;

public class EnrollNewUser {
	 JLabel l1 = new JLabel("用户名：");
	 JLabel l2 = new JLabel("密    码：");
	 JLabel l3 = new JLabel("姓    名：");
	 JLabel l4 = new JLabel("身份证号：");
	 JLabel l5 = new JLabel("性    别：");
	 JLabel l6 = new JLabel("地    址：");
	 JLabel l7 = new JLabel("邮    箱：");
	 JLabel l8 = new JLabel("电    话：");
	 JTextField username= new JTextField(20);
	 JPasswordField password = new JPasswordField();
	 JTextField name= new JTextField(20);
	 JTextField  id_num= new JTextField(20);;
	 JTextField sex= new JTextField(20);;
		//private Date birthday;
	 JTextField address = new JTextField(20);;
	 JTextField  email= new JTextField(20);;
	 JTextField tel= new JTextField(20);
	 ImageJpanel p1 = new ImageJpanel();
	 JButton b1 = new JButton("确认");
	 JButton b2 = new JButton("重置");
	 JButton b3 = new JButton("返回");
	 JFrame f = new JFrame("注册新用户界面");
	 EnrollNewUser(){
		 f.setLocationRelativeTo(null);
		 f.setLocation(700,400);
		 f.setSize(700,400);
		 f.setBackground(Color.gray);
		 f.setVisible(true);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.add(p1);
		 p1.setImage(new ImageIcon("./src/img/7.4.jpg").getImage());
		    GroupLayout imageJpanel1Layout = new GroupLayout(
					p1);
			p1.setLayout(imageJpanel1Layout);
		 p1.add(l1);
		 l1.setBounds(40, 30, 60, 30);
		 p1.add(username);
		 username.setBounds(110, 30, 240, 30);
		 p1.add(l2);
		 l2.setBounds(40, 70, 60, 30);
		 p1.add(password);
		 password.setBounds(110, 70, 240, 30);
		 p1.add(l3);
		 l3.setBounds(360, 30, 60, 30);
		 p1.add(name);
		 name.setBounds(430, 30, 240, 30);
		 p1.add(l4);
		 l4.setBounds(360, 70, 70, 30);
		 p1.add(id_num);
		 id_num.setBounds(430, 70, 240, 30);
		 p1.add(l5);
		 l5.setBounds(40, 110, 60, 30);
		 p1.add(l6);
		 l6.setBounds(40, 150, 60, 30);
		 p1.add(l7);
		 l7.setBounds(360, 110, 60, 30);
		 p1.add(l8);
		 l8.setBounds(360, 150, 60, 30);
		 p1.add(sex);
		 sex.setBounds(110, 110, 240, 30);
		 p1.add(address);
		 address.setBounds(110, 150, 240, 30);
		 p1.add(email);
		 email.setBounds(430, 110, 240, 30);
		 p1.add(tel);
		 tel.setBounds(430, 150, 240, 30);
		 p1.add(b1);
		 b1.setBounds(190,220, 60, 30);
		 p1.add(b2);
		 b2.setBounds(530,220, 60, 30);
		 p1.add(b3);
		 b3.setBounds(0,0, 60, 30);
		 b1.addActionListener(new ActionListener() {     //登录按钮
		 public void actionPerformed(ActionEvent e) {
			 User u = new User();
			 u.setUser_name(username.getText());
			 u.setPassword(password.getText());
			 u.setAddress(address.getText());
			 u.setName(name.getText());
			 u.setId_num(id_num.getText());
			 u.setEmail(email.getText());
			 u.setSex(sex.getText());
			 u.setTel(tel.getText());
			 Userdao dao =new Userdao();
			  try {
				dao.addNewUser(u);
				
				 JOptionPane.showMessageDialog(null,"注册成功！", "警告",JOptionPane.WARNING_MESSAGE);
				
					 }
			catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(null,"注册失败 ！", "警告",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"注册失败 ！", "警告",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		 	}	 
		 });
		 b2.addActionListener(new ActionListener() {    //重置按钮
				
				public void actionPerformed(ActionEvent e) {
					username.setText(null);
					password.setText(null);
					name.setText(null);
					id_num.setText(null);
					tel.setText(null);
					address.setText(null);
					email.setText(null);
					sex.setText(null);
					
				}
			});
		 b3.addActionListener(new ActionListener() {          //返回按钮
				
				public void actionPerformed(ActionEvent e) {
					f.dispose();
					LoginView l1 = new LoginView();
				}
			});
		 
	}
}
