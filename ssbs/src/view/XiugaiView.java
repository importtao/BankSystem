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
		String welcom = "�𾴵Ļ�ӭʹ��SS����ģ��ϵͳ";
		JComboBox c1 = new JComboBox();
		String usn;
		JLabel l1 = new JLabel(welcom);
		ImageJpanel p1 = new ImageJpanel();
		JButton b1 = new JButton("����");
		JButton b8 = new JButton("������п�");
		JButton b2 = new JButton("��ѯ");
		JButton b3 = new JButton("ȡ��");
		JButton b4 = new JButton("���");
		JButton b6 = new JButton("ת��");
		JButton b5 = new JButton("�޸�");
		JButton b7 = new JButton("�˳�");
		JFrame f = new JFrame("�޸�");
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
				 c1.addItem("��ѡ�����п���");
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
				 b1.addActionListener(new ActionListener() {          //���ذ�ť
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							LoginView l1 = new LoginView();
						}
					});
				 b2.addActionListener(new ActionListener() {          //��ѯ��ť
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							System.out.print(sss);
							if(sss.equals("��ѡ�����п���")){
								JOptionPane.showMessageDialog(null,"��ѡ�����п��� ��", "����",JOptionPane.WARNING_MESSAGE);
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
				 b8.addActionListener(new ActionListener() {          //������п���ť
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
							String sss = usn;
							System.out.print(sss);
							AddCardView l1 = new AddCardView(sss);
						}
					});
				 b3.addActionListener(new ActionListener() {          //ȡ�ť
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							//System.out.print(sss);
							if(sss.equals("��ѡ�����п���")){
								JOptionPane.showMessageDialog(null,"��ѡ�����п��� ��", "����",JOptionPane.WARNING_MESSAGE);
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
				 b4.addActionListener(new ActionListener() {          //��ť
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							//System.out.print();
							if(sss.equals("��ѡ�����п���")){
								JOptionPane.showMessageDialog(null,"��ѡ�����п��� ��", "����",JOptionPane.WARNING_MESSAGE);
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
				 b6.addActionListener(new ActionListener() {          //ת�˰�ť
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();//����
							//System.out.print(sss);
							if(sss.equals("��ѡ�����п���")){
								JOptionPane.showMessageDialog(null,"��ѡ�����п��� ��", "����",JOptionPane.WARNING_MESSAGE);
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
				 b5.addActionListener(new ActionListener() {          //�޸İ�ť
						
						public void actionPerformed(ActionEvent e) {
							String sss = (String) c1.getSelectedItem();
							System.out.print(sss);
							if(sss.equals("��ѡ�����п���")){
								JOptionPane.showMessageDialog(null,"��ѡ�����п��� ��", "����",JOptionPane.WARNING_MESSAGE);
							}
							else{
							}
						}
					});
				 b7.addActionListener(new ActionListener() {          //�˳���ť
						
						public void actionPerformed(ActionEvent e) {
							f.dispose();
						}
					});
		} 
}
