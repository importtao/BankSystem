package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



//import LoginView.LoginView;
import model.Card;
import dao.Carddao;

public class XiugaiView {
	//JComboBox c1 = new JComboBox();
		String welcom = "尊敬的欢迎使用SS银行模拟系统";
		JComboBox c1 = new JComboBox();
		String usn;
		JLabel l1 = new JLabel(welcom);
		ImageJpanel p1 = new ImageJpanel();
		JButton b1 = new JButton("返回");
		JButton b8 = new JButton("添加银行卡");
		JButton b2 = new JButton("查询");
		JButton b3 = new JButton("取款");
		JButton b4 = new JButton("存款");
		JButton b6 = new JButton("转账");
		JButton b5 = new JButton("修改");
		JButton b7 = new JButton("退出");
		JFrame f = new JFrame("修改");
		 XiugaiView(String s) throws SQLException{
			 	usn = s;
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
				 //p1.add(l1);
				 //l1.setBounds(200,0, 250, 50);
				 //l1.setBounds(200,0, 250, 50);
				 Carddao cd = new Carddao();
				 c1.addItem("请选择银行卡号");
				 List<Card> result1 =cd.select(s);
				 for(int i =0;i<result1.size();i++){
					 Card c12 = result1.get(i);
					 c1.addItem(c12.getCard_number()); 
				 }
				 p1.add(c1);
				 c1.setBounds(200,20, 200, 30);
				 p1.add(b8);
				 b8.setBounds(110, 70, 240, 30);
				 p1.add(b2);
				 b2.setBounds(110, 110, 240, 30);
				 p1.add(b3);
				 b3.setBounds(110, 150, 240, 30);
				 p1.add(b6);
				 b6.setBounds(110, 230, 240, 30);
				 p1.add(b5);
				 b5.setBounds(110, 270, 240, 30);
				 p1.add(b4);
				 b4.setBounds(110, 190, 240, 30);
				 p1.add(b1);
				 b1.setBounds(0,0, 60, 30);
				 p1.add(b7);
				 b7.setBounds(110, 310, 240, 30);
				 b1.addActionListener(new ActionListener() {          //返回按钮
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							LoginView l1 = new LoginView();
						}
					});
				 b2.addActionListener(new ActionListener() {          //查询按钮
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							System.out.print(sss);
							if(sss.equals("请选择银行卡号")){
								JOptionPane.showMessageDialog(null,"请选择银行卡号 ！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
							f.dispose();
							try {
								System.out.print(sss);
								SelectView l1 = new SelectView(sss);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}}
						}
					});
				 b8.addActionListener(new ActionListener() {          //添加银行卡按钮
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							String sss = usn;
							System.out.print(sss);
							AddCardView l1 = new AddCardView(sss);
						}
					});
				 b3.addActionListener(new ActionListener() {          //取款按钮
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							//System.out.print(sss);
							if(sss.equals("请选择银行卡号")){
								JOptionPane.showMessageDialog(null,"请选择银行卡号 ！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
							f.dispose();
							try {
								//System.out.print(sss);
								QukuanView l1 = new QukuanView(sss);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}}
						}
					});
				 b4.addActionListener(new ActionListener() {          //存款按钮
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							//System.out.print();
							if(sss.equals("请选择银行卡号")){
								JOptionPane.showMessageDialog(null,"请选择银行卡号 ！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
								f.dispose();
								try {
									CunKuanView cun = new CunKuanView(sss);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});
				 b6.addActionListener(new ActionListener() {          //转账按钮
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();//卡号
							//System.out.print(sss);
							if(sss.equals("请选择银行卡号")){
								JOptionPane.showMessageDialog(null,"请选择银行卡号 ！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
								f.dispose();
								try {
									TranslateView trs = new TranslateView(sss);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});
				 b5.addActionListener(new ActionListener() {          //修改按钮
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							System.out.print(sss);
							if(sss.equals("请选择银行卡号")){
								JOptionPane.showMessageDialog(null,"请选择银行卡号 ！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
							}
						}
					});
				 b7.addActionListener(new ActionListener() {          //退出按钮
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
						}
					});
		} 
}
