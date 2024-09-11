import car_components.*;
import car_models.Camry;
import car_models.Dyna;
import car_models.Hiance;
import car_models.Solara;
import car_types.StartCarException;
import factory.Conveyor;
import factory.CountriesEnum;
import factory.Factory;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        Factory factory1 = new Factory(CountriesEnum.JAPAN.getCountryName());
        Conveyor conveyor = new Conveyor(factory1, CountriesEnum.JAPAN.getCountryName());

        Camry camry = conveyor.createCamry("Black", 2_000_000);

    }
}
