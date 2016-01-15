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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import clases.GestorContactos;
import clases.MiExcepcion;
import clases.Personal;

public class frmVerPersonal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
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
	private JButton btnAtrs;
	private JLabel lblVernombre;
	private JLabel lblVerapell;
	private JLabel lblVermovil;
	private JLabel lblVeremail;
	private JLabel lblVerdomicilio;
	private JLabel lblVertfnodomicilio;
	private JLabel lblVerfechan;
	
	/**
	 * Create the frame.
	 * @param cont 
	 */
	public frmVerPersonal(Personal cont) {
		
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
		
		
		lblVernombre = new JLabel(cont.getNombre());
		lblVernombre.setBounds(65, 61, 127, 14);
		//lblVernombre.setText(cont.getNombre());
		contentPane.add(lblVernombre);
		
		lblVerapell = new JLabel(cont.getApellidos());
		lblVerapell.setBounds(80, 102, 146, 14);
		//lblVerapell.setText(cont.getApellidos());
		contentPane.add(lblVerapell);
		
		String mvl = Integer.toString(cont.getNum_m());
		lblVermovil = new JLabel(mvl);
		lblVermovil.setBounds(51, 142, 86, 14);
		
		//lblVermovil.setText(mvl);
		contentPane.add(lblVermovil);
		
		lblVeremail = new JLabel(cont.getEmail());
		lblVeremail.setBounds(51, 182, 127, 14);
		//lblVeremail.setText(cont.getEmail());
		contentPane.add(lblVeremail);
		
		lblVerdomicilio = new JLabel(cont.getDomicilio());
		lblVerdomicilio.setBounds(78, 222, 225, 14);
		//lblVerdomicilio.setText(cont.getDomicilio());
		contentPane.add(lblVerdomicilio);
		
		String tfno = Integer.toString(cont.getNum_d());
		lblVertfnodomicilio = new JLabel(tfno);
		lblVertfnodomicilio.setBounds(129, 264, 114, 14);
		
	//	lblVertfnodomicilio.setText(tfno);
		contentPane.add(lblVertfnodomicilio);
		
		lblVerfechan = new JLabel(cont.getNacimiento());
		lblVerfechan.setBounds(115, 305, 128, 14);
	//	lblVeremail.setText(cont.getNacimiento());
		contentPane.add(lblVerfechan);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(335, 301, 89, 23);
		btnAtrs.setActionCommand("atras");
		btnAtrs.addActionListener(this);
		contentPane.add(btnAtrs);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
switch (e.getActionCommand()) {
		
		case "atras":
			
			frmTableContactos objTableContactos = new frmTableContactos();
			objTableContactos.setVisible(true);
			frmVerPersonal.this.dispose();
			break;
	}
	}
}
