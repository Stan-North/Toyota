package car_components;

public class Engine extends CarComponent {
    private boolean isWorks;

    public Engine(boolean isWorks) {
        this.isWorks = isWorks;
    }

    public boolean isWorks() {
        return isWorks;
    }
}
