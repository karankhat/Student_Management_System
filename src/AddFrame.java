import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

public static boolean isD(String s)
{
 char a[]=s.toCharArray();
 for(char g: a)
 {
  if(Character.isDigit(g))
   return true;
 }
 return false;
}

AddFrame()
{
c=getContentPane();

c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

lblRno = new JLabel("Roll No: ");
lblName = new JLabel("Name: ");
txtRno = new JTextField(5);
txtName = new JTextField(15);
btnSave = new JButton("Save");
btnBack = new JButton("Back");

p1 = new JPanel();
p2 = new JPanel();

p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);

p2.add(btnSave);
p2.add(btnBack);

c.add(p1);
c.add(p2);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame m=new MainFrame(false);
dispose();
}
});

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
try
{
 int rno=Integer.parseInt(txtRno.getText().toString());
 String name=txtName.getText().toString();
 
 if(name.length()==0 || AddFrame.isD(name))
 {
  JOptionPane.showMessageDialog(c,"Invalid Name");
  txtName.setText("");
  txtName.requestFocus();
 }
 else if(rno<1)
 {
  JOptionPane.showMessageDialog(c,"Invalid Roll No.");
  txtRno.setText("");
  txtRno.requestFocus();
 }
 else
 {
  DbHandler.addStudent(rno,name);  
 }

}
catch(NumberFormatException e)
{
 JOptionPane.showMessageDialog(c,"Invalid Roll No.");
 txtRno.setText(""); 
 txtRno.requestFocus();
}
}
});

setTitle("Add Student");
setSize(380,250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}