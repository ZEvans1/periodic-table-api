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
}
