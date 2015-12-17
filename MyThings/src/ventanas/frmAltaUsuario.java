package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorUsuarios;
import clases.MiExcepcion;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Font;

public class frmAltaUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtNomLogIn;
	private JLabel lblNomReal;
	private JButton btnGuardar;
	private JTextField txtNomReal;
	private JLabel lblApellidos;
	private JLabel lblPassword;
	private JTextField txtApellidos;
	private JTextField txtPassword;
	private JButton btnCancelar;


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
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblNomLogIn = new JLabel("Nombre usuario:");
		contentPane.add(lblNomLogIn);
		
		txtNomLogIn = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomLogIn, 3, SpringLayout.NORTH, txtNomLogIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNomLogIn, -52, SpringLayout.WEST, txtNomLogIn);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNomLogIn, 184, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNomLogIn, -189, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNomLogIn, 303, SpringLayout.WEST, contentPane);
		contentPane.add(txtNomLogIn);
		txtNomLogIn.setColumns(10);
		
		lblNomReal = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNomReal, 0, SpringLayout.WEST, lblNomLogIn);
		contentPane.add(lblNomReal);
		
		txtNomReal = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNomReal, 12, SpringLayout.SOUTH, txtNomLogIn);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNomReal, 90, SpringLayout.EAST, lblNomReal);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNomReal, -115, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomReal, 3, SpringLayout.NORTH, txtNomReal);
		contentPane.add(txtNomReal);
		txtNomReal.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGuardar, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGuardar, -10, SpringLayout.EAST, contentPane);
		btnGuardar.setActionCommand("guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		JLabel lblAltaDeUsuario = new JLabel("ALTA DE USUARIO");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltaDeUsuario, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltaDeUsuario, 133, SpringLayout.WEST, contentPane);
		lblAltaDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblAltaDeUsuario);
		
		lblApellidos = new JLabel("Apellidos:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNomLogIn);
		contentPane.add(lblApellidos);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblNomLogIn);
		contentPane.add(lblPassword);
		
		txtApellidos = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtApellidos, 85, SpringLayout.EAST, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtApellidos, -115, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblApellidos, 3, SpringLayout.NORTH, txtApellidos);
		txtApellidos.setColumns(10);
		contentPane.add(txtApellidos);
		
		txtPassword = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 3, SpringLayout.NORTH, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPassword, 168, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtApellidos, -9, SpringLayout.NORTH, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtNomLogIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPassword, 0, SpringLayout.EAST, txtNomLogIn);
		txtPassword.setColumns(10);
		contentPane.add(txtPassword);
		
		btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCancelar, 0, SpringLayout.SOUTH, btnGuardar);
		btnGuardar.setActionCommand("cancelar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnCancelar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios emp = new GestorUsuarios();
		switch (e.getActionCommand()) {
		
			case "guardar": 
				try {
					emp.AñadirUsuario(txtNomLogIn.getText(), txtNomReal.getText(), txtApellidos.getText(), txtPassword.getText());
				} catch (MiExcepcion e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,e1.YaExiste());
				}
							
				frmLogin objLogin = new frmLogin();
				objLogin.setVisible(true);
				break;
			case "cancelar":
				frmLogin objfrmLogin = new frmLogin();
				objfrmLogin.setVisible(true);
			}
			frmAltaUsuario.this.dispose();
	}
}
