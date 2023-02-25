/**
 * A class to create a cargo ship which 
 * is a subclass of Ship
 * @author Timur Garifullin
 */
public class CargoShip extends Ship{
    private int cargoCapacity;

    /**
     * Default constructor that sets
     * empty strings name & year
     * and sets variables to 0
     */
    public CargoShip(){
        super();
        cargoCapacity = 0;
    }
    /**
     * Another constructor for the Ship class
     * @param name is the name of the ship
     * @param year is the year of the ship
     * @param cargoCapacity is the cargo capacity in tonnage of the ship
     */ 
    public CargoShip(String name, String year, int cargoCapacity){
        super(name, year);
        this.cargoCapacity = cargoCapacity;
    }

    /** 
     * Accessor for the cargo capacity in tonnage of the ship
     * @return the cargo capacity in tonnage of the ship
     */
    public int getCargoCapacity(){
        return cargoCapacity;
    }

    /** 
     * Mutator for setting the cargo capacity in tonnage of the ship
     * @param cargoCapacity is the cargo capacity in tonnage of the ship
     */
    public void setCargoCapacity(){
        this.cargoCapacity = cargoCapacity;
    }
    /**
     * Method to display ship's name, year and cargo capacity
     * @return name, year, and cargo capacity
     */
    public String toString(){
        return "Name: " + super.getName() + ", year: " + super.getYear() + ", Cargo capacity: " + cargoCapacity;
    }
}
