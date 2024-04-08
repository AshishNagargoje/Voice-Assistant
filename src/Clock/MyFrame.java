package Clock;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;




 public class MyFrame extends JFrame{
 
 Calendar calendar;
 SimpleDateFormat timeFormat;
 SimpleDateFormat dayFormat;
 SimpleDateFormat dateFormat;
 JLabel timeLabel;
 JLabel dayLabel;
 JLabel dateLabel;
 String time;
 String day;
 String date;

 public MyFrame(){
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("My Clock Program");
  setLayout(new FlowLayout());
  setSize(350,200);
  setResizable(false);
  
  timeFormat = new SimpleDateFormat("hh:mm:ss a");
  dayFormat = new SimpleDateFormat("EEEE");
  dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
  
  timeLabel = new JLabel();
  timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
  timeLabel.setForeground(new Color(0x00FF00));
  timeLabel.setBackground(Color.black);
  timeLabel.setOpaque(true);
  
  dayLabel = new JLabel();
  dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
  
  dateLabel = new JLabel();
  dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
  
  
  add(timeLabel);
  add(dayLabel);
  add(dateLabel);
  setVisible(true);
  
  setTime();
 }

 
  void setTime() {
  while(true) {
  time = timeFormat.format(Calendar.getInstance().getTime());
  timeLabel.setText(time);
  
  day = dayFormat.format(Calendar.getInstance().getTime());
  dayLabel.setText(day);
  
  date = dateFormat.format(Calendar.getInstance().getTime());
  dateLabel.setText(date);
  
  try {
   Thread.sleep(1000);
  } catch (InterruptedException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  }
 }
}