package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorUsuarios;
import clases.MiExcepcion;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class frmAltaTarea extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JButton btnGuardar;
	private JTextField txtLocalizacion;


	/**
	 * Create the frame.
	 */
	public frmAltaTarea() {
		setResizable(false);
		this.setTitle("MyThings v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 325);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGuardar, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGuardar, -10, SpringLayout.EAST, contentPane);
		btnGuardar.setActionCommand("guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		JLabel lblAltaDeUsuario = new JLabel("NUEVA TAREA");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltaDeUsuario, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltaDeUsuario, 133, SpringLayout.WEST, contentPane);
		lblAltaDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblAltaDeUsuario);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDescripcin, 65, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDescripcin, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblDescripcin);
		
		JLabel lblFechaInicio = new JLabel("Desde:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFechaInicio, 24, SpringLayout.SOUTH, lblDescripcin);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaInicio, 0, SpringLayout.WEST, lblDescripcin);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Hasta:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFechaFin, 17, SpringLayout.SOUTH, lblFechaInicio);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaFin, 0, SpringLayout.WEST, lblDescripcin);
		contentPane.add(lblFechaFin);
		
		JTextPane txtDescripcion = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtDescripcion, 16, SpringLayout.SOUTH, lblAltaDeUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtDescripcion, 11, SpringLayout.EAST, lblDescripcin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtDescripcion, 15, SpringLayout.SOUTH, lblDescripcin);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtDescripcion, 251, SpringLayout.EAST, lblDescripcin);
		contentPane.add(txtDescripcion);
		
		JDateChooser FechaInicio = new JDateChooser();
		sl_contentPane.putConstraint(SpringLayout.WEST, FechaInicio, 0, SpringLayout.WEST, txtDescripcion);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, FechaInicio, 0, SpringLayout.SOUTH, lblFechaInicio);
		contentPane.add(FechaInicio);
		
		JDateChooser FechaFin = new JDateChooser();
		sl_contentPane.putConstraint(SpringLayout.WEST, FechaFin, 0, SpringLayout.WEST, txtDescripcion);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, FechaFin, 0, SpringLayout.SOUTH, lblFechaFin);
		contentPane.add(FechaFin);
		
		JLabel lblTiempoDeViaje = new JLabel("Tiempo de viaje:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTiempoDeViaje, 0, SpringLayout.WEST, lblDescripcin);
		contentPane.add(lblTiempoDeViaje);
		
		JLabel lblLocalizacin = new JLabel("Localizaci\u00F3n:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblLocalizacin, -72, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTiempoDeViaje, -19, SpringLayout.NORTH, lblLocalizacin);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLocalizacin, 0, SpringLayout.WEST, lblDescripcin);
		contentPane.add(lblLocalizacin);
		
		JLabel lblImportancia = new JLabel("Importancia:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImportancia, 18, SpringLayout.SOUTH, lblLocalizacin);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImportancia, 0, SpringLayout.WEST, lblDescripcin);
		contentPane.add(lblImportancia);
		
		JComboBox TiempoViaje = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, TiempoViaje, -3, SpringLayout.NORTH, lblTiempoDeViaje);
		sl_contentPane.putConstraint(SpringLayout.WEST, TiempoViaje, 24, SpringLayout.EAST, lblTiempoDeViaje);
		sl_contentPane.putConstraint(SpringLayout.EAST, TiempoViaje, 52, SpringLayout.EAST, lblTiempoDeViaje);
		contentPane.add(TiempoViaje);
		
		txtLocalizacion = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtLocalizacion, 0, SpringLayout.WEST, txtDescripcion);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtLocalizacion, 0, SpringLayout.SOUTH, lblLocalizacin);
		contentPane.add(txtLocalizacion);
		txtLocalizacion.setColumns(10);
		
		JComboBox Importancia = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Importancia, 0, SpringLayout.SOUTH, lblImportancia);
		sl_contentPane.putConstraint(SpringLayout.EAST, Importancia, 0, SpringLayout.EAST, TiempoViaje);
		contentPane.add(Importancia);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestorUsuarios emp = new GestorUsuarios();
		switch (e.getActionCommand()) {
		
			case "guardar": 
					
				frmLogin objLogin = new frmLogin();
				objLogin.setVisible(true);
				break;
			}
			frmAltaTarea.this.dispose();
	}
}