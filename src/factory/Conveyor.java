package factory;

import car_components.*;
import car_models.*;

import java.math.BigDecimal;

public class Conveyor {
    private static final int DYNA_LOAD_CAPACITY = 600;
    private static final int HIANCE_LOAD_CAPACITY = 800;
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

//    public Conveyor(Factory factory, String country) throws CountyFactoryNotEqualException {
//        if (isCorrectCountry(country) && isCountryMatch(factory, country)) {
//            this.factory = factory;
//            this.country = country;
//        }
//    }

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
     * создание Camry
     */
      public Camry createCamry(String carColor, long carPrice) {
          BigDecimal price = BigDecimal.valueOf(carPrice);

          Wheel firstWheel = factory.createWheel(WheeDiameters.CAMRY.getDiameter());
          Wheel secondWheel = factory.createWheel(WheeDiameters.CAMRY.getDiameter());
          Wheel thirdWheel = factory.createWheel(WheeDiameters.CAMRY.getDiameter());
          Wheel fourthWheel = factory.createWheel(WheeDiameters.CAMRY.getDiameter());
          Electrics camryElectrics = factory.createElectric();
          Engine camryEngine = factory.createEngine();
          FuelTank camryFuelTank = factory.createFuelTank();
          Headlight camryHeadLight = factory.createHeadLight();

          return new Camry(carColor, CarsMaxSpeed.CAMRY.getMaxSpeed(),TransmissionEnum.AUTOMATIC.getTitle(), firstWheel,
                  secondWheel, thirdWheel, fourthWheel, camryElectrics, camryEngine, camryFuelTank, camryHeadLight, price);
      }

    /**
     * создание Dyna
     */
    public Dyna createDyna(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        Wheel firstWheel = factory.createWheel(WheeDiameters.DYNA.getDiameter());
        Wheel secondWheel = factory.createWheel(WheeDiameters.DYNA.getDiameter());
        Wheel thirdWheel = factory.createWheel(WheeDiameters.DYNA.getDiameter());
        Wheel fourthWheel = factory.createWheel(WheeDiameters.DYNA.getDiameter());
        Electrics dynaElectrics = factory.createElectric();
        Engine dynaEngine = factory.createEngine();
        FuelTank dynaFuelTank = factory.createFuelTank();
        Headlight dynaHeadLight = factory.createHeadLight();

        return new Dyna(carColor, CarsMaxSpeed.DYNA.getMaxSpeed(),TransmissionEnum.MANUAL.getTitle(), firstWheel,
                secondWheel, thirdWheel, fourthWheel, dynaElectrics, dynaEngine, dynaFuelTank, dynaHeadLight, price,
                DYNA_LOAD_CAPACITY);
    }

    /**
     * создание Hiance
     */
    public Hiance createHiance(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        Wheel firstWheel = factory.createWheel(WheeDiameters.HIANCE.getDiameter());
        Wheel secondWheel = factory.createWheel(WheeDiameters.HIANCE.getDiameter());
        Wheel thirdWheel = factory.createWheel(WheeDiameters.HIANCE.getDiameter());
        Wheel fourthWheel = factory.createWheel(WheeDiameters.HIANCE.getDiameter());
        Electrics hianceElectrics = factory.createElectric();
        Engine hianceEngine = factory.createEngine();
        FuelTank hianceFuelTank = factory.createFuelTank();
        Headlight hianceHeadLight = factory.createHeadLight();

        return new Hiance(carColor, CarsMaxSpeed.HIANCE.getMaxSpeed(),TransmissionEnum.MANUAL.getTitle(), firstWheel,
                secondWheel, thirdWheel, fourthWheel, hianceElectrics, hianceEngine, hianceFuelTank, hianceHeadLight,
                price, HIANCE_LOAD_CAPACITY);
    }

    /**
     * создание Solara
     */
    public Solara createSolara(String carColor, long carPrice) {
        BigDecimal price = BigDecimal.valueOf(carPrice);

        Wheel firstWheel = factory.createWheel(WheeDiameters.SOLARA.getDiameter());
        Wheel secondWheel = factory.createWheel(WheeDiameters.SOLARA.getDiameter());
        Wheel thirdWheel = factory.createWheel(WheeDiameters.SOLARA.getDiameter());
        Wheel fourthWheel = factory.createWheel(WheeDiameters.SOLARA.getDiameter());
        Electrics solaraElectrics = factory.createElectric();
        Engine solaraEngine = factory.createEngine();
        FuelTank solaraFuelTank = factory.createFuelTank();
        Headlight solaraHeadLight = factory.createHeadLight();

        return new Solara(carColor, CarsMaxSpeed.SOLARA.getMaxSpeed(),TransmissionEnum.ROBOT.getTitle(), firstWheel,
                secondWheel, thirdWheel, fourthWheel, solaraElectrics, solaraEngine, solaraFuelTank, solaraHeadLight,
                price);
    }

    public String getCountry() {
        return country;
    }
}
