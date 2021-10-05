package Model;

import java.util.ArrayList;

import Model.User;
import Model.DTO.Score;
import Model.Review;

import java.util.Scanner;

import UserRepository;
import ReviewRepository;

public class MainHandler extends ReviewHandler, UserHandler {


    public MainHandler(){

        //inject repositories

        private UserRepository userRepository;
        private ReviewRepository reviewRepository;
    }    


    //////  HANDLE REVIEWS ///////


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

    ArrayList<Review> getReviews(){

        ArrayList<Review> reviews = this.reviewRepository.getReviews();

        return reviews;
    }

    void deleteReview(Review review){

        this.reviewRepository.deleteReview(review);
    }

    void voteReview(Review review, User user, Score score){

        review.addUserReview(user, score);
    }



    ////// HANDLE USERS ////////



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

    void deleteUser(User user){

        this.userRepository.deleteUser(user);
    }

    User getUser(String name){

        User user = this.userRepository.getUserByName(name);
    }

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
