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

public class frmTareas extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JButton btnTareas;
	private JButton btnContactos;

	/**
	 * Create the frame.
	 */
	public frmTareas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmTareas.class.getResource("/Imagenes/Beat.png")));
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
		contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblTitulo = new JLabel("Seleccione la opci\u00F3n que desee:");
		lblTitulo.setBounds(100, 24, 290, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnTareas = new JButton("Tareas");
		btnTareas.setBounds(193, 101, 89, 23);
		btnTareas.addActionListener(this);
		contentPane.add(btnTareas);
		
		btnContactos = new JButton("Contactos");
		btnContactos.setBounds(178, 168, 116, 23);
		btnContactos.addActionListener(this);
		contentPane.add(btnContactos);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
	case "Clientes": 
		frmClientes objClientes = new frmClientes();
		objClientes.setVisible(true);
		break;
	case "Proveedores": 
		frmProveedores objProveedores = new frmProveedores();
		objProveedores.setVisible(true);
		break;
	case "Empleados":
		frmEmpleados objEmpleados = new frmEmpleados();
		objEmpleados.setVisible(true);
		break;	
	}
	frmTareas.this.dispose();
	}
}
