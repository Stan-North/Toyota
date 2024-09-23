package car_models;

import car_components.*;
import car_types.Cabriolet;

import java.math.BigDecimal;

public class Solara extends Cabriolet {
    //Для модели solara характерно наличие мини холодильника (функция охладить напиток)
    private MiniFridge miniFridge;


    public Solara(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                  Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                  Headlight headlight, BigDecimal carPrice, String country) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics, engine,
                fuelTank, headlight, carPrice, country);
        this.miniFridge = new MiniFridge();
    }

    public void coolTheDrink() {
        this.miniFridge.coolTheDrink();
    }


    private class MiniFridge {
        private static final String COOL_DRINK_MESSAGE = "Напиток охлажден!";
        private void coolTheDrink() {
            System.out.println(COOL_DRINK_MESSAGE);
        }
    }

    @Override
    public String getModel() {
        return ModelsParameters.SOLARA.getCarModel();
    }
}
