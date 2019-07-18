import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnDelete,btnBack;
JPanel p1,p2;

DeleteFrame()
{
c=getContentPane();

c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

lblRno = new JLabel("Roll No: ");
txtRno = new JTextField(5);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");

p1 = new JPanel();
p2 = new JPanel();

p1.add(lblRno);
p1.add(txtRno);

p2.add(btnDelete);
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

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
try
{
 int r=Integer.parseInt(txtRno.getText().toString());

 if(r<1)
 {
  JOptionPane.showMessageDialog(c,"Invalid Roll No.");
  txtRno.setText("");
  txtRno.requestFocus();
 }
 else
 {
  DbHandler.deleteStudent(r);
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

setTitle("Update Student");
setSize(380,250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}