package factory;

import car_components.*;

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
     * создание всех комплектующих
     */
    public ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> createAllElements(
            int diameter){
        Wheel wheel1 = createWheel(diameter);
        Wheel wheel2 = createWheel(diameter);
        Wheel wheel3 = createWheel(diameter);
        Wheel wheel4 = createWheel(diameter);
        Electrics electrics = createElectric();
        Engine engine = createEngine();
        FuelTank fuelTank = createFuelTank();
        Headlight headlight = createHeadLight();

        return new ElementsGeneric<>(wheel1, wheel2, wheel3, wheel4, electrics, engine, fuelTank, headlight);
    }

    protected Wheel createWheel(int diameter) {
        return new Wheel(true, diameter);
    }

    protected Electrics createElectric() {
        return new Electrics(true);
    }

    protected Engine createEngine() {
        return new Engine(true);
    }

    protected FuelTank createFuelTank() {
        return new FuelTank(DEFAULT_AMOUNT_OF_FUEL);
    }

    protected Headlight createHeadLight() {
        return new Headlight(true);
    }
}
