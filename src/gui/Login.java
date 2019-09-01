package gui;


import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
 
//首先实现登录界面
public class Login {
	
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	//主函数入口
	public static void main(String args[]) {
		
		Login l=new Login();
		l.showUI();
	}
	
	public void showUI() {
		javax.swing.JFrame loginFrom=new javax.swing.JFrame();
		loginFrom.setTitle("签到登陆");
		loginFrom.setSize(340,250);//只对顶级容器有效
		loginFrom.setDefaultCloseOperation(3);//窗体关闭时结束程序
		loginFrom.setLocationRelativeTo(null);//居中
		loginFrom.setResizable(false);
 
		//选择布局类型，定义流式布局的对象,并且设置每个组件之间相隔5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,5,5);
		loginFrom.setLayout(fl);//设置顶级容器的布局为流式布局
		
		//设置格式大小
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//标签的大小
		java.awt.Dimension dim3=new java.awt.Dimension(250, 30);//输入框的大小		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//按钮的大小	
		
		//添加“账号”标签
		JLabel labname=new JLabel();
		labname.setText("账号：");
		labname.setPreferredSize(dim2);
		loginFrom.add(labname);
		
		//添加账号输入框，并添加监控事件
		JTextField frAccountTextField=new JTextField();
		frAccountTextField.setPreferredSize(dim3);
		loginFrom.add(frAccountTextField);
		
		//添加“密码”标签
		JLabel labpassword=new JLabel();
		labpassword.setText("密码：");
		labpassword.setPreferredSize(dim2);
		loginFrom.add(labpassword);
		
		//添加密码输入框，并添加监控事件
		JPasswordField frPasswordField=new JPasswordField();
		frPasswordField.setPreferredSize(dim3);
		loginFrom.add(frPasswordField);
		
		//添加一个button按钮
		javax.swing.JButton loginButton=new javax.swing.JButton();
		loginButton.setText("登录");
		loginButton.setPreferredSize(dim4);
		loginFrom.add(loginButton);
		
		loginFrom.setVisible(true);
		
		//首先实例化登录按钮监听类的对象，并把登录界面中账号和密码输入框的对象传给它
		LoginListener ll=new LoginListener(loginFrom,frAccountTextField,frPasswordField);
		//对当前窗体添加监听方法
		loginButton.addActionListener(ll);//监控按钮
		
	}
}