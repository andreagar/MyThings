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

public class frmAltaContacto extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JButton btnGuardar;
	private JTextField txtApellidos;
	private JLabel lblNum_m;
	private JLabel lblEmail;
	private JTextField txtMovil;
	private JTextField txtEmail;


	/**
	 * Create the frame.
	 */
	public frmAltaContacto() {
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, -286, SpringLayout.EAST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, -3, SpringLayout.NORTH, lblNombre);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApellidos, 91, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, -18, SpringLayout.NORTH, lblApellidos);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 0, SpringLayout.WEST, txtApellidos);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, -5, SpringLayout.EAST, txtApellidos);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtApellidos, 167, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtApellidos, -115, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtApellidos, -3, SpringLayout.NORTH, lblApellidos);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
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
		
		lblNum_m = new JLabel("M\u00F3vil:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblApellidos, -15, SpringLayout.NORTH, lblNum_m);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNum_m, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblNum_m);
		
		lblEmail = new JLabel("Email:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 171, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNum_m, -15, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblEmail);
		
		txtMovil = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtMovil, -3, SpringLayout.NORTH, lblNum_m);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtMovil, 0, SpringLayout.WEST, txtNombre);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtMovil, 0, SpringLayout.EAST, txtApellidos);
		txtMovil.setColumns(10);
		contentPane.add(txtMovil);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 48, SpringLayout.EAST, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtApellidos);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		JLabel lblFoto = new JLabel("Foto:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFoto, 18, SpringLayout.SOUTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFoto, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblFoto);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios emp = new GestorUsuarios();
		switch (e.getActionCommand()) {
		
			case "guardar": 
				try {
					emp.AñadirUsuario(txtNombre.getText(), txtApellidos.getText(), txtMovil.getText(), txtEmail.getText());
				} catch (MiExcepcion e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,e1.YaExiste());
				}
							
				frmLogin objLogin = new frmLogin();
				objLogin.setVisible(true);
				break;
			}
			frmAltaContacto.this.dispose();
	}
}
