package car_types;

import car_components.*;

import java.math.BigDecimal;

public abstract class Car {
    //private String carType = "";
    private static final int COUNT_OF_WHEELS = 4;
    private static final double MIN_AMOUNT_OF_FUEL_TO_MOVE = 0;
    private final String color;
    private final int maxSpeed;
    private final String transmission;

    private Wheel firstWheel;
    private Wheel secondWheel;
    private Wheel thirdWheel;
    private Wheel fourthWheel;

    private final Electrics electrics;
    private final Engine engine;
    private final FuelTank fuelTank;
    private final Headlight headlight;
    private final BigDecimal carPrice;

    private boolean isMoving;

    private String country;

    public Car(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
               Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine,
               FuelTank fuelTank, Headlight headlight, BigDecimal carPrice, String country) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmission = transmission;
        this.firstWheel = firstWheel;
        this.secondWheel = secondWheel;
        this.thirdWheel = thirdWheel;
        this.fourthWheel = fourthWheel;
        this.electrics = electrics;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.headlight = headlight;
        this.carPrice = carPrice;
        this.country = country;
    }

    public void startMove() {
        try {
            if (isCarCanMove()) {
                setMoving(true);
            }
        } catch (StartCarException e) {
            e.getMessage();
        }
    }

    public void stopMove() {
        setMoving(false);
    }

    public void turnOnTheLight() {
        this.headlight.setWorks(true);
    }

    /**
     * проверка, может ли машина ехать
     */
    private boolean isCarCanMove() throws StartCarException {
        if (this.fuelTank.getAmountOfFuel() < MIN_AMOUNT_OF_FUEL_TO_MOVE) {
            throw new StartCarException("Бензин меньше 0");
        }
        if (!isWheelsOkay()) {
            throw new StartCarException("Колесо(а) отсутсвуют или проколоты");
        }
        if (!this.electrics.isWorks()) {
            throw new StartCarException("Электрика не работает");
        }
        if (!this.engine.isWorks()) {
            throw new StartCarException("Двигатель не работает");
        }

        return true;
    }

    /**
     * проверка всех колес
     */
    private boolean isWheelsOkay() {
        return  (isWheelWorks(this.firstWheel)
                && isWheelWorks(this.secondWheel)
                && isWheelWorks(this.thirdWheel)
                && isWheelWorks(this.fourthWheel));
    }

    /**
     * проверка одного колеса
     */
    private boolean isWheelWorks(Wheel wheel) {
        return wheel != null && wheel.isWorks();
    }

    /**
     * замена колеса
     */
    public void changeWheel(int numberOfWheel, Wheel newWheel) {
        if ((numberOfWheel <= COUNT_OF_WHEELS) && (newWheel.getDiameter() == this.firstWheel.getDiameter())) {
            switch (numberOfWheel) {
                case (1) :
                    this.firstWheel = newWheel;
                    break;
                case (2) :
                    this.secondWheel = newWheel;
                    break;
                case (3) :
                    this.thirdWheel = newWheel;
                    break;
                case (4) :
                    this.fourthWheel = newWheel;
                    break;
            }
        } else {
            throw new RuntimeException("Введите номер колеса (1-4)");
        }

    }

    public boolean isMoving() {
        return isMoving;
    }

    private void setMoving(boolean moving) {
        isMoving = moving;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getCountry() {
        return country;
    }

    public abstract String getModel();

    public BigDecimal getCarPrice() {
        return carPrice;
    }


}
