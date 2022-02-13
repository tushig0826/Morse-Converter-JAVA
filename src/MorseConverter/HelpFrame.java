package MorseConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextArea;

public class HelpFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea MessageField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFrame frame = new HelpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HelpFrame() {
		setDefaultCloseOperation(HelpFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the help window");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(128, 10, 219, 25);
		contentPane.add(lblNewLabel);
		
		MessageField = new JTextArea();
		MessageField.setBounds(10, 45, 416, 196);
		contentPane.add(MessageField);
		MessageField.setColumns(10);
		
			MessageField.setText("This program is to code text into morse code and vise versa."
					+"\nYou can write text in the input section and get result in the output section."
					+ "+\nPlease note enter the lower-case letters to convert your text to morse code.");
		
	}
}
