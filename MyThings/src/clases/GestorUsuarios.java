package clases;

import java.util.HashSet;

public class GestorUsuarios {

	HashSet<Usuarios> setUsuarios;
	BaseDeDatos bd;
	
	public GestorUsuarios(){		
		setUsuarios = new HashSet<Usuarios>();
	}
	
	/**Añadir un nuevo usuario a la BD
	 *Primero metemos en un HashSet los usuarios que hay, comparamos que el nuevo no se repita
	 *Si no se repite se mete dentro de la BD, sino sacamos un mensaje de error
	 */
	public void AñadirUsuario (String nomLI, String nombreR, String apell, String password) throws MiExcepcion{
		Usuarios u = new Usuarios(nomLI, nombreR,apell,password);
		if (setUsuarios.add(u))
			bd.insertUsuario(nomLI, nombreR, apell, password);
	}
	
	public boolean Login (String usuario, String password){
		return true;
	}
}
