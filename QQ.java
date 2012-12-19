import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.awt.Button;
import java.awt.Panel;
import java.lang.String;
import javax.swing.JOptionPane;
public class QQ extends Frame implements ActionListener{
Label Lname ,Lpassword; //定义用户名和密码的标签
TextField Tname; //定义用户名的文本框
JPasswordField Tpassword; //定义密码的文本框。注：使用JPasswordField的好处就是输入的密码是以****显示给用户的
Panel panel1=new Panel(); //定义面板
Button Load,login; //定义登陆和注册的按钮
boolean b=false;
File file1;    //定义记录用户注册的用户名和密码的文件夹
Writer writer;
String []Usersname=new String[1024]; //定义记录用户名的数组
String []Userspassword=new String[1024];//定义记录密码的数组
public QQ(){
   Lname=new Label ("用户名");Lname.setBackground(Color.red);//设置标签的背景颜色
   Lpassword=new Label ("密码");Lpassword.setBackground(Color.red);//设置标签的背景颜色
   Tname=new TextField (10);
   Tpassword=new JPasswordField (10);
   Load=new Button("登陆");Load.setBackground(Color.lightGray);
   login=new Button("注册");login.setBackground(Color.lightGray);
   add(panel1,BorderLayout.CENTER);
   setLayout(new CardLayout(3,2));
   panel1.add(Lname);
   panel1.add(Tname);
   panel1.add(Lpassword);
   panel1.add(Tpassword);
   panel1.add(Load);Load.addActionListener(this);
   panel1.add(login);login.addActionListener(this);
 
}
public void actionPerformed(ActionEvent e){
// 用户登录事件处理
if (e.getSource() == Load) {
   String name1 = Tname.getText();
   String password1 = Tpassword.getText();
   boolean flag = false;
   int index = 0;
   for (int i = 0; i < Usersname.length; i++) {
    if (name1.equals(Usersname[i])) {
     flag = true;
     index = i;
     break;
    }
   }
   if (flag && password1.equals(Userspassword[index])) {  
//处理用户登录成功后的反馈信息
                JOptionPane.showMessageDialog(null, "恭喜您登陆成功!", "消息", JOptionPane.INFORMATION_MESSAGE);                                                                     
   } else {
    JOptionPane.showMessageDialog(null, "对不起您的用户名或密码错误!", "错误",JOptionPane.ERROR_MESSAGE);
   }
}

// 用户注册模块的事件处理
if (e.getSource() == login) {
   String NCmp = Tname.getText();
   String PCmp = Tpassword.getText();

   boolean flag = false;
   for (int i = 0; i < Usersname.length; i++) {
    if (NCmp.equals(Usersname[i])) {
     flag = true;
     break;
    }
   }
   if (flag) {
    JOptionPane.showMessageDialog(null, "对不起您的用户名已经注册!", "错误", JOptionPane.ERROR_MESSAGE);
   } else {
    int index = 0;
    JOptionPane.showMessageDialog(null, "注册成功!", "消息", JOptionPane.INFORMATION_MESSAGE);
    for (int i = 0; i < Usersname.length; i++) {
     if (Usersname[i] == null) {
      Usersname[i] = NCmp;
      index = i;
      break;
     }
    }
    Userspassword[index] = PCmp;
   }
              try{
                     file1=new File("Student.dat");
                     FileWriter fw=new FileWriter(file1,true);
                     fw.write("用户名"+"\t\t"+"密码"+"\n");
                     fw.write(NCmp+"\t\t"+PCmp+"\n");   
                     fw.close();
              }catch (IOException e1){
                                 e1.printStackTrace();
              }   
}

}
public static void main(String[] args) {
   // TODO Auto-generated method stub
    Frame Fstudent=new QQ();
    Fstudent.setSize(200,200);
    Fstudent.setTitle("QQ仿真系统");
   
//   关闭窗口
      Fstudent.addWindowListener(new WindowAdapter(){
                              public void windowClosing(WindowEvent e){
                                System.exit(0);
                               }
                               });
      Fstudent.setVisible(true); 

}

}
