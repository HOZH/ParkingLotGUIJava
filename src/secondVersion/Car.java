package secondVersion;


public class Car extends Vehicles {

    Car() {
        super();
        parkingCost = 5.00;
        spaceRequired = 2;
        ifDisabled = false;

    }

    Car(String plate) {
        super(plate);
        parkingCost = 5.00;
        spaceRequired = 2;


    }


    public void setIfDisabled(boolean ifDisabled) {
        this.ifDisabled = ifDisabled;
    }

    @Override
    public String toString() {
        return super.toString() + "Type : Car";
    }
}
