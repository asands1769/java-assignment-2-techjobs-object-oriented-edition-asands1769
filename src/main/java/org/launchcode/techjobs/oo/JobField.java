package org.launchcode.techjobs.oo;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }
    @Override
    public String toString() {
        return getValue();
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}
