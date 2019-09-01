package gui;
 
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

import gui.UserForm;
 
//监听事件
public class LoginListener implements ActionListener{
	
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	private javax.swing.JTextField frAccountTextField;//账号输入框对象
	private javax.swing.JPasswordField frPasswordField;//密码输入框对象
	
	private javax.swing.JFrame login;//定义一个窗体对象
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//获取登录界面
		this.frAccountTextField=jt;//获取登录界面中的账号输入框对象
		this.frPasswordField=jp;//获取登录界面中的密码输入框对象
	}
 
	public void actionPerformed(ActionEvent loginEvent) {
		//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
		
		Connection con = null;
        PreparedStatement pst = null;
        ResultSet result = null;
        try {
	           Class.forName(cfn);
	           con = DriverManager.getConnection(url,"sa","123456");
	          
	           String passwordSQL = "select * from 学生用户 where 学号 = "+frAccountTextField.getText();
	           pst = con.prepareStatement(passwordSQL);
	           result = pst.executeQuery();
	           
	           if(result.next()){
	                 String passWord = result.getString("密码");
	                 String name = result.getString("姓名");
	                 if(String.valueOf(frPasswordField.getPassword()).equals(passWord)){
	     	       		
	     	       		//满足条件，则生成一个新的界面
	              
	     	       		UserForm uf=new UserForm(name,frAccountTextField.getText(),kind.Student);
	     	       		uf.showUI();
	     	       		
	     	       		// 通过我们获取的登录界面对象，用dispose方法关闭它
	     	       		login.dispose();
	     	       		}
	                 else
	                	 JOptionPane.showMessageDialog(null,"用户名或密码错误！",null,JOptionPane.ERROR_MESSAGE);
	                 
	           }
	           else{
	        	   if(result != null) 
	        		   result.close();
	        	   
	        	   passwordSQL = "select * from 教师用户 where 教师编号 = "+frAccountTextField.getText();
		           pst = con.prepareStatement(passwordSQL);
		           result = pst.executeQuery();
		           
		           if(result.next()){
		                 String passWord = result.getString("教师密码");
		                 String name = result.getString("教师姓名");
		                 if(String.valueOf(frPasswordField.getPassword()).equals(passWord)){
		     	       		
		     	       		//满足条件，则生成一个新的界面
		              
		     	       		UserForm uf=new UserForm(name,frAccountTextField.getText(),kind.Teacher);
		     	       		uf.showUI();
		     	       		
		     	       		// 通过我们获取的登录界面对象，用dispose方法关闭它
		     	       		login.dispose();
		                 }
		                 else
		                	 JOptionPane.showMessageDialog(null,"用户名或密码错误！",null,JOptionPane.ERROR_MESSAGE);
		           }
		           else
		        	   JOptionPane.showMessageDialog(null,"用户名不存在！",null,JOptionPane.ERROR_MESSAGE);
	                 
	           }
	       } catch (Exception e) {
           // TODO: handle exception
	    	  e.printStackTrace();
       }finally{
           try {
        	   if(result != null) result.close();
               if(pst != null) con.close();
               if(con != null) con.close();
           } catch (Exception e2) {
               // TODO: handle exception
               e2.printStackTrace();
           }
       }
		
		
	}
}