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
	private JButton btnAgregar;
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
		this.setTitle("Beat v1.0");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblTitulo = new JLabel("CONTACTOS");
		lblTitulo.setBounds(214, 11, 89, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 352, 299);
		contentPane.add(scrollPane);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(389, 70, 89, 23);
		btnAgregar.setActionCommand("Agregar");
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(389, 113, 89, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(389, 151, 89, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(389, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
	case "Agregar": 
		
		break;
	case "Eliminar": 
		
		break;
	case "Modificar":
		
		break;	
	case "Atras":
		frmPrincipal objPrincipal = new frmPrincipal();
		objPrincipal.setVisible(true);
	}
	frmContactos.this.dispose();
	}
}
