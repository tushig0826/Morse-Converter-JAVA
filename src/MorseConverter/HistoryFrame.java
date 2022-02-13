package MorseConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JTextArea;

public class HistoryFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea HistoryField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryFrame frame = new HistoryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HistoryFrame() {
		setDefaultCloseOperation(HistoryFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Displaying History");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(148, 10, 116, 25);
		contentPane.add(lblNewLabel);
		
		HistoryField = new JTextArea();
		HistoryField.setBounds(10, 45, 416, 196);
		contentPane.add(HistoryField);
		HistoryField.setColumns(10);
		try {
			HistoryField.setText(History.loadHistory("history.txt").toString());
		} catch (IOException exp) {
			exp.printStackTrace();
		} catch (ClassNotFoundException exp) {
			exp.printStackTrace();
		}
	}
}
