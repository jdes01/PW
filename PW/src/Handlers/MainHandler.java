package Handlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.DTO.MultipleDate;
import Model.DTO.PeriodicDate;
import Model.DTO.Score;
import Model.DTO.SingleDate;
import Model.Entities.Review.Review;
import Model.Entities.Show.Show;
import Model.Entities.Show.ShowFactory;
import Model.Entities.User;
import Model.Repository.ReviewRepository;
import Model.Repository.ShowRepository;
import Model.Repository.UserRepository;

/**
 * Clase que usa el patron de diseño singleton para gestionar la app
 * 
 * @author Javier De Santiago Palomino
 */
public class MainHandler implements ReviewHandlerInterface, UserHandlerInterface, ShowHandlerInterface {

	private static final MainHandler mainHandler = new MainHandler();

	// inject repositories

	private UserRepository userRepository;
	private ReviewRepository reviewRepository;
	private ShowRepository showRepository;

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
	 * Constructor de MainHandler
	 */
	private MainHandler() {

		this.userRepository = new UserRepository();
		this.reviewRepository = new ReviewRepository();
		this.showRepository = new ShowRepository();
	}

	////// HANDLE REVIEWS ///////

	/**
	 * Funcion para crear reviews
	 * 
	 * @param user Usuario que crea la review
	 */
	public Review createReview(User user) {

		Scanner scanner = new Scanner(System.in);
		Review review = null;

		try {

			System.out.println("please, give a title to the review");

			String title = scanner.nextLine();

			System.out.println("please, rate the film");

			int rate = scanner.nextInt();
			Score score = new Score(rate);

			System.out.println("please, type a brief review");

			String review_text = scanner.nextLine();

			review = new Review(user, title, score, review_text);

			this.reviewRepository.saveReview(review);

		} finally {
			if (scanner != null)
				scanner.close();
		}

		return review;
	}

	/**
	 * Getter de reviews
	 * 
	 * @return Retorna las reviews
	 */
	public ArrayList<Review> getReviews() {

		ArrayList<Review> reviews = this.reviewRepository.getReviews();

		return reviews;
	}

