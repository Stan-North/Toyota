package car_components;

public class Electrics extends CarComponent {
    private boolean isWorks;

    public Electrics(boolean isWorks) {
        this.isWorks = isWorks;
    }

    public boolean isWorks() {
        return isWorks;
    }
}
