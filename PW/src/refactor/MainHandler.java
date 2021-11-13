package refactor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.UserRepository;
import refactor.UseCases.CreateMultiplePassShowUseCase;
import refactor.UseCases.CreateReviewUseCase;
import refactor.UseCases.CreateSeasonShowUseCase;
import refactor.UseCases.DeleteReviewByTitleUseCase;
import refactor.UseCases.CreatePunctualShowUseCase;
import refactor.UseCases.DeleteUserUseCase;
import refactor.UseCases.GetAllReviewsUseCase;
import refactor.UseCases.GetAllShowsUseCase;
import refactor.UseCases.GetAllUsersMailsUseCase;
import refactor.UseCases.GetReviewByTitleUseCase;
import refactor.UseCases.LoginUserUseCase;
import refactor.UseCases.RateReviewByUser;
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


	public ArrayList<String> getAllUsersMails(){

		return GetAllUsersMailsUseCase.getAllUsersMails();
	}


	public void createReview(String userMail, String title, String text, String show, Integer intscore) throws IOException{

		Score score = new Score(intscore);
		CreateReviewUseCase.createReview(userMail, title, text, show, score);
	}


	public ArrayList<Review> getAllReviews() throws IOException{

		return GetAllReviewsUseCase.getAllReviews();
	}


	public void deleteReviewByTitle(String title){
		DeleteReviewByTitleUseCase.deleteReviewByTitle(title);
	} 


    public void createPunctualShow(String title, String description, String category, Integer capacity, Calendar date) {
    
		CreatePunctualShowUseCase.createPunctualShow(title, description, category, capacity, date);
	}


	public void createMultipleDateShow(String title, String description, String category, Integer capacity, ArrayList<Calendar> dates) {
    
		CreateMultiplePassShowUseCase.createMultiplePassShow(title, description, category, capacity, dates);
	}


	public void createSeasonPassDateShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, Integer weekDay) {
    
		CreateSeasonShowUseCase.createSeasonShow(title, description, category, capacity, beginDate, endDate, weekDay);
	}

	public ArrayList<Show> getAllShows(){

		return GetAllShowsUseCase.getAllShows();
	}

	public Review getReviewByTitle(String title){

		return GetReviewByTitleUseCase.getReviewByTitle(title);
	}
	
	public void rateReviewByUser(Review review, String userMail, Integer score){

		RateReviewByUser.rateReviewByUser(review, userMail, score);
	}
}
