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
import clases.Laboral;
import clases.MiExcepcion;

public class frmVerLaboral extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblMovil;
	private JLabel lblCargo;
	private JLabel lblEmail;
	private JLabel lblEmpresa;
	private JLabel lblTfno_empresa;
	private String ruta="";
	private JLabel lblVernombre;
	private JLabel lblVerapell;
	private JButton btnAtrs;
	private JLabel lblVermovil;
	private JLabel lblVeremail;
	private JLabel lblVerEmpresa;
	private JLabel lblVerCargo;
	private JLabel lblVerTfno_empresa;
	
	/**
	 * Create the frame.
	 */
	public frmVerLaboral(Laboral cont) {
		
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
		
//		lblFoto = new JLabel("FOTO");
//		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFoto.setBounds(310, 50, 114, 118);
//		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
//		lblFoto.setBorder(border);
//		contentPane.add(lblFoto);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 61, 58, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(10, 102, 58, 14);
		contentPane.add(lblApellidos);
		
		lblMovil = new JLabel("M\u00F3vil: ");
		lblMovil.setBounds(10, 142, 46, 14);
		contentPane.add(lblMovil);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 264, 127, 14);
		contentPane.add(lblCargo);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(10, 182, 58, 14);
		contentPane.add(lblEmail);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 222, 75, 14);
		contentPane.add(lblEmpresa);
		
		lblTfno_empresa = new JLabel("Telefono empresa:");
		lblTfno_empresa.setBounds(10, 305, 139, 14);
		contentPane.add(lblTfno_empresa);
		
		lblVernombre = new JLabel(cont.getNombre());
		lblVernombre.setBounds(77, 61, 127, 14);
		contentPane.add(lblVernombre);
		
		lblVerapell = new JLabel(cont.getApellidos());
		lblVerapell.setBounds(76, 102, 146, 14);
		contentPane.add(lblVerapell);
		
		String mvl = Integer.toString(cont.getNum_m());
		lblVermovil = new JLabel(mvl);
		lblVermovil.setBounds(51, 142, 86, 14);
		contentPane.add(lblVermovil);
		
		lblVeremail = new JLabel(cont.getEmail());
		lblVeremail.setBounds(79, 182, 127, 14);
		contentPane.add(lblVeremail);
		
		lblVerEmpresa = new JLabel(cont.getEmpresa());
		lblVerEmpresa.setBounds(106, 222, 225, 14);
		contentPane.add(lblVerEmpresa);
		
		lblVerCargo = new JLabel(cont.getCargo());
		lblVerCargo.setBounds(106, 264, 114, 14);
		contentPane.add(lblVerCargo);
		
		String tfno = Integer.toString(cont.getNum_e());
		lblVerTfno_empresa = new JLabel(tfno);
		lblVerTfno_empresa.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerTfno_empresa.setBounds(159, 305, 86, 14);
		contentPane.add(lblVerTfno_empresa);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(335, 301, 89, 23);
		btnAtrs.setActionCommand("atras");
		btnAtrs.addActionListener(this);
		contentPane.add(btnAtrs);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case "atras":
			
			frmTableContactos objTableContactos = new frmTableContactos();
			objTableContactos.setVisible(true);
			frmVerLaboral.this.dispose();
			break;
	}
}
}
