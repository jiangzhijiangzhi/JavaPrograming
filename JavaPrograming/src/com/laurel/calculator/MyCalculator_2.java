package com.laurel.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class MyCalculator_2 extends JFrame {
	private JTextField tf;
	private JPanel panel1,panel2,panel3,panel4;
	private JMenuBar myBar;
	private JMenu menu1,menu2,menu3;
	private JMenuItem editItem1,editItem2,help1,help2;
	private JRadioButtonMenuItem seeItem1,seeItem2;//��ѡ��
	private JCheckBoxMenuItem seeItem3;//��ѡ��
//	private ButtonGroup bgb;
//	private String back;
	private boolean IfResult=true,flag=false;
	private String oper="=";
	private double result=0;
	private Num numActionListener;
	private DecimalFormat df;
	
	public MyCalculator_2() {
		super("��ѧ������");//������
		df=new DecimalFormat("#.####");//������λС��
		this.setLayout(new BorderLayout(10,5));
		panel1=new JPanel(new GridLayout(1,3,10,20));
		panel2=new JPanel(new GridLayout(5,6,5,5));
		panel3=new JPanel(new GridLayout(5,1,5,5));
		panel4=new JPanel(new BorderLayout(5,5));
		//*******�˵���*******//
		myBar=new JMenuBar();
		menu1=new JMenu("�༭(E)");
		menu2=new JMenu("�鿴(V)");
		menu3=new JMenu("����(H)");
		menu1.setFont(new Font("����",Font.PLAIN,12));
		menu2.setFont(new Font("����",Font.PLAIN,12));
		menu3.setFont(new Font("����",Font.PLAIN,12));
		//*******�༭��*******//
		editItem1=new JMenuItem("����(C) Ctrl+C");
		editItem2=new JMenuItem("ճ��(P) Ctrl+V");
		editItem1.setFont(new Font("����",Font.PLAIN,12));
		editItem2.setFont(new Font("����",Font.PLAIN,12));
		//*******�鿴��*******//
		seeItem1=new JRadioButtonMenuItem("��ѧ��(T)");
		seeItem2=new JRadioButtonMenuItem("��׼��(S)");
		seeItem3=new JCheckBoxMenuItem("���ַ���(I)");
		seeItem1.setFont(new Font("����",Font.PLAIN,12));
		seeItem2.setFont(new Font("����",Font.PLAIN,12));
		seeItem3.setFont(new Font("����",Font.PLAIN,12));
		//*******������*******//	
		help1=new JMenuItem("��������(H)");
		help2=new JMenuItem("���ڼ�����(A)");
		help1.setFont(new Font("����",Font.PLAIN,12));
		help2.setFont(new Font("����",Font.PLAIN,12));
//		bgb=new ButtonGroup();//ѡ����
		menu1.add(editItem1);
		menu1.add(editItem2);
		menu2.add(seeItem1);
		menu2.add(seeItem2);
		menu2.addSeparator();//���һ���ָ���
		menu2.add(seeItem3);
		menu3.add(help1);
		menu3.addSeparator();
		menu3.add(help2);
		myBar.add(menu1);
		myBar.add(menu2);
		myBar.add(menu3);
		this.setJMenuBar(myBar);
		numActionListener=new Num();//ʵ�����ּ���
		//*******�ı���*******//
		tf=new JTextField();
		tf.setEditable(false);//�ı��򲻿ɱ༭
		tf.setBackground(Color.white);//�ı����򱳾�ɫ
		tf.setHorizontalAlignment(JTextField.RIGHT);//�����Ҷ���
		tf.setText("0");
		tf.setBorder(BorderFactory.createLoweredBevelBorder());
		init();//��������ʼ��
		
	}
	//*******��ʼ������/��Ӱ�ť*******//
	private void init() {
		addButton(panel1,"Backspace",new Clear(),Color.red);
		addButton(panel1,"CE",new Clear(),Color.red);
		addButton(panel1,"C",new Clear(),Color.red);
		addButton(panel2,"1/x",new Signs(),Color.magenta);
		addButton(panel2,"log",new Signs(),Color.magenta);
		addButton(panel2,"7",numActionListener,Color.blue);
		addButton(panel2,"8",numActionListener,Color.blue);
		addButton(panel2,"9",numActionListener,Color.blue);
		addButton(panel2,"��",new Signs(),Color.red);
		addButton(panel2,"n!",new Signs(),Color.magenta);
		addButton(panel2,"sqrt",new Signs(),Color.magenta);
		addButton(panel2,"4",numActionListener,Color.blue);
		addButton(panel2,"5",numActionListener,Color.blue);
		addButton(panel2,"6",numActionListener,Color.blue);
		addButton(panel2,"��",new Signs(),Color.red);
		addButton(panel2,"sin",new Signs(),Color.magenta);
		addButton(panel2,"x^2",new Signs(),Color.magenta);
		addButton(panel2,"1",numActionListener,Color.blue);
		addButton(panel2,"2",numActionListener,Color.blue);
		addButton(panel2,"3",numActionListener,Color.blue);
		addButton(panel2,"-",new Signs(),Color.red);
		addButton(panel2,"cos",new Signs(),Color.magenta);
		addButton(panel2,"x^3",new Signs(),Color.magenta);
		addButton(panel2,"0",numActionListener,Color.blue);
		addButton(panel2,"-/+",new Clear(),Color.blue);
		addButton(panel2,".",new Dot(),Color.blue);
		addButton(panel2,"+",new Signs(),Color.red);
		addButton(panel2,"tan",new Signs(),Color.magenta);
		addButton(panel2,"%",new Signs(),Color.magenta);
		addButton(panel2,"��",numActionListener,Color.orange);
		addButton(panel2,"e",numActionListener,Color.orange);
		addButton(panel2,"'",new Signs(),Color.orange);
		addButton(panel2,"=",new Signs(),Color.red);
		
		JButton btns=new JButton("������");
		btns.setBorder(BorderFactory.createLoweredBevelBorder());
		btns.setEnabled(false);//��ť���ɲ���
		btns.setPreferredSize(new Dimension(20,20));
		panel3.add(btns);//���밴ť
		addButton(panel3,"MC",null,Color.red);
		addButton(panel3,"MR",null,Color.red);
		addButton(panel3,"MS",null,Color.red);
		addButton(panel3,"M+",null,Color.red);
		panel4.add(panel1,BorderLayout.NORTH);
		panel4.add(panel2,BorderLayout.CENTER);
		this.add(tf,BorderLayout.NORTH);
		this.add(panel3, BorderLayout.WEST);
		this.add(panel4);
		pack();
		this.setResizable(false);//���ڴ�С���ɱ�
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//*******���ð�ť��ʹ�÷�ʽ*******//
	private void addButton(JPanel panel,String name,ActionListener action,Color color) {
		JButton bt=new JButton(name);
		panel.add(bt);//����������Ӱ�ť
		bt.setForeground(color);
		bt.addActionListener(action);//���Ӽ����¼�
		
	}
	//*******��������������*******//
	private void getResult(double x) {
		if(oper=="+") result+=x;
		else if(oper=="-")result-=x;
		else if(oper=="��")result*=x;
		else if(oper=="��")result/=x;
		else if(oper=="=")result=x;
		tf.setText(df.format(result));
		
	}
	//*******������ŵ��¼�����*******//
	class Signs implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//��ActionEvent�����getActionCommand()����ȡ���������¼�������ص��ַ���
			String str=e.getActionCommand();
			//��ƽ����
			if(str.equals("sqrt")) {
				double i=Double.parseDouble(tf.getText());
				if(i>=0) {
					//String.valueOf()ת��Ϊ�ַ���
					//df.format()��Ҫ������λС��
					tf.setText(String.valueOf(df.format(Math.sqrt(i))));
				}else {
					tf.setText("�������ܿ�ƽ����");
				}
			}
			//log���ö���
			else if(str.equals("log")) {
				double i=Double.parseDouble(tf.getText());
				if(i>0) {
					tf.setText(String.valueOf(df.format(Math.log(i))));
				}else {
					tf.setText("�������������");
				}
			}
			//��ٷֱ�
			else if(str.equals("%")) {
				tf.setText(df.format(Double.parseDouble(tf.getText())/100));
			}
			//����
			else if(str.equals("1/x")) {
				if(Double.parseDouble(tf.getText())==0) {
					tf.setText("��������Ϊ��");
				}else {
					tf.setText(df.format(1/Double.parseDouble(tf.getText())));
				}
			}
			//�����Һ���
			else if(str.equals("sin")) {
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.sin(i))));
			}
			//�����Һ���
			else if(str.equals("cos")) {
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.cos(i))));
			}
			//���к���
			else if(str.equals("tan")) {
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.tan(i))));
			}
			//��׳�
			else if(str.equals("n!")) {
			double i=Double.parseDouble(tf.getText());
			if((i%2==0)||(i%2==1)){
				int j=(int)i;
				for(int k=1;k<=j;k++)result*=k;
				tf.setText(String.valueOf(result));
			}else {
				tf.setText("�޷����н׳�");
			}
			}	
			//��ƽ��
			else if(str.equals("x^2")) {
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i*i)));
			}
			//������
			else if(str.equals("x^3")) {
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i*i*i)));
			}
			//�Ƕ�ת��
			else if(str.equals(" '")){
				double i=Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(i/180*Math.PI));
			}else {
				if(flag) {
					IfResult=false;
				}
				if(IfResult) {
					oper=str;
				}else {
					getResult(Double.parseDouble(tf.getText()));
					oper=str;
					IfResult=true;
				}
			}
			
		}
	}
	//�����ť���¼�����
	class Clear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();
			if(str=="C") {
				tf.setText("0");
				IfResult=true;
				result=0;
			}else if(str=="-/+") {
				double i=0-Double.parseDouble(tf.getText().trim());
				tf.setText(df.format(i));
			}else if(str=="Backspace") {
				if(Double.parseDouble(tf.getText())>0) {
					if(tf.getText().length()>1) {
						tf.setText(tf.getText().substring(0, tf.getText().length()-1));
					}else {
						tf.setText("0");
						IfResult=true;
					}
				}else {
					if(tf.getText().length()>2) {
						tf.setText(tf.getText().substring(0, tf.getText().length()-1));
					}else {
						tf.setText("0");
						IfResult=true;
					}
				}
			}else if(str=="CE") {
				tf.setText("0");
				IfResult=true;
			}
		}
	}
	//����������¼�����
	class Num implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();
			if(IfResult) {
				tf.setText("");
				IfResult=false;
			}
			if(str=="��") tf.setText(String.valueOf(Math.PI));
			else if(str=="e")tf.setText(String.valueOf(Math.E));
			else {
				tf.setText(tf.getText().trim()+str);
				if(tf.getText().equals("0")) {
					tf.setText("0");
					IfResult=true;
					flag=true;
				}
			}
		}
	}
	//С�����¼��ļ���
	class Dot implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			IfResult=false;
			if(tf.getText().trim().indexOf(".")==-1)tf.setText(tf.getText()+".");
		}
	}
	
	public static void main(String[] args) {
		new MyCalculator_2().setVisible(true);
	}
}
