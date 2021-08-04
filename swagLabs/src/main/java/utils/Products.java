package utils;

public enum Products {
    SAUCE_LABS_BACKPACK("sauce-labs-backpack"),
    SAUCE_LABS_BIKE_LIGHT("sauce-labs-bike-light"),
    SAUCE_LABS_BOLT_T_SHIRT("sauce-labs-bolt-t-shirt"),
    SAUCE_LABS_FLEECE_JACKET("sauce-labs-fleece-jacket"),
    SAUCE_LABS_ONESIE("sauce-labs-onesie"),
    ALL_THE_THINGS("test.allthethings()-t-shirt-(red)");

    private String name;

    Products(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
