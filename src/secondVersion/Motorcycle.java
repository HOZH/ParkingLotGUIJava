package secondVersion;

public class Motorcycle extends Vehicles {

    Motorcycle() {
        super();
        parkingCost = 3.00;
        spaceRequired = 1;
    }

    Motorcycle(String plate) {
        super(plate);
        parkingCost = 3.00;
        spaceRequired = 1;
    }

    @Override
    public String toString() {
        return super.toString() + "Type : Motorcycle";
    }
}
