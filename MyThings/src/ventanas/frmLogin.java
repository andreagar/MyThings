package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.KeyStroke;


import java.awt.Toolkit;

public class frmLogin extends JFrame implements ActionListener{

	private PanelConImagen contentPane;
	
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JTextField txtPassword;


	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 379);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(79, 84, 66, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(79, 140, 82, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(169, 81, 152, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n:");
		lblInicioDeSesin.setBounds(169, 11, 152, 27);
		lblInicioDeSesin.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblInicioDeSesin);
		
		btnLogIn = new JButton("Log in");
//		btnLogIn.setMnemonic('L');
		btnLogIn.setMnemonic(KeyEvent.VK_ENTER);
		btnLogIn.setBounds(377, 304, 89, 23);
		btnLogIn.setActionCommand("login");
		btnLogIn.addActionListener(this);
		contentPane.add(btnLogIn);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(171, 137, 150, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//clsGestorPersonas persona = new clsGestorPersonas();
		switch (e.getActionCommand())
		{
		case "login": 
		//	if(persona.Login(txtUsuario.getText(), txtPassword.getText()))
			{
				frmPrincipal objPrincipal = new frmPrincipal();
				objPrincipal.setVisible(true);
				frmLogin.this.dispose();
			}			
			break;
		}
	}
}
