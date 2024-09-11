package car_components;

public enum WheeDiameters {

    CAMRY("Camry", 17),
    SOLARA("Solara", 16),
    HIANCE("Hiance", 20),
    DYNA("Dyna", 20);

    private String carModel;
    private int diameter;


    WheeDiameters(String carModel, int diameter) {
        this.carModel = carModel;
        this.diameter = diameter;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getDiameter() {
        return diameter;
    }
}
