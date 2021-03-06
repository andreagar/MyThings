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

public class frmPrincipal extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JButton btnTareas;
	private JButton btnContactos;
	private JButton btnCerrarSesion;

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/Imagenes/Beat.png")));
		setBackground(new Color(175, 238, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 230);
		contentPane = new PanelConImagen();
		this.setTitle("MyThings v1.0");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblTitulo = new JLabel("Seleccione la opci\u00F3n que desee:");
		lblTitulo.setBounds(66, 23, 290, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnTareas = new JButton("Tareas");
		btnTareas.setBounds(171, 74, 89, 23);
		btnTareas.setActionCommand("Tareas");
		btnTareas.addActionListener(this);
		contentPane.add(btnTareas);
		
		btnContactos = new JButton("Contactos");
		btnContactos.setBounds(157, 108, 116, 23);
		btnContactos.setActionCommand("Contactos");
		btnContactos.addActionListener(this);
		contentPane.add(btnContactos);
		
		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(279, 168, 116, 23);
		btnCerrarSesion.setActionCommand("CerrarSesion");
		btnCerrarSesion.addActionListener(this);
		contentPane.add(btnCerrarSesion);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
	case "Tareas": 
		frmTableTareas objTareas = new frmTableTareas();
		objTareas.setVisible(true);
		break;
	case "Contactos": 
		frmTableContactos objContactos = new frmTableContactos();
		objContactos.setVisible(true);
		break;
	case "CerrarSesion":
		frmLogin objLogin = new frmLogin();
		objLogin.setVisible(true);
		break;	
	}
	frmPrincipal.this.dispose();
	}
}
