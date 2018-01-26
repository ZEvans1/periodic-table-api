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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (atomicNumber != element.atomicNumber) return false;
        if (atomicMass != element.atomicMass) return false;
        if (groupNumber != element.groupNumber) return false;
        if (periodNumber != element.periodNumber) return false;
        if (id != element.id) return false;
        if (groupId != element.groupId) return false;
        if (periodId != element.periodId) return false;
        if (!name.equals(element.name)) return false;
        return symbol.equals(element.symbol);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + symbol.hashCode();
        result = 31 * result + atomicNumber;
        result = 31 * result + atomicMass;
        result = 31 * result + groupNumber;
        result = 31 * result + periodNumber;
        result = 31 * result + id;
        result = 31 * result + groupId;
        result = 31 * result + periodId;
        return result;
    }
}
