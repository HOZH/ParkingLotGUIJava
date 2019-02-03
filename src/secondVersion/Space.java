package secondVersion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hz
 */
public class Space implements Serializable {
    private static int idIncrementer = 0;
    private final int id = ++idIncrementer;// n++ set first id 0
    public SimpleBooleanProperty1 isavaliable = new SimpleBooleanProperty1(true);
    public boolean ifDisable = false;
    boolean indicator = isavaliable.getValue();
    private int capacity = 2;// 1,2,4,5 for different sized vehicles


    public Space() {
    }

    public static int getIdIncrementer() {
        return idIncrementer;
    }

    public static void setIdIncrementer(int idIncrementer) {
        Space.idIncrementer = idIncrementer;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeBoolean(isIsavaliable());
        out.writeBoolean(isIndicator());
        out.writeBoolean(isIfDisable());


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.isavaliable = new SimpleBooleanProperty1(in.readBoolean());
        this.indicator = in.readBoolean();
        this.ifDisable = in.readBoolean();

    }

    public boolean isIsavaliable() {
        return isavaliable.get();
    }

    public void setIsavaliable(boolean istrue) {
        this.isavaliable.set(istrue);
    }

    public SimpleBooleanProperty1 isavaliableProperty() {
        return isavaliable;
    }

    public boolean isIndicator() {
        return indicator;
    }

    public void setIndicator(boolean indicator) {
        this.indicator = indicator;
    }

    public boolean isIfDisable() {
        return ifDisable;
    }

    public void setIfDisable(boolean ifDisable) {
        this.ifDisable = ifDisable;
    }

    public boolean booleanHelper() {
        return isavaliable.getValue();
    }

    public void setOppositeValue() {
        this.setIsavaliable(!indicator);
        indicator = !indicator;

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int getId() {
        return id;
    }

}



