package secondVersion;

import java.io.Serializable;

public class paymentByPlans implements paymentBehavior, Serializable {


    double payment;

    public double payment(Vehicles vehicles) {
        switch (vehicles.typeOfplan) {

            case 1:
                System.out.println("monthly plan");
                setPayment(100 * vehicles.parkingCost);
                break;
            case 2:
                System.out.println("yearly plan");
                setPayment(900 * vehicles.parkingCost);
                break;
            default:
                System.out.println("Invalid plan");

                break;


        }

        return getPayment();
    }

    public void setHours(double hours) {
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
