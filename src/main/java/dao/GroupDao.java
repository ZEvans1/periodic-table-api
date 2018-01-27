package dao;

import models.Element;
import models.Group;

import java.util.List;

public interface GroupDao {
    void add(Group group);
    List<Group> getAll();
    Group findById(int id);
}
