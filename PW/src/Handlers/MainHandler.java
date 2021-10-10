package Model;

import java.util.ArrayList;

import Model.User;
import Model.DTO.Score;
import Model.Review;

import java.util.Scanner;

import UserRepository;
import ReviewRepository;

/**
 * Clase que usa el patron de diseño singleton para gestionar la app
 * @author Javier De Santiago Palomino
 */

public class MainHandler extends ReviewHandler, UserHandler {

    private static final MainHandler mainHandler;

    //inject repositories

    private UserRepository userRepository;
    private ReviewRepository reviewRepository;

/**
 *  
 */
    
    public getHandler(){

        if (this.mainHandler == null) {
 
            MainHandler mainHandler = new MainHandler(); 
            
            return mainHandler;
        }

        return this.mainHandler;
    }
    
/**
 * Constructor de MainHandler
 */

    private MainHandler(){

        this.userRepository = new UserRepository();
        this.reviewRepository = new ReviewRepository();
    }    


    //////  HANDLE REVIEWS ///////

/**
 * Funcion para crear reviews
 * @param user Usuario que crea la review
 */
    
    void createReview(User user){

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
    
/**
 * Getter de reviews
 * @return Retorna las reviews
 */

    ArrayList<Review> getReviews(){

        ArrayList<Review> reviews = this.reviewRepository.getReviews();

        return reviews;
    }

/**
 * Funcion para borrar reviews
 * @param review Review que se va a borra
 */
    
    void deleteReview(Review review){

        this.reviewRepository.deleteReview(review);
    }

/**
 * Funcion 
 * @param review
 * @param user
 * @param score
 */
    
    void voteReview(Review review, User user, Score score){

        review.addUserReview(user, score);
    }



    ////// HANDLE USERS ////////

/**
 * Funcion para crear un usuario añadiendo sus datos
 */

    void createUser(){

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

/**
 * Funcion para borrar usuarios
 * @param user Usuario que se va a borrar
 */
    
    void deleteUser(User user){

        this.userRepository.deleteUser(user);
    }

    User getUser(String name){

        User user = this.userRepository.getUserByName(name);
    }

/**
 * Funcion para actualizar los datos del usuario
 * @param user Usuario que se va a actualizar
 */
    
    void updateUser(User user){

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
    
}
