package gui;


import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
 
//����ʵ�ֵ�¼����
public class Login {
	
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	//���������
	public static void main(String args[]) {
		
		Login l=new Login();
		l.showUI();
	}
	
	public void showUI() {
		javax.swing.JFrame loginFrom=new javax.swing.JFrame();
		loginFrom.setTitle("ǩ����½");
		loginFrom.setSize(340,250);//ֻ�Զ���������Ч
		loginFrom.setDefaultCloseOperation(3);//����ر�ʱ��������
		loginFrom.setLocationRelativeTo(null);//����
		loginFrom.setResizable(false);
 
		//ѡ�񲼾����ͣ�������ʽ���ֵĶ���,��������ÿ�����֮�����5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,5,5);
		loginFrom.setLayout(fl);//���ö��������Ĳ���Ϊ��ʽ����
		
		//���ø�ʽ��С
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//��ǩ�Ĵ�С
		java.awt.Dimension dim3=new java.awt.Dimension(250, 30);//�����Ĵ�С		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//��ť�Ĵ�С	
		
		//��ӡ��˺š���ǩ
		JLabel labname=new JLabel();
		labname.setText("�˺ţ�");
		labname.setPreferredSize(dim2);
		loginFrom.add(labname);
		
		//����˺�����򣬲���Ӽ���¼�
		JTextField frAccountTextField=new JTextField();
		frAccountTextField.setPreferredSize(dim3);
		loginFrom.add(frAccountTextField);
		
		//��ӡ����롱��ǩ
		JLabel labpassword=new JLabel();
		labpassword.setText("���룺");
		labpassword.setPreferredSize(dim2);
		loginFrom.add(labpassword);
		
		//�����������򣬲���Ӽ���¼�
		JPasswordField frPasswordField=new JPasswordField();
		frPasswordField.setPreferredSize(dim3);
		loginFrom.add(frPasswordField);
		
		//���һ��button��ť
		javax.swing.JButton loginButton=new javax.swing.JButton();
		loginButton.setText("��¼");
		loginButton.setPreferredSize(dim4);
		loginFrom.add(loginButton);
		
		loginFrom.setVisible(true);
		
		//����ʵ������¼��ť������Ķ��󣬲��ѵ�¼�������˺ź����������Ķ��󴫸���
		LoginListener ll=new LoginListener(loginFrom,frAccountTextField,frPasswordField);
		//�Ե�ǰ������Ӽ�������
		loginButton.addActionListener(ll);//��ذ�ť
		
	}
}