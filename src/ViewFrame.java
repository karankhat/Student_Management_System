import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;
JPanel p1,p2;

ViewFrame()
{
c=getContentPane();

ta = new TextArea(5,40);
btnBack = new JButton("Back");

p1 = new JPanel();
p2 = new JPanel();

c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1.add(ta);
p2.add(btnBack);

c.add(p1);
c.add(p2);

String data=DbHandler.viewStudent();
ta.setText(data);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame m=new MainFrame(false);
dispose();
}
});

setTitle("View Student");
setSize(380,250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}