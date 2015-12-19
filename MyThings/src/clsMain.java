import ventanas.frmLogin;
import clases.BaseDeDatos;
public class clsMain {

	/**
	 * 
	 * @param args
	 * Llama a la ventana del Log In para inicializar el programa
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseDeDatos.initBD( "MyThings.BD" ); //inicializar conexión con la BD
		BaseDeDatos.crearTablaUsuario();
		
		frmLogin menu = new frmLogin();
		menu.setVisible(true);
	}

}
