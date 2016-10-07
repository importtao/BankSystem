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

import org.omg.CORBA.PRIVATE_MEMBER;

import model.Card;
import model.User;
import dao.Carddao;
import dao.Userdao;

public class AddCardView {
	String usn;
	ImageJpanel p1 = new ImageJpanel();
	 JLabel l1 = new JLabel("��    �ţ�");
	 JLabel l2 = new JLabel("��    �룺");
	 JTextField card_number= new JTextField();
	 JPasswordField password = new JPasswordField();
	 JButton b1 = new JButton("ȷ��");
	 JButton b2 = new JButton("����");
	 JButton b3 = new JButton("����");
	 JFrame f = new JFrame("������п�");
	 public AddCardView(String s) {
		 usn = s;
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
		 p1.add(card_number);
		 card_number.setBounds(110, 30, 240, 30);
		 p1.add(l2);
		 l2.setBounds(40, 70, 60, 30);
		 p1.add(password);
		 password.setBounds(110, 70, 240, 30);
		 p1.add(b1);
		 b1.setBounds(190,220, 60, 30);
		 p1.add(b2);
		 b2.setBounds(530,220, 60, 30);
		 p1.add(b3);
		 b3.setBounds(0,0, 60, 30);
		 b1.addActionListener(new ActionListener() {     //��Ӱ�ť
		 public void actionPerformed(ActionEvent e) {
			 Card c = new Card();
			 c.setPassword(password.getText());
			 c.setCard_number(card_number.getText());
			 Carddao dao =new Carddao();
			 try{
				 dao.AddCard(c,usn);
			JOptionPane.showMessageDialog(null,"��ӳɹ���", "����",JOptionPane.WARNING_MESSAGE);
				
					 }
			catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(null,"���ʧ�� ��", "����",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"���ʧ�� ��", "����",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		 	}	 
		 });
		 b2.addActionListener(new ActionListener() {    //���ð�ť
				
				public void actionPerformed(ActionEvent e) {
					card_number.setText(null);
					password.setText(null);
				}
			});
		 b3.addActionListener(new ActionListener() {          //���ذ�ť
				
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
		 
	}
}
