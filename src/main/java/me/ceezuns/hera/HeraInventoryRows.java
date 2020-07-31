package me.ceezuns.hera;

public enum HeraInventoryRows {

    ONE(9),
    TWO(18),
    THREE(27),
    FOUR(36),
    FIVE(45),
    SIX(54),
    SEVEN(63),
    EIGHT(72),
    NINE(81);

    private int size;

    HeraInventoryRows(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
