package dao;

import models.Element;

import java.util.List;

public interface ElementDao {

    void add(Element element);
    List<Element> getAll();
}
