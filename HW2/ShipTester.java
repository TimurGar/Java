/**
 * class to test Ship, CruiseShip & CargoShip classes
 * @author Timur Garifullin
 */
public class ShipTester {
    public static void main(String[] args) {
        // creating the ship
        Ship aShip = new Ship("bright", "1971");
        System.out.println(aShip.toString());

        // creating the cruise ship
        CruiseShip aCruiseShip = new CruiseShip("cruise", "1000", 52);
        System.out.println(aCruiseShip.toString());

        // creating the cargo ship
        CargoShip aCargoShip = new CargoShip("cargo", "2023", 1200);
        System.out.println(aCargoShip.toString());
    }
}
   
