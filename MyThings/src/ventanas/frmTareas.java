package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import LN.clsEmpleado;
import clases.GestorTareas;
import clases.Tareas;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmTareas extends JFrame implements ActionListener {

	private PanelConImagen contentPane;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTable table;
	private JButton btnModificar;
	private JButton btnAtras;
	ArrayList<Tareas> listaTareas;
	GestorTareas tareas = new GestorTareas();

	/**
	 * Create the frame.
	 */
	public frmTareas() {
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(frmTareas.class.getResource("/Imagenes/Beat.png")));
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
		
		JLabel lblTitulo = new JLabel("TAREAS");
		lblTitulo.setBounds(214, 22, 89, 27);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(389, 81, 89, 23);
		btnAgregar.setActionCommand("Agregar");
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(387, 124, 89, 23);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(389, 166, 89, 23);
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(389, 335, 89, 23);
		btnAtras.setActionCommand("Atras");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		crearTabla();
		scrollPane.setViewportView(table);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
	case "Agregar": 
		frmAltaTarea objAltaTarea = new frmAltaTarea();
		objAltaTarea.setVisible(true);
		break;
	case "Eliminar": 
		
		break;
	case "Modificar":
		
		break;	
	case "Atras":
		frmPrincipal objPrincipal = new frmPrincipal();
		objPrincipal.setVisible(true);
	}
	frmTareas.this.dispose();
	}
	
	private void crearTabla()
	{
		table=null;
		
		listaTareas = new ArrayList<Tareas>();
		listaTareas = tareas.ArrayTareas(); //DE ESTA FORMA NO ME DA NULL.POINTER.EXCEPTION, PERO LA LISTA ME SALE VACIA
		
		TablaDiscosModel tcm=new TablaDiscosModel(listaTareas);
//********************************************************************************************************************		
		table = new JTable(tcm);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
	}
	
	class TablaDiscosModel extends AbstractTableModel
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"Nombre", "DNI", "Email", "Password"};
        Object[][] data;
        
        public TablaDiscosModel(ArrayList<Tareas> m)
        {
        	
        	super();
        	
    		int filas = m.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (Tareas entry : listaTareas)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]a={new String(entry.getNombre()),
    					   new String(entry.getDni()),
    					   new String(entry.getEmail()),
    					   new String(entry.getPassword())};
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(ArrayList<Tareas> m) 
        {
        	int filas = m.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (Tareas entry : listaTareas)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]a={new String(entry.getNombre()),
 					   new String(entry.getDni()),
 					   new String(entry.getEmail()),
 					   new String(entry.getPassword())};
    			data[cont]=a;
    			cont++;
    		}
        }

		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
		
		public String getColumnName (int col){
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
            return data[row][col];
		}
    }
}
