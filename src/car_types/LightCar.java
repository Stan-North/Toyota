package car_types;

import car_components.*;

import java.math.BigDecimal;

public abstract class LightCar extends Car {
    //Для легковых авто характерно наличие круиз контроля, и возможности включить или выключить его.
    private boolean isCruiseControlWorking;

    public LightCar(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                    Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                    Headlight headlight, BigDecimal carPrice) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice);
    }

    public void turnOnTheCruiseControl() {
        isCruiseControlWorking = true;
    }

    public void turnOffTheCruiseControl() {
        isCruiseControlWorking = false;
    }

    public boolean isCruiseControlOn() {
        return isCruiseControlWorking;
    }
}
