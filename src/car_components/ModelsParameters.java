package car_components;

import java.math.BigDecimal;

public enum ModelsParameters {

    CAMRY("Camry", 17, 250, BigDecimal.valueOf(10_000), "black",
            BigDecimal.valueOf(5000)),
    SOLARA("Solara", 16, 200, BigDecimal.valueOf(12_000), "white",
            BigDecimal.valueOf(8000)),
    HIANCE("Hiance", 20, 180, BigDecimal.valueOf(15_000), "black",
            BigDecimal.valueOf(10000)),
    DYNA("Dyna", 20, 160, BigDecimal.valueOf(22_000), "black",
            BigDecimal.valueOf(12000));

    private final String carModel;
    private final int diameter;
    private final int maxSpeed;
    private final BigDecimal price;
    private final String standartColor;
    private final BigDecimal costPrice;

    ModelsParameters(String carModel, int diameter, int maxSpeed, BigDecimal price, String standartColor,
                     BigDecimal costPrice) {
        this.carModel = carModel;
        this.diameter = diameter;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.standartColor = standartColor;
        this.costPrice = costPrice;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getStandartColor() {
        return standartColor;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }
}
