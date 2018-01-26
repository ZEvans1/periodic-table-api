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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicMass() {
        return atomicMass;
    }

    public void setAtomicMass(int atomicMass) {
        this.atomicMass = atomicMass;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(int periodNumber) {
        this.periodNumber = periodNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }
}
