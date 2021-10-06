package Model;

import java.util.ArrayList;

import Model.User;
import Model.DTO.Score;
import Model.Review;

import java.util.Scanner;

import UserRepository;
import ReviewRepository;
import ShowRepository;

public class MainHandler implements ReviewHandler, UserHandler {

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


    public void createPunctualShow(){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, give a title to the show");

            String title = scanner.nextString();

        System.out.println("please, give a cathegory to the show among 'concierto, monologo, obra de teatro'");

            String cathegory = scanner.nextString();

        System.out.println("please, give a description to the show");

            String desccription = scanner.nextString();

        System.out.println("please, give a location capacity");

            Int locationCapacity = scanner.nextInt();

        System.out.println("please, give a date to the show");

            String date = scanner.nextString();

        PunctualShow punctualShow = new PunctualShow(title, cathegory, description, locationCapacity, date);

        this.showRepository.saveShow(punctualShow);
    }

    
    public void createSeasonShow(){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, give a title to the show");

            String title = scanner.nextString();

        System.out.println("please, give a cathegory to the show among 'concierto, monologo, obra de teatro'");

            String cathegory = scanner.nextString();

        System.out.println("please, give a description to the show");

            String desccription = scanner.nextString();

        System.out.println("please, give a location capacity");

            Int locationCapacity = scanner.nextInt();

        System.out.println("please, give a day of the week to the show");

            String date = scanner.nextString();

        SeasonShow seasonShow = new SeasonShow(title, cathegory, description, locationCapacity, date);

        this.showRepository.saveShow(seasonShow);
    }


    public void createMultiplePassShow(){

        Scanner scanner = new Scanner(System.in); 

        System.out.println("please, give a title to the show");

            String title = scanner.nextString();

        System.out.println("please, give a cathegory to the show among 'concierto, monologo, obra de teatro'");

            String cathegory = scanner.nextString();

        System.out.println("please, give a description to the show");

            String desccription = scanner.nextString();

        System.out.println("please, give a location capacity");

            Int locationCapacity = scanner.nextInt();

        System.out.println("please, give give a first date to the show; you will be able to add dates later");

            String date = scanner.nextString();

        MultiplePassShow multiplePassShow = new MultiplePassShow(title, cathegory, description, locationCapacity, date);

        this.showRepository.saveShow(multiplePassShow);
    }

    public ArrayList<Show> getShows(){

        ArrayList<Show> shows = this.showRepository.getShows();

        return shows;
    }
    
}
