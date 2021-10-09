public class LocationAndAvailableTickets {
    
    private String location;
    private Int tickets;

    LocationAndAvailableTickets(String location, Int tickets){

        this.location = location;
        this.tickets = tickets;
    }

    String getLocation(){ return this.location; }
    Int getTickets(){ return this.tickets; }

    void setLocation(String location){ this.location = location; }
    void setTickets(Int tickets){ this.tickets = tickets; }
}
