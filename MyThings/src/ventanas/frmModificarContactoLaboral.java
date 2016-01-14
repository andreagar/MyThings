package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import clases.GestorContactos;
import clases.Laboral;

public class frmModificarContactoLaboral extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblMovil;
	private JLabel lblTelfonoDomicilio;
	private JLabel lblEmail;
	private JLabel lblDomicilio;
	private JLabel lblFechaNacimiento;
	private String ruta="";
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtMovil;
	private JTextField txtEmail;
	private JTextField txtDomicilio;
	private JTextField txtTfno_Domi;
	private JButton btnGuardar;
	private JButton btnSubirFoto;
	private JDateChooser FechaN;
	private Laboral cont1;
	File fichero;
	
	/**
	 * Create the frame.
	 * @param cont 
	 */
	public frmModificarContactoLaboral(Laboral cont) {
		cont1 = cont;
		ruta = cont1.getFoto();
		
		setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFoto = new JLabel("FOTO");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(310, 50, 114, 118);
		ImageIcon icon = new ImageIcon(cont.getFoto());
		Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(icono);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		lblFoto.setBorder(border);
		contentPane.add(lblFoto);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 61, 58, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(10, 102, 58, 14);
		contentPane.add(lblApellidos);
		
		lblMovil = new JLabel("M\u00F3vil: ");
		lblMovil.setBounds(10, 142, 46, 14);
		contentPane.add(lblMovil);
		
		lblTelfonoDomicilio = new JLabel("Tel\u00E9fono domicilio:");
		lblTelfonoDomicilio.setBounds(10, 264, 127, 14);
		contentPane.add(lblTelfonoDomicilio);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(10, 182, 46, 14);
		contentPane.add(lblEmail);
		
		lblDomicilio = new JLabel("Domicilio: ");
		lblDomicilio.setBounds(10, 222, 58, 14);
		contentPane.add(lblDomicilio);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento: ");
		lblFechaNacimiento.setBounds(10, 305, 114, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtNombre = new JTextField(cont1.getNombre());
		txtNombre.setBounds(66, 58, 148, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField(cont1.getApellidos());
		txtApellidos.setBounds(66, 99, 148, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		String mvl = Integer.toString(cont1.getNum_m());
		txtMovil = new JTextField(mvl);
		txtMovil.setBounds(66, 139, 86, 20);
		contentPane.add(txtMovil);
		txtMovil.setColumns(10);
		
		txtEmail = new JTextField(cont1.getEmail());
		txtEmail.setBounds(55, 179, 148, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDomicilio = new JTextField(cont1.getDomicilio());
		txtDomicilio.setBounds(66, 219, 193, 20);
		contentPane.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		String tfno = Integer.toString(cont1.getNum_d());
		txtTfno_Domi = new JTextField(tfno);
		txtTfno_Domi.setBounds(117, 261, 86, 20);
		contentPane.add(txtTfno_Domi);
		txtTfno_Domi.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmModificarContactoPersonal.class.getResource("/ventanas/img/save.png")));
		btnGuardar.setBounds(310, 283, 120, 41);
		btnGuardar.setActionCommand("Guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		btnSubirFoto = new JButton("Subir foto");
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resultado;
				
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
						
						ruta = fichero.toString();
						
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
		btnSubirFoto.setBounds(310, 140, 114, 23);
		contentPane.add(btnSubirFoto);
		
		FechaN = new JDateChooser();
		FechaN.setBounds(117, 299, 95, 20);
		contentPane.add(FechaN);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorContactos contacto = new GestorContactos();
		
		switch (e.getActionCommand()) {
		
			case "Guardar":
				
			try{ 
				DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
				String fechaN = fecha.format(FechaN.getDate());
				if (contacto.ModificarContLaboral(txtNombre.getText(), txtApellidos.getText(), txtEmail.getText(),
						txtMovil.getText(), ruta, txtDomicilio.getText(), txtTfno_Domi.getText(),fechaN, cont1))
				{
					frmTableContactos objContacto= new frmTableContactos();
					objContacto.setVisible(true);
					frmModificarContactoLaboral.this.dispose();
				} 
			}catch(Exception e1){
			}				
			break;
		}
	}
}