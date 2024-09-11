package car_components;

public class Wheel {
    private boolean isWorks;
    private int diameter;

    public Wheel(boolean isWorks, int diameter) {
        this.isWorks = isWorks;
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public boolean isWorks() {
        return isWorks;
    }
}
