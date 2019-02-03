package secondVersion;

public class Truck extends Vehicles {

    Truck() {
        super();
        parkingCost = 8.00;
        spaceRequired = 4;
    }

    Truck(String plate) {
        super(plate);
        parkingCost = 8.00;
        spaceRequired = 4;
    }


    @Override
    public String toString() {
        return super.toString() + "Type : Truck";
    }
}
