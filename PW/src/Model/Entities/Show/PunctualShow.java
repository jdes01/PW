public class PunctualShow {

    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Int locationCapacity;
    
    
    private SingleDate singleDate;

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, SingleDate singleDate){

        super(title, cathegory, description, locationCapacity);

        this.singleDate = singleDate;
    }
}