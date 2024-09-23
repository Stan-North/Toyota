package car_models;

import car_components.*;
import car_types.CargoVan;

import java.math.BigDecimal;

public class Hiance extends CargoVan {
    public static final int HIANCE_LOAD_CAPACITY = 800;

    protected Wheel spareWheel;
    public Hiance(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                  Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                  Headlight headlight, BigDecimal carPrice, int loadCapacity, String country) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice, loadCapacity, country);
        this.spareWheel = new Wheel(true, ModelsParameters.HIANCE.getDiameter());
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    @Override
    public String getModel() {
        return ModelsParameters.HIANCE.getCarModel();
    }
}
