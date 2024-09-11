package car_components;

public enum TransmissionEnum {
    AUTOMATIC ("Автоматическая"),
    MANUAL ("Ручная"),
    ROBOT ("Робот");

    private String title;

    TransmissionEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
