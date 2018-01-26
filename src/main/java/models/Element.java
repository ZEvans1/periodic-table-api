package models;

public class Element {

    private String name;
    private String symbol;
    private int atomicNumber;
    private int atomicMass;
    private int groupNumber;
    private int periodNumber;
    private int id;
    private int groupId;
    private int periodId;

    public Element(String name, String symbol, int atomicNumber, int atomicMass, int groupNumber, int periodNumber, int groupId, int periodId) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.groupNumber = groupNumber;
        this.periodNumber = periodNumber;
        this.groupId = groupId;
        this.periodId = periodId;

    }
}
