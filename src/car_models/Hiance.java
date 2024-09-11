package car_models;

import car_components.*;
import car_types.CargoVan;

import java.math.BigDecimal;

public class Hiance extends CargoVan {
    protected Wheel spareWheel;
    public Hiance(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                  Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                  Headlight headlight, BigDecimal carPrice, int loadCapacity) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice, loadCapacity);
        this.spareWheel = new Wheel(true, WheeDiameters.HIANCE.getDiameter());
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }
}
