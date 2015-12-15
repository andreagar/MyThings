package clases;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class GestorUsuarios {

	HashSet<Usuarios> setUsuarios;
	
	public GestorUsuarios(){		
		
		setUsuarios = new HashSet<Usuarios>();
	}

	public void AñadirUsuario (String nomLI, String nombreR, String apell, String password) throws MiExcepcion{

		DatosFicheros datos = new DatosFicheros();
		Usuarios usuario = new Usuarios();
		//1. leemos todos los usuarios y los llevamos a un set 2. metemos el nuevo usuario
		
		try {
			
			ArrayList<Serializable> listaS = datos.Read(1);
			
			for(Serializable a: listaS)
				setUsuarios.add((Usuarios)a);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} 
		
		usuario.setNomLogIn(nomLI);
		usuario.setNombreReal(nombreR);
		usuario.setApellidos(apell);
		usuario.setPassword(password);
		
		if(setUsuarios.add(usuario)){
			datos.GuardarDatos(usuario, 3);
		} else{
			throw new MiExcepcion();
		}		
	}
	
	public boolean Login(String usuario, String password){
		
		DatosFicheros datos = new DatosFicheros();
		boolean entrar = false;
		ArrayList<Usuarios> este = new ArrayList<Usuarios>();
		
		try {
			ArrayList<Serializable>listaS =datos.Read(1);
			setUsuarios.clear();
			for(Serializable a: listaS)
				este.add((Usuarios)a);					
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} 
		
		for (Usuarios w: este){
			if ((usuario.equals(w.getNomLogIn())) && (password.equals(w.getPassword()))) {
				entrar = true;
			}
		}
		if (usuario.equals("admin") && (password.equals("admin"))){
			entrar = true;
		}
		return entrar;
	}
}
