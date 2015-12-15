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
		
	}
	
	public boolean Login (String usuario, String password){

		return true;
	}
}
