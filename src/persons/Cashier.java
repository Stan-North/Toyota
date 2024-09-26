package persons;

import car_types.Car;

import java.math.BigDecimal;

public class Cashier {
    private static final String PRINT_INCOME_MESSAGE = "Сумма проданных машин: ";
    private static BigDecimal totalIncome = BigDecimal.ZERO;

    public void addIncome(Car car) {
        if (car != null) {
            totalIncome = totalIncome.add(car.getCarPrice());
        }
    }

    public void printTotalIncome() {
        System.out.println(PRINT_INCOME_MESSAGE + totalIncome);
    }
}
