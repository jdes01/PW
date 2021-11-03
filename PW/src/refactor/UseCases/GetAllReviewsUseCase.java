package refactor.UseCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import refactor.Model.Entities.Review;

public class GetAllReviewsUseCase {

    public static List<Review> GetAllReviews() throws IOException{


        ArrayList < String > lista = new ArrayList <String> ();
        lista.add("Pedro");
        lista.add("Olga");
        lista.add("Miguel");
        lista.add("Antonio");
        lista.add("Pedro"); 

        Iterator < String > it = lista.iterator();

            while (it.hasNext()) {

            System.out.println(it.next());

        }

        // ReviewRepository reviewRepository = new ReviewRepository();
        //
        // Review review = new Review(user, title, text, show, score);
        // 
        // reviewRepository.saveReview(review);
        
        }
    
}
