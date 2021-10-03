import Model.Review;

import Model.Viewer;
import Model.DTO.Score;
import Model.Espectaculo;

public class mainProgram {
    public static void main(String[] args){

        Viewer viewer = new Viewer();
 
        String title = "titulo";
        String review_text = "texto";
         
        Score score = new Score(10);

        Review review = new Review(viewer, title, score, review_text);

        System.out.println(review.getScore());

    }
  }