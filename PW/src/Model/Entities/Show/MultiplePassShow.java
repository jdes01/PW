public class MultiplePassShow {

    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Int locationCapacity;
    

    private MultipleDate multipleDate;

    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, MultipleDate multipleDate){

        super(title, cathegory, description, locationCapacity);

        this.multipleDate = multipleDate;
    }    
}
