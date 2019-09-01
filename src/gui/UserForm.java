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
		uf.setTitle("������["+accountName+"]");
		uf.setSize(340,500);//ֻ�Զ���������Ч
		uf.setDefaultCloseOperation(3);//����ر�ʱ��������
		uf.setLocationRelativeTo(null);//����
		uf.setResizable(false);
		uf.setVisible(true);
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,200,30);
		uf.setLayout(fl);//���ö��������Ĳ���Ϊ��ʽ����
		
		java.awt.Dimension dimLabel=new java.awt.Dimension(300, 50);
		java.awt.Dimension dimButton=new java.awt.Dimension(150, 40);//��ť�Ĵ�С	
		
		JLabel labname=new JLabel();
		labname.setText("�˺����ͣ�"+k);
		labname.setPreferredSize(dimLabel);
		uf.add(labname);
		
		javax.swing.JButton signButton=new javax.swing.JButton();
		signButton.setText(k==kind.Teacher?"ǩ����Ƭ":"�ҵ���Ƭ");
		signButton.setPreferredSize(dimButton);
		uf.add(signButton);
		
		javax.swing.JButton inquireButton=new javax.swing.JButton();
		inquireButton.setText("�ҵ���Ϣ");
		inquireButton.setPreferredSize(dimButton);
		uf.add(inquireButton);
		
		javax.swing.JButton worksButton=new javax.swing.JButton();
		worksButton.setText("�ҵ���ҵ(δ����)");
		worksButton.setPreferredSize(dimButton);
		uf.add(worksButton);
		
		javax.swing.JButton testButton=new javax.swing.JButton();
		testButton.setText("�ҵĿ���(δ����)");
		testButton.setPreferredSize(dimButton);
		uf.add(testButton);
		
		InquireInfogui ii=new InquireInfogui(accountName,accountNum,k);
		FaceRecognitionGUI fr=new FaceRecognitionGUI(accountName,accountNum,k);
		
		signButton.addActionListener(fr);
		inquireButton.addActionListener(ii);
	}

	
}
