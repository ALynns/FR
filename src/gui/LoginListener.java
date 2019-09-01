package gui;
 
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

import gui.UserForm;
 
//�����¼�
public class LoginListener implements ActionListener{
	
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	private javax.swing.JTextField frAccountTextField;//�˺���������
	private javax.swing.JPasswordField frPasswordField;//������������
	
	private javax.swing.JFrame login;//����һ���������
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//��ȡ��¼����
		this.frAccountTextField=jt;//��ȡ��¼�����е��˺���������
		this.frPasswordField=jp;//��ȡ��¼�����е�������������
	}
 
	public void actionPerformed(ActionEvent loginEvent) {
		//����get��������ȡ�˺ź����������ı���Ϣ������equal���������жϡ���ò�Ҫ��==����==����ط���֤����ȥ��
		
		Connection con = null;
        PreparedStatement pst = null;
        ResultSet result = null;
        try {
	           Class.forName(cfn);
	           con = DriverManager.getConnection(url,"sa","123456");
	          
	           String passwordSQL = "select * from ѧ���û� where ѧ�� = "+frAccountTextField.getText();
	           pst = con.prepareStatement(passwordSQL);
	           result = pst.executeQuery();
	           
	           if(result.next()){
	                 String passWord = result.getString("����");
	                 String name = result.getString("����");
	                 if(String.valueOf(frPasswordField.getPassword()).equals(passWord)){
	     	       		
	     	       		//����������������һ���µĽ���
	              
	     	       		UserForm uf=new UserForm(name,frAccountTextField.getText(),kind.Student);
	     	       		uf.showUI();
	     	       		
	     	       		// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
	     	       		login.dispose();
	     	       		}
	                 else
	                	 JOptionPane.showMessageDialog(null,"�û������������",null,JOptionPane.ERROR_MESSAGE);
	                 
	           }
	           else{
	        	   if(result != null) 
	        		   result.close();
	        	   
	        	   passwordSQL = "select * from ��ʦ�û� where ��ʦ��� = "+frAccountTextField.getText();
		           pst = con.prepareStatement(passwordSQL);
		           result = pst.executeQuery();
		           
		           if(result.next()){
		                 String passWord = result.getString("��ʦ����");
		                 String name = result.getString("��ʦ����");
		                 if(String.valueOf(frPasswordField.getPassword()).equals(passWord)){
		     	       		
		     	       		//����������������һ���µĽ���
		              
		     	       		UserForm uf=new UserForm(name,frAccountTextField.getText(),kind.Teacher);
		     	       		uf.showUI();
		     	       		
		     	       		// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
		     	       		login.dispose();
		                 }
		                 else
		                	 JOptionPane.showMessageDialog(null,"�û������������",null,JOptionPane.ERROR_MESSAGE);
		           }
		           else
		        	   JOptionPane.showMessageDialog(null,"�û��������ڣ�",null,JOptionPane.ERROR_MESSAGE);
	                 
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