public class MultiplePassShow {

    private ArrayList<String> dates = new ArrayList<String>(); // multiple dates

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, String date){

        super(title, cathegory, description, locationCapacity);

        addDate(date);
    }

    public ArrayList<String> getDates(){ return this.dates; }

    public void addDate(String date){ this.dates.add(date); }
    
}
