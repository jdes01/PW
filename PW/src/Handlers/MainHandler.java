package Model;

import java.util.ArrayList;

import Model.User;
import Model.DTO.Score;
import Model.Review;

import java.util.Scanner;

import UserRepository;
import ReviewRepository;
import ShowRepository;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class MainHandler implements ReviewHandlerInterface, UserHandlerInterface, ShowHandlerInterface {

    private static final MainHandler mainHandler;

    //inject repositories

    private UserRepository userRepository;
    private ReviewRepository reviewRepository;
    private ShowRepository showRepository;

    public getHandler(){

        if (this.mainHandler == null) {
 
            MainHandler mainHandler = new MainHandler(); 
            
            return mainHandler;
        }

        return this.mainHandler;
    }

    private MainHandler(){

        this.userRepository = new UserRepository();
        this.reviewRepository = new ReviewRepository();
        this.showRepository = new ShowRepository();
    }    


    //////  HANDLE REVIEWS ///////


    public void createReview(User user){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, give a title to the review");

            String title = scanner.nextString();

        System.out.println("please, rate the film");

            Int rate = scanner.nextInt();
            Score score = new Score(rate);

        System.out.println("please, type a brief review");

            String review_text = scanner.nextString();

        Review review = new Review(user, title, score, review_text);

        this.reviewRepository.saveReview(review);
    }


    public ArrayList<Review> getReviews(){

        ArrayList<Review> reviews = this.reviewRepository.getReviews();

        return reviews;
    }


    public void deleteReview(Review review){

        this.reviewRepository.deleteReview(review);
    }


    public void voteReview(Review review, User user, Score score){

        review.addUserReview(user, score);
    }



    ////// HANDLE USERS ////////



    public void createUser(){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, write your full name");

            String name = scanner.nextString();

        System.out.println("please, write your nick");

            String nick = scanner.nextString();

        System.out.println("please, write your mail");

            String mail = scanner.nextString();

        User user = new User(name, nick, mail);

        this.userRepository.saveUser(user);        
    }


    public void deleteUser(User user){

        this.userRepository.deleteUser(user);
    }


    public User getUser(String name){

        User user = this.userRepository.getUserByName(name);
    }
    

    public void updateUser(User user){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, write your new full name");

            String name = scanner.nextString();

        System.out.println("please, write your new nick");

            String nick = scanner.nextString();

        System.out.println("please, write your new mail");

            String mail = scanner.nextString();

        user.setName(name);
        user.setNick(nick);
        user.setMail(mail);

        this.userRepository.saveUser(user);    
    }


    /////// HANDLE SHOWS //////////


    public void createShow(){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, give a title to the show");

            String title = scanner.nextString();

        System.out.println("please, give a cathegory to the show among 'concierto, monologo, obra de teatro'");

            String cathegory = scanner.nextString();

        System.out.println("please, give a description to the show");

            String desccription = scanner.nextString();

        System.out.println("please, give a capacity");

            Int capacity = scanner.nextInt();

        System.out.println("please, type a date (format = dd/MM/yyyy)");

            String stringDate = scanner.nextString();

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);  

            System.out.println("please, type the first location");

            String firstLocation = scanner.nextString();

        System.out.println("please, type 1 if you want a single date, 2 if you want a periodic date or 3 if you want a multiple date");

            String option = scanner.nextString();

        if(option === "1"){

            SingleDate singleDate = new SingleDate(date);

            Show createdShow = ShowFactory.createShow(title, cathegory, description, capacity, singleDate, firstLocation);

        } else if (option === "2"){

            PeriodicDate periodicDate = new PeriodicDate(date);

            Show createdShow = ShowFactory.createShow(title, cathegory, description, capacity, periodicDate, firstLocation);

        } else if (option === "3"){

            MultipleDate multipleDate = new MultipleDate(date);

            Show createdShow = ShowFactory.createShow(title, cathegory, description, capacity, multipleDate, firstLocation);

        } else {

            System.out.println("wrong format");

            return 0;
        }

        this.showRepository.saveShow(createdShow);
    }


    public ArrayList<Show> getShows(){

        ArrayList<Show> shows = this.showRepository.getShows();

        return shows;
    }


    void cancelShow(Show show);

    void cancelAllShows();

    void updateShow();

    void showTicketsForShowSesion(Show show, Int sesion); //using dates array (in case of multiple-dates or periodic-date shows), print date, location and tickets
    
    void getShowByTitle(String title);

    //Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica 

    void reviewAShow(Show show);

    ArrayList<Review> getShowReviewsByName(String name);

    void deleteReview(User user, Show show);

    void rateShowReview(Review review);


    
}
