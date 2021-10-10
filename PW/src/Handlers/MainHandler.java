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
import Model.Entities.User.User;
import Model.Repository.ReviewRepository;
import Model.Repository.ShowRepository;
import Model.Repository.UserRepository;  

public class MainHandler implements ReviewHandlerInterface, UserHandlerInterface, ShowHandlerInterface {

    private static final MainHandler mainHandler = new MainHandler();

    //inject repositories

    private UserRepository userRepository;
    private ReviewRepository reviewRepository;
    private ShowRepository showRepository;

    public MainHandler getHandler(){

        if (MainHandler.mainHandler == null) {
 
            MainHandler mainHandler = new MainHandler(); 
            
            return mainHandler;
        }

        return MainHandler.mainHandler;
    }

    private MainHandler(){

        this.userRepository = new UserRepository();
        this.reviewRepository = new ReviewRepository();
        this.showRepository = new ShowRepository();
    }    


    //////  HANDLE REVIEWS ///////


    public Review createReview(User user){

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
        	if(scanner != null)
        		scanner.close();
        }

        return review;
    }


    public ArrayList<Review> getReviews(){

        ArrayList<Review> reviews = this.reviewRepository.getReviews();

        return reviews;
    }


    public void deleteReview(Review review){

        try {
			this.reviewRepository.deleteReview(review);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
    }


    public void voteReview(Review review, User user, Score score){

        review.addUserReview(user, score);
    }



    ////// HANDLE USERS ////////



    public void createUser() throws IOException{

        Scanner scanner = new Scanner(System.in); 
        
        try {

	        System.out.println("please, write your full name");
	
	            String name = scanner.nextLine();
	
	        System.out.println("please, write your nick");
	
	            String nick = scanner.nextLine();
	
	        System.out.println("please, write your mail");
	
	            String mail = scanner.nextLine();
	
	        User user = new User(name, nick, mail);
	
	        this.userRepository.saveUser(user);
	        
        } finally {
        	if(scanner!=null)
        		scanner.close();
        }
    }


    public void deleteUser(User user){

        try {
			this.userRepository.deleteUser(user);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
    }


    public User getUser(String name){

        User user = this.userRepository.getUserByName(name);
        
        return user;
    }
    

    public void updateUser(User user){

        Scanner scanner = new Scanner(System.in);
        
        try {

	        System.out.println("please, write your new full name");
	
	            String name = scanner.nextLine();
	
	        System.out.println("please, write your new nick");
	
	            String nick = scanner.nextLine();
	
	        System.out.println("please, write your new mail");
	
	            String mail = scanner.nextLine();
	
	        user.setName(name);
	        user.setNick(nick);
	        user.setMail(mail);
	
	        try {
				this.userRepository.saveUser(user);
			} catch (IOException e) {
				e.printStackTrace();
			}    
	        
        } finally {
        	if(scanner!=null) {
        		scanner.close();
        	}
        }
    }


    /////// HANDLE SHOWS //////////


    public Show createShow(){

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
	
	        System.out.println("please, type a date (format = dd/MM/yyyy)");
	
	            String stringDate = scanner.nextLine();
	
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}  
	
	        System.out.println("please, type the first location");
	
	            String firstLocation = scanner.nextLine();
	
	        System.out.println("please, type 1 if you want a single date, 2 if you want a periodic date or 3 if you want a multiple date");
	
	            String option = scanner.nextLine();
	
			if(option == "1"){
	
	            SingleDate singleDate = new SingleDate(date);
	
	            createdShow = ShowFactory.createShow(title, cathegory, description, capacity, singleDate, firstLocation);
	
	        } else if (option == "2"){
	
	            PeriodicDate periodicDate = new PeriodicDate(date);
	
	            createdShow = ShowFactory.createShow(title, cathegory, description, capacity, periodicDate, firstLocation);
	
	        } else if (option == "3"){
	
	            MultipleDate multipleDate = new MultipleDate(date);
	
	            createdShow = ShowFactory.createShow(title, cathegory, description, capacity, multipleDate, firstLocation);
	
	        } else {
	
	            System.out.println("wrong format");
	            
	        }
	
	        this.showRepository.saveShow(createdShow);
		} finally {
			if(scanner!=null) {
				scanner.close();
			}
		}

        return createdShow;
    }


    public ArrayList<Show> getShows(){

        ArrayList<Show> shows = this.showRepository.getShows();

        return shows;
    }


    public void cancelShow(Show show){

        this.showRepository.cancelShow(show);
    }

    public void cancelAllShows(){

        this.showRepository.cancelAllShows();
    }

    void updateShow(Show show){

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
        	if(scanner!=null) {
        		scanner.close();
        	}
        }
    }

    void showTicketsForShowSesion(Show show, Integer sesion) {
	} //using dates array (in case of multiple-dates or periodic-date shows), print date, location and tickets
    
    public Show getShowByTitle(String title){

        return this.showRepository.getShowByTitle(title);
    }

    //Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica 

    public void reviewAShow(Show show, User user){

        Review createdReview = createReview(user);

        show.addShowReview(createdReview);
    }

    public ArrayList<Review> getShowReviewsByName(String name) {
		return null;
	}

    public void deleteReview(User user, Show show) {
	}

    public void rateShowReview(Review review) {
	}

	@Override
	public void updateShow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showTicketsForShowSesion(Show show, int sesion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}