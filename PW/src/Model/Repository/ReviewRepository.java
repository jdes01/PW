package Model.Repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import Model.Entities.Review.Review;
import Model.Entities.User.User;

public class ReviewRepository {
    
    public void saveReview(Review review){
    	try {
        	FileOutputStream file = new FileOutputStream(new File("reviews.txt"));
        	ObjectOutputStream output = new ObjectOutputStream(file);
        	
        	output.writeObject(review);
        	
        	output.close();
        	file.close();
        } catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    }

    @SuppressWarnings("null")
	public ArrayList<Review> getReviews(){
    	ArrayList<Review> reviews = null;
    	
    	try {
	    	FileInputStream file = new FileInputStream(new File("reviews.txt"));
	    	ObjectInputStream input = new ObjectInputStream(file);
	    	
	    	while(true) {
	    		try {
	    			reviews.add((Review) input.readObject());
	    		} catch (EOFException error) {
	    			input.close();
	    			file.close();
	    			return reviews;
	    		} catch (ClassNotFoundException error) {
	    			input.close();
	    			file.close();
	    			error.printStackTrace();
	    		}
	    	}
    	} catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    	
    	return reviews;
    }

    public void deleteReview(Review review) throws ClassNotFoundException, IOException{
    	ArrayList<Review> reviews = null;
    	reviews = getReviews();
    	
    	reviews.remove(review);
    	writeObjectsToFile("reviews.txt", reviews);
    }
    
    private static void writeObjectsToFile(String filename, ArrayList<Review> objects) throws IOException {
        OutputStream os = null;
        try {
          os = new FileOutputStream(filename);
          @SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(os);
          for (Object object : objects) {
            oos.writeObject(object);
          }
          oos.flush();
        } finally {
          if (os != null) {
            os.close();
          }
        }
      }
}
