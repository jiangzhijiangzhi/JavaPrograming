package com.laurel.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame {

	JTextField text;
	JPanel panel1,panel2,panel3,panel4;
	String op="=";
	double result=0;
	boolean IsResult=true;
	DecimalFormat de;
	NumInput numActionListener;
	public MyCalculator(){
		super("My Scientific Calculator");
		de=new DecimalFormat("#.#####");
//		this.setLayout(new BorderLayout(10,5));
		panel1=new JPanel(new GridLayout(1,3,10,20));
		panel2=new JPanel(new GridLayout(4,6,5,5));
		panel3=new JPanel(new GridLayout(4,1,5,5));
		panel4=new JPanel(new BorderLayout(5,5));
		numActionListener=new NumInput();
		text=new JTextField();
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setText("0");
//		text.setBorder(BorderFactory.createLoweredBevelBorder());
		init();
	}
private void init() {
		addButton(panel1,"Backspace",new Clear());
		addButton(panel1,"CE",new Clear());
		addButton(panel1,"C",new Clear());
		addButton(panel2,"MC",null);
		addButton(panel2,"7",numActionListener);
		addButton(panel2,"8",numActionListener);
		addButton(panel2,"9",numActionListener);
		addButton(panel2,"/",new SignOfOperation());
		addButton(panel2,"sqrt",new SignOfOperation());
		addButton(panel2,"MR",null);
		addButton(panel2,"4",numActionListener);
		addButton(panel2,"5",numActionListener);
		addButton(panel2,"6",numActionListener);
		addButton(panel2,"*",new SignOfOperation());
		addButton(panel2,"%",new SignOfOperation());
		addButton(panel2,"MS",null);
		addButton(panel2,"1",numActionListener);
		addButton(panel2,"2",numActionListener);
		addButton(panel2,"3",numActionListener);
		addButton(panel2,"-",new SignOfOperation());
		addButton(panel2,"1/x",new SignOfOperation());
		addButton(panel2,"M+",null);
		addButton(panel2,"0",numActionListener);
		addButton(panel2,".",new Dot());
		addButton(panel2,"+/-",new SignOfOperation());
		addButton(panel2,"+",new SignOfOperation());
		addButton(panel2,"=",new SignOfOperation());
		addButton(panel3,"16",null);
		addButton(panel3,"10",null);
		addButton(panel3,"8",null);
		addButton(panel3,"2",null);
		this.add(text,BorderLayout.NORTH);
		panel4.add(panel1,BorderLayout.NORTH);
		panel4.add(panel2,BorderLayout.CENTER);
		panel4.add(panel3,BorderLayout.WEST);
		this.add(panel4);
		pack();
		this.setLocation(520,260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
private void addButton(JPanel panel,String name,ActionListener action) {
		JButton button=new JButton(name);
		panel.add(button);
		button.addActionListener(action);
		
	}
//¼Ó¼õ³Ë³ý²Ù×÷
public	void arithmatic(double d) {
	if(op=="+")result+=d;
	else if(op=="-")result-=d;
	else if(op=="*")result*=d;
	else if(op=="/")result/=d;
	else if(op=="=")result=d;
	text.setText(de.format(result));
}
class Clear implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		String str=event.getActionCommand();
		if(str=="Backspace") {
			if(text.getText().length()>1)
				text.setText(text.getText().substring(0, text.getText().length()-1));
			else {
				text.setText("0");
				IsResult=true;
			}
		}else if(str=="CE"||str=="C") {
			text.setText("0");
			IsResult=true;
		}
	}
}
class NumInput implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	String str=e.getActionCommand();
	if(IsResult) {
		text.setText("");
		IsResult=false;
	}
		text.setText(text.getText()+str);
		if(text.getText().equals("0")) {
			text.setText("0");
			IsResult=true;
	}
}
}
class SignOfOperation implements ActionListener {
@Override
public void actionPerformed(ActionEvent event) {
	String str=event.getActionCommand();
	if(str.equals("sqrt")) {
		double i=Double.parseDouble(text.getText());
		if(i>=0) text.setText(String.valueOf(de.format(Math.sqrt(i))));
		else text.setText("Error");
	}else if(str.equals("%")) {
		text.setText(de.format(Double.parseDouble(text.getText())/100));
	}else if(str.equals("1/x")) {
		if(Double.parseDouble(text.getText())==0)text.setText("Error");
		else text.setText(de.format(1/Double.parseDouble(text.getText())));
	}else if(str=="+/-") {
		double i=0-Double.parseDouble(text.getText());
		text.setText(de.format(i));
	}else {
		arithmatic(Double.parseDouble(text.getText()));
		op=str;
		IsResult=true;
	}
}
}
class Dot implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	if(text.getText().indexOf(".")==-1)
		text.setText(text.getText()+".");
}

}

/*class Conversion implements ActionListener{
public void actionPerfomed(ActionEvent e) {
	String str=e.getActionCommand();
	if(str=="16") {
		
	}else if(str=="10") {
		
	}else if(str=="8") {
		
	}else if(str=="2") {
		
	}
}
}*/
public static void main(String[] args) {
new MyCalculator().setVisible(true);
}
}
