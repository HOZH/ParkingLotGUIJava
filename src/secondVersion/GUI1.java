package secondVersion;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;


public class GUI1 extends Application implements Serializable {

    public static parkingLot pl = new parkingLot();

    public static void labelDefaultvalue(Label label, Space space) {
        if (space.isavaliable.getValue() == false)
            label.setGraphic(new ImageView(new Image("secondVersion/car-flat.png")));
        if (space.isavaliable.getValue() == true)
            label.setGraphic(new ImageView(new Image("secondVersion/No.png")));
    }

    public static void labelbinder(Label label, Space space) {
        label.focusTraversableProperty().bind(space.isavaliable);
        label.focusTraversableProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == false)
                    label.setGraphic(new ImageView(new Image("secondVersion/car-flat.png")));
                if (newValue == true)
                    label.setGraphic(new ImageView(new Image("secondVersion/No.png")));
            }

        });
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        pl = pl.inputStreamHelper();
        Application.launch(args);
        pl.outputStreamHelper();


    }

    public void start(Stage primaryStage) throws IOException, ClassNotFoundException, InvocationTargetException {


        //  pl.getParkinglot(10, 10, 100, 10, 10);

        LinkedHashSet<Space> allSpace = pl.gatherAllspacesOfallsets();
        Iterator<Space> iter1 = allSpace.iterator();
        Iterator<Space> iter2 = allSpace.iterator();
        Iterator<Space> iter3 = allSpace.iterator();


        TextArea textArea = new TextArea();
        VBox vbox = new VBox();
        HBox[] hboxarray = new HBox[14];
        Label[][] labelarray = new Label[14][10];
        TextField plateTextfield = new TextField();
        TextField hourTextfield = new TextField();

        for (int i = 0; i < hboxarray.length; i++) {
            hboxarray[i] = new HBox();

        }

        hboxarray[0].getChildren().add(new Label(String.format("%0$-30s", "Handicapped Space")));
        hboxarray[1].getChildren().add(new Label(String.format("%0$-30s", "Motorcycle Space")));
        for (int i = 2; i < 12; i++)
            hboxarray[i].getChildren().add(new Label(String.format("%0$-30s", "Regular Space")));
        hboxarray[12].getChildren().add(new Label(String.format("%0$-30s", "Truck Space")));
        hboxarray[13].getChildren().add(new Label(String.format("%0$-30s", "Bus Space")));
        for (int i = 0; i < hboxarray.length; i++) {
            for (int j = 0; j < 10; j++) {
                labelarray[i][j] = new Label();
                labelarray[i][j].setMaxSize(5, 5);


                labelDefaultvalue(labelarray[i][j], iter2.next());
                labelbinder(labelarray[i][j], iter1.next());
                hboxarray[i].getChildren().add(labelarray[i][j]);
            }

        }
        TextField textField = new TextField();
        TextField paymentTextfield = new TextField();
        Button paymentButton = new Button("Payment");
        paymentButton.setOnAction(e -> {
            pl.findVehiclebySpaceID(Integer.parseInt(paymentTextfield.getText())).setPayment();


            paymentTextfield.setText((String.valueOf(pl.findVehiclebySpaceID(Integer.parseInt(paymentTextfield.getText())).getPayment())));

        });


        Button hourButton = new Button("hours");
        hourButton.setOnAction(e -> {

            try {
                Vehicles vehicles = pl.findVehiclebySpaceID(Integer.parseInt(textField.getText()));
                vehicles.paymentBehavior.setHours(Integer.parseInt(hourTextfield.getText()));
                vehicles.setTimeset(Integer.parseInt(hourTextfield.getText()) * 3600 * 1000);
                vehicles.paymentBehavior.payment(pl.findVehiclebySpaceID(Integer.parseInt(textField.getText())));
                pl.findVehiclebySpaceID(Integer.parseInt(textField.getText())).setPayment();
                paymentTextfield.setText(String.valueOf(pl.findVehiclebySpaceID(Integer.parseInt(textField.getText())).getPayment()));
            } catch (NumberFormatException w) {
                textArea.setText("be sure u entered a int");
            } catch (NoSuchElementException r) {
                textArea.setText("make sure the space id u enter is currently used");
            } catch (NullPointerException ii) {
                textArea.setText("be sure press default payment button first");
            }

        });

        Button checkPlanButton = new Button("check Plans");
        checkPlanButton.setOnAction(e -> {

            try {
                Vehicles vehicles = pl.findVehiclebySpaceID(Integer.parseInt(textField.getText()));
                if (pl.sbeinghereMAP.get(vehicles.getPlate()) != null) {
                    vehicles.setTypeOfplan(pl.sbeinghereMAP.get(vehicles.getPlate()).typeOfplan);
                    vehicles.setPlanPurchaseDate((pl.sbeinghereMAP.get(vehicles.getPlate()).getPlanPurchaseDate()));
                    vehicles.setPaymentBehavior(new paymentByPlans());
                    vehicles.setPayment();
                    paymentTextfield.setText(String.valueOf(vehicles.getPayment()));
                    textArea.setText("this vehicle has being here with a payment plan");
                } else {
                    textArea.setText("cannot find any record about this vehicle");
                }
            } catch (NumberFormatException w) {
                textArea.setText("be sure u entered a int");
            } catch (NoSuchElementException r) {
                textArea.setText("make sure the space id u enter is currently used");
            }


        });
        Button getMonthlyButton = new Button("get new Monthly plan");
        getMonthlyButton.setOnAction(e -> {
            try {
                Vehicles vehicles = pl.findVehiclebySpaceID(Integer.parseInt(textField.getText()));
                vehicles.setTypeOfplan(1);
                vehicles.setPaymentBehavior(new paymentByPlans());
                vehicles.setPlanPurchaseDate(System.currentTimeMillis());
                vehicles.setTimeset(2592000000l);
                vehicles.setPayment();
                paymentTextfield.setText(String.valueOf(vehicles.getPayment()));
            } catch (NumberFormatException w) {
                textArea.setText("be sure u entered a int");
            } catch (NoSuchElementException r) {
                textArea.setText("make sure the space id u enter is currently used");
            }


        });
        Button getYearlyButton = new Button("get new yearly plan");
        getYearlyButton.setOnAction(e -> {
            try {
                Vehicles vehicles = pl.findVehiclebySpaceID(Integer.parseInt(textField.getText()));
                vehicles.setTypeOfplan(2);
                vehicles.setPaymentBehavior(new paymentByPlans());
                vehicles.setPlanPurchaseDate(System.currentTimeMillis());
                vehicles.setTimeset(31536000000l);
                vehicles.setPayment();
                paymentTextfield.setText(String.valueOf(vehicles.getPayment()));
            } catch (NumberFormatException w) {
                textArea.setText("be sure u entered a int");
            } catch (NoSuchElementException r) {
                textArea.setText("make sure the space id u enter is currently used");
            }

        });
        Button getDefaultButton = new Button("Default payment");

        getDefaultButton.setOnAction(e -> {

            try {
                pl.findVehiclebySpaceID(Integer.parseInt(textField.getText())).setPaymentBehavior(new defaultPayment());
            } catch (NumberFormatException w) {
                textArea.setText("be sure u entered a int");
            } catch (NoSuchElementException r) {
                textArea.setText("make sure the space id u enter is currently used");
            }


        });


        Button handicappedButton = new Button("park on handicapped");
        handicappedButton.setOnAction(e -> {
            Car car = new Car(plateTextfield.getText());
            car.ifDisabled = true;
            pl.parkVehicle(car);


        });

        Button parkingCarButton = new Button("Park car");
        parkingCarButton.setOnAction(e -> {
            Car car = new Car(plateTextfield.getText());

            pl.parkVehicle(car);

        });

        Button parkingMotorButton = new Button("Park Motorcycle");
        parkingMotorButton.setOnAction(e -> {
            Motorcycle motorcycle = new Motorcycle(plateTextfield.getText());

            pl.parkVehicle(motorcycle);

        });
        Button parkingTruckButton = new Button("Park Truck");
        parkingTruckButton.setOnAction(e -> {
            Truck truck = new Truck(plateTextfield.getText());
            pl.parkVehicle(truck);

        });
        Button parkingBusButton = new Button("Park Bus");
        parkingBusButton.setOnAction(e -> {
            Bus bus = new Bus(plateTextfield.getText());

            pl.parkVehicle(bus);

        });


        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            try {


                pl.removeVehicle(Integer.parseInt(textField.getText()));
                pl.tempvehicles.setTicket();

                textArea.setText(pl.tempvehicles.ticket.toString());


            } catch (NumberFormatException nfe) {
                textField.setText("invalid input");


            } catch (NoSuchElementException ne) {
                textField.setText("no Vehicle is currently parking at this sapce");
            }

        });


        HBox hboxforbutton1 = new HBox();
        HBox hboxforbutton2 = new HBox();
        HBox hboxforbutton3 = new HBox();
        HBox hboxforbutton4 = new HBox();
        HBox hBoxforTextfiled1 = new HBox();
        HBox hBoxforTextfiled2 = new HBox();
        hBoxforTextfiled1.getChildren().addAll(new Label("input space id here"), textField);
        hBoxforTextfiled2.getChildren().addAll(new Label("payment output"), paymentTextfield);
        hboxforbutton1.getChildren().addAll(handicappedButton, parkingMotorButton, parkingCarButton);
        hboxforbutton2.getChildren().addAll(parkingTruckButton, parkingBusButton, removeButton);
        hboxforbutton3.getChildren().addAll(hourButton, checkPlanButton);
        hboxforbutton4.getChildren().addAll(getDefaultButton, getMonthlyButton, getYearlyButton);


        HBox hBoxforTextfiled3 = new HBox();
        HBox hBoxforTextfiled4 = new HBox();

        hBoxforTextfiled3.getChildren().addAll(new Label("input plate here"), plateTextfield);
        hBoxforTextfiled4.getChildren().addAll(new Label("input hour here"), hourTextfield);

        vbox.getChildren().addAll(hBoxforTextfiled1, hBoxforTextfiled3, hboxforbutton1, hboxforbutton2, hBoxforTextfiled2, hBoxforTextfiled4, hboxforbutton3, hboxforbutton4, textArea);


        for (int i = 0; i < hboxarray.length; i++) {
            vbox.getChildren().add(hboxarray[i]);
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        Scene scene = new Scene(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing");

        primaryStage.show();
    }

}
