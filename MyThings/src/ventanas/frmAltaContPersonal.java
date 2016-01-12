package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorContactos;
import clases.MiExcepcion;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;

public class frmAltaContPersonal extends JFrame implements ActionListener{

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
	JButton btnSubirFoto;
	private JLabel lblEmail;
	private JTextField txtMovil;
	private JTextField txtEmail;
	private static String ultimaCarpeta = null;
	private static String ficheros;
	private static String path;
	private static String ultimoPatronFicheros = null;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JLabel lblTelfonoCasa;
	private JLabel lblFechaNacimiento;
	private JTextField txtTfno_dom;
	private JTextField txtFecha_n;

	private static File pedirCarpeta() {
		String carp = ultimaCarpeta; 
		if (ultimaCarpeta==null) carp = System.getProperty("user.dir");
		File dirActual = new File( carp );
		JFileChooser chooser = new JFileChooser( dirActual );
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		int returnVal = chooser.showOpenDialog( null );
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else 
			return null;
	}
	
	/**
	 * Create the frame.
	 */
	public frmAltaContPersonal() {
		setResizable(false);
		this.setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 325);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, -3, SpringLayout.NORTH, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 17, SpringLayout.EAST, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, -214, SpringLayout.EAST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, -18, SpringLayout.NORTH, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtApellidos, -3, SpringLayout.NORTH, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtApellidos, 12, SpringLayout.EAST, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtApellidos, -214, SpringLayout.EAST, contentPane);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGuardar, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGuardar, -10, SpringLayout.EAST, contentPane);
		btnGuardar.setActionCommand("guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		JLabel lblAltaDeUsuario = new JLabel("CONTACTO PERSONAL");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, txtMovil, 30, SpringLayout.EAST, lblNum_m);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtMovil, -214, SpringLayout.EAST, contentPane);
		txtMovil.setColumns(10);
		contentPane.add(txtMovil);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 30, SpringLayout.EAST, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEmail, -214, SpringLayout.EAST, contentPane);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		JLabel lblFoto = new JLabel("Foto:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFoto, 0, SpringLayout.WEST, lblNombre);
		contentPane.add(lblFoto);
		
		btnSubirFoto = new JButton("Subir foto");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSubirFoto, 32, SpringLayout.EAST, lblFoto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFoto, 4, SpringLayout.NORTH, btnSubirFoto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSubirFoto, 17, SpringLayout.SOUTH, txtEmail);
		btnSubirFoto.setActionCommand("foto");
		btnSubirFoto.addActionListener(this);
		contentPane.add(btnSubirFoto);
		
		lblDomicilio = new JLabel("Domicilio: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDomicilio, 0, SpringLayout.NORTH, lblNombre);
		contentPane.add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtDomicilio, 264, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDomicilio, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDomicilio, -6, SpringLayout.WEST, txtDomicilio);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDomicilio, -3, SpringLayout.NORTH, lblNombre);
		txtDomicilio.setColumns(10);
		contentPane.add(txtDomicilio);
		
		lblTelfonoCasa = new JLabel("Tel\u00E9fono casa: ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTelfonoCasa, 6, SpringLayout.EAST, txtApellidos);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTelfonoCasa, 0, SpringLayout.SOUTH, txtApellidos);
		contentPane.add(lblTelfonoCasa);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento: ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaNacimiento, 6, SpringLayout.EAST, txtMovil);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblFechaNacimiento, 0, SpringLayout.SOUTH, txtMovil);
		contentPane.add(lblFechaNacimiento);
		
		txtTfno_dom = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTfno_dom, -3, SpringLayout.NORTH, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTfno_dom, 0, SpringLayout.EAST, lblTelfonoCasa);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTfno_dom, 0, SpringLayout.EAST, btnGuardar);
		txtTfno_dom.setColumns(10);
		contentPane.add(txtTfno_dom);
		
		txtFecha_n = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFecha_n, -3, SpringLayout.NORTH, lblFechaNacimiento);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFecha_n, 6, SpringLayout.EAST, lblFechaNacimiento);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFecha_n, 0, SpringLayout.EAST, btnGuardar);
		txtFecha_n.setColumns(10);
		contentPane.add(txtFecha_n);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorContactos contacto = new GestorContactos();
		switch (e.getActionCommand()) {
		
			case "guardar":
				try {
					contacto.AÒadirContactoPersonal(txtNombre.getText(), txtApellidos.getText(), txtMovil.getText(), txtEmail.getText(),
							txtDomicilio.getText(), txtTfno_dom.getText(), txtFecha_n.getText(), );
				} catch (MiExcepcion e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,e1.YaExiste());
				}
							
				frmLogin objLogin = new frmLogin();
				objLogin.setVisible(true);
				break;
			case "foto":
				File fPath = pedirCarpeta();
				if (fPath==null) return;
				path = fPath.getAbsolutePath();
				ultimaCarpeta = path;
				if (ultimoPatronFicheros==null)
					ficheros = JOptionPane.showInputDialog( null,
							"Nombre de ficheros a elegir (* para cualquier cadena)",
							"Selecci√≥n de ficheros dentro de la carpeta", JOptionPane.QUESTION_MESSAGE );
				else
					ficheros = JOptionPane.showInputDialog( null,
							"Nombre de ficheros a elegir (* para cualquier cadena)",
							ultimoPatronFicheros );
				ultimoPatronFicheros = ficheros;
				//listaRepVideos.add( path, ficheros, true );
				//lCanciones.repaint(); ME PARECE QUE ESTO NO HACE FALTA
			}
			frmAltaContPersonal.this.dispose();
	}
}
