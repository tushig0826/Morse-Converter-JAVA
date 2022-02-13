package MorseConverter;
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
//import javax.swing.JTextPane;
import java.awt.Color;
//import javax.swing.DropMode;
//import javax.swing.JTextArea;
//import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class MorseFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private HelpFrame helper;
	private HistoryFrame history;
	private MorseSound mSound;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorseFrame frame = new MorseFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MorseFrame() {
		setTitle("Morse Converter");
		setDefaultCloseOperation(MorseFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 499);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		
		JMenuItem ExitMenu = new JMenuItem("History");
		FileMenu.add(ExitMenu);
		ExitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				if (e.getSource()== ExitMenu
						) 
				{
					history = new HistoryFrame();
					history.setVisible(true);
				}
			}
		});
		
		
		
		JMenu HelpMenu = new JMenu("Help");
		menuBar.add(HelpMenu);
		
		JMenuItem HelpSubMenu = new JMenuItem("Help");
		HelpMenu.add(HelpSubMenu);
		HelpSubMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if (e.getSource()== HelpSubMenu) 
				{
					helper = new HelpFrame();
					helper.setVisible(true);
					
					
				}
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 287, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textPane.setText("Morse Dictionary:\n"
				+ "\nAlphabets:"
				+ "\na .-, b -..., c -.-., d -.., e ., f ..-., "
				+ "\ng --., h ...., i .., j .---, k -.-, l .-.., "
				+ "\nm --, n -., o ---, p .--.q --.-, r .-., "
				+ "\ns ...,  t -, u ..-, v ...-, w .--, x -..-, "
				+ "\ny -.--, z --.."
				+ "\nNumbers:"
				+ "\n0 - - - - -, 1 .- - - -, 2 ..- - -, 3 ...- -, 4 ....-, 5 ....., 6 -...., 7 - -..., 8 - - -.., 9 - - - -."
				+ "\nSpecial Characters:"
				+ "\n: --..., , --..--, ( -.--., ) -.--.-, ! -.-.--, / -..-., = -...-, - -....-, @ .--.-., + .-.-., . .-.-.-, '' .-..-.\n");
				
			
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(0, 269, 287, 171);
		panel.add(scrollPane);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(MorseFrame.class.getResource("/Images/sat.png")));
		imageLabel.setBounds(0, 0, 287, 269);
		panel.add(imageLabel);

		textField = new JTextField();
		textField.setBounds(344, 92, 346, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(344, 127, 346, 2);
		contentPane.add(separator);
		
		JLabel NewLabel = new JLabel("INPUT:");
		NewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		NewLabel.setBounds(344, 52, 346, 21);
		contentPane.add(NewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(344, 193, 346, 37);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(344, 228, 346, 2);
		contentPane.add(separator_1);
		
		JLabel lblOutpu = new JLabel("OUTPUT:");
		lblOutpu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOutpu.setBounds(344, 153, 334, 21);
		contentPane.add(lblOutpu);
		
		JButton btnNewButton = new JButton("CODE");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BinaryTree BTcode = new BinaryTree();
				String string = "";
							
				if (e.getSource()== btnNewButton) 
				{
					string = textField.getText();					
					textField_1.setText(BinaryTree.Code(string));
					
				}
			}
		});
		btnNewButton.setBounds(344, 261, 87, 66);
		contentPane.add(btnNewButton);
		
		JButton btnDecode = new JButton("DECODE");
		btnDecode.setForeground(new Color(255, 69, 0));
		btnDecode.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDecode.setBounds(452, 261, 87, 66);
		btnDecode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//BinaryTree BTDecode = new BinaryTree();
				String string = "";
				char characters[] = {' ','t','m','o','#','0','9','#','8',':','g','q','z','#',',','7','n','k','y','(',')','c','#','!','d','x','/','b','=','6','-','e','a','w','j','1','#','p','#','@','r','#','+','.','l','#','&','i','u','#','2','#','?','f','s','v','3','h','4','5'};		
				int keys[] = { 31, 15, 8, 4, 2, 1, 3, 5, 6, 7, 10, 9, 13, 12, 11, 14, 23, 19, 16, 18, 17, 22, 21, 20, 26, 24, 25, 28, 27, 30, 29, 47, 39, 35, 34, 32, 33, 38, 36, 37, 43, 40, 42, 41, 45, 44, 46, 54, 52, 49, 48, 50, 51, 53, 57, 56, 55, 59, 58, 60 };
				
				BinaryTree start = null;
				start = BinaryTree.AddNode(start, characters[0], keys[0]);
			
				for (int i = 1; i < characters.length; i++)
				{
					BinaryTree.AddNode(start, characters[i], keys[i]);
				}
				
				if (e.getSource()== btnDecode) 
				{
					
					string = textField.getText();					
					textField_1.setText(BinaryTree.Decode(string, start));
					System.out.println(BinaryTree.Decode(string, start));
					
				}
			}
		});
		contentPane.add(btnDecode);
		
		JButton btnHistory = new JButton("HISTORY");
		
		btnHistory.setForeground(new Color(255, 165, 0));
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHistory.setBounds(344, 347, 195, 56);
		contentPane.add(btnHistory);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if (e.getSource()== btnHistory) 
				{
					history = new HistoryFrame();
					history.setVisible(true);
				}
			}
		});
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setForeground(new Color(128, 0, 0));
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlay.setBounds(561, 261, 129, 142);
		contentPane.add(btnPlay);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mSound = new MorseSound();
				
				try {
					
					String morseCode = MorseSound.loadMorse("sound.txt").toString();
					mSound.playMorse(morseCode);
				} catch (IOException exp) {
					exp.printStackTrace();
				} catch (ClassNotFoundException exp) {
					exp.printStackTrace();
				}
			}
		});
	}
}
