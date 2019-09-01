package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FaceRecognitionGUI implements ActionListener {
	private String accountName;
	private String accountNum;
	private kind k;
	
	final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FR";
	
	public FaceRecognitionGUI(String name,String num,kind k){
		accountName=name;
		accountNum=num;
		this.k=k;
	}
	
	
	public void actionPerformed(ActionEvent inquireInfoButtonEvent) {
		javax.swing.JFrame uf=new javax.swing.JFrame();
		uf.setTitle("ǩ��["+accountName+"]");
		
		
		
		Connection con = null;
        PreparedStatement pst = null;
		
		if(k==kind.Teacher) {
			
			try{
				String command="python G:/Eclipse/facerecognitiongui/src/FR/fr.py G:/Eclipse/facerecognitiongui/src/FR/single G:/Eclipse/facerecognitiongui/src/FR/all";
				Process process= Runtime.getRuntime().exec(command);
				File resultFile = new File("G:/Eclipse/facerecognitiongui/src/FR/result/result.txt");
				InputStreamReader reader = new InputStreamReader(new FileInputStream(resultFile));
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				String list = "<html>ǩ������<br>";
				Thread.sleep(30000);
				
				uf.setSize(340,500);//ֻ�Զ���������Ч
				uf.setLocationRelativeTo(null);//����
				uf.setResizable(false);
				uf.setVisible(true);
	            line = br.readLine();
	            while (line != null) {  
	                 // һ�ζ���һ������
	                if(line.length()!= 7) {
	                	line = br.readLine();
	                	continue;
	                }
	                else {
	                	list=list+line+"<br>";
	                	Class.forName(cfn);
				        con = DriverManager.getConnection(url,"sa","123456");
				        String signSQL = "update �γ̱�0 set ǩ��0 = Yes where ѧ�� = "+line;
				        pst = con.prepareStatement(signSQL);
				        line = br.readLine();
	                }
	            } 
	            list=list+"</html>";
	            
	            
	            java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.LEADING,50,30);
	    		uf.setLayout(fl);
	            java.awt.Dimension dimLabel0=new java.awt.Dimension(300, 500);
	            JLabel labnum=new JLabel();
				labnum.setText(list);
				labnum.setPreferredSize(dimLabel0);
				uf.add(labnum);
	        }
			catch(Exception e){
	            e.printStackTrace();
	        }
		}
		else {
			
			uf.setSize(1000,600);//ֻ�Զ���������Ч
			uf.setLocationRelativeTo(null);//����
			uf.setResizable(false);
			java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.LEADING,0,30);
    		uf.setLayout(fl);
			ImageIcon icon = new ImageIcon("G:\\Eclipse\\facerecognitiongui\\src\\FR\\single\\"+accountNum+".jpg");
			// �ñ�ǩ������ͼƬ��ʵ����JLabel��ǩ���󣬸ö�����ʾiconͼ��
			JLabel labIcon = new JLabel(icon);
			//���ñ�ǩ��С
			//labIcon.setSize(30,20);setSize����ֻ�Դ�����Ч���������������Ĵ�Сֻ����
			Dimension dim = new Dimension(1000,600);
			labIcon.setPreferredSize(dim);
			// ��labIcon��ǩ��ӵ�������
			uf.add(labIcon);
			uf.setVisible(true);
		}
			
	}

}
