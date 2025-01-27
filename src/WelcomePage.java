import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements ActionListener{
	private JFrame frame;
	private JButton start;
	public WelcomePage(String name) {
		frame = new JFrame();
		JLabel label = new JLabel();
		start = new JButton();
		label.setText("Welcome "+name);
		label.setBounds(150,100,200,35);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font(null,Font.ROMAN_BASELINE,15));
		
		start.setText("Main Menu");
		start.setBounds(150,250,200,35);
		start.setFont(new Font(null,Font.ROMAN_BASELINE,15));
		start.setFocusable(false);
		start.setHorizontalAlignment(JButton.CENTER);
		start.setVerticalAlignment(JButton.CENTER);
		start.addActionListener(this);
		frame.setLayout(null);
		
		frame.add(start);
		frame.add(label);
		
		frame.setTitle(name + "'s Account");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			frame.dispose();
			new StartWindow();
		}
		
	}

	
}
