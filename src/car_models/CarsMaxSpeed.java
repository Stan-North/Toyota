package car_models;

public enum CarsMaxSpeed {
    CAMRY("Camry", 250),
    SOLARA("Solara", 200),
    HIANCE("Hiance", 180),
    DYNA("Dyna", 160);

    private String carModel;
    private int maxSpeed;


    CarsMaxSpeed(String carModel, int maxSpeed) {
        this.carModel = carModel;
        this.maxSpeed = maxSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
