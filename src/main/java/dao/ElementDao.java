package dao;

import models.Element;
import models.Group;

import java.util.List;

public interface ElementDao {

    void add(Element element);
    void addElementToGroup(Element element, Group group);

    List<Element> getAll();
    Element findById(int id);
}
