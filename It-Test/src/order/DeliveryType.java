package order;

public enum DeliveryType {
    ON_FOOT(0, "ON FOOT"),
    BICYCLE(0.01, "BICYCLE"),
    MOTORCYCLE(0.02, "MOTORCYCLE");

    private final String TYPE;
    private final double VALUE;

    DeliveryType(double value, String type) {
        this.TYPE = type;
        this.VALUE = value;
    }

    public double getVALUE() {
        return VALUE;
    }

    @Override
    public String toString() {
        return TYPE + '\'' +
                " +" + VALUE * 10 +
                "%";
    }
}
