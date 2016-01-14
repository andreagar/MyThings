package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class frmTableTareas extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTable tabla;
	private JButton btnModificar;
	private JButton btnAtras;
	ResultSet rs;
	GestorTareas tareas = new GestorTareas();
	private JTable jTable1;

	/**
	 * Create the frame.
	 */
	public frmTableTareas() {
		
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
		
		JLabel lblTitulo = new JLabel("TAREAS");
		lblTitulo.setBounds(214, 22, 89, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(476, 81, 89, 23);
		btnAgregar.setActionCommand("Agregar");
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(476, 132, 89, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(476, 183, 89, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(476, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 456, 301);
		contentPane.add(scrollPane);
		
		jTable1 = new JTable();
		scrollPane.setViewportView(jTable1);
		
		crearTabla();
		scrollPane.setViewportView(tabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		
			case "Agregar": 
				frmAltaTarea objAltaTarea = new frmAltaTarea();
				objAltaTarea.setVisible(true);
				frmTableTareas.this.dispose();
				break;
			case "Eliminar": 
					int fila = tabla.getSelectedRow();
					String fechaI = tabla.getValueAt(fila, 0).toString();
					String fechaF = tabla.getValueAt(fila, 1).toString();
					String imp = tabla.getValueAt(fila, 2).toString();
					String loc = tabla.getValueAt(fila, 3).toString();
					String tiempo = tabla.getValueAt(fila, 4).toString();
					String desc = tabla.getValueAt(fila, 5).toString();
				tareas.EliminarTarea(fechaI, fechaF, imp, loc, tiempo, desc);
				break;
			case "Modificar":
				
				break;	
			case "Atras":
				frmPrincipal objPrincipal = new frmPrincipal();
				objPrincipal.setVisible(true);
		}
		frmTableTareas.this.dispose();
	}
	
	private void crearTabla() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		tabla = this.jTable1;
		tabla.setModel(dtm);
		
		dtm.setColumnIdentifiers(new Object[] {"Fecha inicio", "Fecha Fin", "Importancia", "Localizacion", 
				"Tiempo viaje", "Descripcion"});
		
		//para ordenar la JTable pinchando en el nombre de la columna
		TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
		tabla.setRowSorter(elQueOrdena);
		
		BaseDeDatos.getStatement();
		rs = tareas.SeleccionarTareas();
		try{
			while(rs.next()){
				dtm.addRow (new Object[] {rs.getString("fecha_i"), rs.getString("fecha_f"), 
				rs.getString("importancia"), rs.getString("localizacion"), rs.getInt("tiempo_v"), 
				rs.getString("descripcion"), rs.getString("nomLogIn")});
			}
		}catch (Exception e){
		}
	}
}