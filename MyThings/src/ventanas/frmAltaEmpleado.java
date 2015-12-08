package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import LN.clsGestorPersonas;
import LN.clsMiExcepcion;

public class frmAltaEmpleado extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JButton btnGuardar;
	private JTextField txtDni;


	/**
	 * Create the frame.
	 */
	public frmAltaEmpleado() {
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
		
		JLabel lblNombre = new JLabel("Usuario:");
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 3, SpringLayout.NORTH, txtNombre);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, -53, SpringLayout.WEST, txtNombre);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDni = new JLabel("Contrase\u00F1a:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDni, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDni, 3, SpringLayout.NORTH, txtDni);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDni, 132, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 0, SpringLayout.WEST, txtDni);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, -34, SpringLayout.NORTH, txtDni);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDni, -148, SpringLayout.EAST, contentPane);
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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsGestorPersonas emp = new clsGestorPersonas();
		switch (e.getActionCommand())
		{
		case "guardar": 
			
			try {
				emp.AñadirEmpleado(txtNombre.getText(), txtDni.getText(), txtEmail.getText(), txtContraseña.getText() );
			} catch (clsMiExcepcion e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,e1.Informar());
			}
						
			frmLogin objLogin = new frmLogin();
			objLogin.setVisible(true);
			break;
		}
		frmAltaEmpleado.this.dispose();
	}
}
