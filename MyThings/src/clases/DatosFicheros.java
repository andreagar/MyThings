package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class DatosFicheros {

	private final String rutaUsuarios = "Usuarios.dat";
//	private final String rutaSocios = "Socios.dat";
//	private final String rutaEmpleados = "Empleados.dat";
//	private final String rutaCompras = "Compras.dat";
	
	ObjectOutputStream oos; 
	ObjectInputStream ois;
	AppendableObjectOutputStream aos;
	
	public void GuardarDatos (Serializable a, int ruta){
		
		String fichero = null;
		File fic;
		
		
		switch (ruta){ //determinamos en qué fichero vamos a escribir
			case 1: fichero = rutaUsuarios; break;
//			case 2: fichero = rutaSocios; break;
//			case 3: fichero = rutaEmpleados; break;
//			case 4: fichero = rutaCompras; break;
		}
	
		fic = new File (fichero);
		if(fic.exists()) {
//		PARA COMPROBAR QUE SI EXISTE EL FICHERO, ESCRIBAMOS AL FINAL DE ESTE. ES MEJOR HACER ESTO.
		
			try {
				aos = new AppendableObjectOutputStream(new FileOutputStream(fic,true)); //¿HAY QUE PONER A NULL ESTE ARCHIVO?
				aos.writeObject(a);
				aos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		} else {
			try {
				fic.createNewFile();
				oos = new ObjectOutputStream(new FileOutputStream(fic));
				oos.writeObject(a);
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}
	}
	
	public ArrayList<Serializable> Read(int ruta) throws IOException {
		ArrayList<Serializable>lista;
		Serializable a=null;
		
		
		lista=new ArrayList<Serializable>();
		
		//COMPROBAMOS SI EXISTE EL FICHERO		
		String fichero = null;
		switch (ruta){ //determinamos en qué fichero vamos a escribir
			case 1: fichero = rutaUsuarios; break;
//			case 2: fichero = rutaSocios; break;
//			case 3: fichero = rutaEmpleados; break;
//			case 4: fichero = rutaCompras; break;
		}
		
		File fic;
		fic = new File(fichero);
		if (fic.exists()){
			try{
				ois = new ObjectInputStream(new FileInputStream(fic));
				while ((a = (Serializable)ois.readObject()) != null) {
				       lista.add(a);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//System.out.println("Ioexception");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//System.out.println("ClassNotFound");
				e.printStackTrace();
			}
			ois.close();
		}else {
			throw new IOException();
		}
		return lista;
	}
	
	public void Borrar (int ruta) {

		String fichero = null;
		switch (ruta){ //determinamos qué fichero vamos a borrar
			case 1: fichero = rutaUsuarios; break;
//			case 2: fichero = rutaSocios; break;
//			case 3: fichero = rutaEmpleados; break;
//			case 4: fichero = rutaCompras; break;
		}
		File fic = new File (fichero);
		if(fic.delete()) {
			System.out.println("Borrado");
			
		}else {
			System.out.println("Error:" + fic.getAbsolutePath());
			fic.setWritable(true);
			fic.delete();
		}
		
//		public void ResetFile (enFicDatos fichero)
//		{
//			String ruta =setFichero(fichero);
//			File f=new File(ruta);
//			f.delete();
//				
//		}
	}
}