	/**
	 * Funcion para borrar reviews
	 * 
	 * @param review Review que se va a borra
	 */
	public void deleteReview(Review review) {

		try {
			this.reviewRepository.deleteReview(review);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Envia la review
	 * 
	 * @param review Review
	 * @param user   Usuario
	 * @param score  Score
	 */
	public void voteReview(Review review, User user, Score score) {

		review.addUserReview(user, score);
	}

	////// HANDLE USERS ////////

	/**
	 * Funcion para crear un usuario añadiendo sus datos
	 */
	public void createUser() {

		Scanner scanner = new Scanner(System.in);
		String name = null;
		String username = null;
		String mail = null;

		try {

			System.out.println("please, write your full name");

			name = scanner.nextLine();

			System.out.println("please, write your nick");

			username = scanner.nextLine();
			if(username.contains(" ")) {
				System.out.println("[!] Invalid username. Username should be without whitespaces. ");
				return;
			}

			System.out.println("please, write your mail");

			mail = scanner.nextLine();

			User user = new User(name, username, mail);

			try {
				this.userRepository.saveUser(user);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		} finally

		{
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * Funcion publica para borrar usuarios
	 * 
	 * @param user Usuario
	 */

	public void deleteUser() {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("please, give the name from the user you want to delete");

			String name = scanner.nextLine();

			User user = getUser(name);

			if (user != null) {
				System.out.println("User by name " + user.getName() + " was deleted.");
				this.userRepository.deleteUser(user);
			} else {
				System.out.println("Sorry, there is no user with that name.");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		scanner.close();
	}

	/**
	 * Getter de usuarios
	 * 
	 * @param name Nombre
	 * @return Retorna el usuario
	 */

	public User getUser(String name) {

		User user = this.userRepository.getUserByName(name);

		return user;
	}

	public Integer mainMenu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("please, choose an option:");
		System.out.println("1. Create User");
		System.out.println("2. Create Show");
		System.out.println("3. Update User");
		System.out.println("4. Delete User");
		System.out.println("5. Show users");

		return scanner.nextInt();
	}

	/**
	 * Funcion publica para actualizar usuarios
	 * 
	 * @param user Usuarios
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */

	public void updateUser() throws ClassNotFoundException, IOException {

		Scanner scanner = new Scanner(System.in);

		try {
			
			System.out.println("please, write your full name");
			
			String oldName = scanner.nextLine();
			
			User user = getUser(oldName);

			if (user != null) {
				System.out.println("User by name " + user.getName() + " was encountered.");
				this.userRepository.deleteUser(user);
			} else {
				System.out.println("Sorry, there is no user with that name.");
				return;
			}
			
			System.out.println("please, write your new full name");

			String name = scanner.nextLine();

			System.out.println("please, write your new nick");

			String username = scanner.nextLine();
			if(username.contains(" ")) {
				System.out.println("[!] Invalid username. Username should be without whitespaces. ");
				return;
			}

			System.out.println("please, write your new mail");

			String mail = scanner.nextLine();

			user.setName(name);
			user.setUsername(username);
			user.setMail(mail);

			try {
				this.userRepository.saveUser(user);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/////// HANDLE SHOWS //////////

	/**
	 * Funcion publica para crear shows
	 * 
	 * @return Retorna el show creado
	 */

	public Show createShow() {

		Scanner scanner = new Scanner(System.in);
		Show createdShow = null;
		Date date = null;

		try {

			System.out.println("please, give a title to the show");

			String title = scanner.nextLine();

			System.out.println("please, give a cathegory to the show among 'concierto, monologo, obra de teatro'");

			String cathegory = scanner.nextLine();

			System.out.println("please, give a description to the show");

			String description = scanner.nextLine();

			System.out.println("please, give a capacity");

			Integer capacity = scanner.nextInt();
			scanner.nextLine();

			System.out.println("please, type a date (format = dd/MM/yyyy)");

			String stringDate = scanner.nextLine();

			System.out.println("please, type the first location");

			String firstLocation = scanner.nextLine();

			System.out.println(
					"please, type 1 if you want a single date, 2 if you want a periodic date or 3 if you want a multiple date");

			Integer option = scanner.nextInt();
			scanner.nextLine();

			date = new SimpleDateFormat("dd/MM/YYYY").parse(stringDate);

			if (option == 1) {

				SingleDate singleDate = new SingleDate(date);

				createdShow = ShowFactory.createShow(title, cathegory, description, capacity, singleDate,
						firstLocation);

			} else if (option == 2) {

				PeriodicDate periodicDate = new PeriodicDate(date);

				createdShow = ShowFactory.createShow(title, cathegory, description, capacity, periodicDate,
						firstLocation);

			} else if (option == 3) {

				MultipleDate multipleDate = new MultipleDate(date);

				createdShow = ShowFactory.createShow(title, cathegory, description, capacity, multipleDate,
						firstLocation);

			} else {

				System.out.println("wrong format");

			}

			this.showRepository.saveShow(createdShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return createdShow;
	}

	/**
	 * Funcion para borrar usuarios
	 * 
	 * @param user Usuario que se va a borrar
	 */
	public ArrayList<Show> getShows() {

		ArrayList<Show> shows = this.showRepository.getShows();

		return shows;
	}

	public void cancelShow(Show show) {

		this.showRepository.cancelShow(show);
	}

	/**
	 * Funcion para actualizar los datos del usuario
	 * 
	 * @param user Usuario que se va a actualizar
	 */
	public void cancelAllShows() {

		this.showRepository.cancelAllShows();
	}

	/**
	 * Funcion para actualizar el show
	 * 
	 * @param show Show
	 */

	void updateShow(Show show) {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("please, give a new title to the show");

			String title = scanner.nextLine();

			show.setTitle(title);

			System.out.println("please, give a new cathegory to the show among 'concierto, monologo, obra de teatro'");

			String cathegory = scanner.nextLine();

			show.setCathegory(cathegory);

			System.out.println("please, give a new description to the show");

			String description = scanner.nextLine();

			show.setDescription(description);

			System.out.println("please, give a new capacity");

			Integer capacity = scanner.nextInt();

			show.setCapacity(capacity);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Funcion para enseñar tickets de la sesion del show
	 * 
	 * @param show   Show
	 * @param sesion Sesion
	 */

	void showTicketsForShowSesion(Show show, Integer sesion) {
	} // using dates array (in case of multiple-dates or periodic-date shows), print
		// date, location and tickets

	/**
	 * Funcion publica para obtener el show por su titulo
	 * 
	 * @param title Titulo
	 * @return Retorna el titulo
	 */

	public Show getShowByTitle(String title) {

		return this.showRepository.getShowByTitle(title);
	}

	// Búsqueda de próximos espectáculos con entradas disponibles, indicando o no
	// una categoría específica

	/**
	 * Funcion pueblica para poner una review al show
	 * 
	 * @param show Show
	 * @param user Usuario
	 */

	public void reviewAShow(Show show, User user) {

		Review createdReview = createReview(user);

		show.addShowReview(createdReview);
	}

	/**
	 * Funcion publica para obtener reviews de show por su nombre
	 * 
	 * @param name Nombre
	 */

	public ArrayList<Review> getShowReviewsByName(String name) {
		return null;
	}

	/**
	 * Funcion publica para borrar reviews
	 * 
	 * @param user Usuario
	 * @param show Shows
	 */

	public void deleteReview(User user, Show show) {
	}

	/**
	 * Funcion publica para poner una nota al show
	 * 
	 * @param review Review
	 */

	public void rateShowReview(Review review) {
	}

	/**
	 * Funcion publica para actualizar los shows
	 */

	@Override
	public void updateShow() {
		// TODO Auto-generated method stub

	}

	/**
	 * Funcion publica para enseñar los tickets de la sesion
	 * 
	 * @param show   Show
	 * @param sesion Sesion
	 */

	@Override
	public void showTicketsForShowSesion(Show show, int sesion) {
		// TODO Auto-generated method stub

	}

	public ArrayList<User> getUsers() throws ClassNotFoundException, IOException {
		return this.userRepository.getUsers();
	}

}