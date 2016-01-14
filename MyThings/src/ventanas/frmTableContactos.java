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
import clases.Contacto;
import clases.GestorContactos;
import clases.GestorTareas;
import clases.Laboral;
import clases.MiExcepcion;
import clases.Personal;
import clases.Tareas;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;

public class frmTableContactos extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable tabla;
	private JTable tabla_1;
	private JButton btnAtras;
	ResultSet rs;
	GestorContactos contacto = new GestorContactos();
	private JTable jTable1;
	private JTable jTable2;
	private JButton btnLaboral;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnPersonal;
	private JButton btnVerContacto;

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
		lblTitulo.setBounds(198, 22, 129, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(476, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 390, 122);
		contentPane.add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 236, 390, 122);
		contentPane.add(scrollPane_1);
		
		jTable1 = new JTable();
		scrollPane.setViewportView(jTable1);
		
		jTable2 = new JTable();
		scrollPane_1.setViewportView(jTable2);
		
		crearTabla();
		scrollPane.setViewportView(tabla);
		crearTabla1();
		scrollPane_1.setViewportView(tabla_1);
		
		
		btnPersonal = new JButton("Agregar Personal");
		btnPersonal.setActionCommand("Agregar Personal");
		btnPersonal.addActionListener(this);
		btnPersonal.setBounds(448, 128, 115, 23);
		contentPane.add(btnPersonal);
		
		btnLaboral = new JButton("Agregar Laboral");
		btnLaboral.setBounds(448, 162, 115, 23);
		btnLaboral.setActionCommand("Agregar Laboral");
		btnLaboral.addActionListener(this);
		contentPane.add(btnLaboral);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(448, 196, 115, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(448, 233, 115, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnVerContacto = new JButton("Ver contacto");
		btnVerContacto.setBounds(448, 92, 117, 23);
		btnVerContacto.setActionCommand("Ver contacto");
		btnVerContacto.addActionListener(this);
		contentPane.add(btnVerContacto);
		
		JLabel lblLaboral = new JLabel("LABORAL:");
		lblLaboral.setBounds(10, 211, 74, 14);
		contentPane.add(lblLaboral);
		
		JLabel lblPersonal = new JLabel("PERSONAL:");
		lblPersonal.setBounds(10, 55, 89, 14);
		contentPane.add(lblPersonal);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		
			case "Ver contacto":
				
				if (tabla.getSelectedRow()!=-1){
					
						int filaE = tabla.getSelectedRow();
						String nombre = tabla.getValueAt(filaE, 0).toString();
						String apellidos = tabla.getValueAt(filaE, 1).toString();
						String correo = tabla.getValueAt(filaE, 2).toString();
						String movil = tabla.getValueAt(filaE, 3).toString();
						String imagen = tabla.getValueAt(filaE, 4).toString();
						String domi = tabla.getValueAt(filaE, 5).toString();
						String telf_domi = tabla.getValueAt(filaE, 6).toString();
						String f_naci = tabla.getValueAt(filaE, 7).toString();
						
					Personal cont = new Personal();
						cont.setNombre(nombre);
						cont.setApellidos(apellidos);
						cont.setEmail(correo);
						cont.setNum_m(Integer.parseInt(movil));
						cont.setFoto(imagen);
						cont.setDomicilio(domi);
						cont.setNum_d(Integer.parseInt(telf_domi));
						cont.setNacimiento(f_naci);
						
						frmVerPersonal objVerPersonal = new frmVerPersonal(cont);
						objVerPersonal.setVisible(true);
					}
					
				else if (tabla_1.getSelectedRow()!=-1){
					
					int filaE = tabla_1.getSelectedRow();
					String nombre1 = tabla_1.getValueAt(filaE, 0).toString();
					String apellidos1 = tabla_1.getValueAt(filaE, 1).toString();
					String correo1 = tabla_1.getValueAt(filaE, 2).toString();
					String movil1 = tabla_1.getValueAt(filaE, 3).toString();
					String imagen1 = tabla_1.getValueAt(filaE, 4).toString();
					String empresa = tabla_1.getValueAt(filaE, 5).toString();
					String cargo = tabla_1.getValueAt(filaE, 6).toString();
					String tfno_emp = tabla_1.getValueAt(filaE, 7).toString();
					
				Laboral cont = new Laboral();
					cont.setNombre(nombre1);
					cont.setApellidos(apellidos1);
					cont.setEmail(correo1);
					cont.setNum_m(Integer.parseInt(movil1));
					cont.setFoto(imagen1);
					cont.setEmpresa(empresa);
					cont.setCargo(cargo);
					cont.setNum_e(Integer.parseInt(tfno_emp));
					
					frmVerLaboral objVerLaboral = new frmVerLaboral(cont);
					objVerLaboral.setVisible(true);
					}
	
				break;
	
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
				if (tabla.getSelectedRow()!=-1){
					
					int filaE = tabla.getSelectedRow();
					String nombre = tabla.getValueAt(filaE, 0).toString();
					String apellidos = tabla.getValueAt(filaE, 1).toString();
					String correo = tabla.getValueAt(filaE, 2).toString();
					String movil = tabla.getValueAt(filaE, 3).toString();
					String imagen = tabla.getValueAt(filaE, 4).toString();
					String domi = tabla.getValueAt(filaE, 5).toString();
					String telf_domi = tabla.getValueAt(filaE, 6).toString();
					String f_naci = tabla.getValueAt(filaE, 7).toString();
					
				Personal cont = new Personal();
					cont.setNombre(nombre);
					cont.setApellidos(apellidos);
					cont.setEmail(correo);
					cont.setNum_m(Integer.parseInt(movil));
					cont.setFoto(imagen);
					cont.setDomicilio(domi);
					cont.setNum_d(Integer.parseInt(telf_domi));
					cont.setNacimiento(f_naci);
					
					frmModificarContactoPersonal objModificarPersonal = new frmModificarContactoPersonal(cont);
					objModificarPersonal.setVisible(true);
				}
				
			else if (tabla_1.getSelectedRow()!=-1){
				
				
				int filaE = tabla_1.getSelectedRow();
				String nombre1 = tabla_1.getValueAt(filaE, 0).toString();
				String apellidos1 = tabla_1.getValueAt(filaE, 1).toString();
				String correo1 = tabla_1.getValueAt(filaE, 2).toString();
				String movil1 = tabla_1.getValueAt(filaE, 3).toString();
				String imagen1 = tabla_1.getValueAt(filaE, 4).toString();
				String empresa = tabla_1.getValueAt(filaE, 5).toString();
				String cargo = tabla_1.getValueAt(filaE, 6).toString();
				String tfno_emp = tabla_1.getValueAt(filaE, 7).toString();
				
			Laboral cont1 = new Laboral();
				cont1.setNombre(nombre1);
				cont1.setApellidos(apellidos1);
				cont1.setEmail(correo1);
				cont1.setNum_m(Integer.parseInt(movil1));
				cont1.setFoto(imagen1);
				cont1.setEmpresa(empresa);
				cont1.setCargo(cargo);
				cont1.setNum_e(Integer.parseInt(tfno_emp));
				
				frmModificarContactoLaboral objModificarLaboral = new frmModificarContactoLaboral(cont1);
				objModificarLaboral.setVisible(true);
				}

			break;	
				
			case "Eliminar":
				
				if (tabla.getSelectedRow()!=-1){
					
					int filaE = tabla.getSelectedRow();
					String nombre = tabla.getValueAt(filaE, 0).toString();
					String apellidos = tabla.getValueAt(filaE, 1).toString();
					String correo = tabla.getValueAt(filaE, 2).toString();
					String movil = tabla.getValueAt(filaE, 3).toString();
					String imagen = tabla.getValueAt(filaE, 4).toString();
					String domi = tabla.getValueAt(filaE, 5).toString();
					String telf_domi = tabla.getValueAt(filaE, 6).toString();
					String f_naci = tabla.getValueAt(filaE, 7).toString();
					
					contacto.EliminarContactoPersonal(nombre, apellidos, correo, movil, imagen, domi, telf_domi, f_naci);
					crearTabla();
	//				} catch(Exception e2){
	//					try {
	//						throw new MiExcepcion();
	//					} catch (MiExcepcion e1) {
	//						frmExcepcion objExcepcion = new frmExcepcion(e1.SinSeleccionar());
	//						objExcepcion.setVisible(true);
	//					}
	//				}
				}
				
			else if (tabla_1.getSelectedRow()!=-1){
				
				int filaE = tabla_1.getSelectedRow();
				String nombre1 = tabla_1.getValueAt(filaE, 0).toString();
				String apellidos1 = tabla_1.getValueAt(filaE, 1).toString();
				String correo1 = tabla_1.getValueAt(filaE, 2).toString();
				String movil1 = tabla_1.getValueAt(filaE, 3).toString();
				String imagen1 = tabla_1.getValueAt(filaE, 4).toString();
				String empresa = tabla_1.getValueAt(filaE, 5).toString();
				String cargo = tabla_1.getValueAt(filaE, 6).toString();
				String tfno_emp = tabla_1.getValueAt(filaE, 7).toString();
				
//				contacto.EliminarContactoLaboral(nombre1, apellidos1, correo1, movil1, imagen1, empresa, cargo, tfno_emp);
//				crearTabla1();
			}
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
		
		dtm.setColumnIdentifiers(new Object[] {"Nombre", "Apellidos", "", "", "", "", "", "", ""});
		
		//ocultar columnas
		tabla.getColumnModel().getColumn(2).setMaxWidth(0);
		tabla.getColumnModel().getColumn(3).setMaxWidth(0);
		tabla.getColumnModel().getColumn(4).setMaxWidth(0);
		tabla.getColumnModel().getColumn(5).setMaxWidth(0);
		tabla.getColumnModel().getColumn(6).setMaxWidth(0);
		tabla.getColumnModel().getColumn(7).setMaxWidth(0);
		tabla.getColumnModel().getColumn(8).setMaxWidth(0);
		
		tabla.getColumnModel().getColumn(2).setMinWidth(0);
		tabla.getColumnModel().getColumn(3).setMinWidth(0);
		tabla.getColumnModel().getColumn(4).setMinWidth(0);
		tabla.getColumnModel().getColumn(5).setMinWidth(0);
		tabla.getColumnModel().getColumn(6).setMinWidth(0);
		tabla.getColumnModel().getColumn(7).setMinWidth(0);
		tabla.getColumnModel().getColumn(8).setMinWidth(0);
		
		tabla.getColumnModel().getColumn(2).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(7).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
		
		//para ordenar la JTable pinchando en el nombre de la columna
		TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
		tabla.setRowSorter(elQueOrdena);
		
		BaseDeDatos.getStatement();
		rs = contacto.SeleccionarTareas();
		try{
			while(rs.next()){
				dtm.addRow (new Object[] {rs.getString("nombre"), rs.getString("apell"), rs.getString("email"),
						rs.getString("movil"),rs.getString("imagen"),rs.getString("domicilio"), 
						rs.getString("tfno_domicilio"), rs.getString("fecha_n"),rs.getString("nomLogIn")});
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
	
	private void crearTabla1() {
		
		final DefaultTableModel dtm = new DefaultTableModel();
		tabla_1 = this.jTable2;
		tabla_1.setModel(dtm);
		
		dtm.setColumnIdentifiers(new Object[] {"Nombre", "Apellidos"});
		
		//para ordenar la JTable pinchando en el nombre de la columna
		TableRowSorter<TableModel> Ordena = new TableRowSorter<TableModel>(dtm);
		tabla_1.setRowSorter(Ordena);
		
		BaseDeDatos.getStatement();
		rs = contacto.SeleccionarTareas1();
		try{
			while(rs.next()){
				dtm.addRow (new Object[] {rs.getString("nombre"), rs.getString("apell")});
			}
		}catch (Exception e){
		}
		
		tabla_1.addMouseListener(new MouseAdapter() 
		   {
		      public void mouseClicked(MouseEvent e) 
		      {
		         int fila = tabla_1.rowAtPoint(e.getPoint());
		         int columna = tabla_1.columnAtPoint(e.getPoint());
		         if ((fila > -1) && (columna > -1))
		            System.out.println(dtm.getValueAt(fila,columna));
		      }
		   });
	}
}