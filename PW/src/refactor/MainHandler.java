package refactor;

import java.io.IOException;
import java.sql.SQLException;

import refactor.UseCases.DeleteUserUseCase;
import refactor.UseCases.LoginUserUseCase;
import refactor.UseCases.RegisterAdminUseCase;
import refactor.UseCases.RegisterViewerUseCase;
import refactor.UseCases.UpdateUserDataUseCase;

/**
 * Clase que usa el patron de diseño singleton para gestionar la app
 * 
 * @author Javier De Santiago Palomino
 */

public class MainHandler {

    private static final MainHandler mainHandler = new MainHandler();

	/**
	 * Devuelve la única instancia de MainHandler
	 * 
	 * @return MainHandler
	 */

    public static MainHandler getHandler() {

		if (MainHandler.mainHandler == null) {

			MainHandler mainHandler = new MainHandler();
			return mainHandler;
		}

		return MainHandler.mainHandler;
	}

    
	/** 
	 * Funcion publica que se encargar de registrar los viewers
	 * 
	 * @param name Nombre del usuario
	 * @param lastName Apellido del usuario
	 * @param nickName Nick del usuario
	 * @param mail Correo del usuario 
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:

        The forName method in class Class.
        The findSystemClass method in class ClassLoader .
        The loadClass method in class ClassLoader. 
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 */

	public void registerViewer(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        RegisterViewerUseCase.registerViewer(name, lastName, nickName, mail);
    }

	
	/** 
	 * Funcion publica para registrar al administrador
	 * 
	 * @param name Nombre del administrador
	 * @param lastName Apellido del administrador
	 * @param nickName Nick del administrador
	 * @param mail Mail del administrador
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:

       The forName method in class Class.
       The findSystemClass method in class ClassLoader .
       The loadClass method in class ClassLoader. 
	 * @throws SQLException An exception that provides information on a database access error or other errors. 
	 */
	public void registerAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        RegisterAdminUseCase.registerAdmin(name, lastName, nickName, mail);
    }

	/**
	 * Funcion publica para borrar usuarios a partir del mail
	 * 
	 * @param mail Mail del usuario
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */

	public void deleteUser(String mail) throws IOException{

		DeleteUserUseCase.deleteUser(mail);
	}
    
	
	/** 
	 * Funcion publica para loguear a los usuarios a partir del mail
	 * 
	 * @param mail Mail del usuario
	 * @return Boolean 
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 */
	public Boolean loginUser(String mail) throws IOException{

		return LoginUserUseCase.loginUser(mail);
	}

	
	/** 
	 * Funcion publica para actualizar los datos del usuario
	 * 
	 * @param userMail Correo del usuario
	 * @param name Nombre del usuario
	 * @param lastName Apellido del usuario
	 * @param nickName Nick del usuario
	 * @param mail Mail del usuario
	 */
	public void updateUserData(String userMail, String name, String lastName, String nickName, String mail){

		UpdateUserDataUseCase.updateUserData(userMail, name, lastName, nickName, mail);
	}

}
