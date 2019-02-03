package secondVersion;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class parkingLot implements Serializable {
    int numberofspace = 20;


    LinkedHashMap<Space, Vehicles> currentParking = new LinkedHashMap<>();
    LinkedHashMap<String, Vehicles> sbeinghereMAP = new LinkedHashMap<String, Vehicles>();
    Vehicles tempvehicles;
    private LinkedHashSet<Space> handicappedspace = new LinkedHashSet<Space>();
    private LinkedHashSet<Space> motorcyclespace = new LinkedHashSet<Space>();
    private LinkedHashSet<Space> regularspace = new LinkedHashSet<Space>();
    private LinkedHashSet<Space> truckspace = new LinkedHashSet<Space>();
    private LinkedHashSet<Space> busspace = new LinkedHashSet<Space>();

    public parkingLot() {

    }

    public Vehicles getTempvehicles() {
        return tempvehicles;
    }

    public void setTempvehicles(Vehicles tempvehicles) {
        this.tempvehicles = tempvehicles;
    }

    public int getsizeofallsets() {
        int size;
        size = handicappedspace.size() + motorcyclespace.size() + regularspace.size() + truckspace.size() + busspace.size();
        return size;
    }

    public void gatheringHelper(LinkedHashSet<Space> hashSet, LinkedHashSet<Space> targetSet) {
        Iterator<Space> iter = hashSet.iterator();
        while (iter.hasNext()) {
            targetSet.add(iter.next());
        }

    }

    public LinkedHashSet<Space> gatherAllspacesOfallsets() {
        LinkedHashSet<Space> targetHashset = new LinkedHashSet<>();
        gatheringHelper(handicappedspace, targetHashset);
        gatheringHelper(motorcyclespace, targetHashset);
        gatheringHelper(regularspace, targetHashset);
        gatheringHelper(truckspace, targetHashset);
        gatheringHelper(busspace, targetHashset);
        return targetHashset;

    }

    public int getNumberofspace() {
        return numberofspace;
    }

    public void setNumberofspace(int size) {
        this.numberofspace = size;
    }

    public LinkedHashMap<Space, Vehicles> getCurrentParking() {
        return currentParking;
    }

    public void setCurrentParking(LinkedHashMap<Space, Vehicles> currentParking) {
        this.currentParking = currentParking;
    }

    public void displayAset(LinkedHashSet<Space> hashSet) {
        for (Space space : hashSet) System.out.println(space.getId());
    }


    public void getParkinglot
            (int numberOfHandicapped, int numberOfmotorcyclespace,
             int numberOfregularspace, int numberOftruckspace, int numberOfbusspace) {
        this.numberofspace = numberOfbusspace + numberOfHandicapped + numberOftruckspace + numberOfmotorcyclespace + numberOfregularspace;

        for (int i = 0; i < numberOfHandicapped; i++) {
            Space sp = new Space();
            handicappedspace.add(sp);
            sp.ifDisable = true;
        }

        for (int i = 0; i < numberOfmotorcyclespace; i++) {
            Space sp = new Space();
            sp.setCapacity(1);
            motorcyclespace.add(sp);
        }
        for (int i = 0; i < numberOfregularspace; i++) {
            Space sp = new Space();
            sp.setCapacity(2);
            regularspace.add(sp);
        }
        for (int i = 0; i < numberOftruckspace; i++) {
            Space sp = new Space();
            sp.setCapacity(4);
            truckspace.add(sp);
        }
        for (int i = 0; i < numberOfbusspace; i++) {
            Space sp = new Space();
            sp.setCapacity(5);
            busspace.add(sp);
        }

    }


    private void parkVehicleHelper(LinkedHashSet<Space> thatspace, Vehicles vehicles) {

        Iterator<Space> iter1 = thatspace.iterator();
        Iterator<Space> iter2 = thatspace.iterator();
        Iterator<Space> iter3 = thatspace.iterator();
        Iterator<Space> iter4 = thatspace.iterator();
        Iterator<Space> iter5 = thatspace.iterator();
        Iterator<Space> iter6 = thatspace.iterator();

        boolean isparked = false;
        for (int i = 0; i < thatspace.size(); i++) {

            if (iter1.next().isavaliable.getValue() == false) {
                iter2.next();
                iter3.next();
                iter4.next();

            } else {
                iter2.next().isavaliable.setValue(false);
                System.out.println(iter3.next().getId());
                currentParking.put(iter4.next(), vehicles);
                vehicles.setEnterTIme(System.currentTimeMillis());

                isparked = true;

                break;


            }
        }

        if (isparked == false) System.out.println("no more space");

    }


    public void parkVehicle(Vehicles vehicles) {

        if (vehicles.spaceRequired == 1) {
            parkVehicleHelper(motorcyclespace, vehicles);
        } else if (vehicles.spaceRequired == 2) {
            if (vehicles.isDisabled() == true) {
                vehicles.isinhandicapped = true;
                parkVehicleHelper(handicappedspace, vehicles);
            } else parkVehicleHelper(regularspace, vehicles);
        } else if (vehicles.spaceRequired == 4) parkVehicleHelper(truckspace, vehicles);
        else if (vehicles.spaceRequired == 5) parkVehicleHelper(busspace, vehicles);


    }

    private void removeHelper(Space recyclingSpace) {
        recyclingSpace.isavaliable.setValue(true);


    }

    public void removeVehicle(int spaceId) {
        Iterator<Space> iter1 = currentParking.keySet().iterator();
        Iterator<Space> iter2 = currentParking.keySet().iterator();
        Iterator<Space> iter3 = currentParking.keySet().iterator();
        Iterator<Space> iter4 = currentParking.keySet().iterator();
        Iterator<Space> iter5 = currentParking.keySet().iterator();
        Iterator<Space> iter6 = currentParking.keySet().iterator();
        Iterator<Space> iter7 = currentParking.keySet().iterator();
        Iterator<Space> iter8 = currentParking.keySet().iterator();
        Iterator<Space> iter9 = currentParking.keySet().iterator();
        Iterator<Space> iter10 = currentParking.keySet().iterator();
        Iterator<Space> iter11 = currentParking.keySet().iterator();
        Iterator<Space> iter12 = currentParking.keySet().iterator();
        Iterator<Space> iter13 = currentParking.keySet().iterator();
        Iterator<Space> iter14 = currentParking.keySet().iterator();
        Iterator<Space> iter15 = currentParking.keySet().iterator();
        Iterator<Space> iter16 = currentParking.keySet().iterator();
        Iterator<Space> iter17 = currentParking.keySet().iterator();
        Iterator<Space> iter18 = currentParking.keySet().iterator();
        Iterator<Space> iter19 = currentParking.keySet().iterator();
        Iterator<Space> iter20 = currentParking.keySet().iterator();
        Iterator<Space> iter21 = currentParking.keySet().iterator();


        while (iter1.hasNext()) {
            if (spaceId == iter1.next().getId()) {
                break;
            } else {
                iter2.next();
                iter3.next();
                iter4.next();
                iter5.next();
                iter6.next();
                iter7.next();
                iter8.next();
                iter9.next();
                iter10.next();
                iter11.next();
                iter12.next();
                iter13.next();
                iter14.next();
                iter15.next();
                iter16.next();
                iter17.next();
                iter18.next();
                iter19.next();
                iter20.next();
                iter21.next();


            }
        }

        removeHelper(iter2.next());
        currentParking.get(iter5.next()).leaveTime = System.currentTimeMillis();
        currentParking.get(iter3.next()).isinhandicapped = false;

        if (currentParking.get(iter20.next()).typeOfplan == 1 || currentParking.get(iter21.next()).typeOfplan == 2)
            sbeinghereMAP.put(currentParking.get(iter6.next()).getPlate(), currentParking.get(iter7.next()));
        if (currentParking.get(iter12.next()).typeOfplan == 0) {
            if (currentParking.get(iter8.next()).leaveTime - currentParking.get(iter9.next()).enterTIme > currentParking.get(iter10.next()).timeset) {
                currentParking.get(iter11.next()).setIfPassedtimelimit(true);
            }
        } else if ((currentParking.get(iter13.next()).leaveTime - currentParking.get(iter14.next()).planPurchaseDate) > currentParking.get(iter15.next()).timeset) {
            currentParking.get(iter16.next()).setIfPassedtimelimit(true);
        }
        if (currentParking.get(iter17.next()).isIfPassedtimelimit() == true)
            currentParking.get(iter18.next()).fine = 50;

        setTempvehicles(currentParking.get(iter19.next()));
        currentParking.remove(iter4.next());


    }


    public Vehicles findVehiclebySpaceID(int id) {

        Iterator<Space> iter1 = currentParking.keySet().iterator();
        Iterator<Space> iter2 = currentParking.keySet().iterator();
        while (iter1.hasNext()) {
            if (id == iter1.next().getId()) {
                break;
            } else {
                iter2.next();

            }
        }
        return currentParking.get(iter2.next());


    }

    public void outputStreamHelper() throws IOException {
        File file = new File("outputTesting.dat");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));

        outputStream.writeObject(this);
    }

    public parkingLot inputStreamHelper() throws IOException, ClassNotFoundException {
        parkingLot thatparkinglot;
        File file = new File("outputTesting.dat");

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));

        return thatparkinglot = (parkingLot) inputStream.readObject();
    }


}
