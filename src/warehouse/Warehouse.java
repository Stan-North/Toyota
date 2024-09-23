package warehouse;

import car_types.Car;
import java.util.ArrayList;
import java.util.HashMap;

import static car_components.ModelsParameters.*;

public class Warehouse {
    private static final int MAX_CAR_CAPACITY = 1000;
    private static final int INDEX_SUBSTRACT_TO_FIND_CAR = 1;
    private static final String WAREHOUSE_IS_FULL_MESSAGE = "На складе нет места";

    private int carCounter;
    private HashMap<String, ArrayList<Car>> cars;

    public Warehouse() {
        cars = new HashMap<>();
        cars.put(CAMRY.getCarModel(), new ArrayList<>(MAX_CAR_CAPACITY));
        cars.put(DYNA.getCarModel(), new ArrayList<>(MAX_CAR_CAPACITY));
        cars.put(HIANCE.getCarModel(), new ArrayList<>(MAX_CAR_CAPACITY));
        cars.put(SOLARA.getCarModel(), new ArrayList<>(MAX_CAR_CAPACITY));
    }

    /**
     * дообавление машины
     */
    public void addCar(Car car) {
        if (carCounter != MAX_CAR_CAPACITY) {
            ArrayList<Car> carList = cars.get(car.getModel());
            carList.add(car);
            cars.put(car.getModel(), carList);
            carCounter++;
        } else {
            System.out.println(WAREHOUSE_IS_FULL_MESSAGE);
        }
    }

    /**
     * взятие машины со склада
     */
    public Car takeCar(String carModel) {
        ArrayList<Car> carList = cars.get(carModel);
        if (!carList.isEmpty()) {
            Car car = carList.get(carList.size() - INDEX_SUBSTRACT_TO_FIND_CAR);
            carList.remove(car);
            carCounter--;
            return car;
        }
        return null;
    }

    /**
     * возвращает кол-во определенной модели на складе
     */
    public int showModelQuantity(String carModel) {
        ArrayList<Car> carList = cars.get(carModel);
        return carList.size();
    }

    public HashMap<String, ArrayList<Car>> getCars() {
        return cars;
    }
}
