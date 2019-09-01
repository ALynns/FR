package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;

enum kind{Teacher,Student}
public class UserForm {
	private String accountName;
	private String accountNum;
	private kind k;
	
	public UserForm(String name,String num,kind k){
		this.accountName=name;
		this.accountNum=num;
		this.k=k;
	}
	
	public void showUI() {
		javax.swing.JFrame uf=new javax.swing.JFrame();
		uf.setTitle("主界面["+accountName+"]");
		uf.setSize(340,500);//只对顶级容器有效
		uf.setDefaultCloseOperation(3);//窗体关闭时结束程序
		uf.setLocationRelativeTo(null);//居中
		uf.setResizable(false);
		uf.setVisible(true);
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,200,30);
		uf.setLayout(fl);//设置顶级容器的布局为流式布局
		
		java.awt.Dimension dimLabel=new java.awt.Dimension(300, 50);
		java.awt.Dimension dimButton=new java.awt.Dimension(150, 40);//按钮的大小	
		
		JLabel labname=new JLabel();
		labname.setText("账号类型："+k);
		labname.setPreferredSize(dimLabel);
		uf.add(labname);
		
		javax.swing.JButton signButton=new javax.swing.JButton();
		signButton.setText(k==kind.Teacher?"签到照片":"我的照片");
		signButton.setPreferredSize(dimButton);
		uf.add(signButton);
		
		javax.swing.JButton inquireButton=new javax.swing.JButton();
		inquireButton.setText("我的信息");
		inquireButton.setPreferredSize(dimButton);
		uf.add(inquireButton);
		
		javax.swing.JButton worksButton=new javax.swing.JButton();
		worksButton.setText("我的作业(未开放)");
		worksButton.setPreferredSize(dimButton);
		uf.add(worksButton);
		
		javax.swing.JButton testButton=new javax.swing.JButton();
		testButton.setText("我的考试(未开放)");
		testButton.setPreferredSize(dimButton);
		uf.add(testButton);
		
		InquireInfogui ii=new InquireInfogui(accountName,accountNum,k);
		FaceRecognitionGUI fr=new FaceRecognitionGUI(accountName,accountNum,k);
		
		signButton.addActionListener(fr);
		inquireButton.addActionListener(ii);
	}

	
}
