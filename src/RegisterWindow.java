import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterWindow implements ActionListener{
	public static ArrayList<Accounts> accountList = new ArrayList<Accounts>();
	private JFrame frame = new JFrame();
	private JLabel userName = new JLabel();
	private JLabel password = new JLabel();
	private JTextField userNameText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	private JButton registerButton = new JButton();
	private JButton resetButton = new JButton();
	private char[] charPassword;
	private String stringPassword;
	private JButton loginButton;
	private JLabel message;

	
	public RegisterWindow(){}
	void newRegister() {

		userName.setText("USERNAME:");
		userName.setFont(new Font(null,Font.PLAIN,15));
		userName.setBounds(20,100,100,50);
		userName.setHorizontalAlignment(JLabel.LEFT);
		userName.setVerticalAlignment(JLabel.CENTER);
		
		password.setText("PASSWORD:");
		password.setFont(new Font(null,Font.PLAIN,15));
		password.setBounds(20,200,100,50);
		password.setHorizontalAlignment(JLabel.LEFT);
		password.setVerticalAlignment(JLabel.CENTER);
		
		
		
		userNameText.setBounds(120,100,360,50);
		userNameText.setHorizontalAlignment(JTextField.LEFT);
		userNameText.setFont(new Font("Consolas",Font.ITALIC,20));
		userNameText.setEditable(true);
		
		
		passwordText.setBounds(120,200,360,50);
		passwordText.setHorizontalAlignment(JTextField.LEFT);
		passwordText.setFont(new Font("Consolas",Font.ITALIC,20));
		passwordText.setEditable(true);
		
		registerButton.setText("Register");
		registerButton.setBounds(150,300,100,25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		resetButton.setText("Reset");
		resetButton.setBounds(250,300,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setBounds(400,420,80,25);
		loginButton.setFocusable(false);
		loginButton.setVerticalTextPosition(JButton.CENTER);
		loginButton.addActionListener(this);
		
		frame.setTitle("Register Page");
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		frame.add(userName);
		frame.add(password);
		frame.add(passwordText);
		frame.add(userNameText);
		frame.add(registerButton);
		frame.add(resetButton);
		frame.add(loginButton);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registerButton) {
			
			charPassword = passwordText.getPassword();
			stringPassword = new String(charPassword);
			if(stringPassword.length() > 2 && userNameText.getText().length() > 2) {
				accountList.add(new Accounts(userNameText.getText(),stringPassword));
				frame.dispose();
				new StartWindow();
			}
			else {
				message = new JLabel();
				message.setBounds(80,350,340,50);
				message.setVerticalAlignment(JLabel.CENTER);
				message.setHorizontalAlignment(JLabel.CENTER);
				message.setText("your password and ID must be atleast 3 character long");
				frame.add(message);
				frame.repaint();
			}
		}
		else if(e.getSource() == resetButton) {
			
			userNameText.setText("");
			passwordText.setText("");
		}
		else if(e.getSource() == loginButton) {
			frame.dispose();
			new LoginWindow(accountList);
		}
	}
}
