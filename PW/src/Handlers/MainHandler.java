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
    }

    ArrayList<Review> getReviews();

    void deleteReview(Review review);

    void voteReview(Review review, User user, Score score);



    ////// HANDLE USERS ////////



    void createUser(String name);

    void deleteUser(User user);

    User getUser(Integer id);

    void updateUser(User user);
    
}
