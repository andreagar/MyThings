package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorUsuarios;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class frmAltaUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JButton btnGuardar;
	private JTextField txtDni;
	private JLabel lblApellidos;
	private JLabel lblContrasea;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public frmAltaUsuario() {
		setResizable(false);
		this.setTitle("Beat v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 325);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblNombre = new JLabel("Nombre usuario:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 81, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 184, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, -189, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, -53, SpringLayout.WEST, txtNombre);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDni = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDni, 113, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDni, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDni, -3, SpringLayout.NORTH, lblDni);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDni, 0, SpringLayout.EAST, txtNombre);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGuardar, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGuardar, -10, SpringLayout.EAST, contentPane);
		btnGuardar.setActionCommand("guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltaDeUsuario, 24, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltaDeUsuario, 172, SpringLayout.WEST, contentPane);
		contentPane.add(lblAltaDeUsuario);
		
		lblApellidos = new JLabel("Apellidos:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblApellidos, 18, SpringLayout.SOUTH, lblDni);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblApellidos);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContrasea, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, txtNombre);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblContrasea, 3, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 11, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, txtNombre);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios emp = new GestorUsuarios();
		switch (e.getActionCommand())
		{
		case "guardar": 
			
			try {
				emp.AñadirUsuario(txtNombre.getText(), txtDni.getText(), txtEmail.getText(), txtContraseña.getText() );
			} catch (MiExcepcion e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,e1.Informar());
			}
						
			frmLogin objLogin = new frmLogin();
			objLogin.setVisible(true);
			break;
		}
		frmAltaUsuario.this.dispose();
	}
}
