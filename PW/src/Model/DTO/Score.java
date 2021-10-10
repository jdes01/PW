package Model.DTO;

/**
 * 
 * @author David Salcedo Sanchez
 *
 */

public class Score {
    
    Integer score;
    
/**
 * Constructor de la clase score
 * @param score El score de la review
 */

    public Score(Integer score){

        this.score = score;
    }
    
/**
 * Getter de score
 * @return Retorna el score
 */

    public Integer getScore(){

        return score;
    }
    
/**
 * Setter de score
 * @param score El score de la review
 */

    public void setScore(Integer score){

        this.score = score;
    }
}
