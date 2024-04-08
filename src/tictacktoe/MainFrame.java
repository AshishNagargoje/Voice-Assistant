package tictacktoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    JButton b0 = new JButton();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();

    String ChanceOf = "x";
    String[] Values = { "", "", "", "", "", "", "", "", "" };

    ImageIcon x = new ImageIcon("src/tictacktoe/x.jpg");
    ImageIcon o = new ImageIcon("src/tictacktoe/o.jpg");
    ImageIcon clear = new ImageIcon("src/tictacktoe/clear.jpg");

    public MainFrame() {

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        setLayout(new GridLayout(3, 3));
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
       // setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object n = e.getSource();
        if (n == b0) {
            if (ChanceOf == "x") {
                Values[0] = "x";
                b0.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[0] = "o";
                b0.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b1) {
            if (ChanceOf == "x") {
                Values[1] = "x";
                b1.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[1] = "o";
                ;
                b1.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b2) {
            if (ChanceOf == "x") {
                Values[2] = "x";
                b2.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[2] = "o";
                ;
                b2.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b3) {
            if (ChanceOf == "x") {
                Values[3] = "x";
                b3.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[3] = "o";
                ;
                b3.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b4) {
            if (ChanceOf == "x") {
                Values[4] = "x";
                b4.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[4] = "o";
                ;
                b4.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b5) {
            if (ChanceOf == "x") {
                Values[5] = "x";
                b5.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[5] = "o";
                ;
                b5.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b6) {
            if (ChanceOf == "x") {
                Values[6] = "x";
                b6.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[6] = "o";
                ;
                b6.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b7) {
            if (ChanceOf == "x") {
                Values[7] = "x";
                b7.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[7] = "o";
                ;
                b7.setIcon(o);
                ChanceOf = "x";
            }
        } else if (n == b8) {
            if (ChanceOf == "x") {
                Values[8] = "x";
                b8.setIcon(x);
                ChanceOf = "o";
            } else if (ChanceOf == "o") {
                Values[8] = "o";
                
                b8.setIcon(o);
                ChanceOf = "x";
            }
        }
        new LookWhoWins().WhoWins(Values, this);
    }

 
}