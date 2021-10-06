public class SeasonShow extends Show {

    private String weekDay; // same date every week

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, String weekDay){

        super(title, cathegory, description, locationCapacity);

        this.weekDay = weekDay;
    }

    public String getWeekDay(){ return this.weekDay; }

    public String setWeekDay(String weekDay){ this.weekDay = weekDay; }
    
}
