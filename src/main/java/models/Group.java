package models;

public class Group {
    private int name;
    private String specialName;
    private int id;

    public Group(int name) {
        this.name = name;
        this.specialName = "no special name";
    }

    public Group(int name, String specialName) {
        this.name = name;
        this.specialName = specialName;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
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

        Group group = (Group) o;

        if (name != group.name) return false;
        if (id != group.id) return false;
        return specialName != null ? specialName.equals(group.specialName) : group.specialName == null;
    }

    @Override
    public int hashCode() {
        int result = name;
        result = 31 * result + (specialName != null ? specialName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}