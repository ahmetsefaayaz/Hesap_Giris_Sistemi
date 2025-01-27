import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartWindow extends RegisterWindow implements ActionListener {
	private JFrame startFrame = new JFrame();
	private JLabel welcome = new JLabel();
	private JButton loginButton = new JButton();
	private JButton registerButton = new JButton();
	
	public StartWindow() {
		welcome.setText("WELCOME");
		welcome.setFocusable(false);
		welcome.setFont(new Font("Consolas",Font.PLAIN,35));
		welcome.setForeground(Color.YELLOW);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setVerticalAlignment(JLabel.CENTER);
		welcome.setBounds(150,75,200,35);
		
		loginButton.setText("LOGIN");
		loginButton.setBounds(100,250,150,50);
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setVerticalAlignment(JButton.CENTER);
		loginButton.setHorizontalAlignment(JButton.CENTER);
		loginButton.setFont(new Font("Consolas",Font.ITALIC,25));
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		registerButton.setText("REGISTER");
		registerButton.setBounds(250,250,150,50);
		registerButton.setBackground(Color.LIGHT_GRAY);
		registerButton.setVerticalAlignment(JButton.CENTER);
		registerButton.setHorizontalAlignment(JButton.CENTER);
		registerButton.setFont(new Font("Consolas",Font.ITALIC,25));
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		startFrame.setTitle("Main Menu");
		startFrame.setSize(500,500);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(Color.black);
		startFrame.setLayout(null);
		
		// addings
		startFrame.add(welcome);
		startFrame.add(loginButton);
		startFrame.add(registerButton);
		
		
		startFrame.setLocationRelativeTo(null);
		startFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			startFrame.dispose();
			new LoginWindow(accountList);
		}
		else if(e.getSource() == registerButton) {
			startFrame.dispose();
			RegisterWindow reg = new RegisterWindow();
			reg.newRegister();
		}
	}
}
