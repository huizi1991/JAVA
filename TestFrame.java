import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.io.IOException;

public class TestFrame extends JFrame{

JTextArea text;

JButton btn[]=new JButton[2];

public TestFrame(String s){

super(s);



Container contentPane=getContentPane();

contentPane.setLayout(new BorderLayout());

text=new JTextArea("ŽóŒÒºÃ£¬ÎÒÊÇ»Û×Ó ");

setForeground(Color.black);

setBackground(Color.black);

contentPane.add(text,BorderLayout.CENTER);

JPanel panel=new JPanel();



btn[0]=new JButton("nothing");

panel.add(btn[0]);

btn[0].addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e){

   System.out.println("HELLO,WORLD");

}

});

btn[1]=new JButton("»¶Ó­");

panel.add(btn[1]);

btn[1].addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e){ 



System.out.println("HELLO,huizi");

}

});

contentPane.add(panel,BorderLayout.SOUTH);

Toolkit tk=getToolkit();

Image img=tk.getImage("pic1\\a.jpg");

setIconImage(img);



//²Ëµ¥

JMenu fontMenu=new JMenu("Font");

fontMenu.setMnemonic(KeyEvent.VK_F);

//²Ëµ¥Ïî

int size=35;

JMenuItem fontSize=new JMenuItem("Size");

fontSize.setIcon(new ImageIcon("pic31\\fontSize.jpg"));

fontSize.setMnemonic(KeyEvent.VK_Z);

fontSize.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e)

{

String sizeString=JOptionPane.showInputDialog("×ÖºÅŽóÐ¡"); 

try

{



int size=Integer.parseInt(sizeString);

}

catch(NumberFormatException ne)

{

JOptionPane.showMessageDialog(null,"ÊäÈëµÄ×ÖÌåŽóÐ¡±ØÐëÊÇÕûÊý");

}

finally{

int size=Integer.parseInt(sizeString);

text.setFont(new Font("¿¬Ìå_gb2312",Font.PLAIN,size));

}

}

});

fontMenu.add(fontSize);





JMenuItem fontExit=new JMenuItem("Exit");

fontExit.setIcon(new ImageIcon("pic31\\fontExit.jpg"));

fontExit.setMnemonic(KeyEvent.VK_Z);

fontExit.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e){



            System.exit(0);

  

}

});

fontMenu.add(fontExit);

JMenuBar menuBar=new JMenuBar();

setJMenuBar(menuBar);



menuBar.add(fontMenu);

setSize(300,200);

setVisible(true);



}

public static void main(String[] args)

{

TestFrame w=new TestFrame("my world");

}

}
