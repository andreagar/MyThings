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

import clases.GestorUsuarios;
import clases.MiExcepcion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.KeyStroke;


import java.awt.Toolkit;

public class frmLogin extends JFrame implements ActionListener{

	private PanelConImagen contentPane;
	
	public static JTextField txtUsuario;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JPasswordField txtPassword;
	private JButton btnRegistrarme;


	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setResizable(false);
		this.setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 208);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 59, 66, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 92, 82, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(86, 56, 152, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblInicioDeSesin = new JLabel("MyThings");
		lblInicioDeSesin.setBounds(121, 11, 152, 27);
		lblInicioDeSesin.setFont(new Font("Verdana", Font.PLAIN, 22));
		contentPane.add(lblInicioDeSesin);
		
		btnLogIn = new JButton("Log in");
	//	btnLogIn.setMnemonic('L');
		btnLogIn.setMnemonic(KeyEvent.VK_ENTER);
		btnLogIn.setBounds(74, 131, 89, 23);
		btnLogIn.setActionCommand("login");
		btnLogIn.addActionListener(this);
		contentPane.add(btnLogIn);
		
		setContentPane(contentPane);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(86, 89, 150, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setBounds(235, 146, 126, 23);
		btnRegistrarme.setActionCommand("Registrarme");
		btnRegistrarme.addActionListener(this);
		contentPane.add(btnRegistrarme);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios usuario = new GestorUsuarios();
		switch (e.getActionCommand()) {
			
			case "login":				
				try {
					if(usuario.Login(txtUsuario.getText(), txtPassword.getText())) {
					frmPrincipal objPrincipal = new frmPrincipal();
					objPrincipal.setVisible(true);
					frmLogin.this.dispose();
					}
				}catch(MiExcepcion e1){
					frmExcepcion objExcepcion = new frmExcepcion(e1.NoExiste());
					objExcepcion.setVisible(true);
//					JOptionPane.showMessageDialog(this,e1.NoExiste());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			case "Registrarme":
				frmAltaUsuario altaUsuario = new frmAltaUsuario();
				altaUsuario.setVisible(true);
				frmLogin.this.dispose();
				break;
		}
		
	}
}
