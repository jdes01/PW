import Model.Entities.Review;
import Model.Entities.User;

import Model.DTO.Score;
import Model.P0.Espectaculo;

public class mainProgram {
    public static void main(String[] args){

        User user = new User("ImUser");
 
        String title = "titulo";
        String review_text = "texto";
         
        Score score = new Score(10);

        Review review = new Review(user, title, score, review_text);

        System.out.println(review.getScore());     
        
        review.addUserReview(user, score);
    }
  }