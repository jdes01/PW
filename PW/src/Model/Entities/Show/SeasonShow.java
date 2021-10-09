public class SeasonShow {

    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Int locationCapacity;
    

    private PeriodicDate periodicDate;

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, PeriodicDate periodicDate){

        super(title, cathegory, description, locationCapacity);

        this.periodicDate = periodicDate;
    }    
}
