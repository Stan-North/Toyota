package factory;

import car_components.*;
import car_models.*;
import car_types.Car;

import java.math.BigDecimal;
import static car_components.ModelsParameters.*;

public class Conveyor {
    private Factory factory;
    private String country;

    public Conveyor(Factory factory, String country) {
        try {
            if (isCorrectCountry(country) && isCountryMatch(factory, country)) {
                this.factory = factory;
                this.country = country;
            }
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * проверка на соответсвите страны конвеера и фабрики
     */
    public boolean isCountryMatch(Factory factory, String country) throws CountyFactoryNotEqualException {
        if (factory.getCountry().equals(country)) {
            return true;
        } else {
            throw new CountyFactoryNotEqualException("Страны разные. Страна фабрики: " + factory.getCountry()
                    + ". Страна конвеера: " + country);
        }
    }

    /**
     * проверка, есть ли страна для создания в Countries Enum
     */
    private boolean isCorrectCountry(String country) {
        if (country != null) {
            for (CountriesEnum element : CountriesEnum.values()) {
                if (country.equals(element.getCountryName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * создание Camry
     */
    public Camry createCamry(String carColor, BigDecimal carPrice) {
        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(ModelsParameters.CAMRY.getDiameter());

        return new Camry(carColor, CAMRY.getMaxSpeed(), TransmissionEnum.AUTOMATIC.getTitle(),
                details.getWheel1(), details.getWheel2(), details.getWheel3(),
                details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), carPrice, getCountry());
    }

    /**
     * создание Dyna
     */
    public Dyna createDyna(String carColor, BigDecimal carPrice) {

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(ModelsParameters.DYNA.getDiameter());

        return new Dyna(carColor, DYNA.getMaxSpeed(), TransmissionEnum.MANUAL.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), carPrice, Dyna.DYNA_LOAD_CAPACITY, getCountry());
    }

    /**
     * создание Hiance
     */
    public Hiance createHiance(String carColor, BigDecimal carPrice) {

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(ModelsParameters.HIANCE.getDiameter());

        return new Hiance(carColor, HIANCE.getMaxSpeed(), TransmissionEnum.MANUAL.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), carPrice, Hiance.HIANCE_LOAD_CAPACITY, getCountry());
    }

    /**
     * создание Solara
     */
    public Solara createSolara(String carColor, BigDecimal carPrice) {

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(ModelsParameters.SOLARA.getDiameter());

        return new Solara(carColor, SOLARA.getMaxSpeed(), TransmissionEnum.ROBOT.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), carPrice, getCountry());
    }

    public String getCountry() {
        return country;
    }

    public Car createCarFromRequest(String carModel, String carColor, BigDecimal priceWithMargin) {
        if (carModel.equals(CAMRY.getCarModel())) {
            return createCamry(carColor, priceWithMargin);
        } else if (carModel.equals(DYNA.getCarModel())) {
            return createDyna(carColor, priceWithMargin);
        } else if (carModel.equals(HIANCE.getCarModel())) {
            return createHiance(carColor, priceWithMargin);
        } else if (carModel.equals(SOLARA.getCarModel())) {
            return createSolara(carColor, priceWithMargin);
        }
        return null;
    }
}
