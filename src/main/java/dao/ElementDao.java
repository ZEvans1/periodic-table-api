package dao;

import models.Element;
import models.Group;

import java.util.List;

public interface ElementDao {

    void add(Element element);
    List<Element> getAll();
    List<Element> getAllElementsByGroup(int groupId);
    List<Element> getAllElementsByPeriod(int periodId);
    Element findById(int id);

}
