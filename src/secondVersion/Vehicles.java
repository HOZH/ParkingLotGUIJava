package secondVersion;

import java.io.Serializable;
import java.util.Date;

public class Vehicles implements Serializable {


    paymentBehavior paymentBehavior;
    int spaceRequired;
    double parkingCost;
    boolean ifDisabled = false;
    boolean isinhandicapped = false;
    int typeOfplan = 0;
    long planPurchaseDate;
    long enterTIme;
    long leaveTime;
    long timeset;
    Ticket ticket = new Ticket();
    double fine;
    double payment;
    boolean ifPassedtimelimit = false;
    private String plate = null;

    public Vehicles(String plate) {
        this.plate = plate;
    }

    public Vehicles() {
    }

    public boolean isIfPassedtimelimit() {
        return ifPassedtimelimit;
    }

    public void setIfPassedtimelimit(boolean ifPassedtimelimit) {
        this.ifPassedtimelimit = ifPassedtimelimit;
    }

    public long getPlanPurchaseDate() {
        return planPurchaseDate;
    }

    public void setPlanPurchaseDate(long planPurchaseDate) {
        this.planPurchaseDate = planPurchaseDate;
    }

    public long getEnterTIme() {
        return enterTIme;
    }

    public void setEnterTIme(long enterTIme) {
        this.enterTIme = enterTIme;
    }

    public long getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(long leaveTime) {
        this.leaveTime = leaveTime;
    }

    public long getTimeset() {
        return timeset;
    }

    public void setTimeset(long timeset) {
        this.timeset = timeset;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket() {
        ticket.entertime = new Date(enterTIme).toString();
        ticket.leavetime = new Date(leaveTime).toString();
        ticket.setPayment(String.valueOf(this.getPayment()));
        ticket.setFine(String.valueOf(this.getFine()));
        ticket.setTotoalFee(String.valueOf(this.getPayment() + this.getFine()));
        ticket.setType(this.toString());

    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getPayment() {

        return payment;
    }

    public void setPayment(Vehicles this) {
        payment = this.paymentBehavior.payment(this);


    }

    public String toString() {
        return
                "plate:" + plate + "\t\t";
    }

    public String getPlate() {
        return plate;
    }// create a input

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getSpaceRequired() {
        return spaceRequired;
    }

    public void setIfDisabled(boolean ifDisabled) {
        this.ifDisabled = ifDisabled;
    }

    public boolean isDisabled() {
        return ifDisabled;
    }

    public int getTypeOfplan() {
        return typeOfplan;
    }

    public void setTypeOfplan(int typeOfplan) {

        this.typeOfplan = typeOfplan;
    }

    public secondVersion.paymentBehavior getPaymentBehavior() {
        return paymentBehavior;
    }

    public void setPaymentBehavior(secondVersion.paymentBehavior paymentBehavior) {
        this.paymentBehavior = paymentBehavior;
    }

    public double getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(double parkingCost) {
        this.parkingCost = parkingCost;
    }
}
