import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
//JPanel p1,p2,p3;

MainFrame(boolean var)
{
c=getContentPane();

//JOptionPane p=new JOptionPane("Welcome to Student Management System");
//JDialog d=p.createDialog("Message");

btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");

c.setLayout(new FlowLayout());

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
AddFrame a=new AddFrame();
dispose();
}
});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
ViewFrame v=new ViewFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
UpdateFrame u=new UpdateFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
DeleteFrame u=new DeleteFrame();
dispose();
}
});

btnAdd.addKeyListener(new KeyListener(){
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyCode()==KeyEvent.VK_ENTER)
{
AddFrame a=new AddFrame();
dispose();
}
}

public void keyTyped(KeyEvent ke){}
public void keyReleased(KeyEvent ke){}
});

btnView.addKeyListener(new KeyListener(){
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyCode()==KeyEvent.VK_ENTER)
{
ViewFrame a=new ViewFrame();
dispose();
}
}

public void keyTyped(KeyEvent ke){}
public void keyReleased(KeyEvent ke){}
});

btnUpdate.addKeyListener(new KeyListener(){
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyCode()==KeyEvent.VK_ENTER)
{
UpdateFrame u=new UpdateFrame();
dispose();
}

}
public void keyTyped(KeyEvent ke){}
public void keyReleased(KeyEvent ke){}
});

btnDelete.addKeyListener(new KeyListener(){
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyCode()==KeyEvent.VK_ENTER)
{
DeleteFrame d=new DeleteFrame();
dispose();
}
}

public void keyTyped(KeyEvent ke){}
public void keyReleased(KeyEvent ke){}
});

this.addWindowListener(new WindowListener(){
public void windowActivated(WindowEvent we){}
public void windowDeactivated(WindowEvent we){}
public void windowIconified(WindowEvent we){}
public void windowDeiconified(WindowEvent we){}
public void windowClosed(WindowEvent we){}

public void windowOpened(WindowEvent we)
{
if(var)
{
 JOptionPane.showMessageDialog(c,"Welcome to Student Management System");
}
}

public void windowClosing(WindowEvent we)
{
 int o=JOptionPane.showConfirmDialog(c,"Do you want to exit?","Exit?",JOptionPane.YES_NO_OPTION);
 if(o==JOptionPane.YES_OPTION)
  System.exit(1);
 else
  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
}

});

ImageIcon ic=new ImageIcon("F:/JavaKamalSir/Student-Management-System.jpg");
JLabel im=new JLabel(ic);
c.add(im);

setTitle("Student Management System");
setSize(500,280);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}

public static void main(String args[])
{
final boolean var=true;
MainFrame m=new MainFrame(var);

}
}


class DbHandler
{
public static void addStudent(int rno,String name)
{
try
{
 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","karan12345");

 String s="insert into studentgui values(?,?)";
 PreparedStatement pst=con.prepareStatement(s);

 pst.setInt(1,rno);
 pst.setString(2,name);

 int r=pst.executeUpdate();

 JOptionPane.showMessageDialog(new JDialog(),r+" record(s) inserted");
 
 con.close();
}
catch(SQLException e)
{
 JOptionPane.showMessageDialog(new JDialog(),e);
}
}

public static String viewStudent()
{
StringBuffer sb=new StringBuffer();
try
{
 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","karan12345");

 Statement st=con.createStatement();
 String s="select * from studentgui";

 ResultSet rs=st.executeQuery(s);

 while(rs.next())
 {
  int rno=rs.getInt(1);
  String name=rs.getString(2);
  sb.append("Roll No: "+rno+" and Name: "+name+"\n");
 }
 
 con.close();
}
catch(SQLException e)
{
 JOptionPane.showMessageDialog(new JDialog(),e);
}
return sb.toString();
}

public static void updateStudent(int rno,String name)
{
try
{
 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","karan12345");

 String s="update studentgui set name=? where rno=?";
 PreparedStatement ps=con.prepareStatement(s);

 ps.setString(1,name);
 ps.setInt(2,rno);

 int r=ps.executeUpdate();
 JOptionPane.showMessageDialog(new JDialog(),r+" record(s) updated");

 con.close();
}
catch(SQLException e)
{
 JOptionPane.showMessageDialog(new JDialog(),e);
}
}

public static void deleteStudent(int rno)
{
try
{
 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","karan12345");

 String s="delete from studentgui where rno=?";
 PreparedStatement ps=con.prepareStatement(s);

 ps.setInt(1,rno);

 int r=ps.executeUpdate();
 JOptionPane.showMessageDialog(new JDialog(),r+" record(s) deleted"); 

 con.close();
}
catch(SQLException e)
{
 JOptionPane.showMessageDialog(new JDialog(),e);
}
}
}



