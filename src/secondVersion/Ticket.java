package secondVersion;

import java.io.Serializable;

public class Ticket implements Serializable {
    String entertime;
    String leavetime;
    private String payment;
    private String fine;
    private String totoalFee;
    private String type;

    public String getEntertime() {
        return entertime;
    }

    public void setEntertime(String entertime) {
        this.entertime = entertime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entertime='" + entertime + '\'' +
                ", leavetime='" + leavetime + '\'' +
                ", payment='" + payment + '\'' + "\n" +
                ", fine='" + fine + '\'' +
                ", totoalFee='" + totoalFee + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getTotoalFee() {
        return totoalFee;
    }

    public void setTotoalFee(String totoalFee) {
        this.totoalFee = totoalFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
