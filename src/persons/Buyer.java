package persons;

import car_types.Car;

import java.math.BigDecimal;

public class Buyer {
    private String name;
    private BigDecimal amountOfMoney;
    private Car car;

    public Buyer(String name, BigDecimal amountOfMoney) {
        this.name = name;
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }


    public void substractMoney(BigDecimal moneyToTake) {
         amountOfMoney = amountOfMoney.subtract(moneyToTake);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return getName() + " " + getAmountOfMoney() + " " + car;
    }
}
