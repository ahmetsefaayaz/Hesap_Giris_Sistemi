import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JLabel userName = new JLabel();
	private JLabel password = new JLabel();
	private JTextField userNameText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	private JButton loginButton = new JButton();
	private JButton resetButton = new JButton();
	private JButton registerButton = new JButton();
	private ArrayList<Accounts> copyList = new ArrayList<Accounts>();
	private char[] charPassword;
	private String stringPassword;
	private boolean trueID;
	private JLabel message = new JLabel();;
	public LoginWindow(ArrayList <Accounts>accountList) {
		// USERNAME LABEL
		for(int i = 0;i<accountList.size();i++) {
			copyList.add(accountList.get(i));
		}
		
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
		
		loginButton.setText("Login");
		loginButton.setBounds(150,300,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setText("Reset");
		resetButton.setBounds(250,300,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		registerButton = new JButton();
		registerButton.setText("Register");
		registerButton.setBounds(380,420,100,25);
		registerButton.setFocusable(false);
		registerButton.setVerticalTextPosition(JButton.CENTER);
		registerButton.addActionListener(this);
		
		
		frame.setTitle("Login Page");
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		frame.add(userName);
		frame.add(password);
		frame.add(passwordText);
		frame.add(userNameText);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			trueID = false;
			if(copyList.size() == 0) {
				message.setBounds(100,350,300,50);
				message.setVerticalAlignment(JLabel.CENTER);
				message.setHorizontalAlignment(JLabel.CENTER);
				message.setText("There are no accounts in the system!");
				frame.add(message);
				frame.repaint();
			}
			for(int i = 0;i<copyList.size();i++) {
				
				charPassword = passwordText.getPassword();
				stringPassword =new String(charPassword);
				
				if(copyList.get(i).ID.equals(userNameText.getText())) {
					trueID = true;
					if(copyList.get(i).password.equals(stringPassword)) {
						frame.dispose();
						new WelcomePage(userNameText.getText());
					}
					else {
						
						message.setBounds(100,350,300,50);
						message.setVerticalAlignment(JLabel.CENTER);
						message.setHorizontalAlignment(JLabel.CENTER);
						message.setText("Wrong Password");
						frame.add(message);
						frame.repaint();
					}
					
					
				}
				else if(i == copyList.size() - 1 && !trueID){
					message.setBounds(100,350,300,50);
					message.setVerticalAlignment(JLabel.CENTER);
					message.setHorizontalAlignment(JLabel.CENTER);
					message.setText("Wrong ID");
					frame.add(message);
					frame.repaint();
				}
				 
			}
			
			
			
		}
		else if(e.getSource() == resetButton) {
			
			userNameText.setText("");
			passwordText.setText("");
		}
		else if(e.getSource() == registerButton) {
			frame.dispose();
			RegisterWindow reg = new RegisterWindow();
			reg.newRegister();
		}
		
	}
	
}