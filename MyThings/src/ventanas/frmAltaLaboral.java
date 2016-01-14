package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import clases.GestorContactos;
import clases.MiExcepcion;

public class frmAltaLaboral extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnSubirFoto;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblMovil;
	private JLabel lblCargo;
	private JLabel lblEmail;
	private JLabel lblEmpresa;
	private JLabel lblNewLabel;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtMovil;
	private JTextField txtEmail;
	private JTextField txtEmpresa;
	private JTextField txtCargo;
	private JLabel lblTfnoEmp;
	private JTextField txtTfnoEmp;
	
	/**
	 * Create the frame.
	 */
	public frmAltaLaboral() {
		
		setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFoto = new JLabel("FOTO");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(310, 11, 114, 118);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		lblFoto.setBorder(border);
		contentPane.add(lblFoto);
		
		btnSubirFoto = new JButton("Subir foto");
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resultado;
				File fichero;
				SubirFoto ventana = new SubirFoto();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png"); 
				//filtro para la imagen
				
				ventana.fileChooser.setFileFilter(filtro);
				
				resultado = ventana.fileChooser.showOpenDialog(null);
			
				if (JFileChooser.APPROVE_OPTION == resultado){
				// comparar cuando se selecciona un archivo es igual a lo que está guardado en resultado
				
					fichero = ventana.fileChooser.getSelectedFile();
					
					try {
						
						ImageIcon icon = new ImageIcon(fichero.toString());
												
						Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
						//ajustar el tamaño de la imagen al label donde la vamos a mostrar	
								
						//antes de mostrar la imagen, eliminar cualquier texto que haya en el label para que no interfiera
						lblFoto.setText(null);
						
						//mostrar imagen
						lblFoto.setIcon(icono);	
								
					}catch (Exception e){
						JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + e);
					}
				
				}
			
			}
		});
		btnSubirFoto.setBounds(320, 140, 102, 23);
		contentPane.add(btnSubirFoto);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 61, 46, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(10, 102, 58, 14);
		contentPane.add(lblApellidos);
		
		lblMovil = new JLabel("M\u00F3vil: ");
		lblMovil.setBounds(10, 142, 46, 14);
		contentPane.add(lblMovil);
		
		lblCargo = new JLabel("Cargo: ");
		lblCargo.setBounds(10, 264, 36, 14);
		contentPane.add(lblCargo);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(10, 182, 46, 14);
		contentPane.add(lblEmail);
		
		lblEmpresa = new JLabel("Empresa: ");
		lblEmpresa.setBounds(10, 222, 58, 14);
		contentPane.add(lblEmpresa);
		
		lblNewLabel = new JLabel("CONTACTO LABORAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(82, 11, 154, 28);
		contentPane.add(lblNewLabel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmAltaLaboral.class.getResource("/ventanas/img/save.png")));
		btnGuardar.setBounds(310, 220, 114, 39);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmAltaLaboral.class.getResource("/ventanas/img/cancelar.gif")));
		btnCancelar.setBounds(310, 280, 114, 39);
		contentPane.add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 58, 139, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(66, 99, 139, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtMovil = new JTextField();
		txtMovil.setBounds(44, 140, 86, 20);
		contentPane.add(txtMovil);
		txtMovil.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(44, 179, 139, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(65, 219, 199, 20);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(56, 261, 127, 20);
		contentPane.add(txtCargo);
		
		lblTfnoEmp = new JLabel("Tel\u00E9fono empresa:");
		lblTfnoEmp.setBounds(10, 302, 90, 14);
		contentPane.add(lblTfnoEmp);
		
		txtTfnoEmp = new JTextField();
		txtTfnoEmp.setColumns(10);
		txtTfnoEmp.setBounds(106, 299, 102, 20);
		contentPane.add(txtTfnoEmp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorContactos contacto = new GestorContactos();
		
		switch (e.getActionCommand()) {
			
			case "Guardar":
//				try {
//					contacto.AñadirContactoLaboral(txtNombre.getText(), txtApellidos.getText(), txtMovil.getText(), txtEmail.getText());
//				} catch (MiExcepcion e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(this,e1.YaExiste());
//				}
//							
//				frmAltaLaboral.this.dispose();		
//				frmContactos objContactos = new frmContactos();
//				objContactos.setVisible(true);
				break;
			
			case "Cancelar":
				frmAltaLaboral.this.dispose();
				frmContactos objContactos2 = new frmContactos();
				objContactos2.setVisible(true);			
		}
	}
}
