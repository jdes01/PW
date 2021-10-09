import MultipleDate;
import PeriodicDate;
import SingleDate;

import Show;

public class ShowFactory {
    
    static public void createShow(String title, String cathegory, String description, Int locationCapacity, SingleDate singleDate, String firstLocation){
            
        PunctualShow punctualShow = new PunctualShow(String title, String cathegory, String description, Int locationCapacity, SingleDate singleDate, String firstLocation); 
    }

    static public void createShow(String title, String cathegory, String description, Int locationCapacity, PeriodicDate periodicDate, String firstLocation){

        SeasonShow seasonShow = new SeasonShow(String title, String cathegory, String description, Int locationCapacity, PeriodicDate periodicDate, String firstLocation); 
    }

    static public void createShow(String title, String cathegory, String description, Int locationCapacity, MultipleDate multipleDate, String firstLocation){

        MultiplePassShow multiplePassShow = new MultiplePassShow(String title, String cathegory, String description, Int locationCapacity, MultipleDate multipleDate, String firstLocation);
    }
}
