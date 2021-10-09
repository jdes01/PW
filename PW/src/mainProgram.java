import Model.Entities.Review.Review;
import Model.Entities.User.User;

import Model.DTO.Score;

public class mainProgram {
    public static void main(String[] args){

        User user = new User("My Name", "My Nick", "myemail@pw.es");
 
        String title = "titulo";
        String review_text = "texto";
         
        Score score = new Score(10);

        Review review = new Review(user, title, score, review_text);

        System.out.println(review.getScore());     
        
        review.addUserReview(user, score);
    }
  }