package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorUsuarios;
import clases.MiExcepcion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.KeyStroke;


import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class frmExcepcion extends JFrame implements ActionListener{

	private PanelConImagen contentPane;
	private JPasswordField passwordField;
	private JButton btnAceptar;


	/**
	 * Create the frame.
	 * @param excepcion 
	 */
	public frmExcepcion(String excepcion) {
		setResizable(false);
		this.setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 181);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		contentPane.setLayout(null);
		
		JLabel lblInicioDeSesin = new JLabel("\u00A1ATENCI\u00D3N!");
		lblInicioDeSesin.setBounds(184, 11, 152, 27);
		lblInicioDeSesin.setFont(new Font("Verdana", Font.PLAIN, 22));
		contentPane.add(lblInicioDeSesin);
		
		setContentPane(contentPane);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(193, 119, 126, 23);
		btnAceptar.setActionCommand("Aceptar");
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
				
		JLabel lblExcepcion = new JLabel(excepcion);
		lblExcepcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcepcion.setBounds(10, 46, 481, 62);
		contentPane.add(lblExcepcion);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios usuario = new GestorUsuarios();
		switch (e.getActionCommand()) {
			
			case "Aceptar":				
				frmExcepcion.this.dispose();
				
			break;
		}
		
	}
}
