package com.laurel.database;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class StudentManager extends JFrame {
	JTabbedPane tabbedPane=new JTabbedPane();
	JButton inputBtn,viewBtn;
	JTextField noField,nameField,gendarField,telField;
	JTextArea viewArea;
	JLabel noLabel,nameLabel,gendarLabel,telLabel;
	JPanel inputPanel,viewPanel,panel1,panel2;
	Connection conn;
	Statement stmt;
	InputAction inputAction=new InputAction();
	ViewAction viewAction=new ViewAction();
	public StudentManager() {
		setTitle("ѧ����Ϣ����ϵͳ");
		setBounds(0,0,500,344);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		init();
		
	}
	private void init() {
		noLabel=new JLabel("ѧ��");
		nameLabel=new JLabel("����");
		gendarLabel=new JLabel("�Ա�");
		telLabel=new JLabel("��ϵ�绰");
		noField=new JTextField(9);
		nameField=new JTextField(9);
		gendarField=new JTextField(9);
		telField=new JTextField(9);
		inputBtn=new JButton("¼��");
		viewBtn=new JButton("���");
		viewArea=new JTextArea(10,20);
		panel1=new JPanel();
		panel1.setLayout(null);
		panel2=new JPanel();
		panel2.setLayout(null);
		panel1.add(noLabel);
		panel1.add(noField);
		panel1.add(nameLabel);
		panel1.add(nameField);
		panel1.add(gendarLabel);
		panel1.add(gendarField);
		panel1.add(telLabel);
		panel1.add(telField);
		panel1.add(inputBtn);
		
		noLabel.setBounds(40,26,30,23);
		noField.setBounds(90,26,120,23);
		nameLabel.setBounds(260,26,30,23);
		nameField.setBounds(310,26,120,23);
		gendarLabel.setBounds(40,100,30,23);
		gendarField.setBounds(90,100,120,23);
		telLabel.setBounds(235,100,60,23);
		telField.setBounds(310,100,120,23);
		inputBtn.setBounds(205,180,65,25);
		
		panel2.add(viewArea);
		panel2.add(viewBtn);
		viewArea.setBounds(31,31,420,150);
		viewBtn.setBounds(205,200,65,25);
		
		inputBtn.addActionListener(inputAction);
		viewBtn.addActionListener(viewAction);
		tabbedPane.addTab("¼���¼",panel1);
		tabbedPane.addTab("�����¼",panel2);
		this.add(tabbedPane);
	}
	private void connection() {
		try {
		     Class.forName ("com.mysql.jdbc.Driver")   ;  //װ��MySQL��������
		     conn = DriverManager.getConnection  ("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf8&useSSL=false","root","root")  ;   //����MySQL���ݿ�mytest
		     stmt = conn.createStatement();    //���ִ��������stmt��
		        } catch (ClassNotFoundException e1) {
		            System.err.println("��������װ��ʧ�ܣ�");
		        } catch (SQLException e2) {
		            e2.getSQLState();
		            e2.getMessage();
		        }
	}
	private void close() {
		 try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e2) {
	            System.err.println("���������ر�");
	        }
	}
	
	class InputAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String sno = noField.getText();   //���ѧ��
			   String sname = nameField.getText();   //�������
			   String sgendar = gendarField.getText();   //����Ա�
			   String stel = telField.getText();    //�����ϵ�绰��
			   try {
			       connection();
			       String InsSQL;
			       InsSQL = "INSERT INTO student (no,name,gendar,tel)" + "VALUES(" + "'" + sno + "'," + "'" + sname + "'," + "'" + sgendar + "'," + "'" + stel +"')";  //���Ʋ���SQL����ַ���
			       int rs = stmt.executeUpdate(InsSQL);   //ִ�н��¼�¼���뵽���ݱ�student��
			       JOptionPane.showMessageDialog(null, "��¼����ӣ�");
			      } catch (SQLException e1) {
			          System.err.println(e1.getSQLState());
			      } finally {
			           close();    //�ر����ݿ�
			          }
		}
	}
	class ViewAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
			    String viewString = "";
			    connection();
			    ResultSet rs = stmt.executeQuery("SELECT * From student");
			    ResultSetMetaData rsMeta = rs.getMetaData();
			     int nums = rsMeta.getColumnCount();
			     //����ֶ����ƣ�
			     for (int i = 1; i <= nums; i++) {
			          viewString += rsMeta.getColumnName(i) + "\t";
			     }
			     viewString += "\n";
			     //������ݱ�student�ļ�¼��
			     while (rs.next()) {
			        for (int i = 1; i <= nums; i++) {
			             viewString += rs.getString(i) + "\t";
			        }
			        viewString += "\n";
			        viewArea.setText(viewString);
			      }
			    } catch (SQLException e1) {
			         System.err.println("���ѧ����¼ʧ��");
			           System.err.println(e1.getSQLState() + e1.getMessage());
			       } finally {
			           close();
			        }
		}
	}
	
	
	public static void main(String[] args) {
		new StudentManager().setVisible(true);
	}

}
