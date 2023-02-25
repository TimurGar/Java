/**
 * A class to create a cruise ship which 
 * is a subclass of Ship
 * @author Timur Garifullin
 */
public class CruiseShip extends Ship {
    private int maxNumPassengers;

    /**
     * Default constructor that sets
     * empty strings name & year
     * and sets variables to 0
     */
    public CruiseShip(){
        super();
        maxNumPassengers = 0;
    }
    /**
     * Another constructor for the Ship class
     * @param name is the name of the ship
     * @param year is the year of the ship
     * @param maxNumPassengers is the maximum number of passengers the ship can carry
     */ 
    public CruiseShip(String name, String year, int maxNumPassengers){
        super(name, year);
        this.maxNumPassengers = maxNumPassengers;
    }

    /** 
     * Accessor for the maximum number of passengers the ship can carry
     * @return maximum number of passengers the ship can carry
     */
    public int getMaxNumPassengers(){
        return maxNumPassengers;
    }

    /** 
     * Mutator for the maximum number of passengers the ship can carry
     * @param maxNumPassengers is maximum number of passengers the ship can carry
     */
    public void setMaxNumPassengers(){
        this.maxNumPassengers = maxNumPassengers;
    }
    /**
     * Method to display ship's name and maximum number of passengers
     * @return name and maximum number of passengers of a ship
     */
    public String toString(){
        return "Name: " + super.getName() + ", Maximum number of passengers: " + maxNumPassengers;
    }
}
