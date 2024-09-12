package car_components;

public class Wheel extends CarComponent {
    private boolean isWorks;
    private final int diameter;

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

    public void setWorks(boolean works) {
        isWorks = works;
    }
}
