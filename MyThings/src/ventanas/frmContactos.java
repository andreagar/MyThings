package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class frmContactos extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JButton btnAgregarPer;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public frmContactos() {
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(frmContactos.class.getResource("/Imagenes/Beat.png")));
		setBackground(new Color(0, 153, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 397);
		contentPane = new PanelConImagen();
		this.setTitle("MyThings v1.0");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblTitulo = new JLabel("CONTACTOS");
		lblTitulo.setBounds(176, 11, 136, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 327, 299);
		contentPane.add(scrollPane);
		
		btnAgregarPer = new JButton("Agregar Personal");
		btnAgregarPer.setBounds(347, 70, 131, 23);
		btnAgregarPer.setActionCommand("Agregar");
		btnAgregarPer.addActionListener(this);
		contentPane.add(btnAgregarPer);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(347, 202, 131, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(347, 158, 131, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(389, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		JButton btnAgregarL = new JButton("Agregar Laboral");
		btnAgregarL.setActionCommand("Agregar");
		btnAgregarL.setBounds(347, 114, 131, 23);
		contentPane.add(btnAgregarL);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
	case "Agregar Personal": 
		frmAltaContPersonal objAltaContPersonal = new frmAltaContPersonal();
		objAltaContPersonal.setVisible(true);
		break;
		
	case "Agregar Laboral": 
		frmAltaContLaboral objAltaContLaboral = new frmAltaContLaboral();
		objAltaContLaboral.setVisible(true);
		break;
		
	case "Eliminar": 
		break;
		
	case "Modificar":
		
		break;	
	case "Atras":
		frmPrincipal objPrincipal = new frmPrincipal();
		objPrincipal.setVisible(true);
		break;
	}
	frmContactos.this.dispose();
	}
}
