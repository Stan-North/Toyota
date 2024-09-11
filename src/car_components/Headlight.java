package car_components;

public class Headlight {
    private boolean isWorks;

    public Headlight(boolean isWorks) {
        this.isWorks = isWorks;
    }

    public boolean isWorks() {
        return isWorks;
    }

    public void setWorks(boolean works) {
        isWorks = works;
    }
}
