package com.laurel.database;

import java.sql.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class ShowTree
{
	public static void main(String[] args) 
	{
         Tree_View myTree;
         myTree=new Tree_View();
	}
}


class Tree_View extends JFrame 
{
//odbc驱动
//      String DBDriver="sun.jdbc.odbc.JdbcOdbcDriver";
//access驱动
      String DBDriver="com.hxtt.sql.access.AccessDriver";
//odbc连接
//      String connectionStr="jdbc:odbc:CKconn";   
//jdbc直连
      String connectionStr="jdbc:access:////C://ck.mdb";
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      JTree myTree;

      public Tree_View()
      {super("目录树演示");
       setSize( 500, 500 ); 
       if (linkDatabase())
         createTree();    
       setVisible(true);
       addWindowListener( new WindowAdapter(){ public void windowClosing(WindowEvent e) {
                                closeDatabase();
                            }
                         } 
                       );  
      }

      public boolean linkDatabase()  
      {
       try{
           Class.forName(DBDriver);	 //加载驱动器
           con=DriverManager.getConnection(connectionStr,"","");
	   stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);   //创建Statement对象
          }
       //捕获加载驱动程序异常
       catch ( ClassNotFoundException cnfex )
          { 
           System.err.println("装载 JDBC/ODBC 驱动程序失败。" ); 
	   return(false);
          } 
      //捕获连接数据库异常
      catch ( SQLException sqlex ) 
         { 
           System.err.println( "无法连接数据库" ); 
	   return(false);
         } 
      return(true);
      }

  
    public void createTree()
    {
       DefaultMutableTreeNode[] aNode=new DefaultMutableTreeNode[7];
       String curHH="",curMC;
       int dotCount=0;
    try{
        rs=stmt.executeQuery("select * from clggb order by hh");  //查询表
  	while(rs.next())         //显示所有记录
	  {
           curHH=rs.getString("hh").trim();
           curMC=rs.getString("mc").trim();
           dotCount=curHH.length()/2;
           System.out.println(dotCount+"="+curHH+":"+curMC+"\n");
           if (dotCount==0)
             aNode[0]=new DefaultMutableTreeNode(curHH+":"+curMC);
           else
             {
              aNode[dotCount]=new DefaultMutableTreeNode(curHH+":"+curMC);
              aNode[dotCount-1].add(aNode[dotCount]);
             }

	  };
      }
    catch(Exception e)
      {
         System.err.println( "数据库出错" ); 
         System.exit( 1 );  // terminate program 
     }
    Container c = getContentPane(); 
    myTree = new JTree(aNode[0]);
    c.add(new JScrollPane(myTree));
//    MyDefaultTreeCellRenderer x = new MyDefaultTreeCellRenderer();
//    tree.setCellRenderer(x)       //用于设置结点图标
   }

    public void closeDatabase() 
     {
     try{
        if (stmt!=null)stmt.close();  //关闭语句
        if (con!=null) con.close();   //关闭连接
       }
     catch(Exception e)
       {
         System.err.println( "数据库出错" ); 
         System.exit( 1 );  // terminate program 
       }
    }
}


/*设置结点图标
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyDefaultTreeCellRenderer extends DefaultTreeCellRenderer {
 public MyDefaultTreeCellRenderer() {
 }
 public Component getTreeCellRendererComponent(JTree tree, Object value,
   boolean sel, boolean expanded, boolean leaf, int row,
   boolean hasFocus) {
  super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
    row, hasFocus);  
  Icon test = new ImageIcon("./images/test.jpg");
  Icon test1 = new ImageIcon("./images/test1.jpg");
  Icon test2 = new ImageIcon("./images/test2.jpg");
  Icon test3 = new ImageIcon("./images/test3.jpg");  if (leaf) {
   DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
   String str = value.toString();
   if (str.equals("自由飞翔")) {
    this.setIcon(test1);
   } else if (str.equals("我行我素")) {
    this.setIcon(test2);
   } else {
    this.setIcon(test3);
   }  } else {
   if (expanded) {
    this.setIcon(test);
   } else {
    this.setIcon(test);
   }
  }
  this.setText(value.toString());
  return this;
 }
}
*/

