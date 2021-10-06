public class MultiplePassShow {

    private ArrayList<Date> dates = new ArrayList<Date>(); // multiple dates

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, Date date){

        super(title, cathegory, description, locationCapacity);

        addDate(date);
    }

    public ArrayList<Date> getDates(){ return this.dates; }

    public void addDate(Date date){ this.dates.add(date); }
    
}
