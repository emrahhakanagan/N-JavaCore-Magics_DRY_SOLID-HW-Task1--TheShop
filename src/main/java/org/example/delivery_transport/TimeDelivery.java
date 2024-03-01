package org.example.delivery_transport;

public enum TimeDelivery {
    MOTO_COURIER_DELIVERY_TIME(15),
    BIKE_COURIER_DELIVERY_TIME(60);

    private int min;

    TimeDelivery(int min) {
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "TimeDelivery{" +
                "min=" + min +
                '}';
    }
}
