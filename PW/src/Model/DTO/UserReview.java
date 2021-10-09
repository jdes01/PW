package Model.DTO;

import Model.Entities.User.User;

/**
 * 
 * @author kan0
 *
 */

public class UserReview {
    
    private User user;
    private Score score;

/**
 * 
 * @param user
 * @param score
 */
    
    public UserReview(User user, Score score){

        this.user = user;
        this.score = score;
    }
    
/**
 * 
 * @return
 */

    public User getUser(){

        return this.user;
    }
    
/**
 *     
 * @param User
 */

    public void setUser(User User){

        this.user = User;
    }

/**
 *     
 * @return
 */
    
    public Integer getScore(){

        return this.score.getScore();
    }

/**
 *     
 * @param score
 */
    
    public void setScore(Integer score){

        this.score.setScore(score);
    }
}
