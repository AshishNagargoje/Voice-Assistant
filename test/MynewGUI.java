import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MynewGUI extends JFrame implements ActionListener {

	String strTitle = "Geometrical Feature Recognition";
	JFrame frmMain = new JFrame(strTitle);
	DrawPanel1 dp = new DrawPanel1();
	ShowPanel1 sp = new ShowPanel1();
	JButton btNewScript = new JButton("New");
	JButton btSaveScript = new JButton("Save");
	JButton btClearScript = new JButton("Clear");
	JButton btRecognize = new JButton("Recognize");
	
	
	int CurrentScript=0;
    int stroke;

	public MynewGUI() {
		// gui definitions
		JFrame.setDefaultLookAndFeelDecorated(true);
		frmMain.setLayout(new GridLayout(4, 3));
		    
		frmMain.setResizable(true);
		frmMain.setBounds(300, 300, 800, 600);
		frmMain.getContentPane().setLayout(null);
		frmMain.setLocationRelativeTo(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dp.setBounds(20, 20, 580, 520);
		sp.setBounds(620, 300, 165, 200);
		sp.setBackground(Color.WHITE);
		frmMain.getContentPane().add(dp);
		frmMain.getContentPane().add(sp);

		btNewScript.setBounds(frmMain.getWidth() - 180, 170, 160, 20);
		btNewScript.addActionListener(this);
		frmMain.getContentPane().add(btNewScript);

		btClearScript.setBounds(frmMain.getWidth() - 180, 200, 160, 20);
		btClearScript.addActionListener(this);
		btClearScript.setEnabled(false);
		frmMain.getContentPane().add(btClearScript);

		btSaveScript.setBounds(frmMain.getWidth() - 180, 230, 160, 20);
		btSaveScript.addActionListener(this);
		btSaveScript.setEnabled(false);
		frmMain.getContentPane().add(btSaveScript);

		btRecognize.setBounds(frmMain.getWidth() - 180, 260, 160, 20);
		btRecognize.addActionListener(this);
		btRecognize.setEnabled(false);
		frmMain.getContentPane().add(btRecognize);

		frmMain.setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btNewScript) {
			
			dp.Clear();
			dp.setEnabled(true);

			btClearScript.setEnabled(true);
			btNewScript.setEnabled(false);
			File selectedFile = null;
			if(CurrentScript<=1)
			{
				btSaveScript.setEnabled(true);
			}

			JFileChooser dlg = new JFileChooser();
			FileFilter ft = new FileNameExtensionFilter("Text Files","txt");
			dlg.addChoosableFileFilter(ft);

			int rVal = dlg.showOpenDialog(this);

			if (rVal == JFileChooser.APPROVE_OPTION) {

				selectedFile = dlg.getSelectedFile();

			}

			try {

				//String fileName = selectedFile.getAbsolutePath();
				FileInputStream fstream = new FileInputStream(selectedFile);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				java.util.ArrayList<Point2D> arrPoints = new java.util.ArrayList<Point2D>();

				while ((strLine = br.readLine()) != null) {

					StringTokenizer tk = new StringTokenizer(strLine,"\t");
					while (tk.hasMoreTokens()) {
						Double X = Double
						.parseDouble(tk.nextToken().toString());
						Double Y = Double
						.parseDouble(tk.nextToken().toString());
						Double Y_MAX = 450.0;
						Double Y_VALUE = Y_MAX - Y;

						arrPoints.add(new Point2D.Double(X, Y_VALUE));
					}

				}
				dp.setDraw(true);
				dp.setArrPoints(arrPoints);
				dp.repaint();
			} catch (IOException e) {

				e.printStackTrace();

			}
		}

		else if (evt.getSource() == btClearScript) {
			dp.Clear();
			btNewScript.setEnabled(true);
			btClearScript.setEnabled(false);
		}
                  else if(evt.getSource() == btSaveScript)  {

//done know wat should be written here.
                  }
	}
	

	
	public static void main(String[] args) {
		new MynewGUI();
	}
}