/**
 * A class to create a Ship 
 * @author Timur Garifullin
 */
public class Ship {
    private String name;
    private String year;

    /**
     * Default constructor that sets
     * empty strings
     * 
     */
    public Ship(){
        name = "";
        year = "";
    }

    /**
     * Another constructor for the Ship class
     * @param name is the name of the ship
     * @param year is the year of the ship
     */ 
    public Ship(String name, String year){
        this.name = name;
        this.year = year;
    }

    /** 
     * Accessor for the name of the ship
     * @return name of the ship
     */
    public String getName(){
        return name;
    }

    /** 
     * Accessor for the year of the ship
     * @return year of the ship
     */
    public String getYear(){
        return year;
    }

    /** 
     * Mutator for setting the name of the ship 
     * @param name new name of the ship
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * Mutator for setting the year field 
     * @param year new year of the ship
     */
    public void setYear(String year){
        this.year = year;
        
    }
    /**
     * Method to display ship's name and year
     * @return name and year of a ship
     */
    public String toString(){
       return "Name: " + name + ", Year: " + year;
    }
}
