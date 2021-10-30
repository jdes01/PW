package refactor.model.Entities;

import java.util.UUID;

import refactor.model.ValueObjects.Score;

public class Show {

    private UUID _id;

    private String _title;
    private String _description;
    private String _category;
    private Score _score;


    public Show(String title, String description, String category, Integer score){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._title = title;
        this._description = description;
        this._category = category;
        
        this._score = new Score(score);

    }



    public UUID getUuid(){ return this._id; }

    public String getTitle(){ return this._title; }

    public String getDescription(){ return this._description; }

    public String getCategory(){ return this._category; }

    public Integer getScore(){ return this._score.getScore(); }



    public void setTitle(String title){ this._title = title; }

    public void setDescription(String description){ this._description = description; }

    public void setCategory(String category){ this._category = category; }

    public void setScore(Integer score){ this._score.setScore(score); }
    
}
