package car_types;

import car_components.*;

import java.math.BigDecimal;

public abstract class Cabriolet extends LightCar {
    private boolean isRoofRaised = false;

    public Cabriolet(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                     Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                     Headlight headlight, BigDecimal carPrice, String country) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics,
                engine, fuelTank, headlight, carPrice, country);
    }

    /**
     * опустить крышу
     */
    public void dropTheRoof() {
        setRoofRaised(false);
    }

    /**
     * поднять крышу
     */
    public void raiseTheRoof() {
        setRoofRaised(true);
    }

    public boolean isRoofRaised() {
        return isRoofRaised;
    }

    public void setRoofRaised(boolean roofRaised) {
        isRoofRaised = roofRaised;
    }


}
