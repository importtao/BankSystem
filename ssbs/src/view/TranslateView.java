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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Card;
import dao.Carddao;

public class TranslateView {
	//JComboBox c1 = new JComboBox();
		String welcom = "尊敬的欢迎使用SS银行模拟系统";
		String kh;//卡号
		String usn;//户主
		int yu;//余额
		JLabel b2 = new JLabel("请输入卡号：");
		ImageJpanel p1 = new ImageJpanel();
		JButton b1 = new JButton("返回");
		JButton b8 = new JButton("转账");
		JTextField b3 = new JTextField();
		JLabel b4 = new JLabel("请输入转账额：");
		JTextField b5 = new JTextField();
		JFrame f = new JFrame("转账");
		 public TranslateView(String kh1) throws SQLException{
			 	 kh = kh1;
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
				 p1.add(b2);
				 b2.setBounds(180, 110, 240, 30);
				 p1.add(b3);
				 b3.setBounds(110, 150, 240, 30);
				 p1.add(b5);
				 b5.setBounds(110, 230, 240, 30);
				 b3.setFont(new Font("f2",20,20));
				 b5.setFont(new Font("f2",20,20));
				 p1.add(b4);
				 b4.setBounds(180, 190, 240, 30);
				 p1.add(b1);
				 b1.setBounds(0,0, 60, 30);
				 p1.add(b8);
				 b8.setBounds(160, 280, 140, 30);
				 Carddao cd1 = new Carddao();
					//List<Card> result12 =cd1.selectAll("1234567890");
					List<Card> result1 = cd1.selectAll(kh);
					Card c = result1.get(0);
					usn = c.getUser_name();
					//kh = c.getCard_number();
					yu = c.getYue();
					System.out.print("zhuanz");
				 b1.addActionListener(new ActionListener() {          //返回按钮
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							try {
								MainView l1 = new MainView(usn);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				
				 b8.addActionListener(new ActionListener() {          //转账按钮
						
						public void actionPerformed(ActionEvent e) {
							String dkh = b3.getText(); //对方卡号
							Integer je=0; 
							try{je = je.valueOf(b5.getText());}
							catch(NumberFormatException e2){
								je = 0;
							}//转账金额}
							System.out.print(je);
							if(dkh.equals(null)){
								JOptionPane.showMessageDialog(null,"卡号不能为空！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else if(yu<je){
								JOptionPane.showMessageDialog(null,"余额不足！", "警告",JOptionPane.WARNING_MESSAGE);
							}
							else{
								Carddao cd1 = new Carddao();
								List<Card> result12 = null;
								try {
									result12 = cd1.selectAll(dkh);
									Card c = result12.get(0);
									String dun = c.getUser_name();
									int dyu = c.getYue();
									yu = yu - je;
									dyu = dyu + je;
									Carddao dao = new Carddao();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
									JOptionPane.showMessageDialog(null,"该卡号不存在！", "警告",JOptionPane.WARNING_MESSAGE);
								}
								//List<Card> result1 = cd1.selectAll(s);
								Card c = result12.get(0);
								String dun = c.getUser_name();
								int dyu = c.getYue();
								yu = yu - je;
								dyu = dyu + je;
								Carddao dao = new Carddao();
								try {
									//JOptionPane.showMessageDialog(null,dyu, "警告",JOptionPane.WARNING_MESSAGE);
									dao.update(dkh, dyu);
									//JOptionPane.showMessageDialog(null,dyu, "警告",JOptionPane.WARNING_MESSAGE);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									dao.update(kh, yu);
									JOptionPane.showMessageDialog(null,"转账成功！", "警告",JOptionPane.WARNING_MESSAGE);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									
								}
							}
						}
					});
				
		} 
}
