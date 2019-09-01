package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InquireInfogui implements ActionListener {
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	private String accountName;
	private String accountNum;
	private kind k;
	
	
	public InquireInfogui(String name,String num,kind k){
		this.accountName=name;
		this.accountNum=num;
		this.k=k;
	}
	
	public void actionPerformed(ActionEvent inquireInfoButtonEvent) {
		
		javax.swing.JFrame uf=new javax.swing.JFrame();
		uf.setTitle("��Ϣ��ѯ["+accountName+"]");
		uf.setSize(340,500);//ֻ�Զ���������Ч
		uf.setLocationRelativeTo(null);//����
		uf.setResizable(false);
		uf.setVisible(true);
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.LEADING,50,30);
		uf.setLayout(fl);
		java.awt.Dimension dimLabel0=new java.awt.Dimension(300, 10);
		java.awt.Dimension dimLabel1=new java.awt.Dimension(300, 60);
		
		JLabel labName=new JLabel();
		labName.setText("������"+this.accountName);
		labName.setPreferredSize(dimLabel0);
		uf.add(labName);
		
		JLabel labKind=new JLabel();
		labKind.setText("�˺����ͣ�"+k);
		labKind.setPreferredSize(dimLabel0);
		uf.add(labKind);
		
		
		Connection con = null;
        PreparedStatement pst = null;
        ResultSet result = null;
        
        if(k==kind.Student) {
	        int n=0;
	        
	        ArrayList<String> className=new ArrayList<String>();
	    	ArrayList<String> signState0=new ArrayList<String>();
	    	ArrayList<String> signState1=new ArrayList<String>();
	        
	        while(true) {
		        try {
			        Class.forName(cfn);
			        con = DriverManager.getConnection(url,"sa","123456");
			          
			        String passwordSQL = "select * from �γ̱�"+n+" where ѧ�� = "+accountNum;
			        pst = con.prepareStatement(passwordSQL);
			        result = pst.executeQuery();
			        
			        if(result.next()){
			        	className.add(result.getString("�γ�����"));
			        	signState0.add(result.getString("ǩ��0"));
			        	signState1.add(result.getString("ǩ��1"));
			        }
			        else {
			        	break;
			        }
			    } 
		        catch (Exception e) {
		            // TODO: handle exception
		        	e.printStackTrace();
		        	break;
		        }
		        finally{
		        	try {
		        		if(result != null) result.close();
		        		if(pst != null) con.close();
		        		if(con != null) con.close();
			            } 
		        	catch (Exception e2) {
		        		// TODO: handle exception
		        		e2.printStackTrace();
		        	}
		        }
		        n=n+1;
	        }
		
			JLabel labnum=new JLabel();
			labnum.setText("ѧ�ţ�"+this.accountNum);
			labnum.setPreferredSize(dimLabel0);
			uf.add(labnum);
			
			JLabel classNameLabel0=new JLabel();
			classNameLabel0.setText("<html>�γ����ƣ�"+className.get(0)+"<br>"+"ǩ��1:"+signState0.get(0)+"<br>"+"ǩ��2:"+signState0.get(1)+"</html>");
			classNameLabel0.setPreferredSize(dimLabel1);
			uf.add(classNameLabel0);
			
			JLabel classNameLabel1=new JLabel();
			classNameLabel1.setText("<html>�γ����ƣ�"+className.get(1)+"<br>"+"ǩ��1:"+signState1.get(0)+"<br>"+"ǩ��2:"+signState1.get(1)+"</html>");
			classNameLabel1.setPreferredSize(dimLabel1);
			uf.add(classNameLabel1);
        }
        else {
        	ArrayList<String> className=new ArrayList<String>();
        	try {
		        Class.forName(cfn);
		        con = DriverManager.getConnection(url,"sa","123456");
		          
		        String passwordSQL = "select * from ��ʦ�û� where ��ʦ��� = "+accountNum;
		        pst = con.prepareStatement(passwordSQL);
		        result = pst.executeQuery();
		        
		        if(result.next()){
		        	
		        	className.add(result.getString("ִ�̿γ�1"));
		        }
		    } 
	        catch (Exception e) {
	            // TODO: handle exception
	        	e.printStackTrace();
	        }
	        finally{
	        	try {
	        		if(result != null) result.close();
	        		if(pst != null) con.close();
	        		if(con != null) con.close();
		            } 
	        	catch (Exception e2) {
	        		// TODO: handle exception
	        		e2.printStackTrace();
	        	}
	        }
        	
        	JLabel labnum=new JLabel();
			labnum.setText("��ʦ��ţ�"+this.accountNum);
			labnum.setPreferredSize(dimLabel0);
			uf.add(labnum);
			
			JLabel classNameLabel0=new JLabel();
			classNameLabel0.setText("ִ�̿γ����ƣ�"+className.get(0));
			classNameLabel0.setPreferredSize(dimLabel1);
			uf.add(classNameLabel0);
			
        }
		
		
	}
}
