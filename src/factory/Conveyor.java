package factory;

import car_components.*;
import car_models.*;

import java.math.BigDecimal;

public class Conveyor {
    private static final int DYNA_LOAD_CAPACITY = 600;
    private static final int HIANCE_LOAD_CAPACITY = 800;
    private Factory factory;
    private String country;
    //

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
        if (factory.getCountry().equals(country)){
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
      public Camry createCamry(String carColor, long carPrice) {
          BigDecimal price = BigDecimal.valueOf(carPrice);

          ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                  factory.createAllElements(WheeDiameters.CAMRY.getDiameter());

          return new Camry(carColor, CarsMaxSpeed.CAMRY.getMaxSpeed(),TransmissionEnum.AUTOMATIC.getTitle(),
                  details.getWheel1(), details.getWheel2(), details.getWheel3(),
                  details.getWheel4(), details.getElectrics(), details.getEngine(),
                  details.getFuelTank(), details.getHeadlight(), price);
      }

    /**
     * создание Dyna
     */
    public Dyna createDyna(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(WheeDiameters.DYNA.getDiameter());

        return new Dyna(carColor, CarsMaxSpeed.DYNA.getMaxSpeed(),TransmissionEnum.MANUAL.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), price, DYNA_LOAD_CAPACITY);
    }

    /**
     * создание Hiance
     */
    public Hiance createHiance(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(WheeDiameters.HIANCE.getDiameter());

        return new Hiance(carColor, CarsMaxSpeed.HIANCE.getMaxSpeed(),TransmissionEnum.MANUAL.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), price, HIANCE_LOAD_CAPACITY);
    }

    /**
     * создание Solara
     */
    public Solara createSolara(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        ElementsGeneric<Wheel, Wheel, Wheel, Wheel, Electrics, Engine, FuelTank, Headlight> details =
                factory.createAllElements(WheeDiameters.SOLARA.getDiameter());

        return new Solara(carColor, CarsMaxSpeed.SOLARA.getMaxSpeed(),TransmissionEnum.ROBOT.getTitle(), details.getWheel1(),
                details.getWheel2(), details.getWheel3(), details.getWheel4(), details.getElectrics(), details.getEngine(),
                details.getFuelTank(), details.getHeadlight(), price);
    }

    public String getCountry() {
        return country;
    }
}
