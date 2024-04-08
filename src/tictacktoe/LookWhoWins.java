/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictacktoe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LookWhoWins {

    public void WhoWins(String[] values, JFrame jf) {
        if (values[0] == values[1] && values[1] == values[2] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " wins");
            Restart(jf);
        } else if (values[3] == values[4] && values[4] == values[5] && values[3] != "") {
            JOptionPane.showMessageDialog(null, values[3] + " wins");
            Restart(jf);
        } else if (values[6] == values[7] && values[7] == values[8] && values[6] != "") {
            JOptionPane.showMessageDialog(null, values[6] + " wins");
            Restart(jf);
        } else if (values[0] == values[3] && values[3] == values[6] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " wins");
            Restart(jf);
        } else if (values[1] == values[4] && values[4] == values[7] && values[1] != "") {
            JOptionPane.showMessageDialog(null, values[1] + " wins");
            Restart(jf);
        } else if (values[2] == values[5] && values[5] == values[8] && values[2] != "") {
            JOptionPane.showMessageDialog(null, values[2] + " wins");
            Restart(jf);
        } else if (values[0] == values[4] && values[4] == values[8] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " wins");
            Restart(jf);
        } else if (values[2] == values[4] && values[4] == values[6] && values[2] != "") {
            JOptionPane.showMessageDialog(null, values[2] + " wins");
            Restart(jf);
        } else if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3] && values[3] == values[4]
                && values[4] == values[5] && values[5] == values[6] && values[6] == values[7] && values[7] == values[8]
                && values[8] == values[0]) {
            JOptionPane.showMessageDialog(null, "Tie");
            Restart(jf);
        }
    }

    public void Restart(JFrame JF) {
        JF.dispose();
        new MainFrame();

    }
}

// 0,1,2,
// 3,4,5,
// 6,7,8