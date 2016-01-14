package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import clases.BaseDeDatos;
import clases.GestorTareas;
import clases.Tareas;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmTableContactos extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JButton btnAtras;
	ResultSet rs;
	GestorTareas tareas = new GestorTareas();
	private JTable jTable1;
	private JButton btnLaboral;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnPersonal;

	/**
	 * Create the frame.
	 */
	public frmTableContactos() {
		
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(frmTareas.class.getResource("/Imagenes/Beat.png")));
		setBackground(new Color(0, 153, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 397);
		contentPane = new PanelConImagen();
		this.setTitle("MyThings v1.0");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackgroundImage(contentPane.createImage("/Imagenes/fondo.jpg").getImage());
		
		JLabel lblTitulo = new JLabel("CONTACTOS");
		lblTitulo.setBounds(214, 22, 129, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(476, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 390, 301);
		contentPane.add(scrollPane);
		
		jTable1 = new JTable();
		scrollPane.setViewportView(jTable1);
		
		crearTabla();
		scrollPane.setViewportView(tabla);
		
		btnPersonal = new JButton("Agregar Personal");
		btnPersonal.setActionCommand("Agregar Personal");
		btnPersonal.addActionListener(this);
		btnPersonal.setBounds(448, 77, 115, 23);
		contentPane.add(btnPersonal);
		
		btnLaboral = new JButton("Agregar Laboral");
		btnLaboral.setBounds(448, 137, 115, 23);
		btnLaboral.setActionCommand("Agregar Laboral");
		btnLaboral.addActionListener(this);
		contentPane.add(btnLaboral);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(448, 196, 115, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(448, 258, 115, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		
			case "Agregar Personal": 
				frmTableContactos.this.dispose();
				frmAltaPersonal objPersonal = new frmAltaPersonal();
				objPersonal.setVisible(true);
				
				break;
				
			case "Agregar Laboral": 
				frmAltaLaboral objLaboral = new frmAltaLaboral();
				objLaboral.setVisible(true);
				frmTableContactos.this.dispose();
				break;
				
			case "Modificar":
								
				break;	
				
			case "Eliminar":
				
				break;
				
			case "Atras":
				frmPrincipal objPrincipal = new frmPrincipal();
				objPrincipal.setVisible(true);
				frmTableContactos.this.dispose();
				break;
		}
		
	}
	
	private void crearTabla() {
		
		final DefaultTableModel dtm = new DefaultTableModel();
		tabla = this.jTable1;
		tabla.setModel(dtm);
		
		dtm.setColumnIdentifiers(new Object[] {"Nombre", "Apellidos"});
		
		//para ordenar la JTable pinchando en el nombre de la columna
		TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
		tabla.setRowSorter(elQueOrdena);
		
		BaseDeDatos.getStatement();
		rs = tareas.SeleccionarTareas();
		try{
			while(rs.next()){
				dtm.addRow (new Object[] {rs.getString("nombre"), rs.getString("apell")});
			}
		}catch (Exception e){
		}
		
		tabla.addMouseListener(new MouseAdapter() 
		   {
		      public void mouseClicked(MouseEvent e) 
		      {
		         int fila = tabla.rowAtPoint(e.getPoint());
		         int columna = tabla.columnAtPoint(e.getPoint());
		         if ((fila > -1) && (columna > -1))
		            System.out.println(dtm.getValueAt(fila,columna));
		      }
		   });
	}
}