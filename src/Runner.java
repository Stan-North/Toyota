import car_components.ModelsParameters;
import car_models.Camry;
import car_models.Dyna;
import car_models.Hiance;
import car_models.Solara;
import factory.Conveyor;
import factory.Factory;
import persons.Buyer;
import persons.Cashier;
import persons.Manager;
import warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static factory.CountriesEnum.*;
import static car_components.ModelsParameters.*;

public class Runner {
    public static void main(String[] args) {
        Factory factory1 = new Factory(JAPAN.getCountryName());
        Conveyor conveyor = new Conveyor(factory1, JAPAN.getCountryName());
        Warehouse warehouse = new Warehouse();

        Camry camry = conveyor.createCamry(CAMRY.getStandartColor(), CAMRY.getPrice());
        Solara solara = conveyor.createSolara(SOLARA.getStandartColor(), SOLARA.getPrice());
        Hiance hiance = conveyor.createHiance(HIANCE.getStandartColor(), HIANCE.getPrice());
        Dyna dyna = conveyor.createDyna(DYNA.getStandartColor(), DYNA.getPrice());
        warehouse.addCar(camry);
        warehouse.addCar(solara);
        warehouse.addCar(hiance);
        warehouse.addCar(dyna);

        Manager manager = new Manager(warehouse, conveyor, "Victoria");
        Cashier cashier = new Cashier();

        Buyer buyer1 = new Buyer("Petr", BigDecimal.valueOf(10_000));
        Buyer buyer2 = new Buyer("Ivan", BigDecimal.valueOf(12_000));
        Buyer buyer3 = new Buyer("Oleg", BigDecimal.valueOf(15_000));
        Buyer buyer4 = new Buyer("Dima", BigDecimal.valueOf(22_000));
        Buyer buyer5 = new Buyer("Alex", BigDecimal.valueOf(11_000));
        Buyer buyer6 = new Buyer("Vlad", BigDecimal.valueOf(13_200));
        Buyer buyer7 = new Buyer("Anton", BigDecimal.valueOf(8_000));
        Buyer buyer8 = new Buyer("Ilya", BigDecimal.valueOf(30_000));

        ArrayList<Buyer> buyers = new ArrayList<>(List.of(buyer1, buyer2, buyer3, buyer4, buyer5,
                buyer6, buyer7, buyer8));

        for (Buyer buyer : buyers) {
            cashier.addIncome(manager.sellCar(buyer));
        }

        cashier.printTotalIncome();
        manager.generateReport();

    }
}
