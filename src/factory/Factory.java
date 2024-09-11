package factory;

import car_components.*;

import java.math.BigDecimal;

public class Factory {
    private static final double DEFAULT_AMOUNT_OF_FUEL = 0;
    private final String country;

    public Factory(String country) {
        if (isCorrectCountry(country)){
            this.country = country;
        } else {
            throw new RuntimeException("Такой страны нет");
        }

    }

    public String getCountry() {
        return country;
    }

    /**
     * проверка, есть ли страна для создания в enume
     */
    private boolean isCorrectCountry(String country) {
        for (CountriesEnum element : CountriesEnum.values()) {
            if (country.equals(element.getCountryName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Создание колеса
     */
    protected Wheel createWheel(int diameter) {
        return new Wheel(true, diameter);
    }

    /**
     * Создание электроники
     */
    protected Electrics createElectric() {
        return new Electrics(true);
    }

    /**
     * Создание двигателя
     */
    protected Engine createEngine() {
        return new Engine(true);
    }

    /**
     * Создание бензобака
     */
    protected FuelTank createFuelTank() {
        return new FuelTank(DEFAULT_AMOUNT_OF_FUEL);
    }

    /**
     * Создание фар
     */
    protected Headlight createHeadLight() {
        return new Headlight(true);
    }
}
