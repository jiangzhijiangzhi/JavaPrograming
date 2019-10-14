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
		setTitle("学生信息管理系统");
		setBounds(0,0,500,344);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		init();
		
	}
	private void init() {
		noLabel=new JLabel("学号");
		nameLabel=new JLabel("姓名");
		gendarLabel=new JLabel("性别");
		telLabel=new JLabel("联系电话");
		noField=new JTextField(9);
		nameField=new JTextField(9);
		gendarField=new JTextField(9);
		telField=new JTextField(9);
		inputBtn=new JButton("录入");
		viewBtn=new JButton("浏览");
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
		tabbedPane.addTab("录入记录",panel1);
		tabbedPane.addTab("浏览记录",panel2);
		this.add(tabbedPane);
	}
	private void connection() {
		try {
		     Class.forName ("com.mysql.jdbc.Driver")   ;  //装载MySQL驱动程序；
		     conn = DriverManager.getConnection  ("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf8&useSSL=false","root","root")  ;   //连接MySQL数据库mytest
		     stmt = conn.createStatement();    //获得执行语句对象stmt；
		        } catch (ClassNotFoundException e1) {
		            System.err.println("驱动程序装载失败！");
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
	            System.err.println("不能正常关闭");
	        }
	}
	
	class InputAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String sno = noField.getText();   //获得学号
			   String sname = nameField.getText();   //获得姓名
			   String sgendar = gendarField.getText();   //获得性别
			   String stel = telField.getText();    //获得联系电话；
			   try {
			       connection();
			       String InsSQL;
			       InsSQL = "INSERT INTO student (no,name,gendar,tel)" + "VALUES(" + "'" + sno + "'," + "'" + sname + "'," + "'" + sgendar + "'," + "'" + stel +"')";  //定制插入SQL语句字符串
			       int rs = stmt.executeUpdate(InsSQL);   //执行将新记录插入到数据表student中
			       JOptionPane.showMessageDialog(null, "记录已添加！");
			      } catch (SQLException e1) {
			          System.err.println(e1.getSQLState());
			      } finally {
			           close();    //关闭数据库
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
			     //获得字段名称；
			     for (int i = 1; i <= nums; i++) {
			          viewString += rsMeta.getColumnName(i) + "\t";
			     }
			     viewString += "\n";
			     //获得数据表student的记录；
			     while (rs.next()) {
			        for (int i = 1; i <= nums; i++) {
			             viewString += rs.getString(i) + "\t";
			        }
			        viewString += "\n";
			        viewArea.setText(viewString);
			      }
			    } catch (SQLException e1) {
			         System.err.println("浏览学生记录失败");
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
