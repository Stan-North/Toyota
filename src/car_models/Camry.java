package car_models;

import car_components.*;
import car_types.LightCar;
import java.math.BigDecimal;

public class Camry extends LightCar {
    private final Usb usb;
    private static final String MUSIC_MESSAGE = "Музыка подключена";

    public Camry(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                 Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine,
                 FuelTank fuelTank, Headlight headlight, BigDecimal carPrice) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice);
        this.usb = new Usb();
    }

    /**
     * подключение музыки
     */
    public void turnOnTheMusic() {
        usb.turnOnTheMusic();
    }

    private class Usb {
        private void turnOnTheMusic() {
            System.out.println(MUSIC_MESSAGE);
        }
    }

}
