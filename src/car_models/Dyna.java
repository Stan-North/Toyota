package car_models;

import car_components.*;
import car_types.CargoVan;

import java.math.BigDecimal;

public class Dyna extends CargoVan {
    public static final int DYNA_LOAD_CAPACITY = 800;
    private final Socket socket;

    public Dyna(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                Headlight headlight, BigDecimal carPrice, int loadCapacity, String country) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice, loadCapacity, country);
        this.socket = new Socket();
    }

    public void chargePhone() {
        socket.chargePhone();
    }

    @Override
    public String getModel() {
        return ModelsParameters.DYNA.getCarModel();
    }

    private class Socket {
        private static final String SOCKET_MESSAGE = "Телефон заряжается";

        private void chargePhone() {
            System.out.println(SOCKET_MESSAGE);
        }
    }
}
