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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Card;
import dao.Carddao;

public class CunKuanView {
	String usn;   //����
	int yu;           //���
	String un;
	//JLabel l1 = new JLabel(welcom);
	ImageJpanel p1 = new ImageJpanel();
	JLabel l1 = new JLabel("��������");
	JTextField t1 = new JTextField();
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("100");
	JButton b3 = new JButton("500");
	JButton b4 = new JButton("1000");
	JButton b5 = new JButton("5000");
	JButton b6 = new JButton("���");
	
	JFrame f = new JFrame("���");
	 public CunKuanView(String s) throws SQLException{
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
			 p1.add(b2);
			 b2.setBounds(50, 40, 130, 40);
			 p1.add(b3);
			 b3.setBounds(230, 40, 130, 40);
			 p1.add(b5);
			 b5.setBounds(230, 100, 130, 40);
			 p1.add(b4);
			 b4.setBounds(50, 100, 130, 40);
			 p1.add(b1);
			 b1.setBounds(0,0, 60, 30);
			 p1.add(b6);
			 b6.setBounds(130, 240, 150, 40);
			 p1.add(l1);
			 l1.setBounds(150, 140, 150, 30);
			 p1.add(t1);
			 t1.setBounds(150, 170, 100, 50);
			 t1.setFont(new Font("f2",20,20));
			Carddao cd1 = new Carddao();
			List<Card> result12 =cd1.selectAll(s);
			List<Card> result1 = cd1.selectAll(s);
			Card c = result12.get(0);
			usn = c.getCard_number();
			yu = c.getYue();
			un = c.getUser_name();
			b1.addActionListener(new ActionListener() {          //���ذ�ť
					
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
			 b2.addActionListener(new ActionListener() {          //100��ť
					
					public void actionPerformed(ActionEvent e) {
						yu = yu+100;
							Carddao dao = new Carddao();
							try {
								dao.update(usn, yu);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null,"ȡ��ɹ� ��", "����",JOptionPane.WARNING_MESSAGE);
						
						}
					}
				);
			
			 b3.addActionListener(new ActionListener() {          //500��ť
					
					public void actionPerformed(ActionEvent e) {
						yu = yu+500;
						Carddao dao = new Carddao();
						try {
							dao.update(usn, yu);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"���ɹ� ��", "����",JOptionPane.WARNING_MESSAGE);
					
					}
				}
				);
			 b4.addActionListener(new ActionListener() {          //1000��ť
					
					public void actionPerformed(ActionEvent e) {
						yu = yu+1000;
						Carddao dao = new Carddao();
						try {
							dao.update(usn, yu);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"���ɹ� ��", "����",JOptionPane.WARNING_MESSAGE);
					
					}
				});
			 b5.addActionListener(new ActionListener() {          //5000��ť
					
					public void actionPerformed(ActionEvent e) {
						yu = yu+5000;
						Carddao dao = new Carddao();
						try {
							dao.update(usn, yu);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"���ɹ� ��", "����",JOptionPane.WARNING_MESSAGE);
					
					}
				
				});
			 b6.addActionListener(new ActionListener() {          //qukuan��ť
					
					public void actionPerformed(ActionEvent e) {
						int qukuane = Integer.valueOf(t1.getText());
						yu = yu+qukuane;
						Carddao dao = new Carddao();
						try {
							dao.update(usn, yu);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"���ɹ� ��", "����",JOptionPane.WARNING_MESSAGE);
					}
					});
			 } 
	
}
