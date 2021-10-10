package Model.Entities.Show;

import Model.DTO.SingleDate;
import Model.DTO.MultipleDate;
import Model.DTO.PeriodicDate;
import Model.Entities.Show.PunctualShow;

public class ShowFactory {
    
    static public PunctualShow createShow(String title, String cathegory, String description, Integer locationCapacity, SingleDate singleDate, String firstLocation){
            
        PunctualShow punctualShow = new PunctualShow(title, cathegory, description, locationCapacity, singleDate, firstLocation); 
        
        return punctualShow;
    }

    static public SeasonShow createShow(String title, String cathegory, String description, Integer locationCapacity, PeriodicDate periodicDate, String firstLocation){

        SeasonShow seasonShow = new SeasonShow(title, cathegory, description, locationCapacity, periodicDate, firstLocation); 
    
        return seasonShow;
    }

    static public MultiplePassShow createShow(String title, String cathegory, String description, Integer locationCapacity, MultipleDate multipleDate, String firstLocation){

        MultiplePassShow multiplePassShow = new MultiplePassShow(title, cathegory, description, locationCapacity, multipleDate, firstLocation);
    
        return multiplePassShow;
    }
}
