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
}
