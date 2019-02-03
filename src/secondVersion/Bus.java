package secondVersion;

public class Bus extends Vehicles {

    Bus() {
        super();
        parkingCost = 20.00;
        spaceRequired = 5;
    }

    Bus(String plate) {
        super(plate);
        parkingCost = 20.00;
        spaceRequired = 5;
    }

    @Override
    public String toString() {
        return super.toString() + "Type : Bus";
    }
}
