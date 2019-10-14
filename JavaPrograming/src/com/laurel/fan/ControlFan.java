package com.laurel.fan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ControlFan extends JFrame {
	JTextField speed,timing;
	String s;
	int sp;
	JPanel switchPanel,timingPanel,adjustPanel,statePanel,fanPanel,controlPanel;
	JLabel v,t;
	FanPanel left;
	ControlPanel right;
	ImageIcon[] imgs= {
			new ImageIcon("E:\\60\\图片1.png"),
			new ImageIcon("E:\\60\\图片2.png"),
			new ImageIcon("E:\\60\\图片3.png"),
			new ImageIcon("E:\\60\\图片4.png"),
			new ImageIcon("E:\\60\\图片5.png"),
			new ImageIcon("E:\\60\\图片6.png")
	
	};
	int index;
	FanPic fp;
	Timer timer;
	boolean IsOn=false;
	
	ActionListener timeListener=new TimingListen();
	public ControlFan() {
		super("遥控风扇");
		init();
	}
	private void init() {
		left=new FanPanel();
		right=new ControlPanel();
		fp=new FanPic();
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(fp,BorderLayout.CENTER);
		pack();
		this.setBounds(0,0,680,360);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//风扇面板
	class FanPanel extends JPanel{
		public FanPanel() {
			//开关
			switchPanel=new JPanel();
			switchPanel.setPreferredSize(new Dimension(180,63));//(width,height)
			switchPanel.setBorder(new TitledBorder("开关"));
			addButton(switchPanel,"开",new Switch());
			addButton(switchPanel,"关",new Switch());
			//定时
			timingPanel=new JPanel();
			timingPanel.setPreferredSize(new Dimension(180,63));
			timingPanel.setBorder(new TitledBorder("定时"));
			addButton(timingPanel,"+30",new TimeChange());
			addButton(timingPanel,"-30",new TimeChange());
			//调速
			adjustPanel=new JPanel();
			adjustPanel.setPreferredSize(new Dimension(180,63));
			adjustPanel.setBorder(new TitledBorder("调速"));
			addButton(adjustPanel,"1",new Speed());
			addButton(adjustPanel,"2",new Speed());
			addButton(adjustPanel,"3",new Speed());
			//状态
			statePanel=new JPanel(new FlowLayout(1,1,1));
			statePanel.setPreferredSize(new Dimension(180,73));
			statePanel.setBorder(new TitledBorder("状态"));
			speed=new JTextField(11);
			timing=new JTextField(11);
			v=new JLabel("速度：");
			statePanel.add(v);
			statePanel.add(speed);
			t=new JLabel("定时：");
			statePanel.add(t,BorderLayout.SOUTH);
			statePanel.add(timing);
			timing.addActionListener(timeListener);
			fanPanel=new JPanel(new FlowLayout());
			fanPanel.setPreferredSize(new Dimension(200,310));
			fanPanel.setBorder(new TitledBorder("风扇面板"));
			fanPanel.add(switchPanel,BorderLayout.NORTH);
			fanPanel.add(timingPanel);
			fanPanel.add(adjustPanel);
			fanPanel.add(statePanel);
			this.add(fanPanel);
		}
	}
	//遥控器面板
	class ControlPanel extends JPanel{
		public ControlPanel() {
			switchPanel=new JPanel();
			switchPanel.setPreferredSize(new Dimension(180,63));
			switchPanel.setBorder(new TitledBorder("开关"));
			addButton(switchPanel,"开",new Switch());
			addButton(switchPanel,"关",new Switch());
			timingPanel=new JPanel();
			timingPanel.setPreferredSize(new Dimension(180,63));
			timingPanel.setBorder(new TitledBorder("定时"));
			addButton(timingPanel,"+30",null);
			addButton(timingPanel,"-30",null);
			adjustPanel=new JPanel();
			adjustPanel.setPreferredSize(new Dimension(180,63));
			adjustPanel.setBorder(new TitledBorder("调速"));
			addButton(adjustPanel,"1",new Speed());
			addButton(adjustPanel,"2",new Speed());
			addButton(adjustPanel,"3",new Speed());
//			controlPanel=new JPanel(new GridLayout(3,3,0,3));
			controlPanel=new JPanel(new FlowLayout());
			controlPanel.setPreferredSize(new Dimension(200,310));
			controlPanel.setBorder(new TitledBorder("遥控器面板"));
			controlPanel.add(switchPanel,BorderLayout.NORTH);
			controlPanel.add(timingPanel);
			controlPanel.add(adjustPanel);
			this.add(controlPanel);
		}
	}
	//图片放置
	class FanPic extends JPanel{
		 public void paint(Graphics g) { 
	            super.paint(g); //重写需要先调用这个
	            g.drawImage(imgs[index%imgs.length].getImage(), 1, 46,this); 
	            index++;
	        }
	}
	class FanTask extends TimerTask{
		public void run() {
			fp.repaint();
			IsOn=true;
		}
	}
	class StopTask extends TimerTask{
		public void run() {
			timer.cancel();
			IsOn=false;
		}
	}
	//按钮监听
		private void addButton(JPanel panel,String name,ActionListener action) {
			JButton button=new JButton(name);
			panel.add(button);
			button.addActionListener(action);
		}
		//开关按钮
		class Switch implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String str=e.getActionCommand();
				if(str=="开") {
					if(IsOn==true) {
						
					}else if(IsOn==false) {
					/*timer = new Timer(200,fanmove);
					timer.start();*/
					timer=new Timer();
					timer.schedule(new FanTask(),0,200);
					IsOn=true;
					}
				}else if(str=="关") {
					timer.cancel();
					IsOn=false;
				}
			}
		}
		//调速按钮
		class Speed implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String str=e.getActionCommand();
				if(str=="1") {
					if(IsOn==true) {
					  timer.cancel(); timer=new Timer();
						timer.schedule(new FanTask(),0,200);
					}else if(IsOn==false) {
					timer=new Timer();
					timer.schedule(new FanTask(),0,200);
					}
				}else if(str=="2"){
					if(IsOn==true) {
						timer.cancel();
						timer=new Timer();
						timer.schedule(new FanTask(),0,60);
					}else if(IsOn==false) {
						timer=new Timer();
						timer.schedule(new FanTask(),0,60);
					}
				}else if(str=="3") {
					if(IsOn==true) {
						timer.cancel();
						timer=new Timer();
						timer.schedule(new FanTask(),0,6);
					}else if(IsOn==false) {
					timer=new Timer();
					timer.schedule(new FanTask(),0,6);
					}
				}
			}
		}
		//定时文本框
		class TimingListen implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String str=e.getActionCommand();
				s=speed.getText().toString();
				if(s!=null&&s.length()>0) {
					sp=Integer.parseInt(s);
				}else if(s==null) {
				}
				if(IsOn==true) {
					timer.cancel();
					timer=new Timer();
					timer.schedule(new FanTask(),0,sp);
					timer.schedule(new StopTask(),Integer.parseInt(str));
				}else if(IsOn==false) {
					timer=new Timer();
					timer.schedule(new FanTask(),0,sp);
					timer.schedule(new StopTask(),Integer.parseInt(str));
				}
			}
		}
		//定时按钮
		class TimeChange implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String str=e.getActionCommand();
				if(str=="+30") {
					
				}else if(str=="-30") {
					
				}
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ControlFan().setVisible(true);
	}

}
