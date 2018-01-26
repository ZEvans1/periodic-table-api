package models;

public class Group {
    private String name;
    private String specialName;
    private int id;

    public Group(String name) {
        this.name = name;
        this.specialName = "no special name";
    }

    public Group(String name, String specialName) {
        this.name = name;
        this.specialName = specialName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

        if (id != group.id) return false;
        if (!name.equals(group.name)) return false;
        return specialName != null ? specialName.equals(group.specialName) : group.specialName == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (specialName != null ? specialName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
