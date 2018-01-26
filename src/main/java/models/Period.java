package models;

public class Period {
    private int name;
    private int id;

    public Period(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (name != period.name) return false;
        return id == period.id;
    }

    @Override
    public int hashCode() {
        int result = name;
        result = 31 * result + id;
        return result;
    }
}
