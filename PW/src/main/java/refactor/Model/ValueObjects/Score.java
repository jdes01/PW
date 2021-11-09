package refactor.Model.ValueObjects;

/**
 * Clase score de la review
 * 
 * @author David Salcedo Sanchez
 */

public class Score {

    public int _score;

/**
 * Constructor de la clase score
 * 
 * @param score El score de la review
 */

    public Score(int score){

        if(10 >= score || score >= 0){
            this._score = score;
        
        } else {
            new Exception("wrong number");
        }
        
    }

/**
 * Getter de score
 * 
 * @return Retorna el score
 */

    public int getScore(){ return this._score; }

/**
 * Setter de score
 * 
 * @param score El score de la review
 */

    public void setScore(int score){ 

        if(10 >= score || score >= 0){
            this._score = score;
        
        } else {
            new Exception("wrong number");
        }
    }
}
