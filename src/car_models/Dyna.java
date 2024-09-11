package car_models;

import car_components.*;
import car_types.CargoVan;

import java.math.BigDecimal;

public class Dyna extends CargoVan {
    private final Socket socket;

    public Dyna(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                Headlight headlight, BigDecimal carPrice, int loadCapacity) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice, loadCapacity);
        this.socket = new Socket();
    }

    /**
     * зарядить телефон
     */
    public void chargePhone() {
        this.socket.chargePhone();
    }

    private class Socket {
        private static final String SOCKET_MESSAGE = "Телефон заряжается";

        private void chargePhone() {
            System.out.println(SOCKET_MESSAGE);
        }
    }
}
