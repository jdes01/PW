package refactor.model.ValueObjects;

public class Score {

    public int _score;

    public Score(int score){

        if(10 >= score || score >= 0){
            this._score = score;
        
        } else {
            new Exception("wrong number");
        }
        
    }

    public int getScore(){ return this._score; }

    public void setScore(int score){ 

        if(10 >= score || score >= 0){
            this._score = score;
        
        } else {
            new Exception("wrong number");
        }
    }
}
