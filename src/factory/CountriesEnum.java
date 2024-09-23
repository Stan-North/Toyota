package factory;

public enum CountriesEnum {
    JAPAN("Япония");

    private final String countryName;

    CountriesEnum(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
