package secondVersion;

import java.io.Serializable;

public class defaultPayment implements paymentBehavior, Serializable {
    double payment;
    private double ratio = 1;
    private boolean isHandicapped;
    private double hours = 1;


    @Override
    public double payment(Vehicles vehicles) {
        isHandicapped(vehicles);
        checkRatioFactors();
        setPayment(ratio * hours * vehicles.parkingCost);
        return payment;
    }

    public boolean isHandicapped(Vehicles vehicles) {
        return this.isHandicapped = vehicles.isinhandicapped;

    }

    public void checkRatioFactors
            () {

        if (isHandicapped) setRatio(0.8);


    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRatio() {
        return ratio;
    }

    private void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getPayment() {
        return payment;
    }


    private void setPayment(double payment) {
        this.payment = payment;
    }


}
