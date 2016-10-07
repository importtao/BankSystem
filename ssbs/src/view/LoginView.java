package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.Userdao;
import model.User;

public class LoginView  {
	public String un;
	 JTextField username= new JTextField(20);
	 JPasswordField password;
	 //JPanel p1 = new JPanel();
	 JButton b1 = new JButton("登录");
	 JButton b2 = new JButton("重置");
	 JButton b3 = new JButton("注册");
	 JFrame f = new JFrame("SS银行模拟系统");
	 ImageJpanel p1 = new ImageJpanel();
 public LoginView(){
	 f.setLocationRelativeTo(null);  //窗口居中显示
	f.setLocation(700,400);
	f.setSize(400,300);
    f.setBackground(Color.gray);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel l1=new JLabel("用户名:");
    l1.setVisible(true);
    p1.setImage(new ImageIcon("./src/img/l.jpg").getImage());
    GroupLayout imageJpanel1Layout = new GroupLayout(
			p1);
	p1.setLayout(imageJpanel1Layout);
	f.add(p1);
	p1.setBounds(0, 0, 1400, 1000);
    //l1.setLocation(200, 200);
    //final JTextField username = new JTextField(20); 
    JLabel l2=new JLabel("密    码:");
    l2.setVisible(true);
    //l2.setLocation(200, 400);
    password = new JPasswordField(20); 
    p1.setLayout(null);
    p1.add(l1);
    l1.setBounds(50, 30, 50, 30);
    p1.add(username);
    username.setBounds(110, 30, 240, 30);
    p1.add(l2);
    l2.setBounds(50, 70, 50,30);
    p1.add(password);
    password.setBounds(110, 70, 240, 30);
    p1.add(b1);
    b1.setBounds(110,120, 60, 30);
    b1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
				b1actionPerformed(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
b2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			username.setText(null);
			password.setText(null);
			
		}
	});
b3.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		//f.setVisible(false);
		f.dispose();
		EnrollNewUser E = new EnrollNewUser();
		
	}
});
    p1.add(b2);
    b2.setBounds(290,120, 60, 30);
    p1.add(b3);
    b3.setBounds(110,170,240,30);
    f.add(p1);
    p1.setVisible(true);
    p1.setBounds(0,0, 400, 400);
    String s1 =username.getText();
    f.setResizable(false);
    
  }

public void actionPerformed(ActionEvent e) {
	final String s1 =username.getText();
	
}
public void b1actionPerformed(ActionEvent e) throws SQLException   {
	String s1 =username.getText();
	String n = "";
	un = s1;
	String s2 =password.getText();
	/*if(s1.equals(n)){
		JOptionPane.showMessageDialog(null," 用户名不能为空 ！", "警告",JOptionPane.WARNING_MESSAGE);
	}
	else if(s2.equals(n)){
		JOptionPane.showMessageDialog(null," 密码不能为空 ！", "警告",JOptionPane.WARNING_MESSAGE);
	}
	else{*/
	User u2 = new User();
	u2.setUser_name(s1);
	u2.setPassword(s2);
	Userdao dao = new Userdao();
	boolean flag = false;
	try {
		flag = dao.LoginCheck(u2);
		
		
			 }
	catch (HeadlessException e1) {
		JOptionPane.showMessageDialog(null," 用户名或密码错误 ！", "警告",JOptionPane.WARNING_MESSAGE);
		e1.printStackTrace();
	} catch (Exception e1) {
		JOptionPane.showMessageDialog(null,"用户名或密码错误 ！", "警告",JOptionPane.WARNING_MESSAGE);
		e1.printStackTrace();
	}
	if(flag){
		f.dispose();
		MainView m = new MainView(un);
	}
	else{JOptionPane.showMessageDialog(null,"用户名或密码错误！", "警告",JOptionPane.WARNING_MESSAGE);}
}
}
//}	

